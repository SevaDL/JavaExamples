package com.company;

public class Voyage_new extends Voyage {
    private int coolseats;
    private float coolprice;
    public void Init(int s, float p,  int cs)
    {
        super.Init(s, p);
        coolprice = p*2;
        coolseats = cs;
    }
    public void Display()
    {
        super.Display();
        System.out.println("количество мест первого класса: " + coolseats);
        System.out.println("цена мест первого класса: " + coolprice);
        System.out.println("Цена билетов с учетом мест первого класса: " + Totalcost2());
    }
    public float Totalcost2()
    {
        float totalcost;

        totalcost = coolprice* coolseats + price * seats;
        return totalcost;
    }
    public Voyage_new(int s, float p,  int cs)
    {
        super( s,  p);
        coolprice = p*2;
        coolseats = cs;
    }
    public Voyage_new()
    {
        super();
        coolprice = 10000;
        coolseats = 5;
    }
    public float Coolprice()
    {
        return coolprice;
    }

    public int Coolseats()
    {
        return coolseats;
    }

}
