package aldan.apps.matematriks.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import java.util.HashMap;

import aldan.apps.matematriks.QuizTest;
import aldan.apps.matematriks.R;
import aldan.apps.matematriks.SoalPGController;
import aldan.apps.matematriks.activity.menu.belajar.belajar_determinan;
import aldan.apps.matematriks.activity.menu.belajar.belajar_matriks;
import aldan.apps.matematriks.activity.menu.belajar.belajar_minor;
import aldan.apps.matematriks.session.PrefManager;

import static aldan.apps.matematriks.R.drawable.icon_checked_finish;

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
public class BelajarFragment extends Fragment {

    private static final String TAG = BelajarFragment.class.getSimpleName();
    View RootView;
    private SliderLayout sliderLayout;
    private PrefManager prefManager;
    ProgressBar progressBarScore;
    TextView textScore;
    ImageView statusBelajarMatriks, statusBelajarDeterminan, statusBelajarMinor;
    Handler progressHandler = new Handler();
    int i = 0;

    public BelajarFragment() {
        // Required empty public constructor
    }

    public static BelajarFragment newInstance(String param1, String param2) {
        BelajarFragment fragment = new BelajarFragment();
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
        RootView = inflater.inflate(R.layout.menu_belajar, container, false);
        setHasOptionsMenu(true);

        initView();
        sliderLayout();

        prefManager = new PrefManager(getActivity());
        String ScoreMatriks = prefManager.getScoreBelajarMatriks();
        String ScoreDeterminan = prefManager.getScoreBelajarDeterminan();
        String ScoreMinor = prefManager.getScoreBelajarMinor();

//        Toast.makeText(getActivity(), ScoreDeterminan, Toast.LENGTH_SHORT).show();

        if (ScoreMatriks == ""){
            ScoreMatriks = "0";
        }else{
            statusBelajarMatriks.setImageDrawable(getResources().getDrawable(R.drawable.icon_checked_finish));
        }

        if (ScoreDeterminan == ""){
            ScoreDeterminan = "0";
        }else{
            statusBelajarDeterminan.setImageDrawable(getResources().getDrawable(R.drawable.icon_checked_finish));
        }

        if (ScoreMinor == ""){
            ScoreMinor = "0";
        }else{
            statusBelajarMinor.setImageDrawable(getResources().getDrawable(R.drawable.icon_checked_finish));
        }
        final Integer Matriks = Integer.parseInt(ScoreMatriks);
        final Integer Determinan = Integer.parseInt(ScoreDeterminan);
        final Integer Minor = Integer.parseInt(ScoreMinor);
        final Integer theScore = Matriks + Determinan + Minor;

        new Thread(new Runnable() {
            public void run() {
                while (i < theScore) {
                    i += 5;
                    progressHandler.post(new Runnable() {
                        public void run() {
                            progressBarScore.setProgress(i);
                            textScore.setText("" + i + " %");
                        }
                    });
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        return RootView;
    }

    public void initView(){
        progressBarScore = RootView.findViewById(R.id.progressBarScore);
        textScore = RootView.findViewById(R.id.textScore);
        statusBelajarMatriks = RootView.findViewById(R.id.statusBelajarMatriks);
        statusBelajarDeterminan = RootView.findViewById(R.id.statusBelajarDeterminan);
        statusBelajarMinor = RootView.findViewById(R.id.statusBelajarMinor);

        RootView.findViewById(R.id.menu_belajar_matriks).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), belajar_matriks.class));
            }
        });

        RootView.findViewById(R.id.menu_belajar_determinan).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), belajar_determinan.class));
            }
        });

        RootView.findViewById(R.id.menu_belajar_minor).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), belajar_minor.class));
            }
        });

    }

    public void sliderLayout(){
        sliderLayout = (SliderLayout) RootView.findViewById(R.id.slider);
        // Load image dari URL
        //        HashMap<String,String> url_maps = new HashMap<String, String>();
        //        url_maps.put("Hannibal", "pict");
        //        url_maps.put("Big Bang Theory", "pict");
        //        url_maps.put("House of Cards", "pict");
        //        url_maps.put("Game of Thrones", "pict");
        // Load Image Dari res/drawable
        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("“I hate Maths, But i love counting money.” \n" +
                        "- Me\n",
                R.drawable.slideshow_phone);
        file_maps.put("“Physics depends on a universe infinitely centred on an equals sign.” \n" +
                        "- Mark Z. Danielewski, House of Leaves\n",
                R.drawable.slideshow_calculator);
        file_maps.put("“I had a polynomial once. My doctor removed it.” \n" + "― Michael Grant, Gone\n",
                R.drawable.slideshow_chalk);
        file_maps.put("“Since the mathematicians have invaded the theory of relativity I do not understand it myself any more.” \n" +
                        "- Albert Einstein\n",
                R.drawable.slideshow_teacher);
        for(String name : file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(getActivity());
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit);
            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle().putString("extra",name);
            sliderLayout.addSlider(textSliderView);
        }
        sliderLayout.setPresetTransformer(SliderLayout.Transformer.Accordion);
        sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        sliderLayout.setCustomAnimation(new DescriptionAnimation());
        sliderLayout.setDuration(5000);
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}