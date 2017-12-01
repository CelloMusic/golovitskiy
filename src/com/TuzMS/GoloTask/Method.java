package com.TuzMS.GoloTask;

public class Method {
	//Родительский класс для описания методов
	protected double[] Xi; //Значения Х точек
	protected double[] Yi; //Значения Y точек
	protected double[] a = new double[3]; //Коэффициенты аппроксимирующей зависимости
	protected int k; //Количесво точек
		
	public Method(double[] x, double[] y){
		Xi = x;
		Yi = y;
		k = Xi.length;
	}
		
	protected double[] ResApproks() {
		//Результат аппроксимации
		double[] YRes = new double[k];
		for (int j = 0; j < k; j++) {
			YRes[j] = yRes(Xi[j]);
		}
		return YRes;
	}
	
	protected double yRes(double x) {
		//Результат аппроксимации в точке х
		return a[1]*x + a[2]*Math.pow(x, 3) + a[3]*Math.pow(x, 5);
	}

}
