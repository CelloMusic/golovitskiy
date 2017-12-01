package com.TuzMS.GoloTask;

public class MatrixOperation {
	//����� ��� �������� ��������� �������� ��� ���������
	
	public double[][] MultiMM(double[][] A, double[][] B) {
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
	
	public double[][] MultiNM(double[][] A, double n) {
		//��������� ������� �� �����
		int ai = A.length; //����� ����� ������� �
		int aj = A[0].length; //����� �������� ������� �
		
		for (int i = 0; i < ai; i++) {
			for (int j = 0; j < aj; j++) {
				A[i][j] *= n; 
			}
		}
		return A;
	}
	
	public double Det(double[][] A) {
		//���������� ������������ ������� ����������� ����������
		double det = 0;
		int n = A.length;
		
		if (n == 2) {
			det = A[0][0] * A[1][1] - A[0][1] * A [1][0];
		} else {
			for (int i = 0; i < n; i++) {
				det += Math.pow(-1, i+1) * A[1][i] * Det(MinorMatrix(A, 1, i));
			}
		}
		return det;
	}
	
	public double[][] MinorMatrix(double[][] A, int ai, int aj) {
		//���������� ������� ������ �(ai, aj) (������������ ai ������ � aj �������)
		int n = A.length - 1;
		double[][] M = new double[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i <= ai-1) {
					if (j <= aj-1) {
						M[i][j] = A[i][j];
					} else if (j > aj-1) {
						M[i][j] = A[i][j+1];
					}
				} else if (i > ai-1) {
					if (j <= aj-1) {
						M[i][j] = A[i+1][j];
					} else if (j > aj-1) {
						M[i][j] = A[i+1][j+1];
					}
				}
			}
		}
		return M;
	}
	
	public double AlgDop(double[][] A, int ai, int aj) {
		//���������� ��������������� ���������� A(ai, aj)
		return Math.pow(-1, ai + aj) * Det(MinorMatrix(A, ai, aj));
	}
	
	public double[][] AlgDopMatrix(double[][] A) {
		//���������� ������� �������������� ����������
		int n = A.length;
		double[][] M = new double[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				M[i][j] = AlgDop(A, i, j);
			}
		}
		return M;
	}
	
	public double[][] Transp(double[][] A) {
		//���������������� �������
		int ni = A.length;
		int nj = A[0].length;
		double[][] M = new double[nj][ni];
		
		for (int i = 0; i < ni; i++) {
			for (int j = 0; j < nj; j++) {
				M[j][i] = A[i][j];
			}
		}
		return M;
	}
	
	public double[][] Obrat(double[][] A) {
		//���������� �������� �������
		return MultiNM(Transp(AlgDopMatrix(A)), 1/Det(A));
	}
	
}
