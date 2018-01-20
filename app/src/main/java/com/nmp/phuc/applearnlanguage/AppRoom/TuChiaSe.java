package com.nmp.phuc.applearnlanguage.AppRoom;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by AM on 1/17/2018.
 */
@Entity(tableName = "tuchiase",
        foreignKeys = {
        @ForeignKey(entity = TuVung.class,parentColumns = "matu",childColumns = "shared_matu"),
        @ForeignKey(entity = NgDung.class,parentColumns = "mangdung",childColumns = "mangshare"),
        @ForeignKey(entity = NhomChat.class,parentColumns = "manhomchat",childColumns = "manhom")
                      })

public class TuChiaSe {
    @PrimaryKey
    @ColumnInfo(name = "shared_matu")
    public int matu;
    public int mangshare;
    public int manhom;
    public String tgianshare;

    public TuChiaSe() {
    }

    public TuChiaSe(int matu,int mangshare, int manhom, String tgianshare) {
        this.matu = matu;
        this.mangshare = mangshare;
        this.manhom = manhom;
        this.tgianshare = tgianshare;
    }
}
