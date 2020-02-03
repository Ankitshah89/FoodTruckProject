package com.skilldistillery.foodtrucks;

public class FoodTruck {
	
	private int truckId;
	private static int uniqueTruckId = 1;
	private String truckName;
	private String foodType;
	private double truckRating;

	public FoodTruck(String truckName, String foodType, double truckRating) {
		super();
		this.truckName = truckName;
		this.foodType = foodType;
		this.truckRating = truckRating;
		this.truckId += uniqueTruckId++ ;
	}

	public String toString() {
		String output = "ID : " + truckId + "    Truck Name : "  + truckName + "    Type of Food :  " + foodType + "    Rating :  "
				+ truckRating;
		return output;
	}

	public void displayTruck() {
		String truckData = toString();
		System.out.println(truckData);
	}

	public int getTruckId() {
		return truckId;
	}

	public void setTruckId(int truckId) {
		this.truckId = truckId;
	}

	public String getTruckName() {
		return truckName;
	}

	public void setTruckName(String truckName) {
		this.truckName = truckName;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public double getTruckRating() {
		return truckRating;
	}

	public void setTruckRating(double truckRating) {
		this.truckRating = truckRating;
	}

}
