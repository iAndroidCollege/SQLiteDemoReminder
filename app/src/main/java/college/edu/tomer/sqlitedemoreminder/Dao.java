package college.edu.tomer.sqlitedemoreminder;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


public class Dao{
   private SQLiteDatabase db;
   private static Dao instance;

    private Dao(Context context){
        NotesDbHelper helper = new NotesDbHelper(context);
        db = helper.getWritableDatabase();
    }

    public static synchronized Dao getSharedInstance(Context context){
        if (instance == null)
            instance = new Dao(context);
        return  instance;
    }

    public void insertNote(String title, String note){
        ContentValues values = new ContentValues();
        values.put("Note", note);
        values.put("Title", title);

        db.insert("Notes", null, values);
    }

    public void dispAllNotes(){
        Cursor cursor = db.rawQuery("SELECT * FROM Notes", null);


        while (cursor.moveToNext()){
            String note = cursor.getString(cursor.getColumnIndex("Note"));
            String title = cursor.getString(cursor.getColumnIndex("Title"));

            System.out.println(note);
            System.out.println(title);
        }
        //db.rawQuery("SELECT * FROM Notes WHERE _id=?", new String[]{"1"});
    }
}
