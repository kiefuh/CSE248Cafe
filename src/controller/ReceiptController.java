package controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import model.OrderDecorator;
import model.OrderSingleton;

public class ReceiptController {
	@FXML
	private TextArea receiptArea;
	
	public ReceiptController() {
		Platform.runLater(()->{
			OrderDecorator decoratedOrder= new OrderDecorator(OrderSingleton.getOrder());
			receiptArea.setText(decoratedOrder.printGUI());
			
		});
	}
}
