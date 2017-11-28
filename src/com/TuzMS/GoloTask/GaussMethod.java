package com.TuzMS.GoloTask;

public class GaussMethod {
	//������� ���� ������� ������
	private int n; //���������� ��������
	private float[][] A; //������� �������������
	private float[] B; //������� ��������� ������
	
	public GaussMethod(int n1, float[][] A1, float[] B1) {
		//����������� �������� ��������� ������� ��� �������������
		n = n1;
		A = A1;
		B = B1;
	}
	
	public float[] GaussM() {
		float[] X = new float[n--]; //������� �����������
		//������ ��� ������ ������
		for (int k = 0; k <= n - 1; k++) {
			for (int i = k + 1; i <= n; i++) {
				float c = A[i][k] / A[k][k];
				A[i][k] = 0;
				for (int j = k + 1; j <= n; j++) {
					A[i][j] -= c * A[k][j];
				}
				B[i] -= c * B[k];
			}
		}
		//�������� ��� ������ ������
		X[n] = B[n] / A[n][n];
		for (int i = n - 1; i >= 0; i--) {
			float s = 0;
			for (int j = i+1; j <= n; j++) {
				s += A[i][j] * X[j];
			}
			X[i] = (B[i] - s) / A[i][i];
		}
		return X;
	}
}
