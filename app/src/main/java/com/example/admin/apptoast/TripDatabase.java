package com.example.admin.apptoast;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 01-Feb-18.
 */

public class TripDatabase extends SQLiteOpenHelper {
    private static final String TABLE_PERSON="table_trip";
    private static final String KEY_ID ="id";
    private static final String KEY_FROM_PLACE="from";
    private static final String KEY_TO_PLACE ="to";
    private static final String FROM_DATE ="password";
    private static final String TO_DATE ="email";
    private static final String NUM_BUS ="role";
    private static final String TRIPS_TYPE ="contact";


    ///REport
    private static final String TABLE_REPORT="table_reports";
    private static final String KEY_RPORTID ="id";
    private static final String KEY_REF ="ref";
    private static final String KEY_SUBJECT="subject";
    private static final String KEY_MARKS ="marks";
    private static final String KEY_TERM ="term";
    private static final String KEY_COMMENT ="comment";
    private static final String KEY_TOTAL_MARK ="totalmarks";




    private static final String DATABASE_NAME="trips.db";
    private static final int DATABASE_VERSION=1;

    private final String CREATE_TABLE_TRIP ="Create table " +TABLE_PERSON + " ( "
            + KEY_ID + "  integer primary key autoincrement  , "
            + KEY_TO_PLACE + " text not null , "
            + FROM_DATE + " text not null , "
            + TO_DATE + " text not null , "
            + NUM_BUS + " text not null , "
            + TRIPS_TYPE + " text not null,"
            +KEY_FROM_PLACE+ " text not null);";


    public TripDatabase(Context context) {
        super(context,DATABASE_NAME, null, DATABASE_VERSION);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE_TRIP);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(String.format("DROP TABLE IF TABLE EXIST%s", TABLE_PERSON));
        db.execSQL(CREATE_TABLE_TRIP);

    }
    public int addContact(TripPojo tripPojo)
    {
        int id =0;

        SQLiteDatabase db = this.getWritableDatabase();


        ContentValues cv = new ContentValues();

        cv.put(KEY_TO_PLACE, tripPojo.getPlaceTo());
        cv.put(FROM_DATE, tripPojo.getFromDate());
        cv.put(TO_DATE, tripPojo.getToDate());
        cv.put(NUM_BUS, tripPojo.getNumBuS());
        cv.put(TRIPS_TYPE, tripPojo.getTypeTrips());
        cv.put(KEY_FROM_PLACE, tripPojo.getPlaceFrom());


        id =(int)db.insert(TABLE_PERSON, null,cv);

        return id;

    }


    public List<TripPojo> getAllSubject()
    {
        List<TripPojo> reports = new ArrayList<TripPojo>();
        SQLiteDatabase db =this.getWritableDatabase();
        String selectQuery ="SELECT * FROM " + TABLE_REPORT;

        Cursor cursor =db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst())
        {
            do
            {
                TripPojo report = new TripPojo();
                report.setId(cursor.getInt(cursor.getColumnIndex(KEY_ID)));
                report.setFromDate(cursor.getString(cursor.getColumnIndex(FROM_DATE)));
                report.setNumBuS(cursor.getString(cursor.getColumnIndex(NUM_BUS)));
                report.setPlaceTo(cursor.getString(cursor.getColumnIndex(KEY_TO_PLACE)));
                report.setToDate(cursor.getString(cursor.getColumnIndex(TO_DATE)));
                report.setPlaceFrom(cursor.getString(cursor.getColumnIndex(KEY_FROM_PLACE)));
                report.setTypeTrips(cursor.getString(cursor.getColumnIndex(TRIPS_TYPE)));






                reports.add(report);

            }while(cursor.moveToNext());
        }
        return reports;

    }


    public List<TripPojo> getAllSudentSubject(int compID)
    {
        List<TripPojo> reports = new ArrayList<TripPojo>();
        SQLiteDatabase db =this.getWritableDatabase();
        String selectQuery ="SELECT * FROM " + TABLE_REPORT +" WHERE "+KEY_REF+"=?";

        String select[] = {String.valueOf(compID)};
        Cursor cursor =db.rawQuery(selectQuery, select);

        if(cursor.moveToFirst())
        {
            do
            {
                TripPojo report = new TripPojo();
                report.setId(cursor.getInt(cursor.getColumnIndex(KEY_ID)));
                report.setFromDate(cursor.getString(cursor.getColumnIndex(FROM_DATE)));
                report.setNumBuS(cursor.getString(cursor.getColumnIndex(NUM_BUS)));
                report.setPlaceTo(cursor.getString(cursor.getColumnIndex(KEY_TO_PLACE)));
                report.setToDate(cursor.getString(cursor.getColumnIndex(TO_DATE)));
                report.setPlaceFrom(cursor.getString(cursor.getColumnIndex(KEY_FROM_PLACE)));
                report.setTypeTrips(cursor.getString(cursor.getColumnIndex(TRIPS_TYPE)));







                reports.add(report);

            }while(cursor.moveToNext());
        }
        return reports;

    }

    public void deletSubjectAll(long id)
    {
        String args[] = {String.valueOf(id)};

        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_REPORT, KEY_REF + " = ? ", args);
        db.close();

    }


}
