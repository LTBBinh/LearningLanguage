package com.nmp.phuc.applearnlanguage.AppRoom;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by AM on 1/17/2018.
 */
@Entity (tableName = "nhomchat")
public class NhomChat {
    @PrimaryKey (autoGenerate = true)
    private int manhomchat;
    private String tgianbdau;

    public NhomChat() {
    }

    public NhomChat(String tgianbdau) {
        this.tgianbdau = tgianbdau;
    }
}
