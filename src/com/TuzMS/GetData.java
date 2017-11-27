package com.TuzMS;

import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.BufferedReader;

public class GetData {
	private /*final*/ String taskFileName = "Task2.txt"; //
	private float[] arrX; //������ �������� X
	private float[] arrY; //������ �������� Y
	
	public void readFile(String fileName) {
		try {
			File taskFile = new File(taskFileName); //��������� ���� � ��������
			FileReader readTaskFile = new FileReader(taskFile); //������ �������� �����
			BufferedReader reader = new BufferedReader(readTaskFile);
			String line = reader.readLine();
			while (line != null){
				System.out.println(line)
			}
			System.out.println("������");
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public String getTaskFileName() {
		return taskFileName;
	}
	
	
}