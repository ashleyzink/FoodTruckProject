package com.skilldistillery.foodproject;

import java.util.Scanner;

public class FoodTruckApp {

	boolean keepGoing = true;

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
		while (truckApp.keepGoing) {
			truckApp.printMenu(userInput, truckApp, trucks);
		}

	}

	private void printMenu(Scanner userInput, FoodTruckApp truckApp, FoodTruck[] trucks) {
		System.out.println("*~*~*~*~*  Food Truck Info At Your Fingertips  *~*~*~*~*");
		System.out.println("\nPlease type the corresponding number from the menu below "
				+ "\n      for the information you'd like to access");
		System.out.println("\n\t1.) List of All Food Trucks");
		System.out.println("\t2.) The Average Rating of All Food Trucks");
		System.out.println("\t3.) Display of the Highest Rated Food Truck");
		System.out.println("\t4.) Quit the Program ");
		System.out.println("\n *~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*");

		int menuSelection = userInput.nextInt();

		switch (menuSelection) {

		case 1:
			truckApp.printAllTrucks(trucks);
			break;
		case 2:
			System.out.printf(
					"------- The average rating of all your food trucks is: %.2f -------\n\n", truckApp.getAverageFoodTruckRating(trucks));
			break;
		case 3:
			truckApp.getHighestRatedTruck(trucks);
			break;
		case 4:
			System.out.println("Thank you for using our Food Truck App! Have a great day \u263a");
			keepGoing = false;
			break;
		}

	}

	private void getHighestRatedTruck(FoodTruck[] trucks) {

		double highestRating = 0;
		int index = 0;
		for (int i = 0; i < trucks.length; i++) {
			if (trucks[i] != null) {
				if (trucks[i].getFoodRating() > highestRating) {
					highestRating = trucks[i].getFoodRating();
					index = i;

				}
			}
		}
		System.out.println(trucks[index]);

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
