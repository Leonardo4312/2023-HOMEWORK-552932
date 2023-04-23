package diadia_base.tar.gz_expanded.giocatore;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class BorsaTest {
	private Attrezzo attrezzo1;
	private Borsa borsa;

	@Before
	public void setUp() {
		this.borsa=new Borsa();
		this.attrezzo1=new Attrezzo("Attrezzo1",1);
	}

	@Test
	public void testIsEmpty() {
		borsa.addAttrezzo(attrezzo1);
		assertFalse(borsa.isEmpty());


	}
	@Test
	public void testPesoMax() {
		borsa.setPesoMax(2);
		assertEquals(2,borsa.getPesoMax());
	}
	
	

}
