package com.padcmyanmar.padc9.helloandroid.persistence.typeconverters;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.padcmyanmar.padc9.helloandroid.data.vos.UserVO;

import java.lang.reflect.Type;
import java.util.List;

public class UserListTypeConverter {
    @TypeConverter
    public static String userListToJson(List<UserVO> userList){
        return new Gson().toJson(userList);
    }

    @TypeConverter
    public static List<UserVO> jsonToUserList(String userListJson){
        Type userListType = new TypeToken<List<UserVO>>(){}.getType();
        return new Gson().fromJson(userListJson, userListType);
    }
}
