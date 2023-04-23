package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccata extends Stanza {
	private String direzioneBloccata;
	private String chiave;

	public StanzaBloccata(String nome,String direzioneBloccata,String chiave) {
		super(nome);
		this.direzioneBloccata=direzioneBloccata;
		this.chiave=chiave;
	}

	/**
	 * Restituisce stanza adiacente
	 */
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if(direzione.equals(this.direzioneBloccata)&& !this.hasAttrezzo(this.chiave)) {
			return this;
		}
		return super.getStanzaAdiacente(direzione);

	}
	/**
	 * Restituisce una descrizione della stanza
	 */
	@Override
	public String getDescrizione() {
		StringBuilder risultato = new StringBuilder();
		if(!this.getPartita().getGiocatore().getBorsa().hasAttrezzo(this.chiave)) {
			risultato.append("Non hai la chiave per aprire la porta!!!");
		}
		else {
			risultato.append(this.getNome());
			risultato.append("\nUscite: ");
			for (String direzione : this.getDirezioni())
				if (direzione!=null)
					risultato.append(" " + direzione);
		}
		risultato.append("\nAttrezzi nella stanza: ");
		for (Attrezzo attrezzo : this.getAttrezzi()) {
			if(attrezzo!=null)
				risultato.append(attrezzo.toString()+" ");
		}
		return risultato.toString();
	}

	public String getChiave(){
		return this.chiave;
	}


}
