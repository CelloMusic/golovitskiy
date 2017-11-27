package com.TuzMS.GoloTask;

public class Main {
	public static void main(String [] args) {
		GetData d = new GetData();
    	d.readFile(d.getTaskFileName());
    	//System.out.println("Good");
	}
}
