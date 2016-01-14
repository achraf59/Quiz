package premiereapplication.testautomation.quiz.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import premiereapplication.testautomation.quiz.QuizAplication;
import premiereapplication.testautomation.quiz.R;
import premiereapplication.testautomation.quiz.objects.ObjetQuiz;


public class ListQuizsAdapter extends BaseAdapter {

    public final List<ObjetQuiz> listObjetQuizs;
    private LayoutInflater mLayoutInflater;

    public ListQuizsAdapter(List<ObjetQuiz> listObjetQuizs) {
        this.listObjetQuizs=listObjetQuizs;
        mLayoutInflater=LayoutInflater.from(QuizAplication.getContext());

    }

    @Override
    public int getCount() {
        return null!= listObjetQuizs ? listObjetQuizs.size():0 ;
    }

    @Override
    public Object getItem(int position) {
        return null!= listObjetQuizs ? listObjetQuizs.get(position):null ;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if(null==convertView){
            convertView=mLayoutInflater.inflate(R.layout.layout_items_of_quizs_listview,null);
            holder=new ViewHolder(convertView);
            convertView.setTag(holder);
        }

        else{
            holder=(ViewHolder) convertView.getTag();

        }

        final View view =mLayoutInflater.inflate(R.layout.layout_items_of_quizs_listview,null);
        final ObjetQuiz objetQuiz=(ObjetQuiz) getItem(position);


        holder.nomQuiz.setText(objetQuiz.nomQuiz);
        holder.dureeQuiz.setText(objetQuiz.dureeQuiz+" sec");


        return convertView;
    }


    private class ViewHolder {

        private TextView nomQuiz;
        private TextView dureeQuiz;
        private ImageView imageQuiz;


        public ViewHolder(View view){
            nomQuiz=(TextView) view.findViewById(R.id.nomQuizLaunchedTextView);
            dureeQuiz=(TextView) view.findViewById(R.id.dureeQuizLaunchedTextView);
            imageQuiz=(ImageView) view.findViewById(R.id.quizImageView);


        }
    }



}
