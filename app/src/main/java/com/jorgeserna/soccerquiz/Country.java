package com.jorgeserna.soccerquiz;

/**
 * Created by jorgeserna on 2018-02-02.
 */

public class Country {

    private String mCountry;
    private String mFilename;

    public Country(String countryname, String filename) {
        mCountry = countryname;
        mFilename = filename;
    }

    public String getCountry() {
        return mCountry;
    }

    public void setCountry(String country) {
        mCountry = country;
    }

    public String getFilename() {
        return mFilename;
    }

    public void setFilename(String filename) {
        mFilename = filename;
    }

}
