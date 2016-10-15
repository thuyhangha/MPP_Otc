package com.library.utility;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Utility {
	 public static void showAlerMessage(String title, String header, String message, AlertType alertType) {
	    	Alert alert = new Alert(alertType);
	    	alert.setTitle(title);
	    	alert.setHeaderText(header);
	    	alert.setContentText(message);
	    	alert.showAndWait();
	 }
}
