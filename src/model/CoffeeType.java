package model;

import java.io.Serializable;

public class CoffeeType implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 944583506841917507L;
	private CoffeeVariety coffeeVariety;
	
	public void setVariety(CoffeeVariety cV) {
		coffeeVariety=cV;
	}
	
	public CoffeeVariety getVariety() {
		return coffeeVariety;
	}
}
