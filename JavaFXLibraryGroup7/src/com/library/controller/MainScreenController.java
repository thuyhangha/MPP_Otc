package com.library.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.library.entity.Auth;
import com.library.entity.LoggedUser;
import com.library.entity.User;
import com.library.recourse.Resource;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class MainScreenController implements Initializable{

	@FXML
	Hyperlink hlViewLibraryMember;
	
	@FXML
	Hyperlink hlAddLibraryMember;
	
	@FXML
	Hyperlink hlOverdueBook;
	
	@FXML
	Hyperlink hlCheckoutBook;
	
	@FXML
	Hyperlink hlAddACopyExsitingBook;
	
	@FXML
	Hyperlink hlAddABook;
	
	@FXML
	Hyperlink hlPrintCheckoutRecord;
	
	@FXML
	BorderPane rightPlitBorderPanel;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		User loggedUser = LoggedUser.getInstance().getUser();
		String authen = loggedUser.getAuthorization().name();
		if(authen.equals(Auth.ADMIN)){
			hlAddABook.setDisable(false);
			hlViewLibraryMember.setDisable(false);
			hlAddLibraryMember.setDisable(false);
			hlAddACopyExsitingBook.setDisable(false);
			hlAddABook.setDisable(false);
			
			hlCheckoutBook.setDisable(true);
			hlPrintCheckoutRecord.setDisable(true);
			hlOverdueBook.setDisable(true);
		}else if(authen.equals(Auth.LIBRARIAN)){
			hlAddABook.setDisable(true);
			hlViewLibraryMember.setDisable(true);
			hlAddLibraryMember.setDisable(true);
			hlAddACopyExsitingBook.setDisable(true);
			hlAddABook.setDisable(true);
			
			hlCheckoutBook.setDisable(false);
			hlPrintCheckoutRecord.setDisable(false);
			hlOverdueBook.setDisable(false);
		}else if(authen.equals(Auth.BOTH)){
			hlAddABook.setDisable(false);
			hlViewLibraryMember.setDisable(false);
			hlAddLibraryMember.setDisable(false);
			hlAddACopyExsitingBook.setDisable(false);
			hlAddABook.setDisable(false);
			
			hlCheckoutBook.setDisable(false);
			hlPrintCheckoutRecord.setDisable(false);
			hlOverdueBook.setDisable(false);
		}
	}
	
	@FXML
	void goViewLibraryMember(ActionEvent event) throws IOException{
		gotoLibraryMemberMethod();
	}

	private void gotoLibraryMemberMethod() throws IOException {
		rightPlitBorderPanel.getChildren().clear();
		AnchorPane pane = FXMLLoader.load(getClass().getResource(Resource.MEMBERVIEW));
        rightPlitBorderPanel.setCenter(pane);
	}
	
	@FXML
	void goAddLibraryMember(ActionEvent event) throws IOException{
		rightPlitBorderPanel.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource(Resource.MEMBERADD));
        rightPlitBorderPanel.setCenter(pane);
	}
	
	@FXML
	void goOverdueBook(ActionEvent event) throws IOException{
		rightPlitBorderPanel.getChildren().clear();
		AnchorPane pane = FXMLLoader.load(getClass().getResource(Resource.OVERDUEBOOK));
        rightPlitBorderPanel.setCenter(pane);
	}
	
	@FXML
	void goCheckoutBook(ActionEvent event) throws IOException{
		rightPlitBorderPanel.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource(Resource.CHECKOUTBOOKFORM));
        rightPlitBorderPanel.setCenter(pane);
	}
	
	@FXML
	void goAddACopyExsitingBook(ActionEvent event) throws IOException{
		rightPlitBorderPanel.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource(Resource.NEWBOOKCOPYVIEW));
        rightPlitBorderPanel.setCenter(pane);
	}
	
	@FXML
	void goAddABook(ActionEvent event) throws IOException{
		rightPlitBorderPanel.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource(Resource.NEWBOOKVIEW));
        rightPlitBorderPanel.setCenter(pane);
	}
	
	@FXML
	void goPrintCheckoutRecord(ActionEvent event) throws IOException{
		rightPlitBorderPanel.getChildren().clear();
        AnchorPane pane = FXMLLoader.load(getClass().getResource(Resource.PRINTCHECKOUTRECORD));
        rightPlitBorderPanel.setCenter(pane);
	}
}
