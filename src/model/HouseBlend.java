package model;

import java.io.Serializable;

public class HouseBlend implements CoffeeVariety,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6815985841157253743L;

	@Override
	public double price() {
		// TODO Auto-generated method stub
		return 2.00;
	}

	@Override
	public String print() {
		// TODO Auto-generated method stub
		return "House Blend\t2.00\n";
	}

	@Override
	public String toString() {
		return "HouseBlend";
	}
	
	

}
