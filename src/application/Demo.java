package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import model.Coffee;
import model.Condiment;
import model.Condiments;
import model.DarkRoast;
import model.Decaf;
import model.Mocha;
import model.Order;
import model.Sandwich;
import model.Soy;
import model.SteamedMilk;
import model.WhippedMilk;

public class Demo {

	public static void main(String[] args) {
//		Connection conn = null;
//		try {
//			conn=DriverManager.getConnection("jdbc:sqlite:CoffeeDB.sqlite");
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
//		 String sql = "Create TABLE OrderItems "+
//                 "(OrderNumber Integer," +
//                 " Orderable VARCHAR(60) NOT NULL," +
//                 " CoffeeVariety VARCHAR(60),"+
//                 " Condiments VARCHAR(1000))"
//                 
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
