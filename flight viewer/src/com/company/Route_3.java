package com.company;

public class Route_3 implements  Route{

    private int ticketssold1;
    private int ticketssold2;
    private int ticketssoldSSS2;
    private Voyage v1;
    private Voyage_new v2;

    public Route_3(int s1, int a1, float c1, int s2, int s3, int a2, float c2, int sa2)
    {
        v1 = new Voyage(a1, c1);
        v2 = new Voyage_new(a2, c2, sa2);
        ticketssold1 = s1;
        ticketssold2 = s2;
        ticketssoldSSS2 = s3;
    }
    public float Income()
    {
        return (v1.Getprice() * ticketssold1 + v2.Getprice() * ticketssold2 + v2.Coolprice() * ticketssoldSSS2);
    }
    public void Display()
    {
        System.out.println("Рейс 1:\n" + "Продано обычных мест: " + ticketssold1 );
        v1.Display();
        System.out.println("Рейс 2:\n" + "Продано обычных мест: " + ticketssold2 + "\nПродано мест первого класса: " + ticketssoldSSS2);
        v2.Display();
    }

}
