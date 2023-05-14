package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza {
	private String attrezzoPerVedere;

	public StanzaBuia(String nome,String nomeAttrezzo) {
		super(nome);
		this.attrezzoPerVedere=nomeAttrezzo;

	}

	/**
	 * Restituisce una descrizione della stanza a seconda del fatto che sia presente o meno l'attrezzo per "vedere"
	 * @return descrizione della stanza
	 */
	@Override
	public String getDescrizione() {
		if(super.hasAttrezzo(attrezzoPerVedere)) {
			return super.toString();
		}

		return "Qui c'è buio pesto";
	}

	public void setAttrezzoPerVedere(String attrezzoPerVedere) {
		this.attrezzoPerVedere= attrezzoPerVedere;
	}
	public String getAttrezzoPerVedere() {
		return this.attrezzoPerVedere;
	}

}
