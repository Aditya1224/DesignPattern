package com.singleton.pattern;

public class SynchronizedSingletonClass {

//	private static SynchronizedSingletonClass synchronizedSingleton;
	/*
	 * declared the obj volatile which ensures that multiple threads offer the obj
	 * variable correctly when it is being initialized to Singleton instance.
	 * Line #27, #36(obj read from main memory not from cache)
	 */
	private static volatile SynchronizedSingletonClass synchronizedSingleton;

	private SynchronizedSingletonClass() {
	}

//	public static SynchronizedSingletonClass getInstance() throws InterruptedException {
//		synchronized (SynchronizedSingletonClass.class) {
//			if (null == synchronizedSingleton) {
//				Thread.sleep(1000);
//				synchronizedSingleton = new SynchronizedSingletonClass();
//			}
//		}
//		return synchronizedSingleton;
//	}

//	Double Checked Locking
	public static SynchronizedSingletonClass getInstance() throws InterruptedException {
		if (null == synchronizedSingleton) {
			synchronized (SynchronizedSingletonClass.class) {
				if (null == synchronizedSingleton) {
					Thread.sleep(1000);
					synchronizedSingleton = new SynchronizedSingletonClass();
				}
			}
		}
		return synchronizedSingleton;
	}
}
