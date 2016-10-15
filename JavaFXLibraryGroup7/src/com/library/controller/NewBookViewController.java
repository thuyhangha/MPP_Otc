package com.library.controller;

import java.io.IOException;

import com.library.entity.Book;
import com.library.model.DataAccess;
import com.library.utility.Utility;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class NewBookViewController {
	@FXML
	TextField txtISBN;
	
	@FXML
	TextField txtTitle;
	
	@FXML
	TextField txtBorrowDuration;
	
	@FXML
	void goActionCancel(ActionEvent event) throws IOException {
		txtISBN.setText("");
		txtTitle.setText("");
		txtBorrowDuration.setText("");
	}
	
	@FXML
	void goActionAddNewBook(ActionEvent event) throws IOException {
		String isbn = txtISBN.getText().trim();
		String title = txtTitle.getText().trim();
		Integer borrowDuration = Integer.parseInt(txtBorrowDuration.getText().trim());
	
		DataAccess dataAccess  = SystemController.getDataAccessInstance();
		Book book = dataAccess.searchBook(isbn);
		if(book != null) 
			Utility.showAlerMessage("Information Dialog", "Add New Book Error", "This book is not available!", AlertType.ERROR);
		else {
			Book newbook  = new Book(isbn, title, borrowDuration);		
			dataAccess.addBook(newbook);
			Utility.showAlerMessage("Information Dialog", "Success", "Book is added successful!", AlertType.INFORMATION);
		}
	}
}
