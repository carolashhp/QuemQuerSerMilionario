package android.flag.pt.challenge_it.quemquersermilionario.provider;

import android.net.Uri;
import android.provider.BaseColumns;


public class AnswerContract {
    // table name
    public static final String TABLE = "ANSWER";

    // columns names
    public static final String ID_QUESTION = "ID_Question";
    public static final String ID = BaseColumns._ID;
    public static final String ID_ANSWER = "ID_Answer";
    public static final String ANSWER = "answer";
    public static final String CORRECT = "correct";

    // IDENTIFCADORES DO CONTENT VALUE
    public static final String ID_ANSWER_A = "ID_ANSWER_A";
    public static final String ANSWER_A = "answer_A";
    public static final String CORRECT_A = "correct_A";

    public static final String ID_ANSWER_B = "ID_ANSWER_B";
    public static final String ANSWER_B = "answer_B";
    public static final String CORRECT_B = "correct_B";

    public static final String ID_ANSWER_C = "ID_ANSWER_C";
    public static final String ANSWER_C = "answer_C";
    public static final String CORRECT_C = "correct_C";

    public static final String ID_ANSWER_D = "ID_ANSWER_D";
    public static final String ANSWER_D = "answer_D";
    public static final String CORRECT_D = "correct_D";


    // content URI for subset of provided data from temperature provider.
    public static Uri CONTENT_PROVIDER = Uri.withAppendedPath(AnswerProvider.CONTENT_URI, TABLE);
}

