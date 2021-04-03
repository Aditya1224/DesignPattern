package com.singleton.pattern;

/*
 * Cloning: Cloning is a concept to create duplicate objects. 
 * Using clone we can create copy of object. Suppose, 
 * we create clone of a singleton object, then it will create a 
 * copy that is there are two instances of a singleton class, 
 * hence the class is no more singleton.
 */
public class SingletonWithCloning {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		CloneableSingleton instance1 = CloneableSingleton.singletonObj;
		CloneableSingleton instance2 = (CloneableSingleton) instance1.clone();

		System.out.println("instance1 hashCode:- " + instance1.hashCode());
		System.out.println("instance2 hashCode:- " + instance2.hashCode());
	}

}

class TestCloneable implements Cloneable {
	int i = 10;

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

class CloneableSingleton extends TestCloneable {

	public static CloneableSingleton singletonObj = new CloneableSingleton();

	private CloneableSingleton() {
	}
	/*
	 * stopped user to create clone of singleton class. 
	 * If you don't want to throw exception you can also 
	 * return the same instance from clone method.
	 */
//	@Override
//	protected Object clone() throws CloneNotSupportedException {
//		throw new CloneNotSupportedException();
//	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return singletonObj;
	}
}
