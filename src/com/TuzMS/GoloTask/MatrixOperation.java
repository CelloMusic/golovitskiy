package com.TuzMS.GoloTask;

public class MatrixOperation {
	//Класс для описания различных операций над матрицами
	
	public double[][] Multi(double[][] A, double[][] B) {
		//Перемножение матриц
		int ai = A.length; //Число строк матрицы А
		int ak = A[0].length; //Число столбцов матрицы А
		int bk = B.length; //Число строк матрицы В
		int bj = B[0].length; //Число столбцов матрицы В
		
		if (ak == bk) {
			double[][] C = new double[ai][bj];
			for (int i = 0; i < ai; i++) {
				for (int j = 0; j < bj; j++) {
					C[i][j] = 0;
					for (int k = 0; k < ak; k++) {
						C[i][j] += A[i][k]*B[k][j];
					}
				}
			}
			return C;
		} else {
			System.out.println("Эти матрицы перемножать нельзя!");
			return null;
		}
	}
	
}
