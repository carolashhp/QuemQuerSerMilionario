package android.flag.pt.challenge_it.quemquersermilionario.Model;

/**
 * Created by Formando FLAG on 04-05-2015.
 */
public class Answer {

    private final String id;

    private  final String answer;

    private final boolean correct;

    public Answer(String id, String answer, boolean correct){
        this.id=id;
        this.answer=answer;
        this.correct=correct;

    }

    public String getAnswer() {
        return answer;
    }

    public String getId() {
        return id;
    }

    public boolean getCorrect(){
        return correct;
    }

}
