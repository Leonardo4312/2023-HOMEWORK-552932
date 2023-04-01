package diadia_base.tar.gz_expanded;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

public class PartitaTest {
	private Partita partita;
	private Labirinto università;
	private Stanza stanzaVincente;

	@Before
	public void setUp() {
		this.partita= new Partita();
		this.università= new Labirinto();
		this.stanzaVincente= università.getStanzaVincente();
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
