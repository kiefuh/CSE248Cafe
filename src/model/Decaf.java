package model;

import java.io.Serializable;

public class Decaf implements CoffeeVariety, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7829796419274860322L;

	@Override
	public double price() {
		// TODO Auto-generated method stub
		return 2.50;
	}

	@Override
	public String print() {
		// TODO Auto-generated method stub
		return "Decaf\t\t2.50\n";
	}

	@Override
	public String toString() {
		return "Decaf";
	}
	
	

}
