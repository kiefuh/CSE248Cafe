package model;

import java.io.Serializable;

public class Espresso implements CoffeeVariety,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5538470691586614372L;

	@Override
	public double price() {
		// TODO Auto-generated method stub
		return 3.00;
	}

	@Override
	public String print() {
		// TODO Auto-generated method stub
		return "Espresso\t\t3.00\n";
	}

	@Override
	public String toString() {
		return "Espresso";
	}
	
	

}
