package com.example.bin;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private int binId;

    @Enumerated(EnumType.ORDINAL)
    private Type type;
    
    private Timestamp time;
    
    private boolean inBin = true;

    public enum Type {
        TYPE0, TYPE1, TYPE2, TYPE3
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBinId() {
        return binId;
    }

    public void setBinId(int binId) {
        this.binId = binId;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public boolean isInBin() {
        return inBin;
    }

    public void setInBin(boolean inBin) {
        this.inBin = inBin;
    }
}
