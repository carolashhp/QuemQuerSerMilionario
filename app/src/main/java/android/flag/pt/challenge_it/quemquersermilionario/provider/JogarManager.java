package android.flag.pt.challenge_it.quemquersermilionario.provider;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.flag.pt.challenge_it.quemquersermilionario.Model.Answer;
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


        for( Question q : questionList){
            ContentValues values = new ContentValues();
            values.put(QuestionContract.ID_QUESTION, q.getId());
            values.put(QuestionContract.QUESTION, q.getQuestion());


            for( Answer y : q.getAnswers()){

                values.put(AnswerContract.ID_ANSWER, y.getId());
                values.put(AnswerContract.ANSWER, y.getAnswer());
                values.put(AnswerContract.CORRECT, y.getCorrect());

            }
            _context.getContentResolver().insert(QuestionContract.CONTENT_PROVIDER, values);


        }

    }

    /**
     * Get all temperatures stored in database.
     * @return list of temperatures
     */
    public ArrayList<Question> getAll()
    {
        Cursor questionsCursor = _context.getContentResolver().query(QuestionContract.CONTENT_PROVIDER, null, null, null, null);
        ArrayList<Question> questions = new ArrayList<>();
        while(questionsCursor.moveToNext())
        {
            Cursor answersCursor = _context.getContentResolver().query(AnswerContract.CONTENT_PROVIDER, null, null, null, null);
            ArrayList<Answer> answers = new ArrayList<>();
            while(answersCursor.moveToNext())
            {
                answers.add(new Answer(answersCursor.getString(answersCursor.getColumnIndex(AnswerContract.ID_ANSWER)),
                        answersCursor.getString(answersCursor.getColumnIndex(AnswerContract.ANSWER)),
                        answersCursor.getInt(answersCursor.getColumnIndex(AnswerContract.CORRECT)) == 1
                ));


            }
            answersCursor.close();
            questions.add(new Question(questionsCursor.getString(questionsCursor.getColumnIndex(QuestionContract.ID_QUESTION)),
                            questionsCursor.getColumnIndex(QuestionContract.ID_QUESTION))
                    ));
        }
        questionsCursor.close();

        return questions;



    }
}