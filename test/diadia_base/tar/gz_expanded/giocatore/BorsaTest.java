package diadia_base.tar.gz_expanded.giocatore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparatoreAttrezziPerPeso;
import it.uniroma3.diadia.giocatore.Borsa;


public class BorsaTest {
	private Attrezzo attrezzo1;
	private Attrezzo attrezzo2;
	private Attrezzo attrezzo3;
	private Attrezzo attrezzo4;
	private Borsa borsa;

	@Before
	public void setUp() {
		this.borsa=new Borsa();
		this.attrezzo1=new Attrezzo("Attrezzo1",1);
		this.attrezzo2=new Attrezzo("Attrezzo2",2);
		this.attrezzo3=new Attrezzo("Attrezzo3",3);
		this.attrezzo4= new Attrezzo("Attrezzo4",2);
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

	@Test
	public void testGetAttrezzo() {
		this.borsa.addAttrezzo(attrezzo1);
		assertEquals(attrezzo1,this.borsa.getAttrezzo("Attrezzo1"));
	}

	@Test
	public void testOrdinataPerPeso() {
		this.borsa.addAttrezzo(attrezzo1);
		this.borsa.addAttrezzo(attrezzo2);
		this.borsa.addAttrezzo(attrezzo3);

		List<Attrezzo> risultatoAspettato= new ArrayList<>();
		risultatoAspettato.add(attrezzo1);
		risultatoAspettato.add(attrezzo2);
		risultatoAspettato.add(attrezzo3);

		assertEquals(risultatoAspettato,this.borsa.getContenutoOrdinatoPerPeso());

	}

	@Test
	public void testOrdinataPerNome() {
		this.borsa.addAttrezzo(attrezzo1);
		this.borsa.addAttrezzo(attrezzo2);
		this.borsa.addAttrezzo(attrezzo3);

		Set<Attrezzo> risultatoAspettato = new HashSet<Attrezzo>();
		risultatoAspettato.add(attrezzo1);
		risultatoAspettato.add(attrezzo2);
		risultatoAspettato.add(attrezzo3);

		assertEquals(risultatoAspettato, this.borsa.getContenutoOrdinatoPerNome());
	}


	@Test
	public void testSortedOrdinatoPerPeso() {
		ComparatoreAttrezziPerPeso comp= new ComparatoreAttrezziPerPeso();
		this.borsa.addAttrezzo(attrezzo1);   
		this.borsa.addAttrezzo(attrezzo2);
		this.borsa.addAttrezzo(attrezzo4);   
		this.borsa.addAttrezzo(attrezzo3);        

		SortedSet<Attrezzo> set = new TreeSet<>(comp);
		set = this.borsa.getSortedSetOrdinatoPerPeso();

		Iterator<Attrezzo> it = set.iterator();
		assertSame(attrezzo1, it.next());
		assertSame(attrezzo2, it.next());
		assertSame(attrezzo4, it.next());
		assertSame(attrezzo3, it.next());

	}

	@Test
	public void testRaggruppatoPerPeso() {

		this.borsa.addAttrezzo(attrezzo1);       
		this.borsa.addAttrezzo(attrezzo2);        
		this.borsa.addAttrezzo(attrezzo4); 

		Map<Integer, Set<Attrezzo>> map = this.borsa.getContenutoRaggruppatoPerPeso();

		Set<Attrezzo> set1 = new HashSet<>();
		set1.add(attrezzo1);
		assertTrue(map.containsKey(1));
		assertEquals(set1, map.get(1));

		Set<Attrezzo> set2 = new HashSet<>();
		set2.add(attrezzo2);
		set2.add(attrezzo4);
		assertTrue(map.containsKey(2));
		assertEquals(set2, map.get(2));
	}




}

