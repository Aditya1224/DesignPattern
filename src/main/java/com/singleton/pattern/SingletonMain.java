package com.singleton.pattern;

public class SingletonMain {
	volatile int count = 0;

	public static void main(String[] args) throws Exception {
		SingletonMain main = new SingletonMain();
		// Classic Implementation
//		SimpleSingleton simpleSingleton1 = SimpleSingleton.getInstance();
//		System.out.println("Classic Implementation 1 => " + simpleSingleton1.hashCode());
//
//		SimpleSingleton simpleSingleton2 = SimpleSingleton.getInstance();
//		System.out.println("Classic Implementation 2 => " + simpleSingleton2.hashCode());

		// Synchronized Singleton -> SimpleSingleton is not thread safe.

//		while (main.count < 2) {
//			new Thread(() -> {
//				SimpleSingleton simpleSingleton3;
//				try {
//					simpleSingleton3 = SimpleSingleton.getInstance();
//
//					System.out.println("Synchronized with Classic Implementation 3 => " + simpleSingleton3.hashCode());
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}).start();
//			new Thread(() -> {
//				SimpleSingleton simpleSingleton4;
//				try {
//					simpleSingleton4 = SimpleSingleton.getInstance();
//
//					System.out.println("Synchronized with Classic Implementation 4 => " + simpleSingleton4.hashCode());
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}).start();
//			main.count++;
//		}
		
		//Synchronized get singleton instance => SynchronizedSingletonClass
		while (main.count < 2) {
			new Thread(() -> {
				SynchronizedSingletonClass synchronizedSingleton1;
				try {
					synchronizedSingleton1 = SynchronizedSingletonClass.getInstance();

					System.out.println("Synchronized get singleton instance 1 => " 
										+ synchronizedSingleton1.hashCode());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}).start();
			new Thread(() -> {
				SynchronizedSingletonClass synchronizedSingleton2;
				try {
					synchronizedSingleton2 = SynchronizedSingletonClass.getInstance();

					System.out.println("Synchronized get singleton instance 2 => "
										+ synchronizedSingleton2.hashCode());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}).start();
			main.count++;
		}
	}

}
