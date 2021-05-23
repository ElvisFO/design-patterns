package com.observer.subject;

import com.observer.observers.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Elvis Fernandes on 23/05/2021
 * @project design-patterns
 */
public abstract class Subject {
    private List<Observer> observers = new ArrayList<>();

    public void add(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers(boolean status) {
        for(Observer o: observers) {
            o.update(status);
        }
    }
}