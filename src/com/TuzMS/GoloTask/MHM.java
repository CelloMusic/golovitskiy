package com.TuzMS.GoloTask;

public class MHM extends Method{
	//����� ���������� ������� �������������
	
	public MHM(double[] x, double[] y, double[] ri, double[] a0) {
		super(x, y, ri);
		a = a0; //��������� �������� ��������� �������������
	}
	
	private void SetR() {
		//������� ������������� ����
		for (int i = 0; i < k; i++) {
			r[i] /= Math.abs(Yi[i] - yRes(Xi[i]));
		}
	}
	
	private void MHMIter() {
		//������ ����� ���������
		SetR();
		MHK resh = new MHK(Xi, Yi, r);
		a = resh.MHKResh();
	}
	
	public double[] MHMResh(double p) {
		//������� ���. ������� �� ������������� ������� � %
		double pMHM; //������� �� ��M
		int i = 0;
		do {
			MHMIter();
			pMHM = OtnNevyazka();
			i++;
		} while (pMHM > p);
		System.out.println("����� ���������: " + i);
		return a;
	}
	
}
