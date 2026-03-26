import java.util.Scanner;

public class DaysOfAMonth {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int year;
		int day = 0;
		String month;
		
		System.out.print("Enter month: ");
		month = input.nextLine();
		System.out.print("Enter year: ");
		year = input.nextInt();
			
		if(year >= 0) {
			if(month.equals("January") || month.equals("Jan") || month.equals("Jan.") || month.equals("1") ||
			   month.equals("March") || month.equals("Mar") || month.equals("Mar.") || month.equals("3") || 
			   month.equals("May") || month.equals("5") || 
			   month.equals("July") || month.equals("Jul") || month.equals("7") || 
			   month.equals("August") || month.equals("Aug") || month.equals("Aug.") || month.equals("8") || 
			   month.equals("October") || month.equals("Oct") || month.equals("Oct.") || month.equals("10") || 
			   month.equals("December") || month.equals("Dec") || month.equals("Dec.") || month.equals("12")) {
				day = 31;
			}
			else if(month.equals("April") || month.equals("Apr") || month.equals("Apr.") || month.equals("4") || 
					month.equals("June") || month.equals("Jun") || month.equals("6") || 
					month.equals("September") || month.equals("Sep") || month.equals("Sep.") || month.equals("9") || 
					month.equals("November") || month.equals("Nov") || month.equals("Nov.") || month.equals("11")) {
				day = 30;
			}
			else if(month.equals("February") || month.equals("Feb") || month.equals("Feb.") || month.equals("2")) {
				if((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
					day = 29;
				}
				else {
					day = 28;
				}
			}
			if(day > 0) {
				System.out.print(day + " days.");
			}
			else {
				System.out.print("Invalid input.");
			}	
		}
		else {
			System.out.print("Invalid input.");
		}
		
	}

}
