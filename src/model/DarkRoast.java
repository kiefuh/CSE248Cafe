package model;

import java.io.Serializable;

public class DarkRoast implements CoffeeVariety,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1229799988482913633L;

	@Override
	public double price() {
		// TODO Auto-generated method stub
		return 2.25;
	}

	@Override
	public String print() {
		// TODO Auto-generated method stub
		return "Dark Roast\t2.25\n";
	}

	@Override
	public String toString() {
		return "Dark Roast";
	}
	
	

}
