package it.uniroma3.diadia.ambienti;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilder extends Labirinto {

	private Stanza stanzaIniziale;
	private Stanza stanzaVincente;
	private List<Stanza> stanze;

	public LabirintoBuilder() {
		this.stanzaIniziale = null;
		this.stanzaVincente = null;
		this.stanze = new ArrayList<>();
	}

	/**
	 * crea una stanza, che sarà quella iniziale del labirinto che sto creando
	 * @param nome - nome della stanza iniziale
	 */
	public LabirintoBuilder addStanzaIniziale(String nome) {
		this.setStanzaIniziale(nome);
		this.stanze.add(this.stanzaIniziale);
		return this;
	}

	/**
	 * crea una stanza, che sarà la vincente del labirinto che sto creando
	 * @param nome - nome della stanza vincente
	 */
	public LabirintoBuilder addStanzaVincente(String nome) {
		this.setStanzaVincente(nome);
		stanze.add(this.stanzaVincente);
		return this;
	}

	public Labirinto getLabirinto() {
		return (Labirinto)this;
	}

	// dove? fa riferimento all’ultima stanza aggiunta
	public LabirintoBuilder addAttrezzo(String nome, int peso) {
		Stanza ultima = this.stanze.get(stanze.size() - 1);
		ultima.addAttrezzo(new Attrezzo(nome, peso));
		return this;
	}

	public LabirintoBuilder addAdiacenza(String stanzaPartenza, String stanzaAdiacente, String direzione) {
		Iterator<Stanza> it = this.stanze.iterator();
		Stanza partenza = null;
		Stanza adiacente = null;
		while(it.hasNext()) {
			Stanza s = it.next();
			if(s.getNome().equals(stanzaPartenza)) {
				partenza = s;
			}
			if(s.getNome().equals(stanzaAdiacente)) {
				adiacente = s;
			}
		}
		partenza.impostaStanzaAdiacente(direzione, adiacente);
		return this; 
	}

	public LabirintoBuilder addStanza(String nome) {
		this.stanze.add(new Stanza(nome));
		return this;
	}

	public LabirintoBuilder addStanzaBuia(String nome, String nomeAttrezzo) {
		this.stanze.add(new StanzaBuia(nome, nomeAttrezzo));
		return this;
	}

	public LabirintoBuilder addStanzaBloccata(String nome,String direzione,String attrezzo) {
		this.stanze.add(new StanzaBloccata(nome,direzione,attrezzo));
		return this;
	}

	public LabirintoBuilder addStanzaMagica(String nome, int sogliaMagica) {
		this.stanze.add(new StanzaMagica(nome, sogliaMagica));
		return this;
	}

	@Override
	public Stanza getStanzaIniziale() {
		return this.stanzaIniziale;
	}

	@Override
	public Stanza getStanzaVincente() {
		return this.stanzaVincente;
	}

	@Override
	public void setStanzaIniziale(String nome) {
		this.stanzaIniziale = new Stanza(nome);
	}

	@Override
	public void setStanzaVincente(String nome) {
		this.stanzaVincente = new Stanza(nome);
	}

	public List<Stanza> getListaStanze(){
		return this.stanze;
	}


}
