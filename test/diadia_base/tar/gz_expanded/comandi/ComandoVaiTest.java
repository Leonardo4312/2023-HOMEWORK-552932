package diadia_base.tar.gz_expanded.comandi;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.comandi.ComandoVai;

public class ComandoVaiTest {

	private Stanza stanzaPartenza;
	private ComandoVai comandoVai;
	private Partita partita;

	@Before
	public void setUp(){
		this.stanzaPartenza=new Stanza("StanzaPartenza");
		this.comandoVai= new ComandoVai();
		this.comandoVai.setIO(new IOConsole());
		this.partita = new Partita();
		
	}

	@Test
	public void testComandoVai(){
		this.comandoVai.setParametro("nord");
		this.partita.setStanzaCorrente(stanzaPartenza);
		this.comandoVai.esegui(this.partita);
		assertEquals("StanzaPartenza",this.partita.getStanzaCorrente().getNome());
	}
}
