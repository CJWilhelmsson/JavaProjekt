package Classes;

import javafx.beans.property.StringProperty;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;


public class Hotel {

	private final IntegerProperty HID;
	private final StringProperty HotelName;
	private final IntegerProperty Stars;
	private final DoubleProperty Price;
	private final IntegerProperty Popularity;
	private final DoubleProperty Distance;
	private final BooleanProperty Breakfast;
	private final BooleanProperty Bar;
	private final BooleanProperty Gym;
	private final BooleanProperty Pets;
	private final BooleanProperty Pool;


	public Hotel() {
		this.HotelName = new SimpleStringProperty();
		this.Stars = new SimpleIntegerProperty();
		this.Popularity = new SimpleIntegerProperty();
		this.Distance = new SimpleDoubleProperty();
		this.Breakfast = new SimpleBooleanProperty();
		this.Bar = new SimpleBooleanProperty();
		this.Gym = new SimpleBooleanProperty();
		this.Pets = new SimpleBooleanProperty();
		this.Pool = new SimpleBooleanProperty();
		this.HID = new SimpleIntegerProperty();
		this.Price = new SimpleDoubleProperty();
	}



	public Hotel(int HID, String HotelName, double Price, int Stars, int Popularity, double Distance, boolean Breakfast, Boolean Bar, Boolean Gym, Boolean Pets, Boolean Pool) {
		this.HotelName = new SimpleStringProperty(HotelName);
		this.Stars = new SimpleIntegerProperty(Stars);
		this.Popularity = new SimpleIntegerProperty(Popularity);
		this.Distance = new SimpleDoubleProperty(Distance);
		this.Breakfast = new SimpleBooleanProperty(Breakfast);
		this.Bar = new SimpleBooleanProperty(Bar);
		this.Gym = new SimpleBooleanProperty(Gym);
		this.Pets = new SimpleBooleanProperty(Pets);
		this.Pool = new SimpleBooleanProperty(Pool);
		this.HID = new SimpleIntegerProperty(HID);
		this.Price = new SimpleDoubleProperty(Price);
	}


	//HotelName
	public String getHotelName() {
		return HotelName.get();
	}

	public void setHotelName(String HotelName) {
		this.HotelName.set(HotelName);
	}
	public StringProperty HotelNameProperty() {
		return HotelName;
	}

	//HID
	public int getHotelId() {
		return HID.get();
	}

	public void setHotelId(int HotelName) {
		this.HID.set(HotelName);
	}

	public IntegerProperty HotelIdProperty() {
		return HID;
	}



	//Price
	public double getHotelPrice() {
		return Price.get();
	}

	public void setHotelPrice(double HotelName) {
		this.Price.set(HotelName);
	}

	public DoubleProperty HotelPriceProperty() {
		return Price;
	}

	//Stars
	public int getStars() {
		return Stars.get();
	}

	public void setStars(int Stars) {
		this.Stars.set(Stars);
	}

	public IntegerProperty StarsProperty() {
		return Stars;
	}

	//Popularity
	public int getPopularity() {
		return Popularity.get();
	}

	public void setPopularity(int Popularity) {
		this.Popularity.set(Popularity);
	}

	public IntegerProperty StarsPopularity() {
		return Popularity;
	}


	//Distance
	public double getDistance() {
		return Distance.get();
	}

	public void setDistance(double Distance) {
		this.Distance.set(Distance);
	}

	public DoubleProperty DistanceProperty() {
		return Distance;
	}


	//Breakfast
	public boolean getBreakfast() {
		return Breakfast.get();
	}

	public void setBreakfast(boolean Breakfast) {
		this.Breakfast.set(Breakfast);
	}

	public BooleanProperty BreakfastProperty() {
		return Breakfast;
	}


	//Bar
	public boolean getBar() {
		return Bar.get();
	}

	public void setBar(boolean Bar) {
		this.Bar.set(Bar);
	}

	public BooleanProperty BarProperty() {
		return Bar;
	}


	// Gym
	public boolean getGym() {
		return Gym.get();
	}

	public void setGym(boolean Gym) {
		this.Gym.set(Gym);
	}

	public BooleanProperty GymProperty() {
		return Gym;
	}


	//Pets
	public boolean getPets() {
		return Pets.get();
	}

	public void setPets(boolean Pets) {
		this.Pets.set(Pets);
	}

	public BooleanProperty PetsProperty() {
		return Pets;
	}


	//Pool
	public boolean getPool() {
		return Pool.get();
	}

	public void setPool(boolean Pool) {
		this.Pool.set(Pool);
	}

	public BooleanProperty PoolProperty() {
		return Pool;
	}
}


