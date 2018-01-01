package aldan.apps.matematriks.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import aldan.apps.matematriks.QuizMatriks;
import aldan.apps.matematriks.R;
import aldan.apps.matematriks.activity.menu.latihan.latihan_determinan;
import aldan.apps.matematriks.session.PrefManager;

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
    private static ImageView statusQuizMultipleChoise;
    private PrefManager prefManager;
    View RootView;

    public LatihanFragment() {
        // Required empty public constructor
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

        String ScoreMultipleChoiseQuiz = prefManager.getScoreMultipleChoise();

        if (ScoreMultipleChoiseQuiz == ""){
            ScoreMultipleChoiseQuiz = "0";
        }

        Integer MultipleChoiseQuiz = Integer.parseInt(ScoreMultipleChoiseQuiz);

        if (MultipleChoiseQuiz >= 60){
            statusQuizMultipleChoise.setImageDrawable(getResources().getDrawable(R.drawable.icon_checked_finish));
        }

        return RootView;
    }

    public void initView(){

        statusQuizMultipleChoise = RootView.findViewById(R.id.statusQuizMultipleChoise);

        RootView.findViewById(R.id.menu_latihan_quiz).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), QuizMatriks.class));
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