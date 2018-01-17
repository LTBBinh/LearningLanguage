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
public interface LuotTroChuyenDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void themLuotTroChuyen(LuotTroChuyen... luotTroChuyens);
    @Insert
    public void themMangLuotTroChuyen(List<LuotTroChuyen> luotTroChuyens);
    @Update
    public void capnhatLuotTroChuyen(LuotTroChuyen... luotTroChuyens);
    @Delete
    public void xoaLuotTroChuyen(LuotTroChuyen... luotTroChuyens);
}
