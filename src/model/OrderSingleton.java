package model;

public class OrderSingleton {
	private static OrderSingleton os;
	private static Order order;
	
	private OrderSingleton(Order order) {
		this.order=order;
	}
	
	public static OrderSingleton createOrderStructureSingleton(Order order) {
		if(order==null) {
			os= new OrderSingleton(order);
		}
		else {
			OrderSingleton.order=order;
		}
		return os;
	}
	
	public static Order getOrder() {
		return order;
	}
	
	public static void setOrder(Order order) {
		OrderSingleton.order=order;
	}
}
