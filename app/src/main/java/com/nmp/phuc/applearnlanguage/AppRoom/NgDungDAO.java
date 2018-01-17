package com.nmp.phuc.applearnlanguage.AppRoom;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by AM on 1/17/2018.
 */
@Dao
public interface NgDungDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void themNgDung(NgDung... ngDungs);
    @Insert
    public void themMangNgDung(List<NgDung> ngDungs);
    @Update
    public void capnhatNgDung(NgDung... ngDungs);
    @Delete
    public void xoaNgDung(NgDung... ngDungs);

    @Query("SELECT * FROM nguoidung")
    public NgDung[] layTatcaNgDung();
    @Query("SELECT * FROM tuvung WHERE tendangnhap LIKE :tendangnhap AND mat_khau LIKE :matkhau"
    )
    public NgDung layNgDung(String tendangnhap,String matkhau);

}
