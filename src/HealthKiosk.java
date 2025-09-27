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
                    System.out.println("Enter weight in kg:");
                    weight = input.nextDouble();

                    System.out.println("Enter height in meters:");
                    height = input.nextDouble();

                    BMI = weight / (height * height);
                    BMI = Math.round(BMI * 10) / 10.0;
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
                    System.out.println("Enter your required dosage in mg : ");
                    RequiredDosage = input.nextDouble();

                    RequiredDosage = RequiredDosage / 250.0;
                    int tabletsToDispense = (int) Math.ceil(RequiredDosage);
                    System.out.println("Number of tablets to dispense: " + tabletsToDispense);

                    metric = tabletsToDispense;

                } else if (metricChoice == 3) {
                    System.out.println("Enter yor angle in degrees:");
                    double angleDegrees = input.nextDouble();

                    double angleRadians = Math.toRadians(angleDegrees);

                    double sin = Math.sin(angleRadians);
                    double cos = Math.cos(angleRadians);
                    System.out.println("Your ange is:" + angleDegrees);
                    System.out.println("Your angle is:" + angleRadians);

                    sin = Math.round(sin * 1000) / 1000.0;
                    cos = Math.round(cos * 1000) / 1000.0;
                    System.out.println("sin : " +sin);
                    System.out.println("cos : " +cos);

                    metric = (int) Math.round(sin * 100);

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

        int L1 = (int) (Math.random() *(9-3+1)) + 3;
        int L2 = (int) (Math.random() *(9-3+1)) + 3;
        int L3 = (int) (Math.random() *(9-3+1)) + 3;
        int L4 = (int) (Math.random() *(9-3+1)) + 3;

        System.out.println(L1 + " " + L2 + " " + L3 + " " + L4);

        String codee = "" + letter + L1 + L2 + L3 + L4;
        System.out.println("Your code is: " + codee);

        int length = codee.length();

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

        System.out.println("Enter your first name: ");
        String name = input.nextLine();

        char letter1 = name.charAt(0);

        char capitalize = Character.toUpperCase(letter1);
        System.out.println("Your first name is: " + capitalize);

        char shift = (char)('A' + (capitalize - 'A' + 2) % 26);
        System.out.println("First character:" + capitalize);
        System.out.println("Your shifted character is: " + shift);

        String lastTwo  = codee.substring(codee.length()-2);

        String codeSecure = " " + shift + lastTwo;

        String finalCode = ( shift + lastTwo +"-" + metric);
        System.out.println("Display Code: " + finalCode);

        // =========================
        // Task 5: Summary
        // =========================
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
