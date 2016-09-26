package rootflyinfo.com.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Mithun Manoharan on 9/14/2016.
 */
public class DbDynamic extends SQLiteOpenHelper{
    public static final String DATABASE_NAME = "gamification.db";
    public static final int DATABASE_VERSION=1;
    public static final String CONTACTS_TABLE_NAME = "appcolor";
    public static final String CONTACTS_COLUMN_ID = "id";
    public static final String CONTACTS_COLUMN_NAME = "company_name";
    public static final String CONTACTS_COLUMN_H = "header";
    public static final String CONTACTS_COLUMN_HT = "headertextView";
    public static final String CONTACTS_COLUMN_AF = "foreground";
    public static final String CONTACTS_COLUMN_AB = "background";
    public static final String CONTACTS_COLUMN_CT = "content";
    public static final String CONTACTS_COLUMN_lOGO = "logo";

    public DbDynamic(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " +CONTACTS_TABLE_NAME
                +"(" +CONTACTS_COLUMN_NAME+
               " VARCHAR, " +CONTACTS_COLUMN_H+
                " TEXT, "+CONTACTS_COLUMN_HT+
                " TEXT, "+CONTACTS_COLUMN_AF+
                " TEXT, "+CONTACTS_COLUMN_AB+
                " TEXT, "+CONTACTS_COLUMN_CT+
                " TEXT, "+CONTACTS_COLUMN_lOGO+
                " TEXT);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS "+CONTACTS_TABLE_NAME;
        db.execSQL(sql);
        onCreate(db);
    }

    public boolean addData(String company_name,String Header,String Header_text,String Foreground,String Background,String context,String logo){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(CONTACTS_COLUMN_NAME, company_name);
        contentValues.put(CONTACTS_COLUMN_H, Header);
        contentValues.put(CONTACTS_COLUMN_HT, Header_text);
        contentValues.put(CONTACTS_COLUMN_AF, Foreground);
        contentValues.put(CONTACTS_COLUMN_AB, Background);
        contentValues.put(CONTACTS_COLUMN_CT, context);
        contentValues.put(CONTACTS_COLUMN_lOGO, logo);
        db.insert(CONTACTS_TABLE_NAME, null, contentValues);
        db.close();
        return true;
    }

    public boolean deleteData(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from "+ CONTACTS_TABLE_NAME);
        db.close();
        return true;
    }

    public Cursor getAllUser(){
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM "+CONTACTS_TABLE_NAME;
        Cursor c = db.rawQuery(sql, null);
        return c;
    }
    public boolean updatelogo(String cname,String logo) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(CONTACTS_COLUMN_lOGO, logo);
        db.update(CONTACTS_TABLE_NAME, contentValues, CONTACTS_COLUMN_NAME + " = ?", new String[]{cname});
        db.close();
        return true;
    }


}
