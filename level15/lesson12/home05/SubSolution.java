package com.javarush.test.level15.lesson12.home05;

/**
 * Created by Tony Loner on 27.05.2016.
 */
public class SubSolution extends Solution
{
    SubSolution() {
    }

    SubSolution(short a)
    {
        super(a);
    }

    SubSolution(int a)
    {
        super(a);
    }

    private SubSolution(double a){}
    private SubSolution(long a){}
    private SubSolution(float a){}

    public SubSolution(String a)
    {
        super(a);
    }

    public SubSolution(char a)
    {
        super(a);
    }

    public SubSolution(Integer a)
    {
        super(a);
    }

    protected SubSolution(int a, String b)
    {
        super(a, b);
    }

    protected SubSolution(short a, String b)
    {
        super(a, b);
    }

    protected SubSolution(byte a, String b)
    {
        super(a, b);
    }
}
