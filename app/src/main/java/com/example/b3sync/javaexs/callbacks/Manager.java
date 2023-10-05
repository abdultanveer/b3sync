package com.example.b3sync.javaexs.callbacks;

public class Manager {
	
	public static void main(String[] args) {
		System.out.println("asking chirag to add 2 nos");
		Chirag chirag = new Chirag();
		Abdul abdul = new Abdul();
		chirag.chiragAdd(10, 20, abdul);
	}

}
