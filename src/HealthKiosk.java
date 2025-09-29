import java.util.Scanner;

public class HealthKiosk {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Ashesi Health Kiosk");

        double weight;
        double height;
        double BMI = 0; // keep BMI available for summary
        double RequiredDosage;
        int metric = 0;

        final double PharmacyDosage = 250.0;

        System.out.println("Enter service code (P/L/T/C) :");
        char code = input.next().charAt(0); // reads a single character
        code = Character.toUpperCase(code); // takes input and prints it in uppercase

        switch (code){
            case 'P':
                System.out.println("Make your way to Pharmacy desk");
                break;

            case 'L':
                System.out.println("Make your way to lab desk");
                break;

            case 'T':
                System.out.println("Make your way to the triage desk");

                System.out.println("Enter metric (1 = BMI, 2 = Dosage, 3 = Trig):");
                int metricChoice = input.nextInt();

                if (metricChoice == 1) {
                    System.out.println("Enter weight in kg:"); // prompt to enter weight in kg
                    weight = input.nextDouble();

                    System.out.println("Enter height in meters:"); // prompt to enter height in meters
                    height = input.nextDouble();

                    BMI = weight / (height * height);
                    BMI = Math.round(BMI * 10) / 10.0; // rounding the value of the BMI
                    System.out.println("Your BMI is: " + BMI);

                    if (BMI < 18.5) {
                        System.out.println("You are underweight");
                    } else if (BMI >= 18.5 && BMI <= 24.9){
                        System.out.println("You are of normal weight");
                    } else if(BMI >= 25.0 && BMI <= 29.9){
                        System.out.println("You are overweight");
                    } else{
                        System.out.println("You are obese");
                    }

                    metric = (int) Math.round(BMI);

                } else if (metricChoice == 2) {
                    System.out.println("Enter your required dosage in mg : "); // prompt to enter required dosage
                    RequiredDosage = input.nextDouble();

                    RequiredDosage = RequiredDosage / 250.0;
                    int tabletsToDispense = (int) Math.ceil(RequiredDosage);  // rounding the value to the nearest integer
                    System.out.println("Number of tablets to dispense: " + tabletsToDispense);

                    metric = tabletsToDispense;

                } else if (metricChoice == 3) {
                    System.out.println("Enter yor angle in degrees:"); // promppt for entering the angle
                    double angleDegrees = input.nextDouble();

                    double angleRadians = Math.toRadians(angleDegrees); // converting angle measured in degrees to angle measured in radians

                    double sin = Math.sin(angleRadians);
                    double cos = Math.cos(angleRadians);
                    System.out.println("Your ange is:" + angleDegrees); // returning the sin of an angle measured in radians
                    System.out.println("Your angle is:" + angleRadians); // returning the cos of an angle measures in radians

                    sin = Math.round(sin * 1000) / 1000.0; // rounding the sin value to three decimal places
                    cos = Math.round(cos * 1000) / 1000.0; // rounding the cos value to three decimal places
                    System.out.println("sin : " +sin);
                    System.out.println("cos : " +cos);

                    metric = (int) Math.round(sin * 100); // takes the sin value, scales it up by 100 and then rounds it to the nearest integer

                } else {
                    System.out.println("Invalid metric choice");
                }

                break;

            case 'C':
                System.out.println("Make your way to the Counselling desk");
                break;

            default:
                System.out.println("Invalid service code");
        }


        char letter = (char)((int) (Math.random() * 26) +65);

        // Method for generating four random numbers between the range of 3 and 9

        int L1 = (int) (Math.random() *(9-3+1)) + 3;
        int L2 = (int) (Math.random() *(9-3+1)) + 3;
        int L3 = (int) (Math.random() *(9-3+1)) + 3;
        int L4 = (int) (Math.random() *(9-3+1)) + 3;

        System.out.println(L1 + " " + L2 + " " + L3 + " " + L4);

        String codee = "" + letter + L1 + L2 + L3 + L4;
        System.out.println("Your code is: " + codee);

        int length = codee.length();

        // This whole block of code is to validate the ID format, meaning that it must start with a letter
        // It must also contain 4 digits

        if (codee.length() == 5) {
            char letter1 = codee.charAt(0);

            if (Character.isLetter(letter1)) {
                if (Character.isDigit(codee.charAt(1)) &&
                        Character.isDigit(codee.charAt(2)) &&
                        Character.isDigit(codee.charAt(3)) &&
                        Character.isDigit(codee.charAt(4))) {
                    System.out.println("ID is valid ");
                } else {
                    System.out.println("Invalid: last 4 characters must be digits");
                }
                System.out.println("Length is valid and first character is a letter");

            } else {
                System.out.println("First character must be a letter");
            }

        } else {
            System.out.println("Invalid length");
        }
        input.nextLine();

        System.out.println("Enter your first name: "); // prompt for entering your name
        String name = input.nextLine();

        char letter1 = name.charAt(0); // This method takes the first character of a word or string

        char capitalize = Character.toUpperCase(letter1); // method for converting the first character of a word or string to uppercase
        System.out.println("Your first name is: " + capitalize);

        char shift = (char)('A' + (capitalize - 'A' + 2) % 26); // This shifts the uppercase letter stored in capitalize by two positions forward
        System.out.println("First character:" + capitalize); // This prints the first character of the first word or string
        System.out.println("Your shifted character is: " + shift); // This prints the shifted character

        String lastTwo  = codee.substring(codee.length()-2);

        String codeSecure = " " + shift + lastTwo;

        String finalCode = ( shift + lastTwo +"-" + metric);
        System.out.println("Display Code: " + finalCode);

        // summary to display info in full context depending on what you chose

        String summary= "";

        switch(code){
            case 'P':
                summary = "Summary: PHARMACY | ID =" + codee+ " | Code=" + finalCode;
                break;

            case 'L':
                summary = "Summary: LAB | ID =" + codee+ " | Code=" + finalCode;
                break;

            case 'T':
                summary = "Summary: TRIAGE | ID =" + codee+ " | BMI=" + BMI + " | Code=" + finalCode;
                break;

            case 'C':
                summary = "Summary: COUNSELING | ID =" + codee+ " | Code=" + finalCode;
                break;

            default:
                summary = "Invalid service code";
        }

        System.out.println("Display Summary: " + summary);

        input.close();
    }
}
