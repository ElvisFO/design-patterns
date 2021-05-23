package com.observer.observers;

/**
 * @author Elvis Fernandes on 23/05/2021
 * @project design-patterns
 */
public class Wife implements Observer {

    public void partyTime() {
        System.out.println("Let´s Party! :D");
    }

    @Override
    public void update(boolean status) {
        if(status) {
            partyTime();
        } else {
            System.out.println("Hold!");
        }
    }
}
