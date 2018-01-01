package com.TuzMS.GoloTask;

public class MHM extends Method{
	//Метод наименьших модулей итерационный
	
	public MHM(double[] x, double[] y, double[] ri, double[] a0) {
		super(x, y, ri);
		a = a0; //Начальные значения параметров аппроксимации
	}
	
	private void SetR() {
		//Задание итерируемого веса
		for (int i = 0; i < k; i++) {
			r[i] /= Math.abs(Yi[i] - yRes(Xi[i]));
		}
	}
	
	private void MHMIter() {
		//Прогон одной итерации
		SetR();
		MHK resh = new MHK(Xi, Yi, r);
		a = resh.MHKResh();
	}
	
	public double[] MHMResh(double p) {
		//Решение МНМ. Зависит от относительной невязки в %
		double pMHM; //Невязка по МНM
		int i = 0;
		do {
			MHMIter();
			pMHM = OtnNevyazka();
			i++;
		} while (pMHM > p);
		System.out.println("Число итераций: " + i);
		return a;
	}
	
}
