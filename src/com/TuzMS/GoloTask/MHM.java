package com.TuzMS.GoloTask;

public class MHM extends Method{
	//Метод наименьших модулей итеррационный
	
	public MHM(double[] x, double[] y, double[] ri, double[] a0) {
		super(x, y, ri);
		a = a0; //Начальные значения парамтров аппроксимации
		for (int i = 0; i < k; i++) {
			r[i] /= Math.abs(Yi[i] - yRes(Xi[i]));
		}
	}
	
	/*private void setR() {
		//Задание итеррируемого веса
		for (int i = 0; i < k; i++) {
			r[i] /= Math.abs(Yi[i] - yRes(Xi[i]));
		}
	}*/
	
	
	
	private double[] MHMIter() {
		//Прогон одной итеррации
		MHK resh = new MHK(Xi, Yi, r);
		a = resh.MHKResh();
		for (int i = 0; i < k; i++) {
			r[i] /= Math.abs(Yi[i] - yRes(Xi[i]));
		}
		return a;
	}
	
	public double[] MHMResh(double p) {
		//Решение МНМ. Зависит от относительной невязки в %
		double pMHM; //Невязка по МНM
		int i = 0;
		do {
			a = MHMIter();
			pMHM = OtnNevyazka();
			System.out.print(pMHM + "	");
			for (int j = 0; j < 3; j++) {
				System.out.print(a[j] + "	");
			}
			System.out.println();
			i++;
		} while (pMHM > p);
		System.out.println("Число итерраций: " + i);
		return a;
	}
	
}
