package model;

import java.io.Serializable;
import java.util.TreeMap;

public class OrderDataStructure implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2102095983186084739L;
	TreeMap<Integer,Order> orderTreeMap;
	
	public OrderDataStructure() {
		orderTreeMap= new TreeMap<>();
	}
	
	public void addToTreeMap(Order order) {
		orderTreeMap.put(order.getId(), order);
	}
	
	public Order removeFromTreeMap(Integer orderNumber) {
		return orderTreeMap.remove(orderNumber);
	}
	
	public int getCurrentId() {
		return orderTreeMap.size();
	}
	
}
