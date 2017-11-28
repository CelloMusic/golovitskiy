package com.TuzMS.GoloTask;

public class Main {
	public static void main(String [] args) {
		GetData d = new GetData();
    	d.readFile(d.getTaskFileName());
    	System.out.println("Good");
    	
    	/*float[][] A = {
				{1f, -10f, 3f, 0f}, 
				{3f, -26f, 8f, 3f}, 
				{-5f, 47f, -15f, 5f},
				{0f, 6f, 2f, -7f}
			};
    	float[] B = {51f, 141f, -225f, -49f};
    	GaussMethod M = new GaussMethod(4, A, B);
    	float[] X = M.GaussM();
    	for (int i = 0; i<4; i++){
    		System.out.println(X[i]);
    	}*/
    	
    	
	}
}
