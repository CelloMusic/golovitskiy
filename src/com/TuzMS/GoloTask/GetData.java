package com.TuzMS.GoloTask;

import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.BufferedReader;

public class GetData {
	private final String taskFileName = "Task.txt"; //Название файла с заданием
	private float[] arrX; //Массив значений X
	private float[] arrY; //Массив значений Y
	
	public void readFile(String fileName) {
		try {
			File taskFile = new File(taskFileName); //Файл открыт
			FileReader readTaskFile = new FileReader(taskFile); //Файл открыт для чтения
			BufferedReader reader = new BufferedReader(readTaskFile); //Читатель файла
			String line = reader.readLine();
			
			for (int i = 0; i <=11; i++){
				//Отмотка до строки со значениями
				line = reader.readLine();
			}
			
			int i = 0; //Счётчик массивов
			
			while (line != null){
				System.out.println(line);
				
				line = reader.readLine();
			}
			
			System.out.println("Готово");
			readTaskFile.close();
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public String getTaskFileName() {
		return taskFileName;
	}
}
