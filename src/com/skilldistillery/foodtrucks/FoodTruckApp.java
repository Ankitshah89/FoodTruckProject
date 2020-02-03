package com.skilldistillery.foodtrucks;

import java.util.Scanner;

public class FoodTruckApp {
	// Fields

	public static Scanner kb;

	static {
		kb = new Scanner(System.in);
	}

	FoodTruck[] foodTruck = new FoodTruck[5];

	// Methods
	public static void main(String[] args) {

		FoodTruckApp app = new FoodTruckApp();
		app.run();

	}

	public void run() {

		displayMenu();
	}

	public void createFoodTruck() {

		for (int i = 0; i < foodTruck.length; i++) {
			System.out.print("Enter the name of the Food Truck or Quit : ");
			String truckName = kb.nextLine();
			if (truckName.equalsIgnoreCase("quit")) {
				System.out.println("Have a wonderful day!");
				break;
			}
			System.out.print("Enter the Food Type: ");
			String foodType = kb.nextLine();

			System.out.print("Enter a rating (1-5): ");
			double rating = kb.nextDouble();
			while (rating < 1 || rating > 5) {
				System.out.print("Please enter a rating between 1-5 : ");
				rating = kb.nextDouble();
			}
			kb.nextLine();

			FoodTruck newtruck = new FoodTruck(truckName, foodType, rating);
			foodTruck[i] = newtruck;

		}
	}

	public void existingTrucks() {
		for (int i = 0; i < foodTruck.length; i++) {
			if ((foodTruck[i] != null)) {
				System.out.println(foodTruck[i].toString());
			}

		}
	}

	public FoodTruck highestRatedFoodTruck() {
		FoodTruck highestRated = null;
		double highestRating = Integer.MIN_VALUE;
		for (int i = 0; i < foodTruck.length; i++) {
			if (foodTruck[i] != null) {

				if (foodTruck[i].getTruckRating() > highestRating) {
					highestRating = foodTruck[i].getTruckRating();
					highestRated = foodTruck[i];
				}

			}
		}
		return highestRated;
	}

	public double averageRating() {
		double total = 0;
		double average = 0;
		double counter = 0;

		for (int i = 0; i < foodTruck.length; i++) {
			if (foodTruck[i] != null) {
				total += foodTruck[i].getTruckRating();
				counter++;
			}
		}
		average = (total / counter);

		return average;
	}

	public void displayMenu() {
		createFoodTruck();
		boolean keepGoing = true;
		do {
			System.out.println();
			System.out.println("\t\t\t\t\t\tWelcome to the world of Food Truck!");
			System.out.println();
			System.out.println("Enter your Choice (1-4)");
			System.out.println();
			System.out.println("1: List all existing food trucks. ");
			System.out.println("2: See the average rating of food trucks. ");
			System.out.println("3: Display the highest-rated food truck. ");
			System.out.println("4: Quit the program. ");
			System.out.println();
			System.out.print("Choice : ");

			int choice = kb.nextInt();

			switch (choice) {
			case 1:
				existingTrucks();
				break;
			case 2:
				double averageRating = averageRating();
				System.out.println("The average rating is : " + averageRating);

				break;
			case 3:
				FoodTruck highest = highestRatedFoodTruck();
				System.out.println("The highest rated foodtruck is :" + highest);
				break;
			case 4:
				System.out.println("Have a Wonderful Day ! ");
				keepGoing = false;
				break;
			default:
				System.out.println("Pleae select (1-4) ");

			}

		} while (keepGoing);

	}

}
