package android.flag.pt.challenge_it.quemquersermilionario;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.flag.pt.challenge_it.quemquersermilionario.Model.Answer;
import android.flag.pt.challenge_it.quemquersermilionario.Model.Question;
import android.flag.pt.challenge_it.quemquersermilionario.provider.AnswerContract;
import android.flag.pt.challenge_it.quemquersermilionario.provider.JogarManager;
import android.flag.pt.challenge_it.quemquersermilionario.provider.QuestionContract;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class JogarActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        JogarManager manager = new JogarManager(this);

        ArrayList<Question>questionsList = manager.getAll();
        Question primeira = questionsList.get(0);
        ArrayList<Answer> answers = primeira.getAnswers();

        Button btnCinco = (Button)findViewById(R.id.btnCinco);
        Button btnPublico = (Button)findViewById(R.id.btnPublico);
        Button btnTelefone = (Button)findViewById(R.id.btnTelefone);

        TextView txtQuestion = (TextView)findViewById(R.id.txtQuestion);
        txtQuestion.setText(primeira.getQuestion());

        Button btnAnswerA = (Button)findViewById(R.id.btnAnswerA);
        Button btnAnswerB = (Button)findViewById(R.id.btnAnswerB);
        Button btnAnswerC = (Button)findViewById(R.id.btnAnswerC);
        Button btnAnswerD = (Button)findViewById(R.id.btnAnswerD);

        btnAnswerA.setText(answers.get(0).getAnswer());
        btnAnswerB.setText(answers.get(1).getAnswer());
        btnAnswerC.setText(answers.get(2).getAnswer());
        btnAnswerD.setText(answers.get(3).getAnswer());


        btnCinco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnPublico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnTelefone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }
}
