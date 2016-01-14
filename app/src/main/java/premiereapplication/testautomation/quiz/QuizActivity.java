package premiereapplication.testautomation.quiz;


import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import premiereapplication.testautomation.quiz.adapters.ListPropositionsReponsesAdapter;
import premiereapplication.testautomation.quiz.helpers.HelperFileToListQuiz;
import premiereapplication.testautomation.quiz.objects.ObjetQuiz;

public class QuizActivity extends Activity  implements AdapterView.OnItemClickListener {

    private static  int indexQuestionEnCours;
    private static  int score=0;
    private static  ObjetQuiz quizToLaunch;

    private TextView nomQuizTextView;
    private TextView dureeQuizTextView;
    private static TextView questionTextView;
    private static ListView mListView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        indexQuestionEnCours=0;
        score=0;
        quizToLaunch = HelperFileToListQuiz.getQuiz(QuizAplication.getContext(),getIntent().getExtras().getInt("position"));

        setContentView(R.layout.layout_quiz_activity);

         nomQuizTextView=(TextView) findViewById(R.id.nomQuizLaunchedTextView);
         nomQuizTextView.setText("Quiz " + quizToLaunch.nomQuiz);

         dureeQuizTextView =(TextView) findViewById(R.id.dureeQuizLaunchedTextView);
         dureeQuizTextView.setText(quizToLaunch.dureeQuiz +" sec");

         questionTextView=(TextView) findViewById(R.id.questionTextView);
         mListView=(ListView) findViewById(R.id.propositionsListView);




        charger();
        mListView.setOnItemClickListener(this);


    }

    @Override
    protected void onPause() {
    super.onPause();
    System.out.println("je ne veux pas etre en pause pour eviter la triche , donc je quitte");
    finish();
    }



    @Override
    public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {

          String reponseChoisi = (String) adapter.getItemAtPosition(position);
          String reponseVraie=quizToLaunch.listQuestionPropositionsReponses.get(indexQuestionEnCours).reponses.get(0);


        if (reponseChoisi.equals(reponseVraie)) {
            mListView.getChildAt(position).setBackgroundColor(Color.GREEN);
            score++;
        }
            else{
                mListView.getChildAt(position).setBackgroundColor(Color.RED);
            }



        indexQuestionEnCours++;
         charger();



    }




    void charger(){

        if(indexQuestionEnCours<quizToLaunch.listQuestionPropositionsReponses.size()){

            questionTextView.setText(quizToLaunch.listQuestionPropositionsReponses.get(indexQuestionEnCours).question);
            ListPropositionsReponsesAdapter listPropositionsReponsesAdapter = new ListPropositionsReponsesAdapter
                    (quizToLaunch.listQuestionPropositionsReponses.get(indexQuestionEnCours).propositions);


            mListView.setAdapter(listPropositionsReponsesAdapter);

        }

        else{

            Toast.makeText(this, "votre score est "+score+"/"+quizToLaunch.listQuestionPropositionsReponses.size(), Toast.LENGTH_LONG).show();
            indexQuestionEnCours=0;
            score=0;
            finish();
        }

    }


}
