package emp.utils;
import java.util.*;

import emp.exceptions.InvalidAgeException;
import emp.exceptions.InvalidChoiceException;
import emp.exceptions.InvalidNameException;
import emp.exceptions.InvalidSalaryException;
import emp.utils.Patterns;

public class Menu{
	private static int maxChoice;

	public static int readChoice(int max){
		maxChoice = max;
		while(true){
			try{
				System.out.print("Enter choice : ");
				int choice = new Scanner(System.in).nextInt();
				if(choice < 1 || choice > maxChoice){
					throw new InvalidChoiceException();
				}
				return choice;
			}
			catch(InputMismatchException e){
				System.out.println("Please enter number only");
			}
			catch(InvalidChoiceException e){
				e.displayMessage(maxChoice);
			}
		}
	}

	public static String readName(){
		while(true){
			try{
				System.out.print("Enter name : ");
				String name = new Scanner(System.in).nextLine();
				if(Patterns.validateName(name)) return name;
				else{
					throw new InvalidNameException();
				}
			}catch(InvalidNameException e){
				//invalid name message printed from constructor
			}catch(InputMismatchException e){
				System.out.println("Name should be a valid string....");
			}
		}
	}

	public static int readAge(int minAge, int maxAge){
		while (true) {
			try{
				System.out.print("Enter age : ");
				int age = new Scanner(System.in).nextInt();
				if(age < minAge || age > maxAge) throw new InvalidAgeException(minAge, maxAge);
				else return age;
			}catch(InvalidAgeException e){
				//printed in InvalidAgeException class

			}catch(InputMismatchException e){
				System.out.println("Only numbers are allowed in input field...");
			}
		}
	}

	public static float readSalary(){
		while(true){
			try{
				System.out.print("Enter salary : ");
				float salary = new Scanner(System.in).nextFloat();
				if(salary <= 50000) throw new InvalidSalaryException();
				else return salary;
			}catch(InvalidSalaryException e){

			}catch(InputMismatchException e){
				System.out.println("Only numbers are allowed in input field...");

			}
		}
	}
}