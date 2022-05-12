package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;

public class Publisher implements  ISubject{


    private int sicaklik;

    IAgAraYuzu agAraYuzu;
    private List<IObserver> subcribers = new ArrayList<>();


    @Override
    public void attach(IObserver subcriber) {

      subcribers.add(subcriber);

    }


    @Override
    public void notify(String mesaj) {

        for(IObserver subcriver : subcribers  ){
            subcriver.update(mesaj);
        }
    }

    private Connection baglan(){

        Connection conn=null;

        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbNesneAnaliz",
                    "postgres", "root");
            if (conn != null){
            }
            else
                System.out.println("Bağlantı girişimi başarısız!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }


    public void sicaklikAl(int sicaklik){
        this.sicaklik=sicaklik;
    }

    public void kritikSicaklikKontrol(){
        if(this.sicaklik <-50 || this.sicaklik >50){
            System.out.println("Cihazınız kabul edilebilir sıcaklık değerleri dışında  !! Cihaz kapanıyor....");
            agAraYuzu.sogutucuKapat(3);
        }
    }


}
