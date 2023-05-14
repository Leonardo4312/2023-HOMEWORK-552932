package it.uniroma3.diadia.giocatore;

public class Giocatore {
	static final private int CFU_INIZIALI= 20;
	private int cfu;
	private Borsa borsa;

	public Giocatore() {
		this.borsa=new Borsa();
		this.cfu=CFU_INIZIALI;
	}

	public void setBorsa(Borsa borsa) {
		this.borsa=borsa;
	}

	public Borsa getBorsa() {
		return borsa;
	}

	public void setCfu(int cfu) {
		this.cfu=cfu;
	}

	public int getCfu() {
		return cfu;
	}
	
	public boolean isVivo() {
		return this.cfu >0;
	}
	

}
