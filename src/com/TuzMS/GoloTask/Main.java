package com.TuzMS.GoloTask;

import java.util.Scanner;

public class Main {
	public static void main(String [] args) {
		//Чтение данных из файла
		GetData task = new GetData();
		task.readFile(task.getTaskFileName());
		double[] xi = task.getArrX();
		double[] yi = task.getArrY();
		
		//МНК
		MHK reshenieMHK = new MHK(xi, yi);
		double[] a = reshenieMHK.MHKResh();
		System.out.println("Решение методом наименьших квадратов: ");
		for (int i = 0; i < 3; i++) {
			System.out.print(a[i] + "	");
		}
		System.out.println();
		double pMHK = reshenieMHK.OtnNevyazka();
		System.out.println("Невязка по МНК = " + pMHK + " %");
		
		//МНМ
		System.out.println("Начало решения МНМ:");
		System.out.println("Введите начальные параметры аппроксимации (3 числа):");
		Scanner sc = new Scanner(System.in);
		double[] b = new double[3];
		for (int i = 0; i < b.length; i++) {	
			b[i] = sc.nextDouble();
		}
		sc.close();
		System.out.println("Начальные значения введены.");
		MHM reshenieMHM = new MHM(xi, yi, b);
		System.out.println("Решение методом наименьших модулей: ");
		b = reshenieMHM.MHMResh(15);
		for (int i = 0; i < 3; i++) {
			System.out.print(b[i] + "	");
		}
		System.out.println();
		double pMHM = reshenieMHM.AbsNevyazka();
		System.out.println("Невязка по МНМ = " + pMHM);
	}
}