package com.chootdev.nems;

import android.app.Application;

import com.chootdev.nems.database.DatabaseManager;

/**
 * Created by Choota.
 */

public class ProjectApplication extends Application {

    // this is project application class
    @Override
    public void onCreate() {
        super.onCreate();

        DatabaseManager.init(this);
    }
}
