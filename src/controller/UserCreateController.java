package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.DatabaseSingleton;

public class UserCreateController {
	@FXML
	private TextField usernameField;
	@FXML
	private TextField passwordField;
	@FXML
	private Button finishedButton;
	
	public UserCreateController() {
		
	}
	
	@FXML
	private void onFinishedButtonClick(ActionEvent actionevent) {
		String username= usernameField.getText();
		String password= passwordField.getText();
		Connection conn = DatabaseSingleton.getConnection();
		Statement createUser=null;
		try {
			createUser=conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String update="INSERT INTO Users (Username , Password) VALUES( '" + username + "','" + password + "')";
		try {
			createUser.executeUpdate(update);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("User added");
		Scene scene= finishedButton.getScene();
		Parent root=null;
		try {
			root = FXMLLoader.load(getClass().getResource("/controller/Login.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		scene.setRoot(root);
	}
}
