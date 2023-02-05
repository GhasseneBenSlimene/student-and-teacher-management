package Projet1;
import java.util.Scanner;

public class Application {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		boolean teste=true;
		while(teste) {
			System.out.println("Menu principal:"
					+ "\n1. Ajouter un etudiant"
					+ "\n2. Supprimer un etudiant"
					+ "\n3. Afficher le nombre des etudiant"
					+ "\n4. Profil etudiant"
					+ "\n5. Liste des etudiants"
					+ "\n6. Afficher les 5 premiers etudiants"
					+ "\n"
					+ "\n7. Ajouter un enseignant"
					+ "\n8. Supprimer un enseignant"
					+ "\n9. liste des enseignants"
					+ "\n"
					+ "\n0. Exite\n");
			
			System.out.print("choisir le numero de service voulu: ");
			switch(sc.nextInt()) {
			case 1:
				System.out.println("Nombre des etudiant:"+Etudiant.nombre()+"/100");
				if(Etudiant.nombre()==100)
					System.out.println("La base est saturée vous ne pouvez pas ajouter des etudiants");
				else {
					System.out.print("Matricule: ");
					int x=sc.nextInt();
					sc.nextLine().replace("\n", "");	//sans cette ligne ch va prandre \n
					System.out.print("Nom: ");
					String ch=sc.nextLine();
					Etudiant.ajouter_etd(x,ch);
					System.out.println(ch+" est ajoute avec succes\n");
				}
				System.out.println("Appuyez sur Entree pour continuer");
				sc.nextLine();
				continue;
			case 2:
				System.out.print("Matricule: ");
				int matri=sc.nextInt();
				if(Etudiant.supprimer(matri)) {
					System.out.println("L'etudiant est supprimé\n");
				}
				else
					System.out.println("Ce matricule n'existe pas\n");
				break;
			case 3:
				System.out.println("Nombre des etudiant:"+Etudiant.nombre()+"/100");
				break;
			case 4:
				System.out.print("Matricule de l'etudiant: ");
				int matricule_etd_m=sc.nextInt();
				int pos=Etudiant.recherche_etd(matricule_etd_m);
				if(pos==-1) {
					System.out.println("Ce matricule n'existe pas\n");
					System.out.println("Appuyez sur Entree pour continuer");
					sc.nextLine().replace("\n", "");
					sc.nextLine();
				}
				else {
					Etudiant etd_m=Etudiant.Grp_Etd[pos];
					boolean t=true;
					while(t) {
						System.out.print("\nProfil de "+etd_m.nom
								+ "\n1. Ajouter une matiere"
								+ "\n2. Supprimer une matiere"
								+ "\n3. Calculer le moyenne de matière"
								+ "\n4. Calculer le moyenne annuelle"
								+ "\n5. Retour au menu principal"
								+ "\n0. Exite"
								+ "\n->");
						switch(sc.nextInt()) {
						case 1:
							sc.nextLine().replace("\n", "");
							System.out.println("Nombre des matieres de "+etd_m.nom+":"+etd_m.nombre_mat()+"/20\n");
							System.out.print("Nom de matiere: ");
							String nom_mat=sc.nextLine();
							System.out.print("Coefficient: ");
							int coeff=sc.nextInt();
							int v=0;
							float ds;
							do {
								v++;
								System.out.print("note de DS /20: ");
								ds=Float.valueOf(sc.next()); /*On peut utiliser sc.nextFloat() mais sa 
																	causera des erreurs si on travaille avec eclipse*/
							}
							while((ds>20 | ds<0) && v<3);
							if(v>=3)
								continue;
							v=0;
							float exa;
							do {
								v++;
								System.out.print("note d'examen /20: ");
								exa=Float.valueOf(sc.next());
							}
							while((exa>20 | exa<0) && v<3);
							if(v>=3)
								continue;
							sc.nextLine().replace("\n", "");
							System.out.print("Nom d'enseignant: ");
							String enseignant=sc.nextLine();
							if(Enseignant.recherche(enseignant)!=-1) {
								etd_m.ajouter_mat(nom_mat,coeff,ds,exa,enseignant);
								System.out.println(nom_mat+" est ajoute avec succes");
							}
							else {
								System.out.print("Attention: Cet enseignant n'existe pas "
										+ "dans la liste des enseignants.\nVoulez-vous l'ajouter?(o/n) ");
								if(sc.nextLine().compareTo("o")==0) {
									Enseignant.ajouter(enseignant);
									etd_m.ajouter_mat(nom_mat,coeff,ds,exa,enseignant);
									System.out.println(nom_mat+" est ajoute avec succes");
								}
							}
							break;
						case 2:
							sc.nextLine().replace("\n", "");
							System.out.print("Nom de matiere: ");
							if(etd_m.supprimer_mat(sc.nextLine()))
								System.out.print("La matiere est supprimée\n");
							else
								System.out.println("Cette matiere n'existe pas\n");
							break;
						case 3:
							sc.nextLine().replace("\n", "");
							System.out.print("Nom de matiere: ");
							String c=sc.nextLine();
							if(etd_m.recherche_mat(c)!=-1)
								System.out.println("Moyenne de "+c+":"+etd_m.moy_mat(c)+"\n");
							else
								System.out.println("Cette matiere n'existe pas\n");
							break;
						case 4:
							sc.nextLine().replace("\n", "");
							if(etd_m.nombre_mat()>0)
								System.out.println("Moyenne annuelle: "+etd_m.moy_a()+"\n");
							else
								System.out.println(etd_m.nom+" n'a aucune matiere\n");
							break;
						case 5:
							t=false;
							continue;
						case 0:
							t=false;
							teste=false;
							continue;
						}
						System.out.println("Appuyez sur Entree pour continuer");
						sc.nextLine();
					}
				}
				continue;
			case 5: 
				System.out.println(Etudiant.affiche());
				break;
			case 6:
				System.out.println(Etudiant.affiche_5_p());
				break;
			case 7:
				sc.nextLine().replace("\n", "");
				System.out.print("Nom: ");
				String a_ens=sc.nextLine();
				Enseignant.ajouter(a_ens);
				System.out.println(a_ens+" est ajoute avec succes\n");
				System.out.println("Appuyez sur Entree pour continuer");
				sc.nextLine();
				continue;
			case 8:
				sc.nextLine().replace("\n", "");
				System.out.println("attention: La supprimission d'un enseignant "
						+ "qui est deja assigne pour une matiere\npeut conduire a des incoherences");
				System.out.print("Nom: ");
				String s_ens=sc.nextLine();
				if(Enseignant.supprimer(s_ens))
					System.out.println("L'enseignant est supprimé");
				else
					System.out.println("Cet enseigant n'existe pas");
				System.out.println("Appuyez sur Entree pour continuer");
				sc.nextLine();
				continue;
			case 9:
				System.out.println(Enseignant.affiche());
				break;
			case 0:
				teste=false;
				continue;
			}
			
			System.out.println("Appuyez sur Entree pour continuer");
			sc.nextLine().replace("\n", "");
			sc.nextLine();
		}
	}
}