package org.example.SSG_from_HyunJik;

import java.util.Scanner;

public class Service {
    private final Dao dao;
    private Scanner sc;
    public Service(Dao dao,Scanner sc){
        this.dao = dao;
        this.sc = sc;
    }
}
