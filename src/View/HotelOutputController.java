package View;


import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import Application.App;
import Classes.Hotel;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import Database.*;

public class HotelOutputController implements Initializable, ControlledScreen {

	private MainController main;
	@FXML TableView<Hotel> HotelTable;
	@FXML
	private Button refresh;
	@FXML
	private TableColumn<Hotel, String> HotelNameColumn;
	@FXML private Label HotelNameLabel;
	@FXML
	private Label PriceLabel;
	@FXML
	private Label StarsLabel;
	@FXML
	private Label PopularityLabel;
	@FXML
	private Label DistanceLabel;
	@FXML
	private Label BreakfastLabel;
	@FXML
	private Label BarLabel;
	@FXML
	private Label GymLabel;
	@FXML
	private Label PetsLabel;
	@FXML
	private Label PoolLabel;
	@FXML
	private boolean okClicked = false;
	@FXML
	ArrayList<Hotel> databaseOut = SQLiteJDBC.RetrieveHotels();
	ObservableList<Hotel> obslist = FXCollections.observableList(databaseOut);
	@FXML
	CheckBox CheapestHotel;
	@FXML
	private Slider PriceSlider;
	@FXML
	private Label PriceLbl;
	//@FXML
	//ArrayList<Hotel> dbFilterPrice = SQLiteJDBC.FilterByPrice();
	//@FXML
	//private ObservableList<Hotel> PriceList = FXCollections.observableArrayList(dbFilterPrice);
	@FXML
	ArrayList<Hotel> dbOrderPrice = SQLiteJDBC.OrderByPrice();
	@FXML
	private ObservableList<Hotel> CheapList = FXCollections.observableArrayList(dbOrderPrice);
	@FXML
	CheckBox DistanceHotel;
	@FXML
	ArrayList<Hotel> dbOrderDistance = SQLiteJDBC.OrderByDistance();
	@FXML
	private ObservableList<Hotel> DistanceList = FXCollections.observableArrayList(dbOrderDistance);
	public static IntegerProperty updateOutput;

	public void setScreenParent(MainController screenParent){
		main = screenParent;
	}
	@FXML
	private void goToAdmin(ActionEvent event){
		main.setScreen(App.LoginScreenID);

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		
		if(!obslist.isEmpty()){
			updateOutput = new SimpleIntegerProperty(1);
			
			updateOutput.addListener(new ChangeListener<Number>() {
				
				@Override
				public void changed(ObservableValue<? extends Number> observable, Number oldValue,
						Number newValue) {
					setList();
					System.out.println("Output Updated");
					
				}
			});

			HotelTable.setItems(obslist);
			HotelNameColumn.setCellValueFactory(cellData -> cellData.getValue().HotelNameProperty());
			showHotelDetails(null);
			HotelTable.getSelectionModel().selectedItemProperty().addListener(
					(observable, oldValue, newValue) -> showHotelDetails(newValue));
			System.out.println("HotelOutput initialized with content");
		}else{
			System.out.println("HotelOutput initialized without content");
		}
		


        PriceSlider.valueChangingProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(
                    ObservableValue<? extends Boolean> observableValue,
                    Boolean wasChanging,
                    Boolean changing) {
                String valueString = String.format("%1$.3f", PriceSlider.getValue());

                if (changing) {
                    PriceLbl.setText(
                            valueString
                    );
                } else {
                    PriceLbl.setText(
                            valueString
                    );
                }
            }
        });

	}




	
	@FXML
	private void DistanceHotel(ActionEvent event){
		if(DistanceHotel.isSelected()){	
		if(!DistanceList.isEmpty()){
				dbOrderDistance = SQLiteJDBC.OrderByDistance();
				HotelTable.setItems(DistanceList);
				HotelNameColumn.setCellValueFactory(cellData -> cellData.getValue().HotelNameProperty());
				showHotelDetails(null);
				HotelTable.getSelectionModel().selectedItemProperty().addListener(
						(observable, oldValue, newValue) -> showHotelDetails(newValue));
				System.out.println("DistanceHotel initialized with content");
			}else{
				System.out.println("DistanceHotel initialized without content");
			}
		}else{
		if(!databaseOut.isEmpty()){
			databaseOut = SQLiteJDBC.RetrieveHotels();
			HotelTable.setItems(obslist);
			HotelNameColumn.setCellValueFactory(cellData -> cellData.getValue().HotelNameProperty());
			showHotelDetails(null);
			HotelTable.getSelectionModel().selectedItemProperty().addListener(
					(observable, oldValue, newValue) -> showHotelDetails(newValue));
			System.out.println("HotelOutput initialized with content");
		}else{
			System.out.println("HotelOutput initialized without content");
		}
		}
	}


	@FXML public void setList(){
		databaseOut = SQLiteJDBC.RetrieveHotels();
		obslist = FXCollections.observableList(databaseOut);
		HotelTable.setItems(obslist);
		
	}



	private void showHotelDetails(Hotel Hotel) {
		if (Hotel != null) {


			HotelNameLabel.setText(Hotel.getHotelName());
			StarsLabel.setText(Integer.toString(Hotel.getStars()));
			PopularityLabel.setText(Integer.toString(Hotel.getPopularity()));
			PriceLabel.setText(Double.toString(Hotel.getHotelPrice()));
			DistanceLabel.setText(Double.toString(Hotel.getDistance()));
			BreakfastLabel.setText(Boolean.toString(Hotel.getBreakfast()));
			BarLabel.setText(Boolean.toString(Hotel.getBar()));	 
			GymLabel.setText(Boolean.toString(Hotel.getGym()));	
			PetsLabel.setText(Boolean.toString(Hotel.getPets()));
			PoolLabel.setText(Boolean.toString(Hotel.getPool()));
		}else{

			HotelNameLabel.setText("");
			StarsLabel.setText(Integer.toString(0));
			PopularityLabel.setText(Integer.toString(0));
			PriceLabel.setText(Double.toString(0));
			DistanceLabel.setText(Double.toString(0));
			BreakfastLabel.setText(Boolean.toString(false));
			BarLabel.setText(Boolean.toString(false));	 
			GymLabel.setText(Boolean.toString(false));	
			PetsLabel.setText(Boolean.toString(false));
			PoolLabel.setText(Boolean.toString(false));
		}
	}



	public HotelOutputController() {


	}


}
