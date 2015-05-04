package android.flag.pt.challenge_it.quemquersermilionario.Model;

import java.util.ArrayList;

/**
 * Created by Formando FLAG on 04-05-2015.
 */
public class Question {
    private final int id;

    private final String question;

    private final ArrayList<Answer> answers;

    public Question( int id, String question, ArrayList<Answer> answers){
        this.id= id;
        this.question = question;
        this.answers = answers;
    }

    public ArrayList<Answer> getAnswers() {
        return answers;
    }

    public int getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }
}
