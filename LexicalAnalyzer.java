
import java.lang.*;
import java.io.*;
import java.util.*;

public class LexicalAnalyzer{
	static ArrayList<String> keyword_list = new ArrayList<String>();
	static ArrayList<String> number_list = new ArrayList<String>();
	static ArrayList<String> operator_list = new ArrayList<String>();
	static ArrayList<String> identifier_list = new ArrayList<String>();
	static ArrayList<String> syntax_list = new ArrayList<String>();

	public static boolean isKeyword(String str)
	{
		String keyword_str = "float int double long String main void abstract extends implements char finally final try catch import public const while do for switch case default super byte throw throws interface package if else break bool";
		String[] keyword_arr = keyword_str.split(" ");
		ArrayList<String> _keyword_list = new ArrayList<String>(Arrays.asList(keyword_arr));
		return _keyword_list.contains(str);
	}

	public static boolean isOperator(String str)
	{
		String operator_str = "+ - = * / % > < >= <= == || &&";
		String[] operator_arr = operator_str.split(" ");
		ArrayList<String> _operator_list = new ArrayList<String>(Arrays.asList(operator_arr));
		return _operator_list.contains(str);
	}

	public static boolean isNumber(String str)
	{
		// if(str.matches("-?[0-9]*\\.?[0-9]*"))
		// return true;
		// else
		// return false;
		if(str.matches("[0-9]+") || str.equals("true") || str.equals("false"))
		return true;
		else
		return false;
	}

	public static boolean isSyntax(String str)
	{
		String syntax_str = "{ } ( ) [ ] ; () {} []";
		String[] syntax_arr = syntax_str.split(" ");
		ArrayList<String> _syntax_list = new ArrayList<String>(Arrays.asList(syntax_arr));
		return _syntax_list.contains(str);
	}
	
	public static void printResults(ArrayList<String> keyword_list, ArrayList<String> number_list, ArrayList<String> operator_list, ArrayList<String> identifier_list, ArrayList<String> syntax_list)
	{
		System.out.print("\nKeywords : " + keyword_list.size() + " => ");
		for(String token : keyword_list)
		System.out.print(token + " ");

		System.out.print("\nConstants : " + number_list.size() + " => ");
		for(String token : number_list)
		System.out.print(token + " ");

		System.out.print("\nOperators : " + operator_list.size() + " => ");
		for(String token : operator_list)
		System.out.print(token + " ");

		System.out.print("\nDelimiters : " + syntax_list.size() + " => ");
		for(String token : syntax_list)
		System.out.print(token + " ");

		System.out.print("\nIdentifiers : " + identifier_list.size() + " => ");
		for(String token : identifier_list)
		System.out.print(token + " ");
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String inp_str = "";
		while(sc.hasNextLine())
		{
			String temp_inp = sc.nextLine();
			if(temp_inp == null || temp_inp.isEmpty())
			break;
			inp_str = inp_str + " " + temp_inp;
		}
		sc.close();
		String[] inp_arr = inp_str.split(" ");
		for(String token : inp_arr)
		{
			if(isKeyword(token))
			if(keyword_list.contains(token))
			continue;
			else
			keyword_list.add(token);

			else if(isNumber(token))
			if(number_list.contains(token))
			continue;
			else
			number_list.add(token);

			else if(isOperator(token))
			if(operator_list.contains(token))
			continue;
			else
			operator_list.add(token);

			else if(isSyntax(token))
			if(syntax_list.contains(token))
			continue;
			else
			syntax_list.add(token);

			else if(token == " " || token == "")
			continue;

			else
			if(identifier_list.contains(token))
			continue;
			else
			identifier_list.add(token);
		}
		printResults(keyword_list, number_list, operator_list, identifier_list, syntax_list);
		
		// System.out.println(identifier_list);
	}
}
