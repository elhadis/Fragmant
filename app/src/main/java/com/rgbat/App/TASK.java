package com.rgbat.App;

import java.io.Serializable;

public class TASK implements Serializable {
    private String name;

    public TASK(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
