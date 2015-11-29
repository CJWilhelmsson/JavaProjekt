package Application;




import Classes.Hotel;
import Database.SQLiteJDBC;
import View.HotelEditController;
import View.HotelOutputController;
import View.HotelOverviewController;
import View.MainController;
import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.stage.Stage;


public class App extends Application{

	public static Stage primaryStage;
	public static String HotelOutputID = "HotelOutput";
	public static String HotelOutputFile = "HotelOutput.fxml";
	public static String HotelEditID = "HotelEdit";
	public static String HotelEditFile = "HotelEdit.fxml";
	public static String HotelOverviewID = "HotelOverview";
	public static String HotelOverviewFile = "HotelOverview.fxml";
	public static String LoginScreenID = "LoginScreen";
	public static String LoginScreenFile = "LoginScreen.fxml";
	public static String RegisterScreenID = "RegisterScreen";
	public static String RegisterScreenFile = "RegisterScreen.fxml";
	public static Group root;
	public static MainController mainContainer;
	public static Scene scene;
	public static IntegerProperty update;
	public static IntegerProperty slider;
	public static Hotel sendHotel;
	public static ObjectProperty<Hotel> appHotel;

	@Override
	public void start(Stage primaryStage) throws Exception{
		@SuppressWarnings("unused")
		SQLiteJDBC hello = new SQLiteJDBC();
		update = new SimpleIntegerProperty(1);

		update.addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue,
					Number newValue) {

				int tmp = HotelOverviewController.updateOverview.get();
				tmp = tmp+1;
				HotelOverviewController.updateOverview.set(tmp);
				HotelOutputController.updateOutput.set(tmp);

			}
		});
		

	   
		
		appHotel = new SimpleObjectProperty<Hotel>(null);

		appHotel.addListener(new ChangeListener<Hotel>() {

			@Override
			public void changed(ObservableValue<? extends Hotel> observable, Hotel oldValue,
					Hotel newValue) {
				sendHotel = appHotel.get();
				HotelEditController.hotelEdit.set(sendHotel);
				System.out.println("Hotel sent to Edit");

			}
		});
		
		

		mainContainer = new MainController();
		mainContainer.loadScreen(App.HotelOutputID,  App.HotelOutputFile);
		mainContainer.loadScreen(App.HotelOverviewID,  App.HotelOverviewFile);
		mainContainer.loadScreen(App.HotelEditID,  App.HotelEditFile);
		mainContainer.loadScreen(App.LoginScreenID,  App.LoginScreenFile);
		mainContainer.loadScreen(App.RegisterScreenID,  App.RegisterScreenFile);
		
		mainContainer.setScreen(App.HotelOutputID);


		root = new Group();
		root.getChildren().addAll(mainContainer); 
		scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();

	}



	public static Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
	}






}
