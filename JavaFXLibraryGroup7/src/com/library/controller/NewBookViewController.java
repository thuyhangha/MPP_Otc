package com.library.controller;

import java.io.IOException;

import com.library.entity.Book;
import com.library.model.DataAccess;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class NewBookViewController {
	@FXML
	TextField txtISBN;
	
	@FXML
	TextField txtTitle;
	
	@FXML
	TextField txtBorrowDuration;
	
	@FXML
	void goActionCancel(ActionEvent event) throws IOException {
		//goToMemberView();
	}
	
	@FXML
	void goActionAddNewBook(ActionEvent event) throws IOException {
		String isbn = txtISBN.getText().trim();
		String title = txtTitle.getText().trim();
		Integer borrowDuration = Integer.parseInt(txtBorrowDuration.getText().trim());
		
		Book book  = new Book(isbn, title, borrowDuration);
		
		DataAccess dataAccess  = SystemController.getDataAccessInstance();
		dataAccess.addBook(book);
		
		Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("Information Dialog");
    	alert.setHeaderText("Success");
    	alert.setContentText("Book is added successful !");
    	alert.showAndWait();
	}
	
}
