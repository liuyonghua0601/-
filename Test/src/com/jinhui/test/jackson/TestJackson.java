package com.jinhui.test.jackson;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

/**
 * 2018-5-3上午10:50:04
 * TestJackson.java
 * author:liuyonghua
 */
public class TestJackson {

	public static void main(String[] args) {
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = "{\"name\":\"Maheshi\",\"age\":\"21\"}";
		try {
			//mapper.enableDefaultTyping();
			Student student = mapper.readValue(jsonString, Student.class);
			System.out.println(student);
			
			mapper.enable(SerializationConfig.Feature.INDENT_OUTPUT);
			jsonString = mapper.writeValueAsString(student);
			System.out.println(jsonString);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	class Student{
		private String name;
		private int age;
		public Student(){
		}
		public Student(String name,int age){
			this.name = name;
			this.age = age;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String toString(){
	      return "Student [ name: "+name+", age: "+ age+ " ]";
	   }
	}
}
