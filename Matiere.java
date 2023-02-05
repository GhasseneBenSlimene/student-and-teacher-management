package Projet1;

public class Matiere {
	private float ds,exa;
	private int coeff;
	private String nom;
	String ens;
	Matiere(String n,int c,float d,float e,String ens) {
		nom=n;
		coeff=c;
		ds=d;
		exa=e;
		this.ens=ens;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getCoeff() {
		return coeff;
	}
	public void setCoeff(int coeff) {
		this.coeff = coeff;
	}
	public float getDs() {
		return ds;
	}
	public void setDs(float ds) {
		this.ds = ds;
	}
	public float getExa() {
		return exa;
	}
	public void setExa(float exa) {
		this.exa = exa;
	}
	public String getEns() {
		return ens;
	}
	public void setEns(String ens) {
		this.ens = ens;
	}
}
