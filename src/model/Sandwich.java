package model;

import java.io.Serializable;

public class Sandwich implements Orderable,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -17993668460452936L;

	@Override
	public double price() {
		// TODO Auto-generated method stub
		return 5.00;
	}

	@Override
	public String print() {
		// TODO Auto-generated method stub
		return "Sandwich\t5.00\n";
	}

	@Override
	public String toString() {
		return "Sandwich";
	}
	
	

}
