package com.library.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.library.entity.Book;
import com.library.model.DataAccess;
import com.library.utility.Utility;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.paint.Color;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class NewBookViewController implements Initializable{
	@FXML
	TextField txtISBN;
	
	@FXML
	TextField txtTitle;
	
	@FXML
	TextField txtBorrowDuration;
	
	@FXML
	TextField txtFirstNameOfAuthor;
	
	@FXML
	TextField txtLastNameOfAuthor;
	
	@FXML
	TextField txtCredentialOfAuthor;
	
	@FXML
	TextField txtPhoneOfAuthor;
	
	@FXML
	Label lblISBNError;
	
	@FXML
	Label lblTitleError;
	
	@FXML
	Label lblBorrowDurationError;
	
	@FXML
	Label lblFirstNameOfAuthorError;
	
	@FXML
	Label lblLastNameOfAuthorError;
	
	@FXML
	Label lblCredentialOfAuthorError;
	
	@FXML
	Label lblPhoneOfAuthorError;
	
	@FXML
	Button btnAdd;
	
	@FXML
	Button btnCancel;
	
	@FXML
	void goActionCancel(ActionEvent event) throws IOException {
		txtISBN.setText("");
		txtTitle.setText("");
		txtBorrowDuration.setText("");
		txtFirstNameOfAuthor.setText("");
		txtLastNameOfAuthor.setText("");
		txtCredentialOfAuthor.setText("");
		txtPhoneOfAuthor.setText("");
	}
	
	@FXML
	void goActionAdd(ActionEvent event) throws IOException {
				
		if(Utility.isEmpty(lblISBNError.getText().trim()) && Utility.isEmpty(lblTitleError.getText().trim()) && Utility.isEmpty(lblBorrowDurationError.getText().trim())
		   && Utility.isEmpty(lblPhoneOfAuthorError.getText().trim())){
			
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
				
				Utility.goToMainScreen(btnAdd, getClass());
			}
		}
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Utility.checkEmptyTextField(txtISBN, lblISBNError);
		Utility.checkEmptyTextField(txtTitle, lblTitleError);
		
		Utility.checkNumberTextField(txtBorrowDuration, lblBorrowDurationError);
		Utility.checkNumberTextField(txtPhoneOfAuthor, lblPhoneOfAuthorError);
	}
}
