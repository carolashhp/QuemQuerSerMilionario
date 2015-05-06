package android.flag.pt.challenge_it.quemquersermilionario.provider;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by Manas Luis on 05-05-2015.
 */
public class AnswerContract {
    // table name
    public static final String TABLE = "ANSWER";

    // columns names
    public static final String ID_QUESTION = "Question_ID";
    public static final String ID_ANSWER = BaseColumns._ID;
    public static final String ABC = "abc";
    public static final String ANSWER = "answer";
    public static final String CORRECT = "correct";


    // content URI for subset of provided data from temperature provider.
    public static Uri CONTENT_PROVIDER = Uri.withAppendedPath(AnswerProvider.CONTENT_URI, TABLE);
}

