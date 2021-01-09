package application;
	
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import model.DataStructureSingleton;
import model.DatabaseSingleton;
import model.ObjectSave;
import model.OrderDataStructure;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	OrderDataStructure os;
	@Override
	public void start(Stage primaryStage) {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DatabaseSingleton.connectToDatabase("jdbc:sqlite:CoffeeDB.sqlite");
		try {
			os = ObjectSave.loadData("Sales/sales.bin");
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IOException e2) {
			os= new OrderDataStructure();
		}
		DataStructureSingleton.createOrderStructureSingleton(os);
		Parent root=null;
		try {
			root = FXMLLoader.load(getClass().getResource("/controller/Login.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		primaryStage.setOnCloseRequest(e->{
			try {
				ObjectSave.saveData(DataStructureSingleton.getOrderStructure(), "Sales/sales.bin");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
//		Connection conn = null;
//		try {
//			conn=DriverManager.getConnection();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		Statement createCoffee=null;
//		try {
//			createCoffee = conn.createStatement();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		 String sql = "CREATE TABLE Users " +
//                 "(Username VARCHAR(20) PRIMARY KEY UNIQUE NOT NULL," +
//                 " Password VARCHAR(20) NOT NULL )" 
//                 ; 
//		try {
//			createCoffee.executeUpdate(sql);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		try {
//			createCoffee.executeUpdate("insert into Orders (CoffeeName,CondimentID) Values('Mocha',2)");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}
}
