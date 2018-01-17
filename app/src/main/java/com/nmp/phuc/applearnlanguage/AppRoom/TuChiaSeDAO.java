package com.nmp.phuc.applearnlanguage.AppRoom;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by AM on 1/17/2018.
 */
@Dao
public interface TuChiaSeDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void themTuChiaSe(TuChiaSe... tuChiaSes);
    @Insert
    public void themMangTuChiaSe(List<TuChiaSe> tuChiaSes);
    @Update
    public void capnhatTuChiaSe(TuChiaSe... tuChiaSes);
    @Delete
    public void xoaTuChiaSe(TuChiaSe... tuChiaSes);
}
