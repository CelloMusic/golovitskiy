package com.TuzMS.GoloTask;

import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.BufferedReader;

public class GetData {
	private final String taskFileName = "Task.txt"; //Название файла с заданием
	private double[] arrX = new double[33]; //Массив значений X
	private double[] arrY = new double[33]; //Массив значений Y
	
	public void readFile(String fileName) {
		try {
			File taskFile = new File(taskFileName); //Файл открыт
			FileReader readTaskFile = new FileReader(taskFile); //Файл открыт для чтения
			BufferedReader reader = new BufferedReader(readTaskFile); //Читатель файла
			String line = reader.readLine();
			
			for (int i = 1; i <=12; i++){
				//Отмотка до строки со значениями
				line = reader.readLine();
			}
			
			int i = 0; //Счётчик массивов
			CorrectRecord rec = new CorrectRecord(); //Для записи числа в правильной форме
			
			while (line != null){
				//Записываем значения точек в массивы
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
