package com.company;

public class VeritabaniIslemleri implements  IKullaniciDogrula{
    private static IKullaniciDogrula veritabani;

    public static synchronized IKullaniciDogrula getVeritabani(){
       if(veritabani == null){
           veritabani = new PostgreSQLKullaniciDogrulama();
       }
       return veritabani;

    }


    @Override
    public boolean kullaniciDogrula(String kullaniciAd, String sifre) {

        System.out.println("Veritabanına bağlanılıyor...");
        return  veritabani.kullaniciDogrula(kullaniciAd,sifre);
    }
}
