package diadia_base.tar.gz_expanded.giocatore;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.giocatore.Giocatore;

public class GiocatoreTest {
	private Giocatore giocatore;

	@Before
	public void setUp() {
		this.giocatore=new Giocatore();
	}
	
	@Test
	public void testGetCfu() {
		giocatore.setCfu(0);
		assertEquals(0, giocatore.getCfu());
	}
   
	@Test
	public void testCfuNonFinitiInizio() {
		assertNotEquals(0,this.giocatore.getCfu());
	}
}
