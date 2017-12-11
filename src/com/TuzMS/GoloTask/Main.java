package com.TuzMS.GoloTask;

import java.util.Scanner;

public class Main {
	public static void main(String [] args) {
		//������ ������ �� �����
		GetData task = new GetData();
		task.readFile(task.getTaskFileName());
		double[] xi = task.getArrX();
		double[] yi = task.getArrY();
		
		//���
		double[] r = new double[xi.length];
		for (int i = 0; i < xi.length; i++) {
			//������� ���� ��� ���
			r[i] = 1;
		}
		MHK reshenieMHK = new MHK(xi, yi, r);
		double[] a = reshenieMHK.MHKResh();
		System.out.println("������� ������� ���������� ���������: ");
		for (int i = 0; i < 3; i++) {
			System.out.print(a[i] + "	");
		}
		System.out.println();
		double pMHK = reshenieMHK.AbsNevyazka();
		System.out.println("������� �� ��� = " + pMHK);
		
		//���
		System.out.println("������ ������� ���:");
		System.out.println("������� ��������� ��������� ������������� (3 �����):");
		Scanner sc = new Scanner(System.in);
		double[] b = new double[3];
		for (int i = 0; i < b.length; i++) {	
			b[i] = sc.nextDouble();
		}
		sc.close();
		System.out.println("��������� �������� �������.");
		MHM reshenieMHM = new MHM(xi, yi, r, b);
		System.out.println("������� ������� ���������� �������: ");
		b = reshenieMHM.MHMResh(5);
		for (int i = 0; i < 3; i++) {
			System.out.print(b[i] + "	");
		}
		System.out.println();
		double pMHM = reshenieMHM.AbsNevyazka();
		System.out.println("������� �� ��� = " + pMHM);
	}
}