package com.observer.subject;

/**
 * @author Elvis Fernandes on 23/05/2021
 * @project design-patterns
 */
public class Doorman extends Subject {

    private boolean status = false;

    public boolean getStatus() {
        return this.status;
    }

    public void setStatus(boolean newStatus) {
        if(status !=  newStatus) {
            this.status = newStatus;
            notifyObservers(newStatus);
        }
    }
}
