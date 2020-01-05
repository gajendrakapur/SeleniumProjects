package org.JavaP.com;

public class SingletonPattern {
		
		private static SingletonPattern singleInstance = null;
		
		//Constructor is kept as private as this is a Singleton Class
		private SingletonPattern() {
			
		}
		
		//write a public static method, that has return type of object of this singleton class
		public static SingletonPattern  getInstance() {
			if(singleInstance == null) {
				singleInstance = new SingletonPattern();
			}
			return singleInstance;
		}
		
		public static void main(String[] args) {
			SingletonPattern x1 = SingletonPattern.getInstance();
			SingletonPattern x2 = SingletonPattern.getInstance();
		}
	}


