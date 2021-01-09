package model;

import java.io.Serializable;
import java.util.LinkedList;

public class Condiments implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -514385912705483748L;
	private LinkedList<Condiment> condimentList;
	private double price;
	
	public void setCondimentList(LinkedList<Condiment> cL) {
		condimentList=cL;
	}
	
	public LinkedList<Condiment> getCondimentList(){
		return condimentList;
	}
	
	public double priceOfCondiments() {
		price=0;
		condimentList.stream().forEach(e->{
			price+=e.price();
		});
		return price;
	}
	
	public String listOfCondiments() {
		return condimentList.toString();
	}
}
