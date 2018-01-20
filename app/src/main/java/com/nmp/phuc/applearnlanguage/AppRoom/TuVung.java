package com.nmp.phuc.applearnlanguage.AppRoom;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.widget.Toast;

/**
 * Created by AM on 1/17/2018.
 */
@Entity (tableName = "tuvung")
public class TuVung {
    @PrimaryKey (autoGenerate = true)
    public int matu;
    public String tumoi;
    public String nghia;
    public int chude;
    public int loai;
    public String thoigiannhap;
    public int manguoinhap;

    public TuVung () {

    }

    public TuVung(String tumoi, String nghia, int chude, int loai, String thoigiannhap, int manguoinhap) {
        this.tumoi = tumoi;
        this.nghia = nghia;
        this.chude = chude;
        this.loai = loai;
        this.thoigiannhap = thoigiannhap;
        this.manguoinhap = manguoinhap;
    }

    public void setChude(int chude) {
        if (chude>=1&&chude<=8)
            this.chude = chude;
        else
            this.chude = 1;
    }

    public void setLoai(int loai) {
        if (loai>=1&&loai<=7)
            this.loai = loai;
        else this.loai = 1;
    }

    @Override
    public String toString() {
        return tumoi;
    }
}
