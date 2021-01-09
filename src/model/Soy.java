package model;

import java.io.Serializable;

public class Soy implements Condiment,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4531920114912647629L;

	@Override
	public double price() {
		// TODO Auto-generated method stub
		return 0.75;
	}

	@Override
	public String print() {
		// TODO Auto-generated method stub
		return " -Soy\t\t0.75\n";
	}

	@Override
	public String toString() {
		return "Soy";
	}
	
	

}
