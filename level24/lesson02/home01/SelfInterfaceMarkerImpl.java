package com.javarush.test.level24.lesson02.home01;

/**
 * Created by riabov on 06.10.16.
 */
public class SelfInterfaceMarkerImpl implements SelfInterfaceMarker{
    public SelfInterfaceMarkerImpl() {
    }

    public void printHello() {
        System.out.println("hELLO yOBA");
    }

    public boolean itsOk(int x) {
        return (x > 5)? true : false;
    }
}
