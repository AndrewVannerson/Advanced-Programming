import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * 
 */

/**
 * @author Andrew
 *
 */
public class PersonGUI extends Application implements EventHandler<ActionEvent>
{
	
	private TextArea text = new TextArea();
	private VBox vbox = new VBox();
	private TextField firstName = new TextField();
	private TextField lastName = new TextField();
	private TextField id = new TextField();
	private TextField city = new TextField();
	private Label nameFirst = new Label();
	private Label nameLast = new Label();
	private Label idNum = new Label();
	private Label personCity = new Label();
	private HBox hbox = new HBox();
	private Button save = new Button();
	private Button cancel = new Button();
	private ArrayList<Person> personList = new ArrayList<Person>();
	private AlertBox alert = new AlertBox();
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		launch(args);

	}
	
	
	public void start(Stage primaryStage) throws Exception
	{
		
		
		
		save.setText("Save");
		cancel.setText("Cancel");
		save.setOnAction(this);
		cancel.setOnAction(this);
		
		nameFirst.setText("First Name");
		nameLast.setText("Last Name");
		idNum.setText("ID");
		personCity.setText("City");
		
		hbox.getChildren().add(save);
		hbox.getChildren().add(cancel);
		
		
		vbox.getChildren().add(nameFirst);
		vbox.getChildren().add(firstName);
		vbox.getChildren().add(nameLast);
		vbox.getChildren().add(lastName);
		vbox.getChildren().add(idNum);
		vbox.getChildren().add(id);
		vbox.getChildren().add(personCity);
		vbox.getChildren().add(city);
		vbox.getChildren().add(hbox);
		
		BorderPane border = new BorderPane();
		border.setCenter(text);
		border.setBottom(vbox);
		
		text.setEditable(false);
	
		primaryStage.setHeight(500);
		primaryStage.setWidth(500);
		Scene scene = new Scene(border);
		
		primaryStage.setTitle("Person Maker");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	public void handle(ActionEvent event)
	{
		if(event.getSource()== save)
		{
			Person temp = new Person(firstName.getText(),lastName.getText(),Integer.parseInt(id.getText()),city.getText());
			personList.add(temp);
			text.setText(personList.toString()+ "\n");
			firstName.setText(null);
			lastName.setText(null);
			id.setText(null);
			city.setText(null);
			
			
		}
		
		if(event.getSource() == cancel)
		{
			
			alert.display("ATTENTION", "Are you sure you want to Cancel?");
		}	
			
		if(alert.getYesNumber() > 0)	
		{
			firstName.setText(null);
			lastName.setText(null);
			id.setText(null);
			city.setText(null);
		}
		
		
	}

}
