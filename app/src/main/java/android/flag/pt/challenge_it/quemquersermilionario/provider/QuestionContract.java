package android.flag.pt.challenge_it.quemquersermilionario.provider;

import android.net.Uri;
import android.provider.BaseColumns;


public class QuestionContract {
    // table name
    public static final String TABLE = "QUESTION";

    // columns names
    public static final String ID = BaseColumns._ID;
    public static final String ID_QUESTION = "ID_Question";
    public static final String QUESTION = "question";

    // content URI for subset of provided data from temperature provider.
    public static Uri CONTENT_PROVIDER = Uri.withAppendedPath(QuestionProvider.CONTENT_URI, TABLE);
}

