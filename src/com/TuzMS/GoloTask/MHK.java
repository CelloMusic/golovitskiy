package com.TuzMS.GoloTask;

public class MHK extends Method {
	//Метод наименьших квадратов

	public MHK(double[] x, double[] y) {
		super(x, y);
	}

	private double[] RaschB() {
		//Расчёт столбца свободных членов СЛАУ (2.5)
		double[] b = new double[3]; //Столбец свободных членов СЛАУ (2.5)
		
		for (int t = 0; t < 3; t++) { //Бегаем по строкам
			b[t] = 0;
			for (int i = 0; i < k; i++) {
				b[t] += Yi[i] * Math.pow(Xi[i], 2*t+1);
			}
		}
		return b;
	}
	
	private double[][] RaschA() {
		//Расчёт матрицы коэффициентов при a(t,j) СЛАУ (2.5)
		double[][] matrix = new double[3][3];
		
		for (int t = 0; t < 3; t++) { //Бегаем по строкам
			for (int j = 0; j < 3; j++) { //Бегаем по столбцам
				matrix[t][j] = 0;
				for (int i = 0; i < k; i++) {
					matrix[t][j] += Math.pow(Xi[i], 2*t+1) * Math.pow(Xi[i], 2*j+1);
				}
			}
		}
		return matrix;
	}
	
	private GaussMethod mnkRes = new GaussMethod(3, RaschA(), RaschB());
	
	public double[] MHKResh() {
		//Собственно нахождение коэффициетов аппроксимации
		a = mnkRes.GaussM();
		return a;
	}
	
}
