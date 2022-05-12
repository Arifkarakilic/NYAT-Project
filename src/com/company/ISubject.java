package com.company;

public interface ISubject {

     void attach(IObserver o);

     void notify(String m);
}
