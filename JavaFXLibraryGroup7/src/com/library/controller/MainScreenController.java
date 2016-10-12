package com.library.controller;

import java.io.IOException;

import com.library.recourse.Resource;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class MainScreenController {

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
	
	@FXML
	void goViewLibraryMember(ActionEvent event) throws IOException{
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
		AnchorPane pane = FXMLLoader.load(getClass().getResource(Resource.BOOKVIEW));
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
	void goPrintCheckoutRecord(ActionEvent event){
		
	}

	/*Stage stage = (Stage) hlViewLibraryMember.getScene().getWindow();
	rightPlitBorderPanel = new BorderPane();
	rightPlitBorderPanel.getChildren().clear();

	AnchorPane root = FXMLLoader.load(getClass().getResource(Resource.MEMBERVIEWTOMEMBER));
	
	rightPlitBorderPanel.setCenter(root);
	
	//Scene scene = new Scene(rightPlitBorderPanel);
	stage.getScene().setRoot(rightPlitBorderPanel);
	stage.show();*/
	
	/*AnchorPane root = FXMLLoader.load(getClass().getResource(Resource.MEMBERVIEWTOMEMBER));
	rightPlitBorderPanel.getChildren().clear();
	rightPlitBorderPanel.getChildren().setAll(root);*/
}
