package premiereapplication.testautomation.quiz.objects;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;


public class ObjetQuiz implements Parcelable {

public String nomQuiz;
public int dureeQuiz;
public List<QuestionPropositionsReponses> listQuestionPropositionsReponses;

    public ObjetQuiz(String nomQuiz,int dureeQuiz,List<QuestionPropositionsReponses> listQuestionPropositionsReponses){

    this.nomQuiz=nomQuiz;
    this.dureeQuiz=dureeQuiz;
    this.listQuestionPropositionsReponses=listQuestionPropositionsReponses;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nomQuiz);
        dest.writeInt(this.dureeQuiz);
        dest.writeList(this.listQuestionPropositionsReponses);
    }

    protected ObjetQuiz(Parcel in) {
        this.nomQuiz = in.readString();
        this.dureeQuiz = in.readInt();
        this.listQuestionPropositionsReponses = new ArrayList<QuestionPropositionsReponses>();
        in.readList(this.listQuestionPropositionsReponses, List.class.getClassLoader());
    }

    public static final Parcelable.Creator<ObjetQuiz> CREATOR = new Parcelable.Creator<ObjetQuiz>() {
        public ObjetQuiz createFromParcel(Parcel source) {
            return new ObjetQuiz(source);
        }

        public ObjetQuiz[] newArray(int size) {
            return new ObjetQuiz[size];
        }
    };











}
