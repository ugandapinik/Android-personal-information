package www.jewel_mahmud.com.personalinformation;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by wohhie on 8/20/2016.
 */
public class UserDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "USERINFO.DB";
    private static final int DATABASE_VERSION = 1;
    private static final String CREATE_QUERY =
            "CREATE TABLE " + UserClass.NewUserInfo.TABLE_NAME + " (" + UserClass.NewUserInfo.USER_NAME + " TEXT, "
            + UserClass.NewUserInfo.USER_MOB + " TEXT," + UserClass.NewUserInfo.USER_EMAIL + " TEXT );";






    public UserDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.e("DATABASE OPERATIONS", "DATABASE CREATED / OPENDED.");
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //create table;
        sqLiteDatabase.execSQL(CREATE_QUERY);
        Log.e("DATABASE OPERATIONS", "TABLE CREATED / OPENDED.");
    }


    public void insertInformation(String name, String mob, String email, SQLiteDatabase db){
        //insert data into the table;
        ContentValues contentValues = new ContentValues();
        contentValues.put(UserClass.NewUserInfo.USER_NAME, name);
        contentValues.put(UserClass.NewUserInfo.USER_MOB, mob);
        contentValues.put(UserClass.NewUserInfo.USER_EMAIL, email);

        db.insert(UserClass.NewUserInfo.TABLE_NAME, null, contentValues);
        Log.e("DATABASE OPERATIONS", "INSERTED...");


    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
