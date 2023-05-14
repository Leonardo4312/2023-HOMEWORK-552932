package it.uniroma3.diadia.giocatore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparatoreAttrezziPerPeso;

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	public Map<String,Attrezzo> attrezzi;
	private int pesoAttuale;
	private int pesoMax;
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new HashMap<>();
		this.pesoAttuale = 0;
	}
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		Attrezzo vecchio=this.attrezzi.put(attrezzo.getNome(), attrezzo);
		if(vecchio!=null)
			this.pesoAttuale=vecchio.getPeso();
		this.pesoAttuale+=attrezzo.getPeso();
		return true;
	}

	public void setPesoMax(int pesoMax) {
		this.pesoMax= pesoMax;
	}
	public int getPesoMax() {
		return pesoMax;
	}
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.get(nomeAttrezzo);
	}
	public int getPeso() {
		return this.pesoAttuale;
	}
	public boolean isEmpty() {
		return this.attrezzi.isEmpty();
	}
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.containsKey(nomeAttrezzo);
	}

	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		if(this.hasAttrezzo(nomeAttrezzo)) {
			this.pesoAttuale-=this.getAttrezzo(nomeAttrezzo).getPeso();
			return this.attrezzi.remove(nomeAttrezzo);
		}
		else
			return null;
	}

	public String toString() {
		StringBuilder s = new StringBuilder();

		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
		    s.append(this.attrezzi.values().toString()+" ");
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}
	
	public List<Attrezzo> getContenutoOrdinatoPerPeso(){
		List<Attrezzo> attrezziPerPeso= new ArrayList<>(this.attrezzi.values());
		Collections.sort(attrezziPerPeso, new ComparatoreAttrezziPerPeso());
		return attrezziPerPeso;
	}		
	
	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){
		return new TreeSet<>(this.attrezzi.values());
	}
	
	public  Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
		Set <Attrezzo> tmp;
		Map<Integer,Set<Attrezzo>> mappa= new HashMap<Integer,Set<Attrezzo>>();
		for(Attrezzo attrezzo: attrezzi.values()) {
			tmp=mappa.get(attrezzo.getPeso());
			if(tmp==null) {
				tmp=new HashSet<Attrezzo>();
				mappa.put(attrezzo.getPeso(), tmp);
			}
			tmp.add(attrezzo);
		}
		return mappa;
	}

	public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso() {
		ComparatoreAttrezziPerPeso comp = new ComparatoreAttrezziPerPeso();
		SortedSet<Attrezzo> set = new TreeSet<Attrezzo>(comp);
		set.addAll(this.attrezzi.values());
		return set;
	}

}