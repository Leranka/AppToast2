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
    private static final String TABLE_TRIP="table_trip";
    private static final String KEY_ID ="id";
    private static final String KEY_FROM_PLACE="yyyy";
    private static final String KEY_TO_PLACE ="o";
    private static final String FROM_DATE ="date";
    private static final String TO_DATE ="da";
    private static final String NUM_BUS ="role";
    private static final String TRIPS_TYPE ="contact";
    private static final String KEY_PRICE="PRICE";

    //ticket
    private static final String TABLE_TICKET="table_trip";
    private static final String KEY_IDS ="id";
    private static final String KEY_FROM_PLACE_T="yyyy";
    private static final String KEY_TO_PLACE_T ="o";
    private static final String KEY_TICKET_TYPE ="type";
    private static final String KEY_TICKET_DATE ="date";
    private static final String KEY_TICKET_PRICE ="date";
    private static final String KEY_TICKET_CARDNO ="card no";






    private static final String DATABASE_NAME="trips.db";
    private static final int DATABASE_VERSION=1;

    private final String CREATE_TABLE_TRIP ="create table "
            + TABLE_TRIP + " ("
            + KEY_ID + "  integer primary key autoincrement  , "
            + KEY_TO_PLACE + " text not null , "
            + FROM_DATE + " text not null , "
            + TO_DATE + " text not null , "
            + NUM_BUS + " text not null , "
            + TRIPS_TYPE + " text not null, "
            + KEY_PRICE + " text not null, "
            +KEY_FROM_PLACE+ " text not null)";

    private final String CREATE_TABLE_TICKET ="create table "
            + TABLE_TICKET + " ("
            + KEY_IDS + "  integer primary key autoincrement  , "
            + KEY_FROM_PLACE_T + " text not null , "
            + KEY_TO_PLACE_T + " text not null , "
            + KEY_TICKET_TYPE + " text not null , "
            + KEY_TICKET_PRICE + " text not null , "
            + KEY_TICKET_CARDNO + " text not null , "
            +KEY_TICKET_DATE+ " text not null)";


    public TripDatabase(Context context) {
        super(context,DATABASE_NAME, null, DATABASE_VERSION);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE_TRIP);
        db.execSQL(CREATE_TABLE_TICKET);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(String.format("DROP TABLE IF TABLE EXIST%s", TABLE_TRIP));
        db.execSQL(CREATE_TABLE_TRIP);
        db.execSQL(String.format("DROP TABLE IF TABLE EXIST%s", TABLE_TICKET));
        db.execSQL(CREATE_TABLE_TICKET);

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
        cv.put(KEY_PRICE, tripPojo.getPrice());
        cv.put(KEY_TICKET_PRICE, tripPojo.getPrice());





        id =(int)db.insert(TABLE_TRIP, null,cv);

        return id;

    }


    public List<TripPojo> getAllSubject()
    {
        List<TripPojo> reports = new ArrayList<TripPojo>();
        SQLiteDatabase db =this.getWritableDatabase();
        String selectQuery ="SELECT * FROM " + TABLE_TRIP;

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
                report.setPrice(cursor.getString(cursor.getColumnIndex(KEY_PRICE)));






                reports.add(report);

            }while(cursor.moveToNext());
        }
        return reports;

    }
    public int addTicket(Ticket ticket)
    {
        int id =0;

        SQLiteDatabase db = this.getWritableDatabase();


        ContentValues cv = new ContentValues();




        cv.put(KEY_FROM_PLACE_T,ticket.getFromDate());
        cv.put(KEY_TO_PLACE_T, ticket.getPlaceTo());
        cv.put(KEY_TICKET_TYPE, ticket.getTickectType());
        cv.put(KEY_TICKET_DATE, ticket.getDate());
        cv.put(KEY_TICKET_PRICE, ticket.getPrice());
        cv.put(KEY_TICKET_CARDNO, ticket.getAccountNo());


        id =(int)db.insert(TABLE_TICKET, null,cv);

        return id;

    }

    public List<Ticket> getAllTickject()
    {
        List<Ticket> reports = new ArrayList<Ticket>();
        SQLiteDatabase db =this.getWritableDatabase();
        String selectQuery ="SELECT * FROM " + TABLE_TRIP;

        Cursor cursor =db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst())
        {
            do
            {


                Ticket report = new Ticket();
                report.setId(cursor.getInt(cursor.getColumnIndex(KEY_IDS)));
                report.setFromDate(cursor.getString(cursor.getColumnIndex(KEY_FROM_PLACE_T)));

                report.setPlaceTo(cursor.getString(cursor.getColumnIndex(KEY_TO_PLACE_T)));
                report.setDate(cursor.getString(cursor.getColumnIndex(TO_DATE)));
                report.setPlaceFrom(cursor.getString(cursor.getColumnIndex(KEY_FROM_PLACE)));
                report.setPlaceFrom(cursor.getString(cursor.getColumnIndex(KEY_FROM_PLACE)));
                report.setTickectType(cursor.getString(cursor.getColumnIndex(KEY_TICKET_TYPE)));
                report.setPrice(cursor.getString(cursor.getColumnIndex(KEY_PRICE)));
                report.setAccountNo(cursor.getString(cursor.getColumnIndex(KEY_TICKET_CARDNO)));






                reports.add(report);

            }while(cursor.moveToNext());
        }
        return reports;

    }


//    public List<TripPojo> getAllSudentSubject(int compID)
//    {
//        List<TripPojo> reports = new ArrayList<TripPojo>();
//        SQLiteDatabase db =this.getWritableDatabase();
//        String selectQuery ="SELECT * FROM " + TABLE_REPORT +" WHERE "+KEY_REF+"=?";
//
//        String select[] = {String.valueOf(compID)};
//        Cursor cursor =db.rawQuery(selectQuery, select);
//
//        if(cursor.moveToFirst())
//        {
//            do
//            {
//                TripPojo report = new TripPojo();
//                report.setId(cursor.getInt(cursor.getColumnIndex(KEY_ID)));
//                report.setFromDate(cursor.getString(cursor.getColumnIndex(FROM_DATE)));
//                report.setNumBuS(cursor.getString(cursor.getColumnIndex(NUM_BUS)));
//                report.setPlaceTo(cursor.getString(cursor.getColumnIndex(KEY_TO_PLACE)));
//                report.setToDate(cursor.getString(cursor.getColumnIndex(TO_DATE)));
//                report.setPlaceFrom(cursor.getString(cursor.getColumnIndex(KEY_FROM_PLACE)));
//                report.setTypeTrips(cursor.getString(cursor.getColumnIndex(TRIPS_TYPE)));
//
//
//
//
//
//
//
//                reports.add(report);
//
//            }while(cursor.moveToNext());
//        }
//        return reports;
//
//    }
//
//    public void deletSubjectAll(long id)
//    {
//        String args[] = {String.valueOf(id)};
//
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        db.delete(TABLE_REPORT, KEY_REF + " = ? ", args);
//        db.close();
//
//    }


}
