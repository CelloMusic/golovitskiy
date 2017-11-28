package com.TuzMS.GoloTask;

public class MHK extends Method {
	//����� ���������� ���������

	public MHK(double[] x, double[] y) {
		super(x, y);
	}

	private double[] RaschB() {
		//������ ������� ��������� ������ ���� (2.5)
		double[] b = new double[3]; //������� ��������� ������ ���� (2.5)
		
		for (int t = 0; t < 3; t++) { //������ �� �������
			b[t] = 0;
			for (int i = 0; i < k; i++) {
				b[t] += Yi[i] * Math.pow(Xi[i], 2*t+1);
			}
		}
		return b;
	}
	
	private double[][] RaschA() {
		//������ ������� ������������� ��� a(t,j) ���� (2.5)
		double[][] matrix = new double[3][3];
		
		for (int t = 0; t < 3; t++) { //������ �� �������
			for (int j = 0; j < 3; j++) { //������ �� ��������
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
		//���������� ���������� ������������ �������������
		a = mnkRes.GaussM();
		return a;
	}
	
}
