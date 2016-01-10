package premiereapplication.testautomation.quiz.objects;


import java.util.List;

public class QuestionPropositionsReponses {

    public String question;
    public List<String> propositions;
    public List<String> reponses;


    public QuestionPropositionsReponses(String question,List<String> propositions, List<String> reponses){
        this.question=question;
        this.propositions=propositions;
        this.reponses=reponses;
    }

}
