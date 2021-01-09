package model;

import java.io.Serializable;

public class SteamedMilk implements Condiment,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6833088631532461543L;

	@Override
	public double price() {
		// TODO Auto-generated method stub
		return 0.50;
	}

	@Override
	public String print() {
		// TODO Auto-generated method stub
		return " -Steamed Milk\t0.50\n";
	}

	@Override
	public String toString() {
		return "SteamedMilk";
	}
	
	

}
