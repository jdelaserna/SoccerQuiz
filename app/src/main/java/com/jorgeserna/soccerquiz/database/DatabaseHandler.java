package com.jorgeserna.soccerquiz.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.jorgeserna.soccerquiz.CountryCursorWrapper;

/**
 * Created by jorgeserna on 2018-02-02.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "soccerQuiz.db";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    public static final class CountryTable {

        public static final String NAME = "countries";

        public static final class Cols {
            public static final String LEVEL = "level";
            public static final String COUNTRYNAME = "countryname";
            public static final String FILENAME = "filename";
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + CountryTable.NAME + "("
                + "_id integer primary key autoincrement, "
                + CountryTable.Cols.LEVEL + ", "
                + CountryTable.Cols.COUNTRYNAME + ", "
                + CountryTable.Cols.FILENAME
                + ")"
        );

        db.execSQL("insert into " + CountryTable.NAME + "(LEVEL, COUNTRYNAME, FILENAME ) values ('1', 'Argentina', 'R.drawable.argentina.png')");
        db.execSQL("insert into " + CountryTable.NAME + "(LEVEL, COUNTRYNAME, FILENAME ) values ('1', 'Brazil', 'R.drawable.brazil.png')");
        db.execSQL("insert into " + CountryTable.NAME + "(LEVEL, COUNTRYNAME, FILENAME ) values ('1', 'France', 'R.drawable.france.png')");
        db.execSQL("insert into " + CountryTable.NAME + "(LEVEL, COUNTRYNAME, FILENAME ) values ('1', 'Spain', 'R.drawable.spain.png')");
        db.execSQL("insert into " + CountryTable.NAME + "(LEVEL, COUNTRYNAME, FILENAME ) values ('2', 'Belgium', 'R.drawable.belgium.png')");
        db.execSQL("insert into " + CountryTable.NAME + "(LEVEL, COUNTRYNAME, FILENAME ) values ('2', 'Croatia', 'R.drawable.croatia.png')");
        db.execSQL("insert into " + CountryTable.NAME + "(LEVEL, COUNTRYNAME, FILENAME ) values ('2', 'England', 'R.drawable.england.png')");
        db.execSQL("insert into " + CountryTable.NAME + "(LEVEL, COUNTRYNAME, FILENAME ) values ('2', 'Peru', 'R.drawable.peru.png')");
        db.execSQL("insert into " + CountryTable.NAME + "(LEVEL, COUNTRYNAME, FILENAME ) values ('3', 'Liechtenstein', 'R.drawable.liechtenstein.png')");
        db.execSQL("insert into " + CountryTable.NAME + "(LEVEL, COUNTRYNAME, FILENAME ) values ('3', 'Macedonia', 'R.drawable.macedonia.png')");
        db.execSQL("insert into " + CountryTable.NAME + "(LEVEL, COUNTRYNAME, FILENAME ) values ('3', 'Qatar', 'R.drawable.qatar.png')");
        db.execSQL("insert into " + CountryTable.NAME + "(LEVEL, COUNTRYNAME, FILENAME ) values ('3', 'Vietnam', 'R.drawable.vietnam.png')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + DATABASE_NAME);
        onCreate(db);
    }

    private CountryCursorWrapper queryCountries() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(CountryTable.NAME, null, null, new String[]{"level = ?"}, null, null, null);

        return new CountryCursorWrapper(cursor);
    }

}
