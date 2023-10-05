package com.example.b3sync.javaexs.callbacks;

public class Chirag {
	
	void chiragAdd(int a, int b, MobilePhone callBack) {
		try {
			Thread.sleep(3000);
			callBack.sum(a+b);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
