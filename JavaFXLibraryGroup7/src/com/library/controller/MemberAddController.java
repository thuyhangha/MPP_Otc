package com.library.controller;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.library.entity.Address;
import com.library.entity.CheckoutRecord;
import com.library.entity.LibraryMember;
import com.library.entity.Person;
import com.library.model.DataAccess;
import com.library.recourse.Resource;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MemberAddController implements Initializable {
	@FXML
	private TextField txtMemberId;

	@FXML
	private TextField txtFirstName;

	@FXML
	private TextField txtLastName;

	@FXML
	private TextField txtPhone;

	@FXML
	private TextField txtStreet;
	
	@FXML
	private TextField txtCity;
	
	@FXML
	private TextField txtZip;
	
	@FXML
	private ComboBox cmbState;

	@FXML
	private Button btnCancel;
	
	@FXML
	private Button btnAddMember;
	
	@FXML
	private CheckBox cbAdmin;
	@FXML
	private CheckBox cbLibrarian;
	@FXML
	private CheckBox cbMember;
	
	@FXML
	private Label lblFirstNameError;
	
	@FXML
	private Label lblLastNameError;
	
	@FXML
	private Label lblStreetError;
	
	@FXML
	private Label lblCityError;
	
	@FXML
	private Label lblZipError;
	
	@FXML
	private Label lblPhoneError;
	
	public void setData(){
		String[] states = {"California", "Alabama", "Arkansas", "Arizona", "Alaska", "Colorado",
				"Connecticut", "Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois",
				"Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts",
				"Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada",
				"New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota",
				"Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota",
				"Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin",
				"Wyoming"};
		cmbState.getItems().clear();
		cmbState.getItems().addAll(states);
		cmbState.setValue(states[0]);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		setData();
		
		checkValidTextField(txtFirstName, lblFirstNameError);
		checkValidTextField(txtLastName, lblLastNameError);
		checkValidTextField(txtCity, lblCityError);
		checkValidTextField(txtPhone, lblPhoneError);
		checkValidTextField(txtStreet, lblStreetError);
		checkValidTextField(txtZip, lblZipError);
	}
	
	@FXML
	void goActionCancel(ActionEvent event) throws IOException {
		goToMemberView();
	}
	
	@FXML
	void goAddMember(ActionEvent event) throws IOException {
		try {			
			if(!isEmpty(lblFirstNameError.getText()) && !isEmpty(lblCityError.getText()) && !isEmpty(lblLastNameError.getText())
			   && !isEmpty(lblPhoneError.getText()) && !isEmpty(lblStreetError.getText()) && !isEmpty(lblZipError.getText())){
				String street = txtStreet.getText();
				String city = txtCity.getText();
				String state = cmbState.getSelectionModel().getSelectedItem().toString();
				
				//End validate
				String zip = txtZip.getText();
				Address address = new Address(street, city, state, zip);

				String memberId = txtMemberId.getText();
				String personId = SystemController.getRandom();
				String firstName = txtFirstName.getText();
				String lastName = txtLastName.getText();
				String phoneNumber = txtPhone.getText();
				
				LibraryMember libraryMember = new LibraryMember(personId, firstName, lastName, phoneNumber, address, memberId,
						new CheckoutRecord());
				Person person = new Person(personId, firstName, lastName, phoneNumber, address);
				DataAccess dataAccess  = SystemController.getDataAccessInstance();
				dataAccess.addLibraryMember(libraryMember.getID(), libraryMember);
				dataAccess.addNewPerson(person);

				Alert alert = new Alert(AlertType.INFORMATION);
		    	alert.setTitle("Information Dialog");
		    	alert.setHeaderText("Success");
		    	alert.setContentText("Member is added successful !");
		    	alert.showAndWait();
		    	
		    	goToMemberView();		
			}else {
				showDialog("Error Input", "Error", "Please input correct all value!");
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
		
	//go to privious page - member view
	public void goToMemberView(){
		try{
			Stage stage = (Stage) btnCancel.getScene().getWindow();
			Parent root = FXMLLoader.load(getClass().getResource(Resource.MEMBERVIEW));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	//Start validation	
	public boolean isEmpty(String txt) {
		if(txt.isEmpty())
			return false;
		return true;
	}
	
	public boolean isNumber(TextField txt)
	{
	  return txt.getText().trim().matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
	}
	
	public void checkValidTextField(TextField txtField, Label lblField) {
		
		txtField.focusedProperty().addListener((observable, oldValue, newValue) ->
		{
		   if(txtField.isFocused() == false)
		   {
			   if(!isEmpty(txtField.getText().trim())){
				   	lblField.setVisible(true);					
					setMessage(lblField,"You can't leave this empty.",Color.RED);
				}else if((txtField.getId().equals(txtZip.getId()) || txtField.getId().equals(txtPhone.getId())) && !isNumber(txtField)){
					setMessage(lblField,"Please input umber",Color.RED);
				}else {
					lblField.setVisible(false);
					lblField.setText("");
				}
		   }
		});
	}
	
	public void setMessage(Label l, String message, Color color){
		l.setText(message);
		l.setTextFill(color);
		l.setVisible(true); 
	}
	
	public void removeAllStyle(Node n){
		n.getStyleClass().removeAll("bad","med","good","best"); 
	}
	
	public void showDialog(String title, String headerText, String contentText) {
		Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle(title);
    	alert.setHeaderText(headerText);
    	alert.setContentText(contentText);
    	alert.showAndWait();
	}
}
