package premiereapplication.testautomation.quiz;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import premiereapplication.testautomation.quiz.helpers.HelperFileToListQuiz;
import premiereapplication.testautomation.quiz.objects.ObjetQuiz;
import premiereapplication.testautomation.quiz.objects.QuestionPropositionsReponses;


public class MainActivity extends Activity implements View.OnClickListener {

    private Button mLancerQuizButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main_activity);

        mLancerQuizButton=(Button) findViewById(R.id.LancerQuizbutton);
        mLancerQuizButton.setOnClickListener(this);

        //some changes

    }

    public void onClick(View view) {
        final Intent intent = new Intent(this,ChooseQuizActivity.class);
        startActivity(intent);

    }


}
