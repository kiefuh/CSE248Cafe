package model;

import java.io.Serializable;

public class WhippedMilk implements Condiment,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4733224925305943906L;

	@Override
	public double price() {
		// TODO Auto-generated method stub
		return .50;
	}

	@Override
	public String print() {
		// TODO Auto-generated method stub
		return " -Whipped Milk\t0.50\n";
	}

	@Override
	public String toString() {
		return "WhippedMilk";
	}

	
}
