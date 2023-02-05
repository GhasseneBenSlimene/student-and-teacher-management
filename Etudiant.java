package Projet1;

public class Etudiant {
	static Etudiant[] Grp_Etd=new Etudiant[100];
	static int i=0;
	Matiere matiere[]=new Matiere[20];
	String nom;
	int matricule,nb_mat=0;
	
	Etudiant(int matricule,String nom){
		this.matricule=matricule;
		this.nom=nom;
		Grp_Etd[i]=this;
		++i;
	}
	
	static String affiche() {
		String ch="Liste:\n";
		for(int j=0;j<i;j++) {
			ch+="\nMatricule: "+Grp_Etd[j].matricule+"\nNom: "+Grp_Etd[j].nom+"\n";
		}
		return ch;
	}
	
	static String affiche_5_p() {
		String ch="Top 5:\n";
		float tab_moy[]=new float[i];
		Etudiant[] grp=Grp_Etd;
		for(int j=0;j<i;j++) {
			tab_moy[j]=grp[j].moy_a();
		}
        for(int j=0; j < i; j++)	/*pour éliminer les "NaN": dans le cas
        							  ou l'etudiant n'a pas aucun matiere*/
        {  
        	if(grp[j].nombre_mat()==0)
        		tab_moy[j]=-1;
        }
        float tmp = 0;
        Etudiant tmp_e;
        for(int k=0; k < 5 && k<i; k++)  /*tri de 5 premiers elements
        								   de deux tableau grp et tab_moy*/
        {
                for(int j=1; j < (i-k); j++)
                {  
                    if(tab_moy[j-1] > tab_moy[j])
                        {
                                tmp = tab_moy[j-1];  
                                tab_moy[j-1] = tab_moy[j];  
                                tab_moy[j] = tmp; 
                                
                                tmp_e = grp[j-1];  
                                grp[j-1] = grp[j];  
                                grp[j] = tmp_e;  
                        }
 
                }
        }
		
		for(int j=i-1;j>i-6 && j>=0 && tab_moy[j]!=-1;j--) {
				ch+="\nMatricule: "+grp[j].matricule+"\nNom: "+grp[j].nom+"\nMoyenne: "+tab_moy[j]+"\n";
		}
		return ch;
	}
	
	static int recherche_etd(int matricule) {
		for(int j=0;j<i;j++)
			if(Grp_Etd[j].matricule==matricule)
				return j;
		return -1;
	}
	
	int recherche_mat(String nom) {
		for(int j=0;j<nb_mat;j++) 
			if(matiere[j].getNom().compareTo(nom)==0)
				return j;
		return -1;
	}
	
	static void ajouter_etd(int matricule,String nom) {
		int j=nombre();
		Grp_Etd[j]=new Etudiant(matricule,nom);
	}
	
	void ajouter_mat(String nom,int coeff,float ds,float exa,String ens) {
		matiere[nb_mat]=new Matiere(nom,coeff,ds,exa,ens);
		nb_mat++;
	}
	
	int nombre_mat() {
		return nb_mat;
	}
	
	boolean supprimer_mat(String nom) {
		for(int j=0;j<nb_mat;j++) {
			if(matiere[j].getNom().compareTo(nom)==0) {
				for(int k=j;k<nb_mat-1;k++)
					matiere[k]=matiere[k+1];
				matiere[nb_mat-1]=null;
				nb_mat--;
				return true;
			}
		}
		return false;
	}
	
	static int nombre() {
		return i;
	}
	
	static boolean supprimer(int matricule) {
		for(int j=0;j<i;j++) {
			if(Grp_Etd[j].matricule==matricule) {
				for(int k=j;k<i-1;k++)
					Grp_Etd[k]=Grp_Etd[k+1];
				Grp_Etd[i-1]=null;
				i--;
				return true;
			}
		}
		return false;
	}
	
	float moy_mat(String nom) {
		int j=0;
		while(matiere[j].getNom().compareTo(nom)!=0) {
			j++;
		}
		return (float) (matiere[j].getDs()*0.3+matiere[j].getExa()*0.7);
	}
	
	float moy_a() {
		float x=0;
		int tot=0;
		for(int j=0;j<nb_mat;j++) {
			x+=(moy_mat(matiere[j].getNom())*matiere[j].getCoeff());
			tot+=matiere[j].getCoeff();
		}
		x=(float)x/tot;
		return x;
	}
}