package com.cybertek.utilities;

public class BrowserUtils {

    //create method name: sleep
    // converting milliseconds to seconds
    //handle checked exception

    public void sleep (int second){
            second *= 1000;
            try {
                Thread.sleep(second);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

