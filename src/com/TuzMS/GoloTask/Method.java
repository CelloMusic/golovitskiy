package com.TuzMS.GoloTask;

public class Method {
	//������������ ����� ��� �������� �������
		private float[] Xi; //�������� � �����
		private float[] Yi; //�������� Y �����
		private float[] a = new float[3]; //������������ ���������������� �����������
		private int n; //��������� �����
		
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
