package diadia_base.tar.gz_expanded.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

public class LabirintoTest {
	private Labirinto labirinto;
	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;
	private Partita partita;
	@Before
	public void setUp() {
		labirinto= new Labirinto();
		partita= new Partita();
		stanzaCorrente = new Stanza("Atrio");
		stanzaVincente = new Stanza("Biblioteca");
	}

	@Test
	public void testStanzaCorrente() {
		partita.setStanzaCorrente(stanzaCorrente);
		assertEquals("Atrio", this.labirinto.getStanzaIniziale().getNome());
	}
	
	@Test
	public void testStanzaVincente() {
		labirinto.setStanzaVincente(stanzaVincente);;
		assertEquals("Biblioteca", this.labirinto.getStanzaVincente().getNome());
	}


}
