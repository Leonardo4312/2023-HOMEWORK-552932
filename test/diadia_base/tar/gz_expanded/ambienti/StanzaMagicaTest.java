package diadia_base.tar.gz_expanded.ambienti;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.StanzaMagica;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaTest {

	private StanzaMagica stanza;
	private Attrezzo a;
	private Attrezzo b;

	@Before
	public void setUp() {
		stanza = new StanzaMagica("stanza");
		a = new Attrezzo("quaderno", 20);
		b = new Attrezzo("libro", 30);
	}

	@Test
	public void testAddAttrezzo() {
		assertTrue(stanza.addAttrezzo(a));

	}


	@Test
	public void testModificaAttrezzo() {
		assertTrue(stanza.addAttrezzo(a));
		assertTrue(stanza.addAttrezzo(b));

	}
}



