package com.headfirst.designpattern.chepter.one;

public class RubberDuck extends Duck{

	public static void main(String[] args) {
		FlyNoWay flyNoWay = new FlyNoWay();
		Squeak squeak = new Squeak();
		RubberDuck rubberDuck = new RubberDuck();
		rubberDuck.setFlyBehavior(flyNoWay);
		rubberDuck.setQuackBehavior(squeak);
		
		rubberDuck.display();
		rubberDuck.swim();
//		rubberDuck.getFlyBehavior().fly();
//		rubberDuck.getQuackBehavior().quack();
		rubberDuck.performFly();
		rubberDuck.performQuack();
		
	}
}
