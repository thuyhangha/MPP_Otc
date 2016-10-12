package application;
	
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.library.entity.Address;
import com.library.entity.Author;
import com.library.entity.Book;
import com.library.entity.BookCopy;
import com.library.entity.Person;
import com.library.model.DataAccess;
import com.library.model.DataAccessFacade;
import com.library.recourse.Resource;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource(Resource.MAINSCREEN));
			Scene scene = new Scene(root, 1150, 800);
			primaryStage.setTitle("Library project group 7");
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			/*TestData test = new TestData();
			SerializeAll seALL = new SerializeAll();
			seALL.deSerializeData();*/
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	private void generateDummyData() {
		  // TODO: TEST CODE
		  DataAccess da = new DataAccessFacade();
		  // PERSONS
		  Address address = new Address("S1", "Fairfield", "Iowa", "52556");
		  Person p1 = new Person("1", "Hang", "Ha", "000000", address);
		  Person p2 = new Person("2", "Thuy Hang", "Ha", "000002", address);
		  da.addNewPerson(p1);
		  da.addNewPerson(p2);
		  HashMap<String, Person> phash = da.getPersons();
		  for (String pId : phash.keySet()) {
		   System.out.println("Person ID: " + pId);
		  }
		  // BOOKS
		  Author author = new Author("123", "ABC", "HTH", "12323131", address, "credent");
		  List<Author> lstAuthor = Arrays.asList(author);
		  Book book = new Book("123", "MPP", 1000, lstAuthor);
		  da.addBook(book);
		  HashMap<String, Book> bhash = da.getBook();
		  for (String bId : bhash.keySet()) {
		   System.out.println("Book ID: " + bId);
		  }
		  // BOOKCOPIES
		  BookCopy bookCopy1 = new BookCopy(book, 1, true);
		  da.addBookCopy(bookCopy1);
		  BookCopy bookCopy2 = new BookCopy(book, 2, true);
		  da.addBookCopy(bookCopy2);
		  BookCopy bookCopy3 = new BookCopy(book, 3, true);
		  da.addBookCopy(bookCopy3);
		  HashMap<String, BookCopy> bcphash = da.getBookCopy();
		  for (String bId : bcphash.keySet()) {
		   System.out.println("Book isbn+number: " + bId);
		  }
		  // END TEST CODE
		 }
}
