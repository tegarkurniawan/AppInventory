package com.appinventory.tegar.appinventory;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by opam on 05/01/17.
 */
public class DBHelper extends  SQLiteOpenHelper{
    public static final String TABLE_NAME = "data_inventori";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "nama_barang";
    public static final String COLUMN_MERK = "merk_barang";
    public static final String COLUMN_HARGA = "harga_barang";
    private static final String db_name ="inventori.db";
    private static final int db_version=1;

    private static final String db_create = "create table "
            + TABLE_NAME + "("
            + COLUMN_ID +" integer primary key autoincrement, "
            + COLUMN_NAME+ " varchar(50) not null, "
            + COLUMN_MERK+ " varchar(50) not null, "
            + COLUMN_HARGA+ " varchar(50) not null);";

    public DBHelper(Context context) {
        super(context, db_name, null, db_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(db_create);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DBHelper.class.getName(), "Upgrading database from version " + oldVersion + " to "
                + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

}
