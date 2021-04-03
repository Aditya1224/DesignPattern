package com.singleton.related.topics;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
 * Serialization and Deserialization: Serialization is a mechanism of 
 * converting the state of an object into a byte stream.
 * Deserialization is the reverse process where the byte stream is 
 * used to recreate the actual Java object in memory. This mechanism is 
 * used to persist the object. 
 * The byte stream created is platform independent. 
 * So, the object serialized on one platform can be deserialized 
 * on a different platform.
 */
//https://www.geeksforgeeks.org/serialization-in-java/
public class SerializationTest {

	public static void printdata(Demo object1) {

		System.out.println("t = " + object1.t);
		System.out.println("s = " + object1.s);
		System.out.println("a = " + object1.a);
		System.out.println("b = " + object1.b);
	}

	public static void main(String[] args) {
//		Demo object = new Demo(1, "geeksforgeeks");
		Demo object = new Demo(22, 33, 1, "geeksforgeeks");
		String filename = "file.ser";

		// Serialization
		try {
			// Saving of object in a file
			FileOutputStream file = new FileOutputStream(filename);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(file);

			// Method for serialization of object
			objectOutputStream.writeObject(object);
			objectOutputStream.close();

			file.close();
			object.s = 2000;

			System.out.println("Object has been serialized");
			printdata(object);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		Demo object1 = null;

		// Deserialization
		try {
			// Reading the object from a file
			FileInputStream file = new FileInputStream(filename);
			ObjectInputStream inputStream = new ObjectInputStream(file);

			// Method for deserialization of object
			object1 = (Demo) inputStream.readObject();

			inputStream.close();
			file.close();

//			System.out.println("Obje	ct has been deserialized ");
//			System.out.println("a = " + object1.a);
//			System.out.println("b = " + object1.b);

			System.out.println("Object has been deserialized\n" + "Data after Deserialization.");
			printdata(object1);

		} catch (IOException ex) {
			System.out.println("IOException is caught");
		} catch (ClassNotFoundException ex) {
			System.out.println("ClassNotFoundException is caught");
		}

	}

}

class Demo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	transient int t;
	static int s;
	public int a;
	public String b;

	public Demo(int a, String b) {
		super();
		this.a = a;
		this.b = b;
	}

	public Demo(int t, int s, int a, String b) {
		super();
		this.t = t;
		this.s = s;
		this.a = a;
		this.b = b;
	}

}

/*
 * OUTPUT: Object has been deserialized Data after Deserialization. t = 22 s =
 * 2000 a = 1 b = geeksforgeeks.
 * 
 * Description for Output: You have seen while deserializing the object the
 * values of t and s has changed. The reason being t was marked as transient and
 * s was static. 
 * 
 * In case of transient variables:- A variable defined with
 * transient keyword is not serialized during serialization process.This
 * variable will be initialized with default value during deserialization. (e.g:
 * for objects it is null, for int it is 0). 
 * 
 * In case of static Variables:- A variable defined with static keyword 
 * is not serialized during serialization process.This variable will be 
 * loaded with current value defined in the class during deserialization.
 */
