package com.company;

public class Eyleyici extends Sicaklik implements IEyleyici {

    private  static  boolean acikMi=false;
    public static  String renk ;
    @Override
    public boolean sogutucuyuAc() {
        if(acikMi==false){
            System.out.println("Soğutucu açılıyor !");
            renk="Mavi";
            acikMi=true;
        } else{
            System.out.println("Soğutucu zaten açık !!!");
        }

        return acikMi;
    }

    @Override
    public boolean sogutucuKapat() {
        if(acikMi){
            System.out.println("Soğutucu kapanıyor ! ");
            acikMi=false;
        }
        else{
            System.out.println("Soğutucu zaten kapalı !");
        }

        return acikMi;
    }

    @Override
    public int sicaklikAyarla(int sicaklik) {

        if(sicaklik <-30 || sicaklik >30){
            System.out.println("Lütfen optimum sıcaklık değerleri girin.");
            System.out.println("Ana menüye yönlendiriliyorsunuz...");
        }
            else { this.sicaklik=sicaklik;
            sistemlereMesajGonder(sicaklik);

            }
        return sicaklik;
    }

    @Override
    public boolean sogutucuAcikMi() {
        return acikMi;
    }

    @Override
    public void sistemlereMesajGonder(int sicaklik) {
        Kullanıcı1 s1 = new Kullanıcı1();
        Kullanıcı2 s2 = new Kullanıcı2();
        Publisher p = new Publisher();

        p.sicaklikAl(sicaklik);
        p.attach(s1);
        p.attach(s2);

       Sicaklikİslemleri sicaklikİslemleri = new Sicaklikİslemleri(sicaklik,p);
       sicaklikİslemleri.mesaj(sicaklik);
    }



}
