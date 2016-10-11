package com.library.controller;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.Set;

import com.library.entity.Person;
import com.library.model.DataAccess;
import com.library.recourse.Resource;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;

public class MembersViewController implements Initializable{
	
	@FXML
    private TableView<Person> tblMemberList;

    @FXML
    private TableColumn<Person, Integer> ID;

    @FXML
    private TableColumn<Person, String> firstName;

    @FXML
    private TableColumn<Person, String> lastName;

    @FXML
    private TableColumn<Person, String> phone;

    @FXML
    private TableColumn<Person, String> street;

    @FXML
    private Button btnAddNewMember;
    
    ObservableList<Person> personData ;
    
    @FXML
    void goMemberAdd(ActionEvent event) throws IOException {
    	try {
	    	Stage stage = (Stage) btnAddNewMember.getScene().getWindow();
	    	Parent root = FXMLLoader.load(getClass().getResource(Resource.MEMBERADDTOMEMBERVIEW));
	        Scene scene = new Scene(root);
		
	    	stage.setScene(scene);
	    	stage.show();
    	 } catch (IOException e) {
             e.printStackTrace();
         }
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		DataAccess dataAccess  = SystemController.getDataAccessInstance();
		
		//start
		HashMap<String, Person> hashMap = new HashMap<String, Person>();
    	hashMap = (HashMap<String, Person>) dataAccess.getPersons();

    	personData = FXCollections.observableArrayList();

    	Set set = hashMap.keySet();
        Iterator iter = set.iterator();
    	while(iter.hasNext()){
    		personData.add(hashMap.get(iter.next()));
    	}

    	ID.setCellValueFactory(new PropertyValueFactory<Person,Integer>("ID"));

    	firstName.setCellValueFactory( new PropertyValueFactory<Person,String>("firstName"));
    	lastName.setCellValueFactory( new PropertyValueFactory<Person,String>("lastName"));
    	phone.setCellValueFactory( new PropertyValueFactory<Person,String>("phone"));


		street.setCellValueFactory(new Callback<CellDataFeatures<Person, String>, ObservableValue<String>>() {
		     public ObservableValue<String> call(CellDataFeatures<Person, String> p) {
		         String rStreet = p.getValue().getAddress().getStreet().trim() + " "
		    	        		 + p.getValue().getAddress().getCity().trim() + " "
		    	        		 + p.getValue().getAddress().getState().trim() + " "
		    	        		 + p.getValue().getAddress().getZip().trim(); 
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
