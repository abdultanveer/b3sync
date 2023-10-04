package com.example.b3sync.javaexs.interfaces;

public class HavellsAppliances implements SwitchBoardListener{

	@Override
	public void switchOne() {
		System.out.println("havells ac is on");
	}

	@Override
	public void switchTwo() {
		System.out.println("havells light is on");
		
	}

	@Override
	public void switchThree() {
		System.out.println("havells fan is on");
		
	}

}
