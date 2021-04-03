package com.headfirst.designpattern.chepter.one;

public abstract class Duck {
	
	private FlyBehavior flyBehavior;
	private QuackBehavior quackBehavior;
	
	public void performFly() {
		flyBehavior.fly();
	}
	public void setFlyBehavior(FlyBehavior flyBehavior) {
		this.flyBehavior = flyBehavior;
	}
	public void performQuack() {
		quackBehavior.quack();
	}
	public void setQuackBehavior(QuackBehavior quackBehavior) {
		this.quackBehavior = quackBehavior;
	}
	public void swim() {
		System.out.println("Swimming!!!!");
	}
	public void display() {
		System.out.println("DIsplay Duck!!!!");
	}
}
