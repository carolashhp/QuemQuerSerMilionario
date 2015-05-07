package android.flag.pt.challenge_it.quemquersermilionario;

import android.app.IntentService;
import android.content.Intent;
import android.flag.pt.challenge_it.quemquersermilionario.Model.Answer;
import android.flag.pt.challenge_it.quemquersermilionario.Model.Question;
import android.flag.pt.challenge_it.quemquersermilionario.provider.JogarManager;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


public class JogarIntentService extends IntentService {

    private static final String INTENT_SERVICE_LOG = "INTENT_SERVICE_LOG";
    private final JogarManager manager;

    private static final String TAG_ID = "id";
    private static final String TAG_QUESTION = "question";
    private static final String TAG_ANSWERS = "answers";
    private static final String TAG_ANSWER = "answer";
    private static final String TAG_CORRECT = "correct";




    public JogarIntentService() {

        super("JogarIntentService");
        this.manager = new JogarManager(this);
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        try
        {
            URL url = new URL("http://54.187.166.51:81/questions");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            String res = "";
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            while ((line = rd.readLine()) != null)
                res += line;

            JSONArray response = new JSONArray(res);

            ArrayList<Question> questionList = new ArrayList<>();

                for (int i = 0; i < response.length(); i++) {
                    JSONObject c = response.getJSONObject(i);

                    int id = c.getInt(TAG_ID);
                    String question = c.getString(TAG_QUESTION);
                    JSONArray answers = c.getJSONArray(TAG_ANSWERS);

                    ArrayList<Answer> answersList = new ArrayList<>();

                        for (int j = 0; j < answers.length(); j++) {
                            JSONObject d = answers.getJSONObject(j);

                            String idAnswer = d.getString(TAG_ID);
                            String answer = d.getString(TAG_ANSWER);
                            boolean correct = d.getBoolean(TAG_CORRECT);

                            answersList.add(new Answer(idAnswer, answer, correct));

                            //Log.i(TAG_ANSWER, id+" " +question + " "+idAnswer+ " "+ answer + " "+ correct );
                        }
                    questionList.add(new Question(id,question,answersList));

                }

            /**
             * Save persistently the temperature in database.
             *
             * @pt Guardar na base de dados a informação da temperatura.
             */
            manager.save(questionList);

        }
        catch(Exception e)
        {
            Log.i(INTENT_SERVICE_LOG, "Não é possível obter os dados.");
            e.printStackTrace();
        }

    }


}
