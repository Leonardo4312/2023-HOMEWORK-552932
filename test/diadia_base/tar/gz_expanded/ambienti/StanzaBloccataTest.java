package diadia_base.tar.gz_expanded.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.StanzaBloccata;

public class StanzaBloccataTest {
	private StanzaBloccata stanzaNord;
	private StanzaBloccata stanzaSud;

	@Before
	public void setUp() {
		this.stanzaNord=new StanzaBloccata("StanzaNord","nord","chiave");
		this.stanzaSud=new StanzaBloccata("StanzaSud","sud","chiave");
	}

	@Test
	public void testGetStanzaAdiacente() {
		stanzaNord.impostaStanzaAdiacente("sud", stanzaSud);
		assertEquals(stanzaSud,stanzaNord.getStanzaAdiacente("sud"));
	}
}





