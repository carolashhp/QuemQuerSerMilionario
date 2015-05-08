package android.flag.pt.challenge_it.quemquersermilionario.provider;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.flag.pt.challenge_it.quemquersermilionario.Model.Answer;
import android.flag.pt.challenge_it.quemquersermilionario.Model.Question;

import java.util.ArrayList;


public class JogarManager {
    private Context _context;

    public JogarManager(Context context)
    {
        _context = context;
    }


    public void save(ArrayList<Question>questionList)
    {


        for( Question q : questionList){
            ContentValues values = new ContentValues();
            values.put(QuestionContract.ID_QUESTION, q.getId());
            values.put(QuestionContract.QUESTION, q.getQuestion());

                ArrayList<Answer>y= q.getAnswers();


                values.put(AnswerContract.ID_ANSWER_A, y.get(0).getId());
                values.put(AnswerContract.ANSWER_A, y.get(0).getAnswer());
                values.put(AnswerContract.CORRECT_A, y.get(0).getCorrect());

                values.put(AnswerContract.ID_ANSWER_B, y.get(1).getId());
                values.put(AnswerContract.ANSWER_B, y.get(1).getAnswer());
                values.put(AnswerContract.CORRECT_B, y.get(1).getCorrect());

                values.put(AnswerContract.ID_ANSWER_C, y.get(2).getId());
                values.put(AnswerContract.ANSWER_C, y.get(2).getAnswer());
                values.put(AnswerContract.CORRECT_C, y.get(2).getCorrect());

                values.put(AnswerContract.ID_ANSWER_D, y.get(3).getId());
                values.put(AnswerContract.ANSWER_D, y.get(3).getAnswer());
                values.put(AnswerContract.CORRECT_D, y.get(3).getCorrect());


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
            questions.add(new Question(questionsCursor.getInt(questionsCursor.getColumnIndex(QuestionContract.ID_QUESTION)),
                    questionsCursor.getString(questionsCursor.getColumnIndex(QuestionContract.QUESTION)),
                    answers));
        }
        questionsCursor.close();

        return questions;



    }
}