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
public interface NhomChatDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void themNhomChat(NhomChat... nhomChats);
    @Insert
    public void themMangNhomChat(List<NhomChat> nhomChats);
    @Update
    public void capnhatNhomChat(NhomChat... nhomChats);
    @Delete
    public void xoaNhomChat(NhomChat... nhomChats);
}
