package diadia_base.tar.gz_expanded.comandi;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPrendi;

public class ComandoPrendiTest {

	private ComandoPrendi comandoPrendi;
	private Partita partita;
	private IOConsole ioconsole;
	private Attrezzo attrezzo;

	@Before
	public void setUp(){
		this.comandoPrendi= new ComandoPrendi();
		this.partita= new Partita();
		this.ioconsole= new IOConsole();
		this.attrezzo=new Attrezzo("osso",1);
	}
	@Test
	public void test() {
		Stanza Atrio= new Stanza("Atrio");
		this.partita.getStanzaCorrente().addAttrezzo(attrezzo);
		this.partita.setStanzaCorrente(Atrio);
		this.comandoPrendi.setParametro("osso");
		this.comandoPrendi.setIO(ioconsole);
		this.comandoPrendi.esegui(partita);
		assertEquals(attrezzo,this.partita.getStanzaCorrente().getAttrezzo("osso"));
	}


}
