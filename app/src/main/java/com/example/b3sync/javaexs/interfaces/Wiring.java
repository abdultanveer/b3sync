package com.example.b3sync.javaexs.interfaces;

public class Wiring {
	
	public static void main(String[] args) {
		SwitchBoardListener sbl = 
				//new GeAppliances();
				new HavellsAppliances(); //wiring
		
		//user clicking the switches
		sbl.switchOne();
		sbl.switchTwo();
		sbl.switchThree();
	}

}
