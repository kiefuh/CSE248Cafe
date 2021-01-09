package model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;

public class Coffee implements Orderable,Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1429900767427783280L;
	private CoffeeType coffeeType;
	private Condiments condiments;
	
	public Coffee() {
		coffeeType= new CoffeeType();
		condiments= new Condiments();
	}
	
	public void createCoffee(CoffeeVariety cV, LinkedList<Condiment> cL) {
		coffeeType.setVariety(cV);
		condiments.setCondimentList(cL);	
	}
	
	public CoffeeType getCoffeeType() {
		return coffeeType;
	}
	
	public Condiments getCondiments() {
		return condiments;
	}

	@Override
	public double price() {
		return coffeeType.getVariety().price()+condiments.priceOfCondiments();
	}
	@Override
	public String print() {
		StringBuilder sb= new StringBuilder();
		sb.append(coffeeType.getVariety().print());
		Iterator<Condiment> it=condiments.getCondimentList().listIterator();
		while(it.hasNext()) {
			sb.append(it.next().print());
		}
		return sb.toString();
	}

	@Override
	public String toString() {
		return "Coffee";
	}
	
	
	
	
	
} 
