package com.tml.mouseDemo.core.collection;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class MyDelay implements Delayed {

    public long getDelayed() {
        return delayed;
    }

    public void setDelayed(long delayed) {
        this.delayed = delayed;
    }

    private long delayed;
    @Override
    public long getDelay(TimeUnit unit) {
        return delayed;
    }

    @Override
    public int compareTo(Delayed o) {
        return 0;
    }
}
