package diadia_base.tar.gz_expanded;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

public class LabirintoTest {
	private Labirinto labirinto;
	private Stanza stanzaCorrente;
	@Before
	public void setUp() {
		labirinto= new Labirinto();
		stanzaCorrente = new Stanza("Atrio");
	}

	@Test
	public void testStanzaCorrente() {
		labirinto.setStanzaCorrente(stanzaCorrente);
		assertEquals("Atrio", this.labirinto.getStanzaCorrente().getNome());
	}

}
