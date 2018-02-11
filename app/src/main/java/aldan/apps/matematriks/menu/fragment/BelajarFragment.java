package aldan.apps.matematriks.menu.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.akexorcist.roundcornerprogressbar.IconRoundCornerProgressBar;
import com.akexorcist.roundcornerprogressbar.RoundCornerProgressBar;
import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import java.util.HashMap;

import aldan.apps.matematriks.R;
import aldan.apps.matematriks.menu.activity.menu.belajar.belajar_determinan_matriks;
import aldan.apps.matematriks.menu.activity.menu.belajar.belajar_jenis_matriks;
import aldan.apps.matematriks.menu.activity.menu.belajar.belajar_kesamaan_matriks;
import aldan.apps.matematriks.menu.activity.menu.belajar.belajar_matriks;
import aldan.apps.matematriks.menu.activity.menu.belajar.belajar_minor_matriks;
import aldan.apps.matematriks.menu.activity.menu.belajar.belajar_ordo_matriks;
import aldan.apps.matematriks.menu.activity.menu.belajar.belajar_perkalian_matriks;
import aldan.apps.matematriks.menu.activity.menu.belajar.belajar_pertambahan_pengurangan_matriks;
import aldan.apps.matematriks.menu.activity.menu.belajar.belajar_transpos_matriks;
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
public class BelajarFragment extends Fragment {

    private static final String TAG = BelajarFragment.class.getSimpleName();
    private static RoundCornerProgressBar progressBarScore;
    private static TextView textScoreKonsep;
    private static ImageView statusBelajarMatriks,
            statusBelajarOrdo,
            statusBelajarJenisMatriks,
            statusBelajarTranspos,
            statusBelajarDeterminan,
            statusBelajarMinor,
            statusBelajarKesamaanMatriks,
            statusBelajarPertambahanPengurangan,
            statusBelajarPerkalian;
    private SliderLayout sliderLayout;
    private PrefManager prefManager;
    Handler progressHandler = new Handler();
    View RootView;
    int i = 0;

    public BelajarFragment() {

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
        progressScore();

        return RootView;
    }

