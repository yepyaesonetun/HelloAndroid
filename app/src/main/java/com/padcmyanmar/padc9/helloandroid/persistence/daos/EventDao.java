package com.padcmyanmar.padc9.helloandroid.persistence.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.padcmyanmar.padc9.helloandroid.data.vos.EventVO;
import com.padcmyanmar.padc9.helloandroid.data.vos.EventsAndUserVO;
import com.padcmyanmar.padc9.helloandroid.data.vos.UserVO;

import java.util.ArrayList;
import java.util.List;

@Dao
public abstract class EventDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract long[] insertEvents(List<EventVO> events);

    @Query("SELECT DISTINCT event.*,user.* FROM event INNER JOIN user WHERE event.id = user.event_id")
    public abstract List<EventsAndUserVO> getAllEventsFromDB();

    @Query("SELECT * FROM event WHERE id = :id")
    public abstract EventVO getEventById(int id);

    public void insertEventsAndUsers(List<EventVO> events, UserDao userDao){
        List<UserVO> userList = new ArrayList<>();
        for(EventVO event: events){
            for(UserVO goingUser : event.getGoingUsers()){
                goingUser.setEventId(event.getId());
            }
            userList.addAll(event.getGoingUsers());
        }

        insertEvents(events);
        userDao.insertUsers(userList);
    }


}
