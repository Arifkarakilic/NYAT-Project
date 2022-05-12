package com.company;

public class Kullanıcı1 implements  IObserver{
    @Override
    public void update(String mesaj) {

        System.out.println(mesaj+" ---> Soğutucunun sıcaklığı güncellendi ");
    }
}
