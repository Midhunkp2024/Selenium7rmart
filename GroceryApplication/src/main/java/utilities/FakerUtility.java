package utilities;

import com.github.javafaker.Faker;
//for generate random name/address/mail/numbers

public class FakerUtility {
	 static Faker faker = new Faker();

    // Method to generate a fake name
    public  String generateName() {
        return faker.name().fullName(); // Generates a full name (e.g., John Doe)
    }

    // Method to generate a fake address
    public  String generateAddress() {
        return faker.address().fullAddress(); // Generates a full address
    }

    // Method to generate a fake email
    public  String generateEmail() {
        return faker.internet().emailAddress(); // Generates an email address
    }
    public  int generateRandomInt(int min, int max) {
        return faker.number().numberBetween(min, max);
    }

    public  String generateRandomDigits(int count) {
        return faker.number().digits(count);
    }
    public  int generateRandomNumber() {
    	return faker.number().randomDigit();
    }
    public static void main(String args[]) {
    	FakerUtility fu =new FakerUtility();
    	System.out.println(fu.generateAddress());
    	System.out.println(fu.generateEmail());
    	try {
			System.out.println(faker.commerce().productName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

   
}
