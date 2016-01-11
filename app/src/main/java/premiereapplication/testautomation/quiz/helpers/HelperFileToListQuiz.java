package premiereapplication.testautomation.quiz.helpers;


import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import premiereapplication.testautomation.quiz.objects.ObjetQuiz;
import premiereapplication.testautomation.quiz.objects.QuestionPropositionsReponses;

public class HelperFileToListQuiz {


    static public String readFile(Context context) {

        String ContenuFichierEntier = "";
        InputStream input = null;
        try {

            input = context.getResources().getAssets().open("quizs.txt");

        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            String ligne = "";
            BufferedReader bfr = new BufferedReader(new InputStreamReader(input));

            while ((ligne = bfr.readLine()) != null) {

                ContenuFichierEntier = ContenuFichierEntier + ligne;
            }


            bfr.close();
        } catch (Exception e) {
            ContenuFichierEntier = e.getMessage();
            System.out.println(e.getMessage());
        }
        return ContenuFichierEntier;
    }


    static public List<ObjetQuiz> getListOfQuizsFromFile(Context context) {

        String ContenuFichierEntier = readFile(context);


        List<ObjetQuiz> ListObjetQuiz = new ArrayList<ObjetQuiz>();


        //division
        String toutLesQuizs[] = ContenuFichierEntier.split("Quiz");

        for (int i = 0; i < toutLesQuizs.length; i++) {
            String NomQuiz = toutLesQuizs[i].split("//")[0]; //on a le nom
            int DureeQuiz = Integer.parseInt(toutLesQuizs[i].split("//")[1]); //on a le temps
            List<QuestionPropositionsReponses> ListeQuestionPropositionsReponses = new ArrayList<QuestionPropositionsReponses>();

            //Maintenant il reste une liste  ListQuestionPropositionsReponses
            //Chaque element de cette liste contient un objet de type QuestionPropositionsReponses
            //chaque élement de ce dernier contient une liste de String pour propositions et une autre liste de String pour Reponses

            String listeQustionPropositionsReponses[] = toutLesQuizs[i].split("//")[2].split(">");
            for (int j = 0; j < listeQustionPropositionsReponses.length; j++) {
                String enonceQuestion = listeQustionPropositionsReponses[j].split("<")[0]; // maintenant on a la question
                List<String> Propositions = new ArrayList<String>();
                List<String> Reponses = new ArrayList<String>();

                String PropositionsReponses = listeQustionPropositionsReponses[j].split("<")[1];
                String propositions[] = PropositionsReponses.split("/")[0].split(",");
                String reponses[] = PropositionsReponses.split("/")[1].split(",");
                for (int n = 0; n < propositions.length; n++) {
                    Propositions.add(propositions[n]);
                }
                for (int n = 0; n < reponses.length; n++) {
                    Reponses.add(reponses[n]);
                }
                QuestionPropositionsReponses qpr = new QuestionPropositionsReponses(enonceQuestion, Propositions, Reponses);
                ListeQuestionPropositionsReponses.add(qpr);


            }

            ObjetQuiz oq = new ObjetQuiz(NomQuiz, DureeQuiz, ListeQuestionPropositionsReponses);
            ListObjetQuiz.add(oq);
        }

    return ListObjetQuiz;
    }

    static public ObjetQuiz getQuiz(Context context,int position) {

        return getListOfQuizsFromFile(context).get(position);

    }



    static public void display(List <ObjetQuiz> listOfQuizs) {

        for (int i = 0; i < listOfQuizs.size(); i++) {

            System.out.println("\n\n\nQuiz " + (i + 1));

            String nomQuiz = listOfQuizs.get(i).nomQuiz;
            int dureeQuiz = listOfQuizs.get(i).dureeQuiz;
            List<QuestionPropositionsReponses> listQuestionPropositionsReponses = listOfQuizs.get(i).listQuestionPropositionsReponses;

            System.out.println("Nom du Quiz :" + nomQuiz);
            System.out.println("Duree du Quiz :" + dureeQuiz + "\n");


            for (int j = 0; j < listQuestionPropositionsReponses.size(); j++) {
                String enonceQuestion = listQuestionPropositionsReponses.get(j).question;
                List<String> listPropositions = listQuestionPropositionsReponses.get(j).propositions; //changer nom en list propo
                List<String> listReponses = listQuestionPropositionsReponses.get(j).reponses;//changer en liste rep

                System.out.println("question " + (j + 1) + " : " + enonceQuestion);
                System.out.println("Propositions :");
                for (int k = 0; k < listPropositions.size(); k++) {
                    System.out.println(listPropositions.get(k));
                }
                System.out.println("Reponses :");
                System.out.println();
                for (int k = 0; k < listReponses.size(); k++) {
                    System.out.println(listReponses.get(k));
                }
            }
        }

    }
}




















































