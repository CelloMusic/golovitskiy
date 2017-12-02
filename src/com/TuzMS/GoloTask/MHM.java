package com.TuzMS.GoloTask;

public class MHM extends Method{
	//����� ���������� ������� �������������
	//A = (X'W(A0)X)^(-1)*X'W(A0)Y
	
	public MHM(double[] x, double[] y, double[] a0) {
		super(x, y);
		a = a0; //��������� �������� ��������� �������������
	}
	
	private double[] MHMIter() {
		//������ ����� ���������
		double[][] X = new double[k][3]; //������� �[i,j]=�j(xi)
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < 3; j++) {
				X[i][j] = Math.pow(Xi[i], 2*j+1);
			}
		}
		
		double[][] W = new double[k][k];
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < k; j++) {
				if (i == j) {
					W[i][i] = Math.abs(Yi[i] - yRes(Xi[i]));
				} else {
					W[i][j] = 0;
				}
			}
		}
		
		double[][] Y = new double[k][1]; //������� Yi
		for (int i = 0; i < k; i++) {
			Y[i][0] = Yi[i];
		}
		
		MatrixOperation m = new MatrixOperation();
		//��������� ����� ���������
		double[][] A = m.MultiMM(m.Obrat(m.MultiMM(m.Transp(X), m.MultiMM(W, X))), m.MultiMM(m.Transp(X), m.MultiMM(W, Y)));
		for (int j = 0; j < 3; j++) {
			a[j] = A[j][0];
		}
		return a;
	}
	
	public double[] MHMResh(double pMHK, double p) {
		//������� ���. ������� �� ������� �� ��� � �������� �������� � %
		double pMHM; //������� �� ���
		double pOtn; //������������� ������� �������
		int i = 0;
		do {
			a = MHMIter();
			pMHM = AbsNevyazka();
			pOtn = Math.abs(pMHK - pMHM) *100 / pMHK;
			i++;
		} while (pOtn > p);
		System.out.println("����� ���������: " + i);
		return a;
	}
	
}
