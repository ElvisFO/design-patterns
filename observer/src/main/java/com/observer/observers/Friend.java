package com.observer.observers;

/**
 * @author Elvis Fernandes on 23/05/2021
 * @project design-patterns
 */
public class Friend implements Observer {

    public void sendGift() {
        System.out.println("Look, I bought your favorite beer!");
    }

    @Override
    public void update(boolean status) {
        if(status) {
            sendGift();
        } else {
            System.out.println("Sleep...");
        }
    }
}
