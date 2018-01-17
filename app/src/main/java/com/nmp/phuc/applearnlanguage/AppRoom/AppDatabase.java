package com.nmp.phuc.applearnlanguage.AppRoom;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by AM on 1/17/2018.
 */
@Database(entities = {TuVung.class,TuChiaSe.class,NhomChat.class,NgDung.class,LuotTroChuyen.class},version = 1)
public abstract class AppDatabase extends RoomDatabase{
    public abstract TuVungDAO getTuVungDAO();
    public abstract NgDungDAO getNgDungDAO();
    public abstract LuotTroChuyenDAO getLuotTroChuyenDAO();
    public abstract NhomChatDAO getNhomChatDAO();
    public abstract TuChiaSeDAO getTuChiaSeDAO();
}
