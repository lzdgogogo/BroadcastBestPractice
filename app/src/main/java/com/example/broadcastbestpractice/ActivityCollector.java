package com.example.broadcastbestpractice;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 刘子恒 on 2017/9/26.
 */

public class ActivityCollector {

    public static List<Activity> activityList=new ArrayList<>();

    public static void addActivity(Activity activity){
        activityList.add(activity);
    }

    public static void removeActivity(Activity activity){
        activityList.remove(activity);
    }

    public static void finishAll(){
        for(Activity activity:activityList){
            if(!activity.isFinishing()){
                activity.isFinishing();
            }
        }
    }
}