package com.nmp.phuc.applearnlanguage.AppRoom;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by AM on 1/17/2018.
 */
@Entity (tableName = "nguoidung",
         indices = {
            @Index(value = {"tendangnhap,matkhau"}),
            @Index(value = "matkhau",unique = true)
         }
)
public class NgDung {
    @PrimaryKey (autoGenerate = true)
    private int mangdung;
    private String tenngdung;
    private String sdt;
    private String tendangnhap;
    @ColumnInfo(name = "mat_khau")
    private String matkhau;

    public NgDung() {
    }

    public NgDung(String tenngdung, String sdt, String tendangnhap, String matkhau) {
        this.tenngdung = tenngdung;
        this.sdt = sdt;
        this.tendangnhap = tendangnhap;
        this.matkhau = matkhau;
    }
}
