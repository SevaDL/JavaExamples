package com.company;

public class Route_1 implements  Route{

    private int ticketssold1;
    private int ticketssold2;
    private int ticketssoldSSS2;
    private Voyage v1;
    private Voyage v2;



    public Route_1(int s1, int a1, float c1, int s2, int a2, float c2)
    {
        v1 = new Voyage(a1, c1);
        v2 = new Voyage(a2, c2);
        ticketssold1 = s1;
        ticketssold2 = s2;

    }
    public float Income()
    {
        return (v1.Getprice() * ticketssold1 + v2.Getprice() * ticketssold2);
    }
    public void Display()
    {
        System.out.println("Рейс 1:\n" + "Продано обычных мест: " + ticketssold1 );
        v1.Display();
        System.out.println("Рейс 2:\n" + "Продано обычных мест: " + ticketssold2 );
        v2.Display();
    }

}
