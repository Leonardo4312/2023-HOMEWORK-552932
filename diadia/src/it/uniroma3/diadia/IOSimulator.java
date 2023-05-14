package it.uniroma3.diadia;

import java.util.ArrayList;
import java.util.List;

public class IOSimulator implements IO {
	private List<String> righeDaLeggere;
	private int indiceRigheDaLeggere;
	private List<String> messaggiProdotti;
	private int indiceMessaggiProdotti;
	private int indiceMessaggiMostrati;



	public IOSimulator(List<String> righeDaLeggere) {
		this.righeDaLeggere=righeDaLeggere;
		this.indiceRigheDaLeggere=0;
		this.messaggiProdotti= new ArrayList<String>();
		this.indiceMessaggiProdotti=0;
		this.indiceMessaggiMostrati=0;
	}


	@Override
	public void mostraMessaggio(String messaggio) {
		this.messaggiProdotti.add(this.indiceMessaggiProdotti, messaggio);
		this.indiceMessaggiProdotti++;
	}

	@Override
	public String leggiRiga() {
		String rigaLetta=this.righeDaLeggere.get(indiceRigheDaLeggere) ;
		this.indiceRigheDaLeggere++;
		return rigaLetta;
	}

	public String nextMessaggio() {
		String next = this.messaggiProdotti.get(indiceMessaggiMostrati);
		this.indiceMessaggiMostrati++;
		return next;
	}

	public boolean hasNextMessaggio() {
		return this.indiceMessaggiMostrati < this.indiceMessaggiProdotti;
	}



}
