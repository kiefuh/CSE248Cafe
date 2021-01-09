package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.DatabaseSingleton;
import model.UserSingleton;

public class LoginController {
	@FXML
	private TextField usernameField;
	@FXML
	private PasswordField passwordField; 
	@FXML
	private Button loginButton;
	@FXML
	private Button createUserButton;
	
	public LoginController() {
		
	}
	
	@FXML
	private void onloginButtonClick(ActionEvent event) {
		String username= usernameField.getText();
		String password= passwordField.getText();
		Connection conn=DatabaseSingleton.getConnection();
		Statement checkPassword=null;
		try {
			checkPassword=conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql="SELECT Password "
				+ "FROM Users "
				+ "WHERE Username ='"+username+"'";
		ResultSet rs=null;
		try {
			rs=checkPassword.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String checkword=null;
		try {
			checkword=rs.getString("Password");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(checkword.equals(password)) {
			System.out.println("This is the correct password");
			Parent root=null;
			try {
				root = FXMLLoader.load(getClass().getResource("/controller/Home.fxml"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			UserSingleton.makeTheUser(username);
			Scene scene=loginButton.getScene();
			scene.setRoot(root);
		}
		else{
			System.out.println("This is the incorrect password");
		}
	}
	
	@FXML
	private void onCreateUserButtonClick(ActionEvent event) {
		Parent root=null;
		try {
			root = FXMLLoader.load(getClass().getResource("/controller/CreateUser.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scene scene= passwordField.getScene();
		scene.setRoot(root);
	}

}
