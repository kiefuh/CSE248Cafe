package model;

import java.io.Serializable;

public class Mocha implements Condiment,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5351866900204794836L;

	@Override
	public double price() {
		// TODO Auto-generated method stub
		return 1.00;
	}

	@Override
	public String print() {
		// TODO Auto-generated method stub
		return " -Mocha\t\t1.00\n";
	}

	@Override
	public String toString() {
		return "Mocha";
	}
	
	

}
