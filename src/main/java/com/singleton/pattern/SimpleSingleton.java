package com.singleton.pattern;

//Classic Implementation 
public class SimpleSingleton {

	private static SimpleSingleton simpleSingleton;

	private SimpleSingleton() {
	}

//	lazy instantiation.
	public static SimpleSingleton getInstance() throws InterruptedException {
		while (null == simpleSingleton) {
			if (null == simpleSingleton) {
				Thread.sleep(5000);
				simpleSingleton = new SimpleSingleton();
			}
		}
		return simpleSingleton;
	}
}
