package com.ibm.spring.PAS.jackson.json;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {

		try {
			
			ObjectMapper mapper = new ObjectMapper();
			Student student = mapper.readValue(new File("data/lite.json"), Student.class);
			System.out.println("Student: " + student.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
