package com.skilldistillery.foodproject;

public class FoodTruck {
	
	//Static variable same for all FoodTruck objects
	private static int nextId = 1000;
	
	//dynamic variables unique for each specific FoodTruck and don't exist until a FoodTruck is constructed.
	//These are declared, not initialized (until a ctor is used.)
	private int uniqueId;
	private String truckName;
	private String typeOfFood;
	private double foodRating;
	
	public FoodTruck(String truckName, String typeOfFood, double foodRating) {
		this.uniqueId = nextId++;
		this.truckName = truckName;
		this.typeOfFood = typeOfFood;
		this.foodRating = foodRating;
	}

	//These are all part of a FoodTruck. If a FoodTruck has no been constructed, they are not accessible. 
	public int getUniqueId() {
		return uniqueId;
	}

	public String getTruckName() {
		return truckName;
	}

	public void setTruckName(String truckName) {
		this.truckName = truckName;
	}

	public String getTypeOfFood() {
		return typeOfFood;
	}

	public void setTypeOfFood(String typeOfFood) {
		this.typeOfFood = typeOfFood;
	}

	public double getFoodRating() {
		return foodRating;
	}

	public void setFoodRating(double foodRating) {
		this.foodRating = foodRating;
	}
	
	@Override
	public String toString() {
		return "Truck ID#: " + uniqueId + "\nTruck name: " + truckName + 
				"\nFood Style: " + typeOfFood + "\nFood Truck Rating: " + foodRating + "\n";
	}

}
