package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando {
	private IO io;
	static final private String[] elencoComandi = {"vai", "aiuto","prendi","posa", "fine"};

	@Override
	public void esegui(Partita partita) {
		for(int i=0; i< elencoComandi.length; i++) 
			this.io.mostraMessaggio(elencoComandi[i]+" ");
		this.io.mostraMessaggio("");
	}

	@Override
	public void setParametro(String parametro) {


	}

	@Override
	public void setIO(IO io) {
		this.io=io;

	}

	@Override
	public String getParametro() {
		return null;
	}

	@Override
	public String getNome() {
		return "aiuto";
	}

}
