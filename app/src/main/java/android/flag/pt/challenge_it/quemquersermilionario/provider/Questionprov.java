package android.flag.pt.challenge_it.quemquersermilionario.provider;


import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.flag.pt.challenge_it.quemquersermilionario.Model.Answer;
import android.net.Uri;

import java.util.ArrayList;


//public class QuestionProvider extends ContentProvider{
public class Questionprov {
    {
        // provider identifier
        private static final String AUTHORITY = "android.flag.pt.challenge_it.quemquersermilionario.provider.questionprovider";

        // The content: scheme identifies the URI as a content URI pointing to an Android content provider.
        public static final Uri CONTENT_URI = Uri.parse(ContentResolver.SCHEME_CONTENT + "://" + AUTHORITY);

        // Matcher for see if the type is one element or all elements.
        private static UriMatcher URIMATCHER = new UriMatcher(UriMatcher.NO_MATCH);
        private static final int QUESTION_ID  = 1;
        //private static final String QUESTION_QUESTION  = 2;
        //private static final ArrayList<Answer> QUESTION_ANSWERS  =3;
        private static final int QUESTION_ALL = 2;

        private static final String MIME_ALL = "vnd.android.cursor.dir/vnd.android.flag.pt.challenge_it.quemquersermilionario.provider." + QuestionContract.TABLE;
        private static final String MIME_ONE = "vnd.android.cursor.item/vnd.android.flag.pt.challenge_it.quemquersermilionario.provider." + QuestionContract.TABLE;
        // private static final String MIME_TWO = "vnd.android.cursor.item/vnd.android.flag.pt.challenge_it.quemquersermilionario.provider." + QuestionContract.TABLE;
        //private static final String MIME_THREE = "vnd.android.cursor.item/vnd.android.flag.pt.challenge_it.quemquersermilionario.provider." + QuestionContract.TABLE;



        // DB Helper instance for access to SQLite DB.
        private SQLiteOpenHelper helper;

        static
        {
            URIMATCHER.addURI(AUTHORITY, QuestionContract.TABLE+"/#", QUESTION_ID);
            URIMATCHER.addURI(AUTHORITY, QuestionContract.TABLE, QUESTION_ALL);
            //URIMATCHER.addURI(AUTHORITY, QuestionContract.TABLE, QUESTION_QUESTION);


        }

        @Override
        public boolean onCreate() {
        helper = new QuestionHelper(getContext());
        return true;
    }

        @Override
        public String getType(Uri uri)
        {
            return URIMATCHER.match(uri) == QUESTION_ALL ? MIME_ALL : MIME_ONE;
        }

        @Override
        public Uri insert(Uri uri, ContentValues values)
        {
            SQLiteDatabase db = helper.getWritableDatabase();
            try
            {
                long row = db.insert(QuestionContract.TABLE, null, values);
                return (row != -1) ? null : ContentUris.withAppendedId(uri, row);
            }
            finally
            {
                db.close();
            }
        }

        @Override
        public Cursor query(Uri uri, String[] projection, String selection,
            String[] selectionArgs, String sortOrder)
        {
            SQLiteDatabase db = helper.getReadableDatabase();
            return db.query(QuestionContract.TABLE, projection, selection, selectionArgs, null, null, sortOrder);
        }

        @Override
        public int update(Uri uri, ContentValues values, String selection,
            String[] selectionArgs)
        {
            SQLiteDatabase db = helper.getWritableDatabase();
            try
            {
                return db.update(QuestionContract.TABLE, values, selection, selectionArgs);
            }
            finally
            {
                db.close();
            }
        }

        @Override
        public int delete(Uri uri, String selection, String[] selectionArgs)
        {
            SQLiteDatabase db = helper.getWritableDatabase();
            try
            {
                return db.delete(QuestionContract.TABLE, selection, selectionArgs);
            }
            finally
            {
                db.close();
            }
        }

        /**
         * DB helper for Temperatures. The DB is an SQLite data base.
         *
         * @pt Criação da base de dados com a tabela TEMPERATURE.
         * @author Challenge.IT
         */
        private static class QuestionHelper extends SQLiteOpenHelper
        {
            public QuestionHelper(Context context)
            {
                super(context, "question.sql", null, 1);
            }

            @Override
            public void onCreate(SQLiteDatabase sqLiteDatabase)
            {
                String columns = QuestionContract._IDQUESTION + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        QuestionContract.QUESTION + " REAL NOT NULL";

                String sql = "CREATE TABLE IF NOT EXISTS " + QuestionContract.TABLE + " (" + columns + ")";
                sqLiteDatabase.execSQL(sql);
            }

            @Override
            public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2)
            {
                // no need to implement this method, just when we want to update the database
            }
        }
    }

