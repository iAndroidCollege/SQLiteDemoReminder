package college.edu.tomer.sqlitedemoreminder;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class NotesDbHelper extends SQLiteOpenHelper {

    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "NotesDb";
    private static final String CREATE_TABLE_NOTES = "" +
            "CREATE TABLE Notes(_ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
            "                   Note TEXT NOT NULL," +
            "                   Title TEXT)";

    public NotesDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_NOTES);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE Notes;");
        onCreate(db);
    }
}
