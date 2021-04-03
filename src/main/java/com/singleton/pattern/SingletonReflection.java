package com.singleton.pattern;

import java.lang.reflect.Constructor;

//https://www.geeksforgeeks.org/prevent-singleton-pattern-reflection-serialization-cloning/
public class SingletonReflection {
	public static void main(String[] args) {

		SingletonTest singletonTest1 = SingletonTest.getInstance();
		SingletonTest singletonTest2 = null;
		try {
			Constructor[] constructors = SingletonTest.class.getDeclaredConstructors();
			for (Constructor c : constructors) {
				/*
				 * Allows to access the field irrespective of the access modifier used with the
				 * field.
				 */
				c.setAccessible(true);
				singletonTest2 = (SingletonTest) c.newInstance();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		System.out.println("singletonTest1.hashCode() => " + singletonTest1.hashCode());
		System.out.println("singletonTest2.hashCode() => " + singletonTest2.hashCode());

	}
}

class SingletonTest {
	private static SingletonTest singletonTest = null;

	private SingletonTest() {
	}

	public static SingletonTest getInstance() {
		if (null == singletonTest) {
			synchronized (SingletonTest.class) {
				if (null == singletonTest) {
					singletonTest = new SingletonTest();
				}
			}
		}
		return singletonTest;
	}
}

/*
 * Overcome reflection issue: To overcome issue raised by reflection, enums are
 * used because java ensures internally that enum value is instantiated only
 * once. As enums don’t have any constructor so it is not possible for
 * Reflection to utilize it. Enums have their by-default constructor, we can’t
 * invoke them by ourself. JVM handles the creation and invocation of enum
 * constructors internally. As enums don’t give their constructor definition to
 * the program, it is not possible for us to access them by Reflection also.
 * Hence, reflection can’t break singleton property in case of enums.
 */
//Java program for Enum type singleton
enum Singleton {
	INSTANCE;
}
