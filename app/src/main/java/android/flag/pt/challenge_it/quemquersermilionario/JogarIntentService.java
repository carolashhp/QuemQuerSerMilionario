package android.flag.pt.challenge_it.quemquersermilionario;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class JogarIntentService extends IntentService {


    public JogarIntentService() {

        super("JogarIntentService");
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

            JSONObject response = new JSONObject(res);
            double temp = response.getJSONObject("main").getDouble("temp");

            Log.i(INTENT_SERVICE_LOG, temp + " ºC");

            /**
             * Save persistently the temperature in database.
             *
             * @pt Guardar na base de dados a informação da temperatura.
             */
            manager.save(new Temperature(temp));
        }
        catch(Exception e)
        {
            Log.i(INTENT_SERVICE_LOG, "Cannot get temperature.");
        }

    }


}
