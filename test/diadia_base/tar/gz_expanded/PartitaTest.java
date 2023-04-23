package diadia_base.tar.gz_expanded;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;


public class PartitaTest {
	private Partita partita;

	@Before
	public void setUp() {
		this.partita= new Partita();
	}

	@Test
	public void NonVintaDaInizio() {
		assertFalse(this.partita.vinta());
	}



	@Test
	public void testIsFinita1() {
		partita.getGiocatore().setCfu(0);
		assertTrue(partita.isFinita());
	}


	@Test
	public void testIsFinita2() {
		this.partita.setFinita();
		assertTrue(this.partita.isFinita());
	}

}
