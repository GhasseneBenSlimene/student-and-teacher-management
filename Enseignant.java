package Projet1;

public class Enseignant {
	static String[] liste=new String[20];
	static int i=0;
	static void ajouter(String ens) {
		liste[i]=ens;
		i++;
	}
	
	static int nombre(){
		return i;
	}
	
	static int recherche(String ens) {		//recherche de premiere occurrence
		int j;
		boolean t=false;
		for(j=0;j<i;j++) {	
			if(liste[j].compareTo(ens)==0) {
				t=true;
				break;
			}
		}
		if(t==true)
			return j;
		else
			return -1;
	}
	
	static boolean supprimer(String ens) {	//supprimer le premiere occurrence
		int x,j=recherche(ens);
		if (j==-1)
			return false;
		else {
			for(int k=j;k<i-1;k++)
				liste[k]=liste[k+1];
			liste[i-1]=null;
			i--;
			return true;
		}
	}
	
	static String affiche() {
		String ch="Liste:\n";
		for(int j=0;j<i;j++) {
			ch+="Nom: "+liste[j]+"\n";
		}
		return ch;
	}
}