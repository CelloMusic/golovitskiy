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
		double[] YRes = new double[k];
		for (int j = 0; j < k; j++) {
			YRes[j] = a[1]*Xi[j] + a[2]*Math.pow(Xi[j], 3)
					+ a[3]*Math.pow(Xi[j], 5);
		}
		return YRes;
	}

}
