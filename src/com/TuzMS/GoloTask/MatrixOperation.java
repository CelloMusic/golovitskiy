package com.TuzMS.GoloTask;

public class MatrixOperation {
	//����� ��� �������� ��������� �������� ��� ���������
	
	public double[][] Multi(double[][] A, double[][] B) {
		//������������ ������
		int ai = A.length; //����� ����� ������� �
		int ak = A[0].length; //����� �������� ������� �
		int bk = B.length; //����� ����� ������� �
		int bj = B[0].length; //����� �������� ������� �
		
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
			System.out.println("��� ������� ����������� ������!");
			return null;
		}
	}
	
}
