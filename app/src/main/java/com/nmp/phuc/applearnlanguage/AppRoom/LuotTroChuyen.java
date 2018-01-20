package com.nmp.phuc.applearnlanguage.AppRoom;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by AM on 1/17/2018.
 */
@Entity(tableName = "luottrochuyen",
        foreignKeys = {
        @ForeignKey(entity = NhomChat.class,parentColumns = "manhomchat",childColumns = "nhomchat_ma"),
        @ForeignKey(entity = NgDung.class,parentColumns = "mangdung",childColumns = "ngdung_ma")
})

public class LuotTroChuyen {
    @PrimaryKey (autoGenerate = true)
    public int maluottrochuyen;
    @ColumnInfo(name = "nhomchat_ma")
    public int manhomchat;
    @ColumnInfo(name = "ngdung_ma")
    public int manguoidung;
    public String thoigian;
    public String tinnhan;

    public LuotTroChuyen() {
    }

    public LuotTroChuyen(int manhomchat, int manguoidung, String thoigian, String tinnhan) {
        this.manhomchat = manhomchat;
        this.manguoidung = manguoidung;
        this.thoigian = thoigian;
        this.tinnhan = tinnhan;
    }
}
