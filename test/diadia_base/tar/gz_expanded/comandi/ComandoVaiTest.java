package diadia_base.tar.gz_expanded.comandi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import diadia_base.tar.gz_expanded.Fixture;
import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoVai;

public class ComandoVaiTest {

	private Stanza stanzaPartenza;
	private ComandoVai comandoVai;
	private Partita partita;
	private Partita p;
	private Comando vai;
	List<String> righeDaLeggere;
	List<String> righeDaLeggere2;
	Labirinto labirinto;
	Labirinto labirinto2;
	private IO io;


	@Before
	public void setUp(){
		this.stanzaPartenza=new Stanza("StanzaPartenza");
		this.comandoVai= new ComandoVai();
		this.comandoVai.setIO(new IOConsole());
		this.partita = new Partita();
		io = new IOConsole();
		vai = new ComandoVai();
		labirinto = Labirinto.labirintoBuilder()
				.addStanzaIniziale("LabCampusOne")
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("LabCampusOne","Biblioteca","ovest")
				.getLabirinto();
		p = new Partita(labirinto);
		vai.setIO(io);
		righeDaLeggere = new ArrayList<>();
		righeDaLeggere2 = new ArrayList<>();


	}

	@Test
	public void testComandoVai(){
		this.comandoVai.setParametro("nord");
		this.partita.setStanzaCorrente(stanzaPartenza);
		this.comandoVai.esegui(this.partita);
		assertEquals("StanzaPartenza",this.partita.getStanzaCorrente().getNome());
	}


	@Test
	public void testPartitaConComandoVai() {
		righeDaLeggere.add("vai ovest");

		IOSimulator io = Fixture.creaSimulazione(righeDaLeggere);
		assertTrue(io.hasNextMessaggio());
		assertEquals(DiaDia.MESSAGGIO_BENVENUTO, io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertEquals("Biblioteca", io.nextMessaggio());
		}
}
