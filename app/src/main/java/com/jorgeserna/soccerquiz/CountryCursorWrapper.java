package com.jorgeserna.soccerquiz;

import android.database.Cursor;
import android.database.CursorWrapper;
import com.jorgeserna.soccerquiz.database.DatabaseHandler;

/**
 * Created by jorgeserna on 2018-02-07.
 */

public class CountryCursorWrapper extends CursorWrapper {
    public CountryCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Country getCountry() {
        String countryname = getString(getColumnIndex(DatabaseHandler.CountryTable.Cols.COUNTRYNAME));
        String filename = getString(getColumnIndex(DatabaseHandler.CountryTable.Cols.FILENAME));

        Country country = new Country(countryname, filename);

        return country;
    }
}
