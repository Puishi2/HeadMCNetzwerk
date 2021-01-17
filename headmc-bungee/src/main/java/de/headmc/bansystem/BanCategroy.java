package de.headmc.bansystem;

import de.headmc.bungee.Proxy;

import java.util.Date;

public class BanCategroy {

    private static int nextId = 1;
    private String name;
    private long duration = -1;
    private final int id;

    public BanCategroy (String name, long duration){
      this(name);
        this.duration = duration;
    }
    public BanCategroy(String name){
        this.name = name;
        id = nextId;
        nextId++;
       Proxy.banCategroy.put(name, this);
       this.duration = -1;
    }

    public long getDuration() {
        return duration;
    }



    public void setDuration(long duration) {
        if(duration != -1)
        this.duration = duration * 24 *60* 60* 1000;
        else
            this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }
    @Override
    public String toString(){
        return name + ";" + id + ";" + duration;
    }
}
