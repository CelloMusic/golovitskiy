package com.TuzMS.GoloTask;

import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.BufferedReader;

public class GetData {
	private final String taskFileName = "Task.txt"; //�������� ����� � ��������
	private double[] arrX = new double[33]; //������ �������� X
	private double[] arrY = new double[33]; //������ �������� Y
	
	public void readFile(String fileName) {
		try {
			File taskFile = new File(taskFileName); //���� ������
			FileReader readTaskFile = new FileReader(taskFile); //���� ������ ��� ������
			BufferedReader reader = new BufferedReader(readTaskFile); //�������� �����
			String line = reader.readLine();
			
			for (int i = 1; i <=12; i++){
				//������� �� ������ �� ����������
				line = reader.readLine();
			}
			
			int i = 0; //������� ��������
			CorrectRecord rec = new CorrectRecord(); //��� ������ ����� � ���������� �����
			
			while (line != null){
				//���������� �������� ����� � �������
				arrX[i] = rec.Rewrite(line);
				line = reader.readLine();
				arrY[i] = rec.Rewrite(line);
				line = reader.readLine();
				i++;
			}
			readTaskFile.close();
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public String getTaskFileName() {
		return taskFileName;
	}
	public double[] getArrX() {
		return arrX;
	}

	public double[] getArrY() {
		return arrY;
	}	
	
}
