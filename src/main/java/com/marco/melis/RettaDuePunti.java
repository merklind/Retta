package com.marco.melis;

public class RettaDuePunti extends Retta{

    public RettaDuePunti(Punto p1, Punto p2) {
        this.a = p2.getY()-p1.getY();
        this.b = -(p2.getX()-p1.getX());
        this.c = p1.getY()*(p2.getX()-p1.getX()) - p1.getX()*(p2.getY()-p1.getY());
    }
    
}
