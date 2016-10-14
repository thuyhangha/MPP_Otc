package com.library.controller;

import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.Set;

import com.library.entity.LibraryMember;
import com.library.entity.Person;
import com.library.model.DataAccess;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class MembersViewController implements Initializable{
	
	@FXML
    private TableView<LibraryMember> tblMemberList;

    @FXML
    private TableColumn<LibraryMember, String> ID;

    @FXML
    private TableColumn<LibraryMember, String> firstName;

    @FXML
    private TableColumn<LibraryMember, String> lastName;

    @FXML
    private TableColumn<LibraryMember, String> phone;

    @FXML
    private TableColumn<LibraryMember, String> street;
    
    ObservableList<LibraryMember> personData ;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		DataAccess dataAccess  = SystemController.getDataAccessInstance();
		
		//start
		HashMap<String, LibraryMember> hashMap = dataAccess.getLibraryMember();

    	personData = FXCollections.observableArrayList(); 

    	Set set = hashMap.keySet();
        Iterator iter = set.iterator();
    	while(iter.hasNext()){
    		personData.add(hashMap.get(iter.next()));
    	}

    	ID.setCellValueFactory(new PropertyValueFactory<LibraryMember,String>("memberId"));

    	firstName.setCellValueFactory( new PropertyValueFactory<LibraryMember,String>("firstName"));
    	lastName.setCellValueFactory( new PropertyValueFactory<LibraryMember,String>("lastName"));
    	phone.setCellValueFactory( new PropertyValueFactory<LibraryMember,String>("phone"));


		street.setCellValueFactory(new Callback<CellDataFeatures<LibraryMember, String>, ObservableValue<String>>() {
		     public ObservableValue<String> call(CellDataFeatures<LibraryMember, String> p) {
		         String rStreet = p.getValue().getAddress().getStringAddress(); 
		         return new SimpleStringProperty(rStreet);
		     }
		});

    	tblMemberList.setItems(personData);	
	}
	
	//Search by ID
	public Person searchByID(String ID) {
		for(Person item: personData){
			if(item.getID().equalsIgnoreCase(ID))
				return item;
		}
		return null;
	}
}