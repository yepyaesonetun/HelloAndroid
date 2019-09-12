package com.padcmyanmar.padc9.helloandroid.persistence;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import com.padcmyanmar.padc9.helloandroid.data.vos.EventVO;
import com.padcmyanmar.padc9.helloandroid.data.vos.UserVO;
import com.padcmyanmar.padc9.helloandroid.persistence.daos.EventDao;
import com.padcmyanmar.padc9.helloandroid.persistence.daos.UserDao;
import com.padcmyanmar.padc9.helloandroid.persistence.typeconverters.EventRequirementTypeConverter;
import com.padcmyanmar.padc9.helloandroid.utils.EventsConstants;

@Database(entities = {EventVO.class, UserVO.class}, version = 15,exportSchema = false)
public abstract class EventsDatabase extends RoomDatabase {

    public abstract EventDao eventDao();

    public abstract UserDao userDao();

    private static EventsDatabase objInstance;

    public static EventsDatabase getObjInstance(Context context){
        if(objInstance == null){
            objInstance = Room.databaseBuilder(context, EventsDatabase.class, EventsConstants.EVENT_DB)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return objInstance;
    }

    public boolean areEventsExistInDB(){
        return !eventDao().getAllEventsFromDB().isEmpty();
    }
}
