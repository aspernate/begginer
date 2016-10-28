package com.javarush.test.level25.lesson05.home01;

/**
 * Created by riabov on 10.10.16.
 */
public class LoggingStateThread extends Thread{

    Thread thread;

    public LoggingStateThread(Thread thread) {
        this.thread = thread;
        setDaemon(true);
    }

    public void run() {
        State state = thread.getState();
        System.out.println(state);
        while(thread.getState() != State.TERMINATED) {
            if(state != thread.getState()) {
                System.out.println(thread.getState());
                state = thread.getState();
            }
        }
    }

}
