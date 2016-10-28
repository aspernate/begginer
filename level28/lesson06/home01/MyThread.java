package com.javarush.test.level28.lesson06.home01;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by riabov on 27.10.16.
 */
public class MyThread extends Thread {

    static AtomicInteger i = new AtomicInteger(1);

    public void priority() {
        this.setPriority(i.get());
        i.incrementAndGet();
        if(i.get() == 11)
            i.set(1);
    }

    public MyThread() {
        priority();
    }

    public MyThread(Runnable target) {
        super(target);
        priority();
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        priority();
    }

    public MyThread(String name) {
        super(name);
        priority();
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        priority();
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        priority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        priority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        priority();
    }
}
