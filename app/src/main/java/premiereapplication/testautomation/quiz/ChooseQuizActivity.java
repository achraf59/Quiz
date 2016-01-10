package premiereapplication.testautomation.quiz;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import premiereapplication.testautomation.quiz.adapters.ListQuizsAdapter;
import premiereapplication.testautomation.quiz.helpers.HelperFileToListQuiz;


public class ChooseQuizActivity extends Activity {

    private ListView mListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_choose_quiz_activity);
        mListView=(ListView) findViewById(R.id.quizsListView);

        final ListQuizsAdapter tweetsAdapter=new ListQuizsAdapter(HelperFileToListQuiz.getListOfQuizsFromFile(getApplicationContext()));
        mListView.setAdapter(tweetsAdapter);




    }
}
