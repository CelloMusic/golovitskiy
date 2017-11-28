package com.TuzMS.GoloTask;

public class Method {
	//Родительский класс для описания методов
		private float[] Xi; //Значения Х точек
		private float[] Yi; //Значения Y точек
		private float[] a = new float[3]; //Коэффициенты аппроксимирующей зависимости
		private int n; //Количесво точек
		
		public Method(float[] x, float[] y){
			Xi = x;
			Yi = y;
			n = Xi.length;
		}
		
		protected float[] ResApproks() {
			float[] YRes = new float[n];
			for (int j = 0; j < n; j++) {
				YRes[j] = a[1]*Xi[j] + a[2]*Xi[j]*Xi[j]*Xi[j]
						+ a[3]*Xi[j]*Xi[j]*Xi[j]*Xi[j]*Xi[j];
			}
			return YRes;
		}

}
