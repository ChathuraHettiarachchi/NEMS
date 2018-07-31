package com.chootdev.nems.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "StatModel")
public class StatModel {


    @DatabaseField(columnName = "id", generatedId = true)
    public int id;

    @DatabaseField(columnName = "cellType")
    public int cellType;

    @DatabaseField(columnName = "itemType")
    public String itemType;

    @DatabaseField(columnName = "name")
    public String name;

    @DatabaseField(columnName = "current")
    public String current;

    @DatabaseField(columnName = "total")
    public String total;

    public StatModel() {
    }

    public StatModel(int type, String itemType, String name, String current, String total) {
        this.cellType = type;
        this.itemType = itemType;
        this.name = name;
        this.current = current;
        this.total = total;
    }
}
