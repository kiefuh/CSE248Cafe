package model;

public class DataStructureSingleton {
	private static DataStructureSingleton data;
	private static OrderDataStructure orderStructure;
	
	private DataStructureSingleton(OrderDataStructure os) {
		this.orderStructure=os;
	}
	
	public static OrderDataStructure createOrderStructureSingleton(OrderDataStructure os) {
		if(orderStructure==null) {
			data= new DataStructureSingleton(os);
		}
		else {
			DataStructureSingleton.orderStructure=os;
		}
		return orderStructure;
	}
	
	public static OrderDataStructure getOrderStructure() {
		return orderStructure;
	}
	
	public static void setOrderStructure(OrderDataStructure os) {
		DataStructureSingleton.orderStructure=os;
	}
	
}
