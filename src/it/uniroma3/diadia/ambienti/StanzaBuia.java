package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza {
	private String attrezzoPerVedere;

	public StanzaBuia(String nome,String nomeAttrezzo) {
		super(nome);
		this.setAttrezzoPerVedere(nomeAttrezzo);

	}

	/**
	 * Restituisce una descrizione della stanza a seconda del fatto che sia presente o meno l'attrezzo per "vedere"
	 * @return descrizione della stanza
	 */
	@Override
	public String getDescrizione() {
		if(!this.getPartita().getGiocatore().getBorsa().hasAttrezzo(attrezzoPerVedere)) {
			return "qui c'è buio pesto";
		}
		return super.getDescrizione();
	}

	public void setAttrezzoPerVedere(String nome) {
		this.attrezzoPerVedere= nome;
	}
	public String getAttrezzoPerVedere() {
		return this.attrezzoPerVedere;
	}

}
