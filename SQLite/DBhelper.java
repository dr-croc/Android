import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DBhelper extends SQLiteOpenHelper {


    public DBhelper(Context context) {
        // super(context, "databseName", "Alwyas null", 1);
        super(context, "userdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // db.execSQL(" CREATE TABLE "Table name"(name TEXT PRIMARY KEY, contact TEXT, dob TEXT)"); dob : date of birth
       
          db.execSQL(" CREATE TABLE userDetails(name TEXT PRIMARY KEY, contact TEXT, dob TEXT)"); 
    }

  
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists userDetails");
    }
  
//insertion
    public Boolean inserUserData(String name, String contact, String dob) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        //cv.put("column name", input value);
        cv.put("name", name);
        cv.put("contact", contact);
        cv.put("dob", dob);

        // db.insert("which table ", null, contentValues);
        long result = db.insert("userDetails", null, cv);

        if (result == -1) {
            return false;
        }
        else {
            return true;
        }
    }

  
// update
    public Boolean upadateUserData(String name, String contact, String dob) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("name", name);
        cv.put("contact", contact);
        cv.put("dob", dob);

        // cursor is like selecting the row

        Cursor cursor = db.rawQuery("SELECT * FROM userDetails WHERE name=?", new String[]{name});

        if (cursor.getCount() > 0) {

            // db.update("table name", all the values-content values, "what column ypu need to change=?", new String[]{value});
            long result = db.update("userDetails", cv, "name=?", new String[]{name});

            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }



// delete data
    public Boolean deleteData(String name) {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM userDetails WHERE name=?", new String[]{name});

        if (cursor.getCount() > 0) {
            long result = db.delete("userDetails", "name= ?", new String[]{name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }


  // get all data
    public Cursor getData() {
        SQLiteDatabase db = this.getWritableDatabase();

        // cursor is like selecting the row
        Cursor cursor = db.rawQuery("SELECT * FROM userDetails", null);

        return cursor;
    }
}
