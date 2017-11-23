package fracCalc;
import java.util.Scanner;
public class FracCalc {

    public static void main(String[] args) 
    {
    	System.out.println("Please type in a fraction:");
    	Scanner consoleOne = new Scanner(System.in);
    	String input = consoleOne.nextLine();
		
		String returned = produceAnswer(input);
		System.out.println(returned);
		
    }
    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"

        // TODO: Implement this function to produce the solution to the input
    public static String produceAnswer(String input) {
    	Scanner console = new Scanner(input);
    	String x = console.next();
    	String y = console.next();
    	String z = console.next();
    	
		String fracOneNew = (newStringOne(fracOne(x)));
		String fracTwoNew = (newStringTwo(fracOne(z)));
		
		String[] oneSplitted = fracOneNew.split("\\s+");
		String[] twoSplitted = fracTwoNew.split("\\s+");
		
		int splitLengthOne = oneSplitted.length;
		int splitLengthTwo = twoSplitted.length; 
		
		String partOneFracOne = oneSplitted[splitLengthOne-3];
		String partTwoFracOne = oneSplitted[splitLengthOne-2];
		String partThreeFracOne = oneSplitted[splitLengthOne-1];
		String partOneFracTwo = twoSplitted[splitLengthTwo-3];
		String partTwoFracTwo = twoSplitted[splitLengthTwo-2];
		String partThreeFracTwo = twoSplitted[splitLengthTwo-1];
		
		String seperatorOne = newCheckOne(partOneFracOne);
		String seperatorTwo = newCheckTwo(partOneFracTwo);
		
		String[] firstOne = seperatorOne.split("\\s+");
		String[] secondOne = seperatorTwo.split("\\s+");
		
		String sectionOneFracOne = firstOne[0];
		String sectionOneFracTwo = secondOne[0];
		
		String symbolOne = pos(sectionOneFracOne);
		String symbolTwo = pos(sectionOneFracTwo);
		
		int wholeNumberOne = Integer.parseInt(firstOne[1]);
		int wholeNumberTwo = Integer.parseInt(secondOne[1]);
		
		int numOne = Integer.parseInt(partTwoFracOne);
		int numTwo = Integer.parseInt(partTwoFracTwo);
		
		int denOne = Integer.parseInt(partThreeFracOne);
		int denTwo = Integer.parseInt(partThreeFracTwo);
		
		String solve = solver("f", y, symbolOne, wholeNumberOne, numOne, denOne, symbolTwo, wholeNumberTwo, numTwo, denTwo);
		
		return new String(solve);
    }
    // TODO: Fill in the space below with any helper methods that you think you will need
    public static String solver(String solved, String y, String symbolOne, int wholeNumberOne, int numOne, int denOne, String symbolTwo, int wholeNumberTwo, int numTwo, int denTwo) {
    	if(((symbolOne.equals("+")) && (y.equals("-")) && (symbolTwo.equals("-"))) || ((symbolOne.equals("+")) && (y.equals("+")) && (symbolTwo.equals("+")))){
    		if(wholeNumberOne == 0 && wholeNumberTwo == 0) {
    			int partOne = numOne * denTwo;
    			int partTwo = numTwo * denOne;
    			int num = partOne + partTwo;
    			int den = denOne * denTwo;
    			String simplified = simplifyPositive("", num, den);
				return new String(simplified);
    		}
    		if(wholeNumberOne != 0 && wholeNumberTwo == 0) {
    			int numChange = wholeNumberOne * denOne;
				int newNumPart = numChange + numOne;
    			int partOne = newNumPart * denTwo;
    			int partTwo = numTwo * denOne;
    			int num = partOne + partTwo;
    			int den = denOne * denTwo;
    			String simplified = simplifyPositive("", num, den);
				return new String(simplified);
    		}
    		if(wholeNumberOne == 0 && wholeNumberTwo != 0) {
    			int numChange = wholeNumberTwo * denTwo;
				int newNumPart = numChange + numTwo;
    			int partOne = numOne * denTwo;
    			int partTwo = newNumPart * denOne;
    			int num = partOne + partTwo;
    			int den = denOne * denTwo;
    			String simplified = simplifyPositive("", num, den);
				return new String(simplified);
    		}
    		if(wholeNumberOne != 0 && wholeNumberTwo != 0 && (numOne != 0 || numTwo != 0)) {
    			int numChangeOne = wholeNumberOne * denOne;
				int newNumPartOne = numChangeOne + numOne;
				int numChangeTwo = wholeNumberTwo * denTwo;
				int newNumPartTwo = numChangeTwo + numTwo;
    			int partOne = newNumPartOne * denTwo;
    			int partTwo = newNumPartTwo * denOne;
    			int num = partOne + partTwo;
    			int den = denOne * denTwo;
    			String simplified = simplifyPositive("", num, den);
				return new String(simplified);
    		}
    		if(wholeNumberOne != 0 && wholeNumberTwo != 0 && (numOne == 0 && numTwo ==0)) {
				return new String(wholeNumberOne + wholeNumberTwo + "");
			}
    	}
    	if(((symbolOne.equals("-")) && (y.equals("-")) && (symbolTwo.equals("+"))) || ((symbolOne.equals("-")) && (y.equals("+")) && (symbolTwo.equals("-")))){
    		if(wholeNumberOne == 0 && wholeNumberTwo == 0) {
    			int partOne = numOne * denTwo;
    			int partTwo = numTwo * denOne;
    			int num = partOne + partTwo;
    			int den = denOne * denTwo;
    			String simplified = simplifyNegative("", num, den);
				return new String(simplified);
    		}
    		if(wholeNumberOne != 0 && wholeNumberTwo == 0) {
    			int numChange = wholeNumberOne * denOne;
				int newNumPart = numChange + numOne;
    			int partOne = newNumPart * denTwo;
    			int partTwo = numTwo * denOne;
    			int num = partOne + partTwo;
    			int den = denOne * denTwo;
    			String simplified = simplifyNegative("", num, den);
				return new String(simplified);
    		}
    		if(wholeNumberOne == 0 && wholeNumberTwo != 0) {
    			int numChange = wholeNumberTwo * denTwo;
				int newNumPart = numChange + numTwo;
    			int partOne = numOne * denTwo;
    			int partTwo = newNumPart * denOne;
    			int num = partOne + partTwo;
    			int den = denOne * denTwo;
    			String simplified = simplifyNegative("", num, den);
				return new String(simplified);
    		}
    		if(wholeNumberOne != 0 && wholeNumberTwo != 0 && (numOne != 0 || numTwo != 0)) {
    			int numChangeOne = wholeNumberOne * denOne;
				int newNumPartOne = numChangeOne + numOne;
				int numChangeTwo = wholeNumberTwo * denTwo;
				int newNumPartTwo = numChangeTwo + numTwo;
    			int partOne = newNumPartOne * denTwo;
    			int partTwo = newNumPartTwo * denOne;
    			int num = partOne + partTwo;
    			int den = denOne * denTwo;
    			String simplified = simplifyNegative("", num, den);
				return new String(simplified);
    		}	
    		if(wholeNumberOne != 0 && wholeNumberTwo != 0 && (numOne == 0 && numTwo ==0)) {
    			int solve = wholeNumberOne + wholeNumberTwo;
				return new String("-" + solve);
			}
    	}
    	if(((symbolOne.equals("+")) && (y.equals("+")) && (symbolTwo.equals("-"))) || ((symbolOne.equals("+")) && (y.equals("-")) && (symbolTwo.equals("+")))){
    		if(wholeNumberOne == 0 && wholeNumberTwo == 0) {
    			int partOne = numOne * denTwo;
    			int partTwo = numTwo * denOne;
    			int num = partOne - partTwo;
    			int den = denOne * denTwo;
    			String simplified = simplifyPositive("", num, den);
				return new String(simplified);
    		}
    		if(wholeNumberOne != 0 && wholeNumberTwo == 0) {
    			int numChange = wholeNumberOne * denOne;
				int newNumPart = numChange + numOne;
    			int partOne = newNumPart * denTwo;
    			int partTwo = numTwo * denOne;
    			int num = partOne - partTwo;
    			int den = denOne * denTwo;
    			String simplified = simplifyPositive("", num, den);
				return new String(simplified);
    		}
    		if(wholeNumberOne == 0 && wholeNumberTwo != 0) {
    			int numChange = wholeNumberTwo * denTwo;
				int newNumPart = numChange + numTwo;
    			int partOne = numOne * denTwo;
    			int partTwo = newNumPart * denOne;
    			int num = partOne - partTwo;
    			int den = denOne * denTwo;
    			String simplified = simplifyPositive("", num, den);
    			return new String(simplified);
    		}
    		if(wholeNumberOne != 0 && wholeNumberTwo != 0 && (numOne != 0 && numTwo != 0)) {
    	
    			int numChangeOne = wholeNumberOne * denOne;
				int newNumPartOne = numChangeOne + numOne;
				int numChangeTwo = wholeNumberTwo * denTwo;
				int newNumPartTwo = numChangeTwo + numTwo;
    			int partOne = newNumPartOne * denTwo;
    			int partTwo = newNumPartTwo * denOne;
				if(partOne > partTwo) {
    				int num = partOne - partTwo;
    				int den = denOne * denTwo;
    				String simplified = simplifyPositive("", num, den);
    				return new String(simplified);
    			}
    			if(partOne < partTwo) {
    				int num = partTwo - partOne;
    				int den = denOne * denTwo;
    				String simplified = simplifyNegative("", num, den);
    				return new String(simplified);
    			}
    			if(partOne == partTwo) {
    				return new String("0");
    			}
    		}
    		if(wholeNumberOne != 0 && wholeNumberTwo != 0 && (numOne == 0 && numTwo ==0)) {
				return new String(wholeNumberOne - wholeNumberTwo + "");
			}
    	}
    	if(((symbolOne.equals("-")) && (y.equals("+")) && (symbolTwo.equals("+"))) || ((symbolOne.equals("-")) && (y.equals("-")) && (symbolTwo.equals("-")))){
    		if(wholeNumberOne == 0 && wholeNumberTwo == 0) {
    			int partOne = numOne * denTwo;
    			int partTwo = numTwo * denOne;
    			int num = partTwo - partOne;
    			int den = denOne * denTwo;
    			String simplified = simplifyPositive("", num, den);
				return new String(simplified);
    		}
    		if(wholeNumberOne != 0 && wholeNumberTwo == 0) {
    			int numChange = wholeNumberOne * denOne;
				int newNumPart = numChange + numOne;
    			int partOne = newNumPart * denTwo;
    			int partTwo = numTwo * denOne;
    			int num = partTwo - partOne;
    			int den = denOne * denTwo;
    			String simplified = simplifyPositive("", num, den);
				return new String(simplified);
    		}
    		if(wholeNumberOne == 0 && wholeNumberTwo != 0) {
    			int numChange = wholeNumberTwo * denTwo;
				int newNumPart = numChange + numTwo;
    			int partOne = numOne * denTwo;
    			int partTwo = newNumPart * denOne;
    			int num = partTwo - partOne;
    			int den = denOne * denTwo;
    			String simplified = simplifyPositive("", num, den);
				return new String(simplified);
    		}
    		if(wholeNumberOne != 0 && wholeNumberTwo != 0 && (numOne != 0 || numTwo != 0)) {
    			int numChangeOne = wholeNumberOne * denOne;
				int newNumPartOne = numChangeOne + numOne;
				int numChangeTwo = wholeNumberTwo * denTwo;
				int newNumPartTwo = numChangeTwo + numTwo;
    			int partOne = newNumPartOne * denTwo;
    			int partTwo = newNumPartTwo * denOne;
    			if(partOne > partTwo) {
    				int num = partOne - partTwo;
        			int den = denOne * denTwo;
        			String simplified = simplifyNegative("", num, den);
    				return new String(simplified);
    			}
    			if(partTwo > partOne) {
    			int num = partTwo - partOne;
    			int den = denOne * denTwo;
    			String simplified = simplifyPositive("", num, den);
				return new String(simplified);
    			}
    		}
    		if(wholeNumberOne != 0 && wholeNumberTwo != 0 && (numOne == 0 && numTwo ==0)) {
    			if(symbolOne.equals("-")) {
    				int solve = wholeNumberTwo - wholeNumberOne;
    				return new String("" + solve);
    			}
			}
    	}
		if(y.equals("*")) {
			if((symbolOne.equals("-") && symbolTwo.equals("-")) || (symbolOne.equals("+") && symbolTwo.equals("+"))) {
				if((wholeNumberOne == 0 && numOne == 0 && denOne == 1) || (wholeNumberTwo == 0 && numTwo == 0 && denTwo == 1)) {
					return new String("0");
				}
				if(wholeNumberOne == 0 && wholeNumberTwo == 0) {
					int lcd = denOne * denTwo;
					int newNum = numOne * numTwo;
					String simplified = simplifyPositive("", newNum, lcd);
					return new String(simplified);
				}
				if(wholeNumberOne == 0 && wholeNumberTwo != 0) {
					int numChange = wholeNumberTwo * denTwo;
					int newNumPart = numChange + numTwo;
					int lcd = denOne * denTwo;
					int newNum = numOne * newNumPart;
					String simplified = simplifyPositive("", newNum, lcd);
					return new String(simplified);
				}
				if(wholeNumberOne != 0 && wholeNumberTwo == 0) {
					int numChange = wholeNumberOne * denOne;
					int newNumPart = numChange + numOne;
					int lcd = denOne * denTwo;
					int newNum = numTwo * newNumPart;
					String simplified = simplifyPositive("", newNum, lcd);
					return new String(simplified);
				}
				if(wholeNumberOne != 0 && wholeNumberTwo != 0 && (numOne != 0 || numTwo !=0)) {
					int numChangeOne = wholeNumberOne * denOne;
					int newNumPartOne = numChangeOne + numOne;
					int numChangeTwo = wholeNumberTwo * denTwo;
					int newNumPartTwo = numChangeTwo + numTwo;
					int newNum = newNumPartOne * newNumPartTwo;
					int lcd = denOne * denTwo;
					String simplified = simplifyPositive("", newNum, lcd);
					return new String(simplified);
				}
				if(wholeNumberOne != 0 && wholeNumberTwo != 0 && (numOne == 0 && numTwo ==0)) {
					return new String(wholeNumberOne * wholeNumberTwo + "");
				}
			}
			if((symbolOne.equals("+") && symbolTwo.equals("-")) || (symbolOne.equals("-") && symbolTwo.equals("+"))) {
				if((wholeNumberOne == 0 && numOne == 0 && denOne == 1) || (wholeNumberTwo == 0 && numTwo == 0 && denTwo == 1)) {
					return new String("0");
				}
				if(wholeNumberOne == 0 && wholeNumberTwo == 0 && numOne != 0 && numTwo != 0 && denOne != 0 && denTwo != 0) {
					int lcd = denOne * denTwo;
					int newNum = numOne * numTwo;
					String simplified = simplifyNegative("", newNum, lcd);
					return new String(simplified);
				}
				if(wholeNumberOne == 0 && wholeNumberTwo != 0) {
					int numChange = wholeNumberTwo * denTwo;
					int newNumPart = numChange + numTwo;
					int lcd = denOne * denTwo;
					int newNum = numOne * newNumPart;
					String simplified = simplifyNegative("", newNum, lcd);
					return new String(simplified);
				}
				if(wholeNumberOne != 0 && wholeNumberTwo == 0) {
					int numChange = wholeNumberOne * denOne;
					int newNumPart = numChange + numOne;
					int lcd = denOne * denTwo;
					int newNum = numTwo * newNumPart;
					String simplified = simplifyNegative("", newNum, lcd);
					return new String(simplified);
				}
				if(wholeNumberOne != 0 && wholeNumberTwo != 0 && (numOne != 0 || numTwo != 0)) {
					int numChangeOne = wholeNumberOne * denOne;
					int newNumPartOne = numChangeOne + numOne;
					int numChangeTwo = wholeNumberTwo * denTwo;
					int newNumPartTwo = numChangeTwo + numTwo;
					int newNum = newNumPartOne * newNumPartTwo;
					int lcd = denOne * denTwo;
					String simplified = simplifyNegative("", newNum, lcd);
					return new String(simplified);
				}
				if(wholeNumberOne != 0 && wholeNumberTwo != 0 && (numOne == 0 && numTwo ==0)) {
	    			int solve = wholeNumberOne * wholeNumberTwo;
					return new String("-" + solve);
				}
			}
		}
		if(y.equals("/")) {
			if((symbolOne.equals("-") && symbolTwo.equals("-")) || (symbolOne.equals("+") && symbolTwo.equals("+"))) {
				if((wholeNumberOne == 0 && numOne == 0 && denOne == 1) || (wholeNumberTwo == 0 && numTwo == 0 && denTwo == 1)) {
					return new String("0");
				}
				if(wholeNumberOne == 0 && wholeNumberTwo == 0) {
					if(numOne == 0 || numTwo == 0) {
						return new String("0");
					}
					int lcd = denOne * numTwo;
					int newNum = numOne * denTwo;
					String simplified = simplifyPositive("", newNum, lcd);
					return new String(simplified);
				}
				if(wholeNumberOne == 0 && wholeNumberTwo != 0) {
					int numChange = wholeNumberTwo * denTwo;
					int newNumPart = numChange + numTwo;
					int newNum = denOne * numTwo;
					int lcd = denOne * newNumPart;
					String simplified = simplifyPositive("", newNum, lcd);
					return new String(simplified);
				}
				if(wholeNumberOne != 0 && wholeNumberTwo == 0) {
					int numChange = wholeNumberOne * denOne;
					int newNumPart = numChange + numOne;
					int lcd = denOne * numTwo;
					int newNum = denTwo * newNumPart;
					String simplified = simplifyPositive("", newNum, lcd);
					return new String(simplified);
				}
				if(wholeNumberOne != 0 && wholeNumberTwo != 0 && (numOne != 0 || numTwo != 0)) {
					int numChangeOne = wholeNumberOne * denOne;
					int newNumPartOne = numChangeOne + numOne;
					int numChangeTwo = wholeNumberTwo * denTwo;
					int newNumPartTwo = numChangeTwo + numTwo;
					int newNum = newNumPartOne * denTwo;
					int lcd = newNumPartTwo * denOne;
					String simplified = simplifyPositive("", newNum, lcd);
					return new String(simplified);
				}
				if(wholeNumberOne != 0 && wholeNumberTwo != 0 && (numOne == 0 && numTwo == 0)) {
					String simplified = simplifyPositive("", wholeNumberOne, wholeNumberTwo);
					return new String(simplified);
				}
			}
			if((symbolOne.equals("+") && symbolTwo.equals("-")) || (symbolOne.equals("-") && symbolTwo.equals("+"))) {
				if((wholeNumberOne == 0 && numOne == 0 && denOne == 1) || (wholeNumberTwo == 0 && numTwo == 0 && denTwo == 1)) {
					return new String("0");
				}
				if(wholeNumberOne == 0 && wholeNumberTwo == 0) {
					int lcd = denOne * numTwo;
					int newNum = numOne * denTwo;
					String simplified = simplifyNegative("", newNum, lcd);
					return new String(simplified);
				}
				if(wholeNumberOne == 0 && wholeNumberTwo != 0) {
					int numChange = wholeNumberTwo * denTwo;
					int newNumPart = numChange + numTwo;
					int newNum = denOne * numTwo;
					int lcd = denOne * newNumPart;
					String simplified = simplifyNegative("", newNum, lcd);
					return new String(simplified);
				}
				if(wholeNumberOne != 0 && wholeNumberTwo == 0) {
					int numChange = wholeNumberOne * denOne;
					int newNumPart = numChange + numOne;
					int lcd = denOne * numTwo;
					int newNum = denTwo * newNumPart;
					String simplified = simplifyNegative("", newNum, lcd);
					return new String(simplified);
				}
				if(wholeNumberOne != 0 && wholeNumberTwo != 0 && (numOne != 0 || numTwo != 0)) {
					int numChangeOne = wholeNumberOne * denOne;
					int newNumPartOne = numChangeOne + numOne;
					int numChangeTwo = wholeNumberTwo * denTwo;
					int newNumPartTwo = numChangeTwo + numTwo;
					int newNum = newNumPartOne * denTwo;
					int lcd = newNumPartTwo * denOne;
					String simplified = simplifyNegative("", newNum, lcd);
					return new String(simplified);
				}
				if(wholeNumberOne != 0 && wholeNumberTwo != 0 && (numOne == 0 && numTwo == 0)) {
					String simplified = simplifyNegative("", wholeNumberOne, wholeNumberTwo);
					return new String(simplified);
				}
			}
		}
		return new String(solved);
}
    public static String simplifyNegative(String container, int x, int y) {
    	if(x == 0) {
    		return new String("0");
    	}
    	if(y == 1) {
			return new String("-" + x);
		}
    	while(((x%2) == 0) && ((y%2) == 0)){
			x = x/2;
			y = y/2;
		}
    	if(x == y) {
    		String whole = "-1";
    		return new String(whole);
    	}
    	if(x > y) {
    		int whole = x/y;
			int newNum = x%y;
			if(newNum == 0 && y == 3) {
				int solve = x/y;
				return new String("-" + solve);
			}
			while(((newNum%3) == 0) && ((y%3) == 0)){
				newNum = newNum/3;
				y = y/3;
			}
			while(((newNum%5) == 0) && ((y%5) == 0)){
				newNum = newNum/5;
				y = y/5;
			}
			if(newNum == 0) {
				int solve = x/y;
				return new String("-" + solve);
			}
			if(y == 1) {
				return new String("-" + x);
			}
			String wholeWithFraction = "-" + whole + "_" + newNum + "/" + y;
			return new String(wholeWithFraction);
    	}
    	if(x < y) {
			int newNum = x%y;
    		while(((newNum%3) == 0) && ((y%3) == 0)){
				newNum = newNum/3;
				y = y/3;
			}
			while(((newNum%5) == 0) && ((y%5) == 0)){
				newNum = newNum/5;
				y = y/5;
			}
			while(((newNum%7) == 0) && ((y%7) == 0)){
				newNum = newNum/7;
				y = y/7;
			}
    		String fill = "-" + newNum + "/" + y;
        	return new String(fill);
    	}
    	return new String(container);
    }
    public static String simplifyPositive(String container, int x, int y) {
    	if(x == 0) {
    		return new String("0");
    	}
    	if(y == 1) {
    		return new String(x + "");
    	}
    	while(((x%2) == 0) && ((y%2) == 0)){
			x = x/2;
			y = y/2;
		}
    	if(x == y) {
    		String whole = "1";
    		return new String(whole);
    	}
    	if(x > y) {
    		int whole = x/y;
			int newNum = x%y;
			if(newNum == 0 && y == 3) {
				int solve = x/y;
				return new String(solve + "");
			}
			while(((newNum%3) == 0) && ((y%3) == 0)){
				newNum = newNum/3;
				y = y/3;
			}
			while(((newNum%5) == 0) && ((y%5) == 0)){
				newNum = newNum/5;
				y = y/5;
			}
			while(((newNum%7) == 0) && ((y%7) == 0)){
				newNum = newNum/7;
				y = y/7;
			}
			if(newNum == 0) {
				int solve = x/y;
				return new String(solve + "");
			}
			if(x/y == 1) {
				String wholeWithFraction = "1_" + newNum + "/" + y;
				return new String(wholeWithFraction);
			}
			String wholeWithFraction = whole + "_" + newNum + "/" + y;
			return new String(wholeWithFraction);
    	}
    	if(x < y) {
			int newNum = x%y;
			while(((newNum%3) == 0) && ((y%3) == 0)){
				newNum = newNum/3;
				y = y/3;
			}
			while(((newNum%5) == 0) && ((y%5) == 0)){
				newNum = newNum/5;
				y = y/5;
			}
			while(((newNum%7) == 0) && ((y%7) == 0)){
				newNum = newNum/7;
				y = y/7;
			}
			String fraction = newNum + "/" + y;
			return new String(fraction);
    	}
    	return new String(container);
    }
	public static String pos(String partOne) {
		if(partOne.trim().isEmpty()) {
			String p = "+";
			return new String(p);
		}
		return new String(partOne);
	}
	public static String symbolOne(String n) {
		if(n.length() == 1) {
			return new String(n);
		}
		if(n.length() == 2) {
			String[] splitString = n.split("\\s+");
			String splitted = splitString[1];
			return new String("+" + splitted);
		}
		return new String(n);
	}
	public static String newStringOne(String newOne) {
		boolean c = newOne.contains(" ");
		if(c == true){
			return new String(newOne);
		}
		if(c == false) {
			String cv = (newOne + " 0" + " 1");
			return new String(cv);
		}
		return new String(newOne);
	}
	public static String newStringTwo(String newTwo) {
		boolean c = newTwo.contains(" ");
		if(c == true){
			return new String(newTwo);
		}
		if(c == false) {
			String cv = (newTwo + " 0" + " 1");
			return new String(cv);
		}
		return new String(newTwo);
	}
	public static String newCheckOne(String x) {
		if(x.charAt(0) == '-') {
			int l = x.length();
			return new String("- " + x.substring(1, l));
		}
		else {
			int l = x.length();
			return new String(" " + x.substring(0, l));
		}
	}
	public static String newCheckTwo(String x) {
		if(x.charAt(0) == '-') {
			int l = x.length();
			return new String("- " + x.substring(1, l));
		}
		else {
			int l = x.length();
			return new String(" " + x.substring(0, l));
		}
	}
	public static String fracOne(String x) {
		int lengthOfX = x.length();
		if(x.charAt(0) == '-') {
			int spaceOne = x.indexOf("_");
			int divideOne = x.indexOf("/");
			if(spaceOne > 0 && spaceOne < lengthOfX) {
				String wholeNumOnex = x.substring(1, spaceOne);
				String numOne = x.substring(spaceOne + 1, divideOne);
				String denOne = x.substring(divideOne + 1, lengthOfX);
				return new String("-" + wholeNumOnex + " " + numOne + " " + denOne);
			}
			else{
				if(divideOne > 0 && divideOne < lengthOfX) {
					String numOne = x.substring(1, divideOne);
					String denOne = x.substring(divideOne + 1, lengthOfX);
					return new String("-" + "0 " + numOne + " " + denOne);
				}
				if(divideOne < 0) {
					String wholeNumberOney = x.substring(1,lengthOfX);
					return new String("-" + wholeNumberOney);
				}
			}
		}
		if(x.indexOf("-") == -1) {
			int spaceOne = x.indexOf("_");
			int divideOne = x.indexOf("/");
			if(spaceOne > 0 && spaceOne < lengthOfX) {
				String wholeNumOnez = x.substring(0,spaceOne);
				String numOne = x.substring(spaceOne + 1, divideOne);
				String denOne = x.substring(divideOne + 1, lengthOfX);
				return new String(wholeNumOnez + " " + numOne + " " + denOne);
			}
			else{
				if(divideOne > 0 && divideOne < lengthOfX) {
					String numOne = x.substring(0, divideOne);
					String denOne = x.substring(divideOne + 1, lengthOfX);
					return new String("0 " + numOne + " " + denOne);
				}
				else {
					String wholeNumberFullTwo = x.substring(0,lengthOfX);
					return new String(wholeNumberFullTwo);
				}
			}
		}
		return new String(x);
	}
	public static String fracTwo(String z) {
		int lengthOfZ = z.length();
		if(z.charAt(0) == '-') {
			int spaceTwo = z.indexOf("_");
			int divideTwo = z.indexOf("/");
			if(spaceTwo > 0 && spaceTwo < lengthOfZ) {
				String wholeNumTwox = z.substring(1, spaceTwo);
				String numTwo = z.substring(spaceTwo + 1, divideTwo);
				String denTwo = z.substring(divideTwo + 1, lengthOfZ);
				return new String("-" + wholeNumTwox + " " + numTwo + " " + denTwo);
			}
			else {
				if(divideTwo > 0 && divideTwo < lengthOfZ) {
					String numTwo = z.substring(1, divideTwo);
					String denTwo = z.substring(divideTwo + 1, lengthOfZ);
					return new String("-" + "0 " + numTwo + " " + denTwo);
				}
				if(divideTwo < 0){
					String wholeNumberFull = z.substring(1,lengthOfZ);
					return new String("-" + wholeNumberFull);
				}
			}
		}
		if(z.charAt(0) != '-') {
			int spaceTwo = z.indexOf("_");
			int divideTwo = z.indexOf("/");
			if(spaceTwo > 0 && spaceTwo < lengthOfZ) {
				String wholeNumTwo = z.substring(0,spaceTwo);
				String numTwo = z.substring(spaceTwo + 1, divideTwo);
				String denTwo = z.substring(divideTwo + 1, lengthOfZ);
				return new String(wholeNumTwo + " " + numTwo + " " + denTwo);
			}
			else{
				if(divideTwo > 0 && divideTwo < lengthOfZ) {
					String numTwo = z.substring(0, divideTwo);
					String denTwo = z.substring(divideTwo + 1, lengthOfZ);
					return new String("0 " + numTwo + " " + denTwo);
				}
				if(divideTwo < 0){
					String wholeNumberFull = z.substring(0,lengthOfZ);
					return new String(wholeNumberFull);
				}
			}
		}
		return new String(z);
	}
}












