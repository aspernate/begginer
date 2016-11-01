package com.javarush.test.level17.lesson10.home02;

/* Comparable
Реализуйте интерфейс Comparable<Beach> в классе Beach, который будет использоваться нитями.
*/

public class Beach implements Comparable<Beach>{
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    @Override
    public int compareTo(Beach o)
    {
        if((1/this.distance)>(1/o.distance))
            return 1;
        else if ((1/this.distance)<(1/o.distance))
            return -1;
        else if ((this.quality/this.distance)>(o.quality/o.distance))
            return 1;
        else if ((this.quality/this.distance)<(o.quality/o.distance))
            return -1;
        else return 0;
    }

        public static void main(String[] args) {
            Beach beach1 = new Beach("Солнечный", 100, 5);
            Beach beach2 = new Beach("Южный", 200, 10);

            System.out.println("1 vs 2: " + beach1.compareTo(beach2));
            System.out.println("1 vs 1: " + beach1.compareTo(beach1));
            System.out.println("2 vs 2: " + beach2.compareTo(beach2));
            System.out.println("2 vs 1: " + beach2.compareTo(beach1));
    }
}
