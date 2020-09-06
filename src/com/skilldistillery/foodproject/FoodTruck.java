package com.skilldistillery.foodproject;

public class FoodTruck {
	
	private static int nextId = 1000;
	private int uniqueId;
	private String truckName;
	private String typeOfFood;
	private double foodRating;
	
	public FoodTruck() {
	}
	
	public FoodTruck(String truckName, String typeOfFood, double foodRating) {
		this.uniqueId = nextId++;
		this.truckName = truckName;
		this.typeOfFood = typeOfFood;
		this.foodRating = foodRating;
	}

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
				"\nFood Style: " + typeOfFood + "\nFood Truck Rating: " + foodRating;
	}

}
