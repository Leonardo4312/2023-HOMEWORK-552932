package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando {
	private IO io;
	private String nomeAttrezzo;
	@Override
	public void esegui(Partita partita) {
		if(!partita.getStanzaCorrente().hasAttrezzo(this.nomeAttrezzo)) {
			this.io.mostraMessaggio("Attrezzo " + this.nomeAttrezzo + " non presente nella stanza");
			return;
		}
		Attrezzo attrezzoDaPrendere = partita.getStanzaCorrente().getAttrezzo(this.nomeAttrezzo);
		boolean attrezzoPreso = partita.getGiocatore().getBorsa().addAttrezzo(attrezzoDaPrendere);
		if (!attrezzoPreso) {
			this.io.mostraMessaggio("Non c e spazio per nuovi attrezzi nella borsa");
			return;
		}
		partita.getStanzaCorrente().removeAttrezzo(attrezzoDaPrendere);
		this.io.mostraMessaggio("Attrezzo " + this.nomeAttrezzo + " preso!");
	}



	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo=parametro;

	}

	@Override
	public void setIO(IO io) {
		this.io=io;

	}

	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
	}

	@Override
	public String getNome() {
		return "prendi";
	}

}
