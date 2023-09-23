package com.example.b3sync.kotlinexs.lamdasdemo;

public class LamdaDemo {
    public static void main(String[] args) {
        //life b4 lamda
        PrintImpl printimp = new PrintImpl();
        printimp.print("page content");


        //life after lamdas
        Printable pable = (ct) -> { System.out.println(ct);};
        pable.print("my page content");

        Sayable syable = (s,n) -> {
            System.out.println(s + n);
        };
        syable.greet("hi ", "abdul");

    }
}
