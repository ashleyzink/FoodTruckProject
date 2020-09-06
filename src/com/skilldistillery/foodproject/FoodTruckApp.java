package com.skilldistillery.foodproject;

import java.util.Scanner;

public class FoodTruckApp {

	public static void main(String[] args) {
		FoodTruckApp truckApp = new FoodTruckApp();

		Scanner userInput = new Scanner(System.in);

		FoodTruck[] trucks = new FoodTruck[5];

		System.out.println("You're able to store information on up to 5 food trucks.");

		for (int i = 0; i < trucks.length; i++) {
			trucks[i] = truckApp.getTruckInfoFromUser(userInput);
			if (trucks[i] == null) {
				break;
			}

//			System.out.println(trucks[i]); //Used for testing userInput. 
			// Created method to print outside of my for loop.
		}

		truckApp.printAllTrucks(trucks);
		truckApp.getAverageFoodTruckRating(trucks);
		truckApp.getHighestRatedTruck(trucks);

	}

	private void getHighestRatedTruck(FoodTruck[] trucks) {

		double highestRating = 0;
		
		for (int i = 0; i < trucks.length; i++) {
			if (trucks[i] != null) {
				double foodRating = trucks[i].getFoodRating();
				
						
			}
		}
	}

	private double getAverageFoodTruckRating(FoodTruck[] trucks) { // TODO: Return the avg ratings to user
		// take the rating from each truck
		double averageRating = 0;
		double sum = 0;
		double numOfRatings = 0;
		for (int i = 0; i < trucks.length; i++) {
			if (trucks[i] != null) {
				double foodRating = trucks[i].getFoodRating();
				// add them together // divide by the amount of ratings given
				sum += foodRating;
				numOfRatings = i + 1;
			}
		}
		averageRating = sum / numOfRatings;
		return averageRating;
	}

	private void printAllTrucks(FoodTruck[] trucks) { // TODO: Fix sysout "null" issue
		for (FoodTruck foodTruck : trucks) {
			if (foodTruck != null) {
				System.out.println(foodTruck);
			}
		}

	}

	public FoodTruck getTruckInfoFromUser(Scanner userInput) {
		System.out.println("Please enter the name of the food truck you'd like to record: ");
		System.out.println("If you'd like to enter less than 5, please type \"Quit\" ");
		String truckName = userInput.nextLine();
		if (truckName.equalsIgnoreCase("Quit")) {
			return null;
		}

		System.out.println("Please enter their style of food: ");
		String typeOfFood = userInput.nextLine();

		double foodRating;
		do {
			System.out.println("Please enter the overall rating you'd score this truck from 1-10: ");
			foodRating = userInput.nextDouble();
		} while (foodRating > 10.0 || foodRating < 1.0);

		userInput.nextLine();

		FoodTruck trucksInfo = new FoodTruck(truckName, typeOfFood, foodRating);
		return trucksInfo;
	}

}
