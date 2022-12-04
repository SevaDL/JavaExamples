package com.company;

import java.util.*;
public class Voyage {
    protected int seats;
    protected float price;

    public float Totalcost()
    {
        float totalcost = seats * price;
        return totalcost;
    }

    public Voyage(int a, float c)
    {
        seats = a;
        price = c;
    }
    public Voyage()
    {
        seats = 50;
        price = 5000;
    }

    public void Init(int a, float c)
    {
        seats = a;
        price = c;
    }

    public void Read()
    {
        Scanner in = new Scanner (System.in);
        seats = in.nextInt();
        price = in.nextFloat();
    }

    public void Display()
    {
        float totalcost = Totalcost();
        System.out.println("количество  мест  в  самолете: " + seats
                + "; \nцена  билета: " + price +
                "; \nобщая  стоимость  билетов  в самолете: " + totalcost + ";");
    }

    public float Getprice()
    {
        return price;
    }
}
