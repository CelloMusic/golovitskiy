package com.TuzMS.GoloTask;

public class Main {
	public static void main(String [] args) {
		GetData task = new GetData();
    	task.readFile(task.getTaskFileName());
    	System.out.println("Good");
    	
    	double[] xi = task.getArrX();
    	double[] yi = task.getArrY();
    	MHK reshenieMHK = new MHK(xi, yi);
    	for (int i = 0; i < 33; i++) {
    		System.out.println(xi[i] + "	" + yi[i]);
    	}
    	
    	double[] a = reshenieMHK.MHKResh();
    	
    	for (int i = 0; i < 3; i++) {
    		System.out.print(a[i] + "	");
    	}
    	System.out.println();
	}
}