    @SuppressLint("ResourceAsColor")
    public void progressScore(){
        prefManager = new PrefManager(getActivity());

        String ScoreMatriks = prefManager.getScoreBelajarMatriks();
        String ScoreOrdo = prefManager.getScoreBelajarOrdoMatriks();
        String ScoreJenisMatriks = prefManager.getScoreBelajarJenisMatriks();
        String ScoreTranspos = prefManager.getScoreBelajarTranspos();
        String ScoreKesamaanMatriks = prefManager.getScoreBelajarKesamaanMatriks();
        String ScorePertambahanPengurangan = prefManager.getScoreBelajarPertambahanPenguranganMatriks();
        String ScorePerkalian = prefManager.getScoreBelajarPerkalianMatriks();
        String ScoreDeterminan = prefManager.getScoreBelajarDeterminan();
        String ScoreMinor = prefManager.getScoreBelajarMinor();

        if (ScoreMatriks == "") ScoreMatriks = "0";
        else statusBelajarMatriks.setImageDrawable(getResources().getDrawable(R.drawable.icon_checked_finish));

        if (ScoreOrdo == "") ScoreOrdo = "0";
        else statusBelajarOrdo.setImageDrawable(getResources().getDrawable(R.drawable.icon_checked_finish));

        if (ScoreJenisMatriks == "") ScoreJenisMatriks = "0";
        else statusBelajarJenisMatriks.setImageDrawable(getResources().getDrawable(R.drawable.icon_checked_finish));

        if (ScoreTranspos == "") ScoreTranspos = "0";
        else statusBelajarTranspos.setImageDrawable(getResources().getDrawable(R.drawable.icon_checked_finish));

        if (ScoreKesamaanMatriks == "") ScoreKesamaanMatriks = "0";
        else statusBelajarKesamaanMatriks.setImageDrawable(getResources().getDrawable(R.drawable.icon_checked_finish));

        if (ScorePertambahanPengurangan == "") ScorePertambahanPengurangan = "0";
        else statusBelajarPertambahanPengurangan.setImageDrawable(getResources().getDrawable(R.drawable.icon_checked_finish));

        if (ScorePerkalian == "") ScorePerkalian = "0";
        else statusBelajarPerkalian.setImageDrawable(getResources().getDrawable(R.drawable.icon_checked_finish));

        if (ScoreDeterminan == "") ScoreDeterminan = "0";
        else statusBelajarDeterminan.setImageDrawable(getResources().getDrawable(R.drawable.icon_checked_finish));

        if (ScoreMinor == "") ScoreMinor = "0";
        else statusBelajarMinor.setImageDrawable(getResources().getDrawable(R.drawable.icon_checked_finish));

        final Integer Matriks = Integer.parseInt(ScoreMatriks);
        final Integer Ordo = Integer.parseInt(ScoreOrdo);
        final Integer JenisMatriks = Integer.parseInt(ScoreJenisMatriks);
        final Integer Transpose = Integer.parseInt(ScoreTranspos);
        final Integer KesamaanMatriks = Integer.parseInt(ScoreKesamaanMatriks);
        final Integer PertambahanPengurangan = Integer.parseInt(ScorePertambahanPengurangan);
        final Integer Perkalian = Integer.parseInt(ScorePerkalian);
        final Integer Determinan = Integer.parseInt(ScoreDeterminan);
        final Integer Minor = Integer.parseInt(ScoreMinor);
        Integer theScore = Matriks + Ordo + JenisMatriks + Transpose + KesamaanMatriks + PertambahanPengurangan + Perkalian + Determinan + Minor;

        float progress = progressBarScore.getProgress();
        if(progress <= 3) {
            progressBarScore.setProgressColor(getResources().getColor(R.color.colorPrimary));
        } else if(progress > 3 && progress <= 6) {
            progressBarScore.setProgressColor(getResources().getColor(R.color.color_yellow_button_denied));
        } else if(progress > 6) {
            progressBarScore.setProgressColor(getResources().getColor(R.color.color_green_circle));
        }

        progressBarScore.setProgressColor(Color.parseColor("#56d2c2"));
        progressBarScore.setProgressBackgroundColor(Color.parseColor("#757575"));
//        progressBarScore.setIconBackgroundColor(Color.parseColor("#38c0ae"));
//        progressBarScore.setIconImageResource(R.drawable.icon_bag);
        progressBarScore.setMax(10);
        final Integer finalTheScore = theScore / 10;
        new Thread(new Runnable() {
            public void run() {
                while (i < finalTheScore) {
                    i += 1;
                    progressHandler.post(new Runnable() {
                        public void run() {
                            progressBarScore.setProgress(i);
                            textScoreKonsep.setText("" + i + "/10");
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
    }

    public void initView(){
        progressBarScore = RootView.findViewById(R.id.progressBarScore);
        textScoreKonsep = RootView.findViewById(R.id.textViewScoreKonsep);
        statusBelajarMatriks = RootView.findViewById(R.id.statusBelajarMatriks);
        statusBelajarOrdo = RootView.findViewById(R.id.statusBelajarOrdoMatriks);
        statusBelajarTranspos = RootView.findViewById(R.id.statusBelajarTranspos);
        statusBelajarJenisMatriks = RootView.findViewById(R.id.statusBelajarJenisMatriks);
        statusBelajarPertambahanPengurangan = RootView.findViewById(R.id.statusBelajarPertambahanPengurangan);
        statusBelajarPerkalian = RootView.findViewById(R.id.statusBelajarPerkalianMatriks);
        statusBelajarDeterminan = RootView.findViewById(R.id.statusBelajarDeterminan);
        statusBelajarMinor = RootView.findViewById(R.id.statusBelajarMinor);
        statusBelajarKesamaanMatriks = RootView.findViewById(R.id.statusBelajarKesamaanMatriks);

        RootView.findViewById(R.id.menu_belajar_matriks).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), belajar_matriks.class));
            }
        });

        RootView.findViewById(R.id.menu_belajar_ordo_matriks).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), belajar_ordo_matriks.class));
            }
        });

        RootView.findViewById(R.id.menu_belajar_jenis_matriks).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), belajar_jenis_matriks.class));
            }
        });

        RootView.findViewById(R.id.menu_belajar_transpos_matriks).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), belajar_transpos_matriks.class));
            }
        });

        RootView.findViewById(R.id.menu_belajar_kesamaan_matriks).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), belajar_kesamaan_matriks.class));
            }
        });

        RootView.findViewById(R.id.menu_belajar_pertambahan_pengurangan_matriks).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), belajar_pertambahan_pengurangan_matriks.class));
            }
        });

        RootView.findViewById(R.id.menu_belajar_perkalian_matriks).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), belajar_perkalian_matriks.class));
            }
        });

        RootView.findViewById(R.id.menu_belajar_determinan_matriks).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), belajar_determinan_matriks.class));
            }
        });

        RootView.findViewById(R.id.menu_belajar_minor_matriks).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), belajar_minor_matriks.class));
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