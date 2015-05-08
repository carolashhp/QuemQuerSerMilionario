package android.flag.pt.challenge_it.quemquersermilionario.provider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Formando FLAG on 06-05-2015.
 */
public class JogarHelper extends SQLiteOpenHelper {
    public JogarHelper(Context context)
    {
        super(context, "question.sql", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        String columns = QuestionContract.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionContract.ID_QUESTION + " TEXT NOT NULL, " +
                QuestionContract.QUESTION + " TEXT NOT NULL";

        String sql = "CREATE TABLE IF NOT EXISTS " + QuestionContract.TABLE + " (" + columns + ")";
        sqLiteDatabase.execSQL(sql);

        String answersColumns = AnswerContract.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                AnswerContract.ID_ANSWER + " TEXT NOT NULL, " +
                AnswerContract.ID_QUESTION + " TEXT NOT NULL, " +
                AnswerContract.ANSWER + " TEXT NOT NULL, " + AnswerContract.CORRECT + " INTEGER NOT NULL" ;

        String answersSql = "CREATE TABLE IF NOT EXISTS " + AnswerContract.TABLE + " (" + columns + ")";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2)
    {
        // no need to implementytjhjkkethod, just whhhffe want to update the database
    }
}
