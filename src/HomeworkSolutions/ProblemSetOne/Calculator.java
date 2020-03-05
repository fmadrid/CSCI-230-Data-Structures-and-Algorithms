package HomeworkSolutions.ProblemSetOne;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

	
	
	private static ArrayList<String> parseString(String inputExpression) {
		
		ArrayList<String> tokens = new ArrayList<String>();
		
		String[] patterns = new String[] {"(sqrt)", "(pow)", "(\\+)", "(\\-)", "(\\*)", "(\\/)", "(\\%)","(\\()", "(\\))", "(\\d+)", "\\,"};
		Matcher m = Pattern.compile(String.join("|", patterns)).matcher(inputExpression);
		
		while(m.find()) tokens.add(m.group());
		
		return tokens;
		
	}
	
	private static int getClosingIndex(List<String> tokens, int currentIDX) {
		for(int i = currentIDX + 1; i < tokens.size(); ++i)
			if(tokens.get(i) == ")") return i;
		throw new IllegalArgumentException("");
	}
	
	private static double evaluateExpression(List<String> tokens) {
		
		char operation = ' ';
		
		
		double temp;
		for(int i = 0; i < tokens.size(); ++i) {
			
			if(tokens.get(i) == "sqrt") {
				int closingIDX = getClosingIndex(tokens, i);
				temp = evaluateExpression(tokens.subList(i+2, closingIDX));
			} else if(tokens.get(i) == "pow") {
				int closingIDX = getClosingIndex(tokens, i);
				temp = evaluateExpression(tokens.subList(i+2, closingIDX));
			} else if(tokens.get(i) == "(") {
				int closingIDX = getClosingIndex(tokens, i);
				temp = evaluateExpression(tokens.subList(i+1, closingIDX));
			}
		
		return 0;
	}
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		String expression = input.nextLine();
		
		System.out.println("Expression: " + expression);
		System.out.println("Value: " + evaluateExpression(parseString(expression)));
		
	}
	
}
