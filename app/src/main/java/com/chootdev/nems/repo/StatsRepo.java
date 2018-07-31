package com.chootdev.nems.repo;

import com.chootdev.nems.database.DatabaseHelper;
import com.chootdev.nems.database.DatabaseManager;
import com.chootdev.nems.models.StatModel;

import java.sql.SQLException;
import java.util.List;

public class StatsRepo implements Crud {

    private DatabaseHelper mHelper;

    public StatsRepo() {
        this.mHelper = DatabaseManager.getInstance().getHelper();
    }

    @Override
    public int create(Object item) {
        int index = -1;

        try {
            StatModel model = (StatModel) item;
            return mHelper.getStatDao().create(model);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public int update(Object item) {
        int index = -1;

        try {
            StatModel model = (StatModel) item;
            return mHelper.getStatDao().update(model);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public int delete(Object item) {
        int index = -1;

        try {
            StatModel model = (StatModel) item;
            return mHelper.getStatDao().delete(model);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return index;
    }

    @Override
    public Object findById(int id) {
        StatModel model = null;

        try {
            model = mHelper.getStatDao().queryForId(id);
            return mHelper.getStatDao().create(model);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return model;
    }

    @Override
    public List<?> findAll() {
        List<StatModel> items = null;

        try {
            items = mHelper.getStatDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }

    public boolean truncate(Class<?> myclass) {
        boolean isDone = this.mHelper.truncateTable(myclass);
        return isDone;
    }
}
