package diadia_base.tar.gz_expanded.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPosa;

public class ComandoPosaTest {

	private ComandoPosa comandoPosa;
	private Partita partita;
	private IOConsole ioconsole;

	@Before
	public void setUp(){
		this.comandoPosa= new ComandoPosa();
		this.partita= new Partita();
		this.ioconsole= new IOConsole();
	}
	@Test
	public void test() {
		Stanza atrio= new Stanza("Atrio");
		Attrezzo osso= new Attrezzo("osso",1);
		this.partita.getGiocatore().getBorsa().addAttrezzo(osso);
		this.partita.setStanzaCorrente(atrio);
		this.comandoPosa.setParametro("osso");
		this.comandoPosa.setIO(ioconsole);
		this.comandoPosa.esegui(partita);
		assertEquals(osso, this.partita.getStanzaCorrente().getAttrezzo("osso"));
	}



}
