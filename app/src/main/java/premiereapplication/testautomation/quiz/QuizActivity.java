package premiereapplication.testautomation.quiz;


import android.app.Activity;
import android.os.Bundle;

import premiereapplication.testautomation.quiz.helpers.HelperFileToListQuiz;
import premiereapplication.testautomation.quiz.objects.ObjetQuiz;

public class QuizActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ObjetQuiz quizToLaunch = HelperFileToListQuiz.getQuiz(QuizAplication.getContext(), getIntent().getExtras().getInt("position"));
        System.out.println("jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj");
        System.out.println(quizToLaunch.nomQuiz);
        System.out.println(quizToLaunch.dureeQuiz);



    }
}
