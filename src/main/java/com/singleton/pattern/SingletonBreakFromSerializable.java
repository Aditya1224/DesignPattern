package com.singleton.pattern;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SingletonBreakFromSerializable {

	public static void main(String[] args) {
		String filename = "file.text";
		SerializableSingleton serializableSingleton1 = SerializableSingleton.singletonObj;
		try {
			//Serailize
			ObjectOutput objectOutput = new ObjectOutputStream(new FileOutputStream(filename));
			objectOutput.writeObject(serializableSingleton1);

			objectOutput.close();
			// Deserailize from file to object
			ObjectInput input = new ObjectInputStream(new FileInputStream(filename));
			SerializableSingleton serializableSingleton2 = (SerializableSingleton) input.readObject();
			input.close();

			System.out.println("serializableSingleton1 hashCode:- " + serializableSingleton1.hashCode());
			System.out.println("serializableSingleton2 hashCode:- " + serializableSingleton2.hashCode());
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}

class SerializableSingleton implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// public instance initialized when loading the class
	public static SerializableSingleton singletonObj = new SerializableSingleton();

	private SerializableSingleton() { } 
	
	/*
	 * Overcome serialization issue:- To overcome this issue, we have to implement 
	 * method readResolve() method. 
	 * The readResolve method is called when ObjectInputStream has read an object from the 
	 * stream and is preparing to return it to the caller. ObjectInputStream checks whether 
	 * the class of the object defines the readResolve method.
	 * 
	 * The readResolve method is not invoked on the object until the object is fully constructed.
	 * 
	 */
	protected Object readResolve()
    {
        return singletonObj;
    }
}