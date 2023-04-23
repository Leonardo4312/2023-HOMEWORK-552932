package diadia_base.tar.gz_expanded.comandi;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;

public class FabbricaDiComandiFisarmonicaTest {

	private FabbricaDiComandiFisarmonica fabbrica;
	private String istruzione;
	private IOConsole io;


	@Before
	public void setUp() {
		this.fabbrica= new FabbricaDiComandiFisarmonica();
	}

	@Test
	public void testCostruisciComandoPrendi() {
		this.istruzione="prendi";
		assertEquals("prendi",fabbrica.costruisciComando(istruzione, io).getNome());
	}

	@Test
	public void testCostruisciComandoPosa() {
		this.istruzione="posa";
		assertEquals("posa",fabbrica.costruisciComando(istruzione, io).getNome());
	}

	@Test
	public void testCostruisciComandoFine() {
		this.istruzione="fine";
		assertEquals("fine",fabbrica.costruisciComando(istruzione, io).getNome());
	}

	@Test
	public void testCostruisciComandoVai() {
		this.istruzione="vai";
		assertEquals("vai",fabbrica.costruisciComando(istruzione, io).getNome());
	}

	@Test
	public void testCostruisciComandoAiuto() {
		this.istruzione="aiuto";
		assertEquals("aiuto",fabbrica.costruisciComando(istruzione, io).getNome());
	}

	@Test
	public void testCostruisciComandoGuarda() {
		this.istruzione="guarda";
		assertEquals("guarda",fabbrica.costruisciComando(istruzione, io).getNome());
	}




}
