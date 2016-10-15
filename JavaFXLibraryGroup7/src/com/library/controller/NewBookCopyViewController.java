package com.library.controller;

import java.io.IOException;

import com.library.entity.Book;
import com.library.entity.BookCopy;
import com.library.model.DataAccess;
import com.library.utility.Utility;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class NewBookCopyViewController {
	@FXML
	TextField txtISBN;
	
	@FXML
	TextField txtCopyNumber;
	
	@FXML
	void goAddBookCopy(ActionEvent event) throws IOException {
		String isbn = txtISBN.getText().trim();
		int copyNumber = Integer.parseInt(txtCopyNumber.getText().trim());
		
		DataAccess dataAccess  = SystemController.getDataAccessInstance();
		Book book = dataAccess.searchBook(isbn);
		if(book == null) 
			Utility.showAlerMessage("Information Dialog", "Add New Book Copy Error", "ISBN does not exist. Please input correct ISBN!", AlertType.ERROR);
		else {			
			BookCopy newBookCopy  = new BookCopy(book, copyNumber);
			dataAccess.addBookCopy(newBookCopy);
			Utility.showAlerMessage("Information Dialog", "Success", "Book Copy is added successful!", AlertType.INFORMATION);
		}
	}
	
	@FXML
	void goCancelBookCopy(ActionEvent event) throws IOException {
		
	}
}
