package com.processing;

import java.util.Scanner;

public class InputQuery {
	
	public static void main(String[] args)
	{
	Scanner scan=new Scanner(System.in);
	System.out.println("Enter the query : ");
	String input=scan.nextLine();
	QueryParser q=new QueryParser();
	q.splitQuery(input);
	q.extractQueryComponents();
	
	
	}

}
