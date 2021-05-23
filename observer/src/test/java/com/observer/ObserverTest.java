package com.observer;

import com.observer.observers.Friend;
import com.observer.observers.Wife;
import com.observer.subject.Doorman;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Elvis Fernandes on 23/05/2021
 * @project design-patterns
 */
public class ObserverTest {

    @Test
    public void observers() {
        Doorman doorman = new Doorman();
        doorman.add(new Wife());
        doorman.add(new Friend());

        System.out.println("Husband is comming");
        doorman.setStatus(true);
        Assert.assertTrue(doorman.getStatus());
    }
}
