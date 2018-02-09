package com.jorgeserna.soccerquiz;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.jorgeserna.soccerquiz.database.DatabaseHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jorgeserna on 2018-02-07.
 */

public class CountryLab {

    private SQLiteDatabase mDatabase;
    private Context mContext;

    public CountryLab(Context context) {
        mContext = context.getApplicationContext();
        mDatabase = new DatabaseHandler(mContext).getWritableDatabase();
    }

    private CountryCursorWrapper queryCountries(String whereClause, String[] whereArgs) {
        Cursor cursor = mDatabase.query(DatabaseHandler.CountryTable.NAME, null, whereClause, whereArgs, null, null, null);

        return new CountryCursorWrapper(cursor);
    }

    public List<Country> getCountries(int level) {

        List<Country> countries = new ArrayList<>();
        CountryCursorWrapper cursor = queryCountries(DatabaseHandler.CountryTable.Cols.LEVEL + " = ? ", new String[]{String.valueOf(level)});

        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                countries.add(cursor.getCountry());
                cursor.moveToNext();
            }
        } finally {
            cursor.close();
        }

        return countries;
    }

}
