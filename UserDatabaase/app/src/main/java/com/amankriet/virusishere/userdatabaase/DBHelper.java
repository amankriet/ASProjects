package com.amankriet.virusishere.userdatabaase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "MyDBName.db";
    public static final String CONTACTS_TABLE_NAME = "Contacts";
    public static final String CONTACTS_COLUMN_ID = "id";
    public static final String CONTACTS_COLUMN_NAME = "Name";
    public static final String EMAIL = "Email";
    public static final String CITY = "City";
    public static final String COUNTRY = "Country";
    public static final String PHONE = "Phone";
    private HashMap hp;

    public DBHelper(Context context) {

        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table Contacts" + "(id integer primary key, Name text, Phone text, " +
                "Email text, City text, Country text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion) {

        db.execSQL("DROP TABLE IF EXISTS Contacts");

        onCreate(db);

    }

    public boolean insertContact(String name, String phone, String email, String city, String country)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("Name", name);
        contentvalues.put("Phone", phone);
        contentvalues.put("Email", email);
        contentvalues.put("City", city);
        contentvalues.put("Country", country);
        db.insert("Contacts", null, contentvalues);
        return true;
    }

    public Cursor getData(int id)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor res = db.rawQuery("select * from Contacts where id=" + id + "", null);
        return res;
    }

    public int numberOfRows()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        return (int) DatabaseUtils.queryNumEntries(db, CONTACTS_TABLE_NAME);
    }

    public boolean updateContact(Integer id, String name, String phone, String email, String city, String country) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name", name);
        contentValues.put("Phone", phone);
        contentValues.put("Email", email);
        contentValues.put("City", city);
        contentValues.put("Country", country);
        db.update("Contacts", contentValues, "id = ?", new String[]{Integer.toString(id)});
        return true;
    }

    public Integer deleteContact(Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("Contacts", "id = ?", new String[]{Integer.toString(id)});
    }

    public ArrayList getAllContacts() {
        ArrayList array_list = new ArrayList();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from Contacts", null);
        res.moveToFirst();
        while (!res.isAfterLast()) {
            array_list.add(res.getString(res.getColumnIndex(CONTACTS_COLUMN_NAME)));
            res.moveToNext();
        }
        return array_list;
    }

}
