package com.TuzMS.GoloTask;

public class MatrixOperation {
	//Класс для описания различных операций над матрицами
	
	public double[][] MultiMM(double[][] A, double[][] B) {
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
	
	public double[][] MultiNM(double[][] A, double n){
		//Умножение матрицы на число
		int ai = A.length; //Число строк матрицы А
		int aj = A[0].length; //Число столбцов матрицы А
		
		for (int i = 0; i < ai; i++) {
			for (int j = 0; j < aj; j++) {
				A[i][j] *= n; 
			}
		}
		return A;
	}
	
	public double Det(double[][] A) {
		//Нахождение определителя матрицы
		int n = A.length; //Размер матрицы А
		double max;
		int r;
		
		double det = 1;
		for (int k = 0; k < n; k++) {
			max = Math.abs(A[k][k]);
			r = k;
			for (int i = k+1; i < n; i++) {
				if (Math.abs(A[i][k]) > max) {
					max = Math.abs(A[i][k]);
					r = i;
				}
			}
			if (r != k) {
				det *= (-1);
			}
			for (int j = 0; j < n; j++) {
				double c = A[k][j];
				A[k][j] = A[r][j];
				A[r][j] = c;
			}
			for (int i = k+1; i < n; i++) {
				for (int j = k; j < n; j++) {
					A[i][j] -= A[i][k] * A[k][j] / A[k][k];
				}
			}
		}
		for (int i = 0; i < n; i++) {
			det *= A[i][i];
		}
		return det;
	}
	
	public double[][] MinorMatrix(double[][] A, int ai, int aj) {
		//Нахождение матрицы минора А(ai, aj)
		//ai - вычёркиваемая строка, aj - столбец
		int n = A.length - 1;
		double[][] M = new double[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i <= ai-1) {
					if (j <= aj-1) {
						M[i][j] = A[i][j];
					} else if (j > aj-1) {
						M[i][j] = A[i][j+1];
					}
				} else if (i > ai-1) {
					if (j <= aj-1) {
						M[i][j] = A[i+1][j];
					} else if (j > aj-1) {
						M[i][j] = A[i+1][j+1];
					}
				}
			}
		}
		return M;
	}
	
}
