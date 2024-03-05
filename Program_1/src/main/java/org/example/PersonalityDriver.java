package org.example;

import java.io.*;
import java.util.*;

public class PersonalityDriver {

	public static void main(String[] args) throws FileNotFoundException{
		//Analyze your info
		Personality me = new Personality("Kilichov.csv");        //Also replace with your filename
		me.analyze();
		System.out.println(me.getClassPersonalityTypes());
		System.out.println("Class Count\n" + me.countClassTypes());
		me.setLastName("Kilichov");
		System.out.println("Those like me\n" + me.similarity());

		System.out.println();
//		Personality myClass = new Personality("oneStudent.csv");
//		Personality myClass = new Personality("fiveStudents.csv");
		Personality myClass = new Personality("csci211_S24.csv");
		myClass.analyze();
		System.out.println("Class Personalities\n" + myClass.getClassPersonalityTypes());
		System.out.println("Class Count\n" + myClass.countClassTypes());
		System.out.println("Most Common Personality Type(s)\n" + myClass.mostCommonType());
		myClass.setLastName("Kilichov");
		System.out.println("LION\nThose with same Personality Type(s)\n" + myClass.similarity());

	}

}
