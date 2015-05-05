package android.flag.pt.challenge_it.quemquersermilionario.provider;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.flag.pt.challenge_it.quemquersermilionario.Model.Question;

import java.util.ArrayList;

/**
 * Created by Formando FLAG on 04-05-2015.
 */
public class JogarManager {
    private Context _context;

    public JogarManager(Context context)
    {
        _context = context;
    }

    /**
     * Store temperature in database.
     * @param temperature
     */
    public void save(ArrayList<Question>questionList)
    {
        ContentValues values = new ContentValues();
        values.put(QuestionContract.QUESTION, Question.getValue());
        _context.getContentResolver().insert(QuestionProvider.CONTENT_URI, values);
    }

    /**
     * Get all temperatures stored in database.
     * @return list of temperatures
     */
    public ArrayList<Question> getAll()
    {
        Cursor cursor = _context.getContentResolver().query(QuestionProvider.CONTENT_URI, null, null, null, null);
        ArrayList<Question> questions = new ArrayList<>();
        while(cursor.moveToNext())
        {
            questions.add(new Question(cursor.getString(cursor.getColumnIndex(QuestionContract.QUESTION))));
        }
        cursor.close();
        return questions;
    }
}