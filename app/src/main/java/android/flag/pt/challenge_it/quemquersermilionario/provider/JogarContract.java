package android.flag.pt.challenge_it.quemquersermilionario.provider;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by Formando FLAG on 04-05-2015.
 */
public class JogarContract {
    // table name
    public static final String TABLE = "JOGAR";

    // columns names
    public static final String _ID = BaseColumns._ID;
    public static final String VALUE = "value";

    // content URI for subset of provided data from temperature provider.
    public static Uri CONTENT_PROVIDER = Uri.withAppendedPath(JogarProvider.CONTENT_URI, TABLE);
}
