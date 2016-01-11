package premiereapplication.testautomation.quiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import premiereapplication.testautomation.quiz.adapters.ListQuizsAdapter;
import premiereapplication.testautomation.quiz.helpers.HelperFileToListQuiz;


public class ChooseQuizActivity extends Activity implements  AdapterView.OnItemClickListener {

    private ListView mListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_choose_quiz_activity);
        mListView=(ListView) findViewById(R.id.quizsListView);

        final ListQuizsAdapter tweetsAdapter=new ListQuizsAdapter(HelperFileToListQuiz.getListOfQuizsFromFile(getApplicationContext()));
        mListView.setAdapter(tweetsAdapter);




    }

    @Override
    public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {

        //final ObjetQuiz quizChoisi = (ObjetQuiz) adapter.getItemAtPosition(position);
        //commentaire test git
        final int indiceQuizChoisi=position;
        final Intent intent = new Intent(this, QuizActivity.class);
        final Bundle extras = new Bundle();
        //extras.putParcelable("QuizToLaunch",quizChoisi);
        extras.putInt("position", indiceQuizChoisi);
        intent.putExtras(extras);
        startActivity(intent);

    }


}
