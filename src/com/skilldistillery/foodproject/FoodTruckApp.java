package com.skilldistillery.foodproject;

import java.util.Scanner;

public class FoodTruckApp {

	public static void main(String[] args) {

		Scanner userInput = new Scanner(System.in);

		FoodTruck[] trucks = new FoodTruck[5];

		System.out.println("You're able to store information on up to 5 food trucks.");

		for (int i = 0; i < trucks.length; i++) {
			trucks[i] = getTruckInfoFromUser(userInput);
			if (trucks[i] == null) {
				break;
			}

//			System.out.println(trucks[i]); //Used for testing userInput. 
			// Created method to print outside of my for loop.
		}

		printAllTrucks(trucks);
	}

	private static void printAllTrucks(FoodTruck[] trucks) { // TODO: Fix sysout "null" issue
		for (FoodTruck foodTruck : trucks) {
			if (foodTruck != null) {
				System.out.println(foodTruck);
			}
		}

	}

	public static FoodTruck getTruckInfoFromUser(Scanner userInput) {
		System.out.println("Please enter the name of the food truck you'd like to record: ");
		System.out.println("If you'd like to enter less than 5, please type \"Quit\" ");
		String truckName = userInput.nextLine();
		if (truckName.equalsIgnoreCase("Quit")) {
			return null;
		}

		System.out.println("Please enter their style of food: ");
		String typeOfFood = userInput.nextLine();

		System.out.println("Please enter the overall rating you'd score this truck from 1-5: ");
		double foodRating = userInput.nextDouble();
		userInput.nextLine();

		FoodTruck trucksInfo = new FoodTruck(truckName, typeOfFood, foodRating);
		return trucksInfo;
	}

}
