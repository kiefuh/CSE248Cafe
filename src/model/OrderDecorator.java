package model;

public class OrderDecorator {
	private Order order;
	
	public OrderDecorator(Order order) {
		this.order=order;
	}
	
	public String printGUI() {
		String body=order.printOrder();
		String top="Barista: "+order.getBarista()+"\n"+"Order Number: "+order.getId()+"\n________________\n"+body;
		return top;
	}
	

}
