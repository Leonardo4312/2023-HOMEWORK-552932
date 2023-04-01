package diadia_base.tar.gz_expanded;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {
	private Stanza stanzaNord;
	private Stanza stanzaSud;
	private Stanza stanzaEst;
	private Stanza stanzaAttrezzi;
	private Attrezzo attrezzo1;
	private Attrezzo attrezzo2;
	private Attrezzo attrezzo3;

	@Before
	public void setUp() {
		this.stanzaNord=new Stanza("StanzaNord");
		this.stanzaSud=new Stanza("StanzaSud");
		this.stanzaEst= new Stanza("StanzaEst");
		this.stanzaAttrezzi=new Stanza("StanzaAttrezzi");
		this.attrezzo1=new Attrezzo("Attrezzo1",1);
		this.attrezzo2=new Attrezzo("Attrezzo2",2);
		this.attrezzo3=new Attrezzo("Attrezzo3",3);
	}

	@Test
	public void testGetNome1() {
		assertEquals("StanzaNord",stanzaNord.getNome());
	}


	@Test
	public void testGetNome2() {
		assertNotEquals("StanzaNord",stanzaSud.getNome());
	}


	@Test
	public void testImpostaStanzaAdiacente1() {
		stanzaNord.impostaStanzaAdiacente("sud",stanzaSud);
		assertEquals(stanzaSud,stanzaNord.getStanzaAdiacente("sud"));
	}

	@Test
	public void testImpostaStanzaAdiacente2() {
		stanzaEst.impostaStanzaAdiacente("sud", stanzaSud);
		assertNotNull(stanzaEst.getStanzaAdiacente("sud"));
	}

	@Test
	public void testImpostaStanzaAdiacente3() {
		assertNull(stanzaEst.getStanzaAdiacente("sud"));
	}



	@Test
	public void testHasAttrezzo1() {
		stanzaAttrezzi.addAttrezzo(attrezzo1);
		stanzaAttrezzi.addAttrezzo(attrezzo2);
		assertTrue(stanzaAttrezzi.hasAttrezzo(attrezzo1.getNome()));
		assertTrue(stanzaAttrezzi.hasAttrezzo(attrezzo2.getNome()));
		assertFalse(stanzaAttrezzi.hasAttrezzo(attrezzo3.getNome()));
	}

	@Test
	public void testHasAttrezzo2() {
		stanzaAttrezzi.addAttrezzo(attrezzo1);
		assertNotNull(stanzaAttrezzi.hasAttrezzo(attrezzo1.getNome()));

	}

	@Test
	public void testHasAttrezzo3() {
		assertFalse(stanzaAttrezzi.hasAttrezzo(attrezzo1.getNome()));
	}

	@Test
	public void testRemoveAttrezzo1() {
		stanzaAttrezzi.addAttrezzo(attrezzo1);
		stanzaAttrezzi.addAttrezzo(attrezzo2);
		stanzaAttrezzi.removeAttrezzo(attrezzo1);
		assertFalse(stanzaAttrezzi.hasAttrezzo(attrezzo1.getNome()));
		assertTrue(stanzaAttrezzi.hasAttrezzo(attrezzo2.getNome()));
	}

	@Test
	public void testRemoveAttrezzo2() {
		assertFalse(stanzaAttrezzi.hasAttrezzo(attrezzo1.getNome()));
	}

}

