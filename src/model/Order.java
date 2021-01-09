package model;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.LinkedList;

public class Order implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3151874715385741600L;
	private LinkedList<Orderable> order;
	private Integer id;
	private double price;
	private String pricePrint;
	private String tax;
	private StringBuilder sb;
	DecimalFormat df = new DecimalFormat(".##");
	private String barista;
	
	public Order() {
		order= new LinkedList<Orderable>();
		id=DataStructureSingleton.getOrderStructure().getCurrentId();
	}
	
	public void addToOrder(Orderable o) {
		order.add(o);
	}
	
	public LinkedList<Orderable> getOrderList() {
		return order;
	}
	
	public void clear() {
		order.clear();
	}
	
	public Integer getId() {
		return id;
	}
	
	public String price() {
		price=0;
		double taxAdd=0;
		order.forEach(e->{
			price+=e.price();
		});
		taxAdd=price*.08625;
		tax= df.format(price*.08625);
		pricePrint=df.format(price+taxAdd);
		return pricePrint;
	}
	
	public String getBarista() {
		return barista;
	}
	
	public int getNumberofItems() {
		return order.size();
	}
	
	public void setBarista(String barista) {
		this.barista=barista;
	}
	
	public String printOrder() {
		price();
		sb= new StringBuilder();
		order.forEach(e->{
			sb.append(e.print());
		});
		sb.append("tax(8.625%):\t"+tax+"\n");
		sb.append("total:\t"+pricePrint+"\n\n");
		return sb.toString();
				
	}
	
}
