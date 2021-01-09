package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Coffee;
import model.CoffeeType;
import model.Condiment;
import model.Condiments;
import model.DarkRoast;
import model.DataStructureSingleton;
import model.DatabaseSingleton;
import model.Decaf;
import model.Espresso;
import model.FileWrite;
import model.HouseBlend;
import model.Mocha;
import model.Order;
import model.OrderDecorator;
import model.OrderSingleton;
import model.Orderable;
import model.Sandwich;
import model.Soy;
import model.SteamedMilk;
import model.UserSingleton;
import model.WhippedMilk;


public class HomeController {
	@FXML
	private Button houseBlendButton;
	@FXML
	private Button darkRoastButton;
	@FXML
	private Button decafButton;
	@FXML
	private Button soyButton;
	@FXML
	private Button steamedMilkButton;
	@FXML
	private Button mochaButton;
	@FXML
	private Button orderButton;
	@FXML
	private TextArea receiptPreviewArea;
	@FXML
	private Button espressoButton;
	@FXML 
	private Button whippedMilkButton;
	@FXML
	private MenuItem logoutItem;
	private Stack<Condiment> condimentStack= new Stack<>();
	private Order order= new Order();
	private CoffeeType previousCoffee=new CoffeeType();
	private Condiments condiments= new Condiments();
	
	
	public HomeController() {
		Platform.runLater(()->{
			logoutItem.setOnAction(e->{
				Parent root=null;
				try {
					root = FXMLLoader.load(getClass().getResource("/controller/Login.fxml"));
				} catch (IOException a) {
					// TODO Auto-generated catch block
					a.printStackTrace();
				}
				Scene scene=orderButton.getScene();
				scene.setRoot(root);
			});
			receiptPreviewArea.setText("Barista: "+UserSingleton.getUsername()+"\n"+"Order Number: "+order.getId()+"\n________________\n");
			
		});
		
	}
	
	private void addToOrder() {
		LinkedList<Condiment> cL= new LinkedList<>();
		while(condimentStack.isEmpty()!=true) {
			cL.add(condimentStack.pop());
		}
		condiments.setCondimentList(cL);
		Coffee newCoffee= new Coffee();
		newCoffee.createCoffee(previousCoffee.getVariety(),condiments.getCondimentList());
		order.addToOrder(newCoffee);
		condimentStack= new Stack<>();
		condiments= new Condiments();
		previousCoffee= new CoffeeType();
	}
	
	@FXML
	private void onHouseBlendClick(ActionEvent event) {
		if(previousCoffee.getVariety()!=null) {
			addToOrder();
		}
		previousCoffee.setVariety(new HouseBlend());
		receiptPreviewArea.appendText(previousCoffee.getVariety().print());
	}
	@FXML
	private void onDarkRoastClick(ActionEvent event) {
		if(previousCoffee.getVariety()!=null) {
			addToOrder();
		}
		previousCoffee.setVariety(new DarkRoast());
		receiptPreviewArea.appendText(previousCoffee.getVariety().print());
	}
	@FXML
	private void onDecafClick(ActionEvent event) {
		if(previousCoffee.getVariety()!=null) {
			addToOrder();
		}
		previousCoffee.setVariety(new Decaf());
		receiptPreviewArea.appendText(previousCoffee.getVariety().print());
	}
	
	@FXML
	private void onSoyButtonClick(ActionEvent event) {
		condimentStack.push(new Soy());
		receiptPreviewArea.appendText(condimentStack.peek().print());
	}
	@FXML
	private void onSteamedMilkButtonClick(ActionEvent event) {
		condimentStack.push(new SteamedMilk());
		receiptPreviewArea.appendText(condimentStack.peek().print());
	}
	@FXML
	private void onMochaButtonClick(ActionEvent event) {
		condimentStack.push(new Mocha());
		receiptPreviewArea.appendText(condimentStack.peek().print());
	}
	@FXML
	private void onEspressoClick(ActionEvent event) {
		if(previousCoffee.getVariety()!=null) {
			addToOrder();
		}
		previousCoffee.setVariety(new Espresso());
		receiptPreviewArea.appendText(previousCoffee.getVariety().print());
	}
	@FXML
	private void onWhippedMilkButtonClick(ActionEvent event) {
		condimentStack.push(new WhippedMilk());
		receiptPreviewArea.appendText(condimentStack.peek().print());
	}
	@FXML
	private void onSanwichClick(ActionEvent event) {
		if(previousCoffee.getVariety()!=null) {
			addToOrder();
		}
		Sandwich sandwich=new Sandwich();
		order.addToOrder(sandwich);
		receiptPreviewArea.appendText(sandwich.print());
	}
	@FXML
	private void onOrderButtonClick(ActionEvent event) {
		if(previousCoffee.getVariety()!=null) {
			addToOrder();
		}
		order.setBarista(UserSingleton.getUsername());
		OrderSingleton.setOrder(order);
		final Stage dialog = new Stage();
    	Parent root=null;
        	try {
				root= FXMLLoader.load(getClass().getResource("/controller/Receipt.FXML"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        dialog.initModality(Modality.WINDOW_MODAL);
        dialog.setTitle("Order Receipt");
        dialog.initOwner((Stage)soyButton.getScene().getWindow());
        Scene dialogScene = new Scene(root, 800, 470);
        dialog.setScene(dialogScene);
        dialog.show();
		OrderDecorator decoratedOrder= new OrderDecorator(order);
		String orderString=decoratedOrder.printGUI();
		System.out.println(orderString);
		DataStructureSingleton.getOrderStructure().addToTreeMap(order);
		FileWrite fw = new FileWrite();
		fw.writeFile(orderString, "Sales/sales.txt");
		String update="INSERT INTO Orders (OrderNumber, Barista, NumberofItems) VALUES( '" + order.getId() + "','" + order.getBarista() + "','" + order.getNumberofItems() + "')";
		Connection conn = null;
		conn=DatabaseSingleton.getConnection();
		Statement createOrder = null;
		try {
			createOrder = conn.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			createOrder.executeUpdate(update);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Iterator<Orderable> orderIterator=order.getOrderList().iterator();
		while(orderIterator.hasNext()) {
			Orderable ordered=orderIterator.next();
			if(ordered instanceof Coffee) {
				Coffee castOrdered=(Coffee)ordered;
				update="INSERT INTO OrderItems (OrderNumber, Orderable, CoffeeVariety,Condiments) VALUES( '" + order.getId() + "','" + ordered.toString() + "','" + castOrdered.getCoffeeType().getVariety().toString()+ "','" + castOrdered.getCondiments().listOfCondiments()+ "')";
			}else {
				update="INSERT INTO OrderItems (OrderNumber, Orderable, CoffeeVariety,Condiments) VALUES( '" + order.getId() + "','" + ordered.toString() + "','" + null + "','" + null + "')";
			}
			try {
				createOrder = conn.createStatement();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				createOrder.executeUpdate(update);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		receiptPreviewArea.setText("Barista: "+order.getBarista()+"\n"+"Order Number: "+order.getId()+"\n________________\n");
		order= new Order();
		
		
	}
	
	
	
	
}
