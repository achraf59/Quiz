package premiereapplication.testautomation.quiz.objects;

import java.util.List;


public class ObjetQuiz {

public String nomQuiz;
public int dureeQuiz;
public List<QuestionPropositionsReponses> listQuestionPropositionsReponses;

    public ObjetQuiz(String nomQuiz,int dureeQuiz,List<QuestionPropositionsReponses> listQuestionPropositionsReponses){

    this.nomQuiz=nomQuiz;
    this.dureeQuiz=dureeQuiz;
    this.listQuestionPropositionsReponses=listQuestionPropositionsReponses;
    }


}
