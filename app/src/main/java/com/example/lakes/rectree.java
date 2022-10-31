package com.example.lakes;

import androidx.appcompat.app.AppCompatActivity;

public class rectree extends AppCompatActivity {
    private final String name;

    private final String info;
    public rectree(String name,String info)
    {
        this.name=name;

        this.info=info;
    }

    public String getName() {
        return name;
    }

    public String getInfo() {
        return info;
    }
}
