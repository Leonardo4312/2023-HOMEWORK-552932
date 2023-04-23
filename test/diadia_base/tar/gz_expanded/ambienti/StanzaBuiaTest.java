package diadia_base.tar.gz_expanded.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.StanzaBuia;

public class StanzaBuiaTest {
	private StanzaBuia stanza;

	@Before
	public void setUp(){
		this.stanza=new StanzaBuia("atrio","lanterna");
	}

	@Test
	public void testGetAttrezzoPerVedere() {
		stanza.setAttrezzoPerVedere("lanterna");
		assertEquals("lanterna",this.stanza.getAttrezzoPerVedere());
	}


}
