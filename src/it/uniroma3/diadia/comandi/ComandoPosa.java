package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando {
	private IO io;
	private String nomeAttrezzo;

	@Override
	public void esegui(Partita partita) {
		if(!partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo)) {
			this.io.mostraMessaggio("Attrezzo" +nomeAttrezzo+"non presente in borsa");
			return;
		}
		Attrezzo a =partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
		partita.getStanzaCorrente().addAttrezzo(a);
		this.io.mostraMessaggio("Attrezzo "+nomeAttrezzo+" posato");
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
		return "posa";
	}

}
