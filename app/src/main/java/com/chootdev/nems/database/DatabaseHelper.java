package com.chootdev.nems.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.chootdev.nems.models.StatModel;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by Choota.
 */

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {


    // name of the database file for your application -- change to something appropriate for your app
    private static final String DATABASE_NAME = "Sample.db";

    // any time you make changes to your database objects, you may have to increase the database version
    private static final int DATABASE_VERSION = 1;

    private Dao<StatModel, Integer> statDao = null;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, StatModel.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, StatModel.class, true);

            onCreate(db, connectionSource);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Dao<StatModel, Integer> getStatDao() {
        if (null == statDao) {
            try {
                statDao = getDao(StatModel.class);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return statDao;
    }

    public boolean truncateTable(Class<?> object) {
        boolean isDone = false;
        try {
            int i = TableUtils.dropTable(getConnectionSource(), object, true);
            i = TableUtils.createTable(getConnectionSource(), object);

            if (i > 0) {
                isDone = true;
            }
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        return isDone;
    }
}
