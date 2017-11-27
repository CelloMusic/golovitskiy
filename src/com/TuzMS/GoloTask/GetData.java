package com.TuzMS.GoloTask;

import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.BufferedReader;

public class GetData {
	private final String taskFileName = "Task.txt"; //�������� ����� � ��������
	private float[] arrX; //������ �������� X
	private float[] arrY; //������ �������� Y
	
	public void readFile(String fileName) {
		try {
			File taskFile = new File(taskFileName); //���� ������
			FileReader readTaskFile = new FileReader(taskFile); //���� ������ ��� ������
			BufferedReader reader = new BufferedReader(readTaskFile); //�������� �����
			String line = reader.readLine();
			
			for (int i = 0; i <=11; i++){
				//������� �� ������ �� ����������
				line = reader.readLine();
			}
			
			int i = 0; //������� ��������
			
			while (line != null){
				System.out.println(line);
				
				line = reader.readLine();
			}
			
			System.out.println("������");
			readTaskFile.close();
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public String getTaskFileName() {
		return taskFileName;
	}
}
