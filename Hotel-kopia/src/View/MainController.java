package View;

import java.io.IOException;
import java.util.HashMap;

import Classes.Hotel;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;



public class MainController extends StackPane{
	
	private HashMap<String, Node> screens = new HashMap<>();
	@FXML HotelEditController edit;
	@FXML HotelOutputController out;
	@FXML HotelOverviewController over;
	
	public MainController(){
		super();
	}
	


	public void addScreen(String name, Node screen){
		screens.put(name, screen);
	}

	public Node getScreen(String name){
		return screens.get(name);

	}
	
	
	public boolean loadScreen(String name, String resource){
		try {
			FXMLLoader myLoader = new FXMLLoader(getClass().getResource(resource));
			Parent loadscreen = (Parent) myLoader.load();
			ControlledScreen myScreenController = ((ControlledScreen) myLoader.getController());
			myScreenController.setScreenParent(this);
			addScreen(name, loadscreen);
			return true;
		}catch (Exception e) {
			System.out.println(e.getMessage()+"Gick inte att ladda");
			return false;
		}
	}
	public boolean setScreen(final String name){
		

		if (screens.get(name)!= null){

			if (!getChildren().isEmpty()){
				getChildren().remove(0);
				getChildren().add(0, screens.get(name));
				
				
			} else {

				getChildren().add(screens.get(name));
			}
			return true;
		}else{
			System.out.println("Screen hasnt been loaded!");
			return false;
		}
	}
	public boolean unloadScreen(String name){
		if (screens.remove(name)== null){
			System.out.println("Screen didnt exist");
			return false;

		}else{ 
			return true;
		}
	}

}