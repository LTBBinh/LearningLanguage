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
public interface TuVungDAO {
    @Insert (onConflict = OnConflictStrategy.REPLACE)
    public void themTu(TuVung... tuVungs);
    @Insert
    public void themMangTu(List<TuVung> tuVungs);
    @Update
    public void capnhatTu(TuVung... tuVungs);
    @Delete
    public void xoaTu(TuVung... tuVungs);

    @Query("SELECT * FROM tuvung")
    public TuVung[] layTatcaTuvung();
    @Query("SELECT * FROM tuvung WHERE tumoi LIKE :tu")
    public TuVung layTu(String tu);
    @Query("SELECT * FROM tuvung WHERE thoigiannhap LIKE :tgian")
    public TuVung[] layTutheoTgian(String tgian);

}
