package aldan.apps.matematriks.menu.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import aldan.apps.matematriks.controller.EssayMatriks;
import aldan.apps.matematriks.controller.MultipleChoiseMatriks;
import aldan.apps.matematriks.R;
import aldan.apps.matematriks.menu.activity.menu.latihan.latihan_determinan;
import aldan.apps.matematriks.helper.session.PrefManager;

/*
 * Copyright 2017.  Aldan Rizki Santosa
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

@SuppressWarnings("deprecation")
public class LatihanFragment extends Fragment {

    private static final String TAG = LatihanFragment.class.getSimpleName();
    private static ImageView statusQuizMultipleChoise, statusQuizEssay;
    private PrefManager prefManager;
    private TextView textLastScore;
    private ImageView imagePiala, imageStarleft, imageStarright;
    View RootView;

    public LatihanFragment() {
    }

    public static LatihanFragment newInstance(String param1, String param2) {
        LatihanFragment fragment = new LatihanFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RootView = inflater.inflate(R.layout.menu_latihan, container, false);
        setHasOptionsMenu(true);
        initView();

        prefManager = new PrefManager(getActivity());

        String lastScore = prefManager.getLastScore();
        String ScoreMultipleChoiseQuiz = prefManager.getScoreMultipleChoise();
        String ScoreEssayQuiz = prefManager.getScoreEssay();

        if (lastScore.equals("")){
            lastScore = "0";
        }

        Integer ScoreLast = Integer.parseInt(lastScore);

        if (ScoreLast == 100) {
            imagePiala.setImageDrawable(getResources().getDrawable(R.drawable.icon_pialaon));
            imageStarleft.setImageDrawable(getResources().getDrawable(R.drawable.icon_leftstaron));
            imageStarright.setImageDrawable(getResources().getDrawable(R.drawable.icon_rightstaron));
        } else if (ScoreLast >= 80) {
            imagePiala.setImageDrawable(getResources().getDrawable(R.drawable.icon_pialaon));
            imageStarleft.setImageDrawable(getResources().getDrawable(R.drawable.icon_leftstaron));
        } else if (ScoreLast >= 60) {
            imagePiala.setImageDrawable(getResources().getDrawable(R.drawable.icon_pialaon));
        } else {
            textLastScore.setTextColor(getResources().getColor(R.color.red_primary));
        }

        if (ScoreLast == 0){
            textLastScore.setText("Kamu belum melakukan test apapun, ayo silahkan coba!");
        }else{
            textLastScore.setText("Skor Terakhir : " + ScoreLast);
        }

        if (ScoreMultipleChoiseQuiz == ""){
            ScoreMultipleChoiseQuiz = "0";
        }
        if (ScoreEssayQuiz == ""){
            ScoreEssayQuiz = "0";
        }

        Integer MultipleChoiseQuiz = Integer.parseInt(ScoreMultipleChoiseQuiz);
        Integer EssayQuiz = Integer.parseInt(ScoreEssayQuiz);

        if (MultipleChoiseQuiz >= 60){
            statusQuizMultipleChoise.setImageDrawable(getResources().getDrawable(R.drawable.icon_checked_finish));
        }

        if (EssayQuiz >= 60){
            statusQuizEssay.setImageDrawable(getResources().getDrawable(R.drawable.icon_checked_finish));
        }

        return RootView;
    }

    public void initView(){

        statusQuizMultipleChoise = RootView.findViewById(R.id.statusQuizMultipleChoise);
        statusQuizEssay = RootView.findViewById(R.id.statusQuizEssay);
        textLastScore = RootView.findViewById(R.id.textViewLastScore);
        imagePiala = RootView.findViewById(R.id.Piala);
        imageStarleft = RootView.findViewById(R.id.StarLeft);
        imageStarright = RootView.findViewById(R.id.StarRight);

        RootView.findViewById(R.id.menu_latihan_quiz_multiple).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), MultipleChoiseMatriks.class));
            }
        });

        RootView.findViewById(R.id.menu_latihan_quiz_essay).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), EssayMatriks.class));
            }
        });

        RootView.findViewById(R.id.menu_latihan_determinan).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), latihan_determinan.class));
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}