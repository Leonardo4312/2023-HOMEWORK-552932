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

	public String getDirezioneBloccata() {
		return direzioneBloccata;
	}

	public void setDirezioneBloccata(String direzioneBloccata) {
		this.direzioneBloccata = direzioneBloccata;
	}

	/**
	 * Restituisce una descrizione della stanza
	 */
	@Override
	public String getDescrizione() {
		return this.toString();
	}

	@Override
	public String toString() {
		StringBuilder risultato = new StringBuilder();
		String descrizioneStanza = super.toString();
		risultato.append(descrizioneStanza);
		risultato.append("\nATTENZIONE! L'uscita: "+ this.direzioneBloccata+"E' bloccata.");
		risultato.append("\nNella stanza deve essere presente l'oggetto  '"+this.chiave+"'");
		risultato.append("\nper poter proseguire in quella direzione.");
		return risultato.toString();
	}


	public String getChiave(){
		return this.chiave;
	}

	public void setChiave(String chiave) {
		this.chiave = chiave;
	}



}
