package View;



import java.net.URL;
import java.util.ResourceBundle;
import Application.App;
import Database.SQLiteJDBC;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;



public class NewHotelController implements  Initializable, ControlledScreen {


	@FXML
	private TextField HotelNameField;
	@FXML
	private TextField PriceField;
	@FXML
	private TextField StarsField;
	@FXML
	private TextField PopularityField;
	@FXML
	private TextField DistanceField;


	@FXML
	private CheckBox BreakfastCheckBox;
	@FXML
	private CheckBox BarCheckBox;
	@FXML
	private CheckBox GymCheckBox;
	@FXML
	private CheckBox PetsCheckBox;
	@FXML
	private CheckBox PoolCheckBox;


	@FXML
	private int PoolBoolean;
	@FXML
	private int BreakfastBoolean;
	@FXML
	private int GymBoolean;
	@FXML
	private int PetsBoolean;
	@FXML
	private int BarBoolean;


	@FXML
	private boolean okClicked = false;
	
	MainController main;



	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("HotelEdit initialized");
	}


	public void setScreenParent(MainController screenParent){
		main = screenParent;
	}
	@FXML
	private void Canclel(ActionEvent event){
		main.setScreen(App.HotelOverviewID);
	}


	@FXML
	private void handleOk(ActionEvent event) {
		if (isInputValid()) {

			SQLiteJDBC.InsertHotel( HotelNameField.getText(), Double.parseDouble(PriceField.getText()), Integer.parseInt(StarsField.getText()), Integer.parseInt(PopularityField.getText()), Double.parseDouble(DistanceField.getText()), BreakfastBoolean, BarBoolean, GymBoolean, PetsBoolean, PoolBoolean);
			showHotelDetails();
			main.setScreen(App.HotelOverviewID);

		}
	}

	@FXML
	private void poolChosen(ActionEvent event) {
		if(PoolCheckBox.isSelected()==true){
			PoolBoolean = 1;
		}else{
			PoolBoolean = 0;
		}


	}
	@FXML
	private void barChosen(ActionEvent event) {
		if(BarCheckBox.isSelected()==true){
			BarBoolean = 1;
		}else{
			BarBoolean = 0;
		}


	}
	@FXML
	private void breakfastChosen(ActionEvent event) {
		if(BreakfastCheckBox.isSelected()==true){
			BreakfastBoolean = 1;
		}else{
			BreakfastBoolean = 0;
		}


	}
	@FXML
	private void petsChosen(ActionEvent event) {
		if(PetsCheckBox.isSelected()==true){
			PetsBoolean = 1;
		}else{
			PetsBoolean = 0;
		}


	}
	@FXML
	private void gymChosen(ActionEvent event) {
		if(GymCheckBox.isSelected()==true){
			GymBoolean = 1;
		}else{
			GymBoolean = 0;
		}


	}


	private void showHotelDetails() {

		HotelNameField.setText("");
		PriceField.setText("");
		StarsField.setText("");
		PopularityField.setText("");
		DistanceField.setText("");
		BreakfastCheckBox.setText("");
		BarCheckBox.setText(String.valueOf(""));
		GymCheckBox.setText(String.valueOf(""));
		PetsCheckBox.setText(String.valueOf(""));
		PoolCheckBox.setText(String.valueOf(""));
	}


	@FXML
	private boolean isInputValid() {
		String errorMessage = "";

		if (HotelNameField.getText() == null || HotelNameField.getText().length() == 0) {
			errorMessage += "No valid Hotel name \n"; 
		}
		if (StarsField.getText() == null || StarsField.getText().length() == 0) {
			errorMessage += "Not a correct amount of stars \n"; 
		}
		if (PopularityField.getText() == null || PopularityField.getText().length() == 0) {
			errorMessage += "Not a correct amount of popularity \n"; 
		}

		if (DistanceField.getText() == null || DistanceField.getText().length() == 0) {
			errorMessage += "Not a valid distance \n"; 
		}

		if (errorMessage.length() == 0) {
			return true;

		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.initOwner(App.getPrimaryStage());
			alert.setTitle("Invalid Fields");
			alert.setHeaderText("Please correct invalid fields");
			alert.setContentText(errorMessage);
			alert.showAndWait();

			return false;
		}

	}

	public NewHotelController() {
	}













}