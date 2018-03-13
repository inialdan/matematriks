package aldan.apps.matematriks.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import aldan.apps.matematriks.Main;
import aldan.apps.matematriks.R;
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

public class ScoreController extends AppCompatActivity {

    private static TextView mtvHasilAkhir, Motivation;
    private static ImageView Piala,StarLeft,StarRight;
    private PrefManager prefManager;
    Button mbtnMenu, mbtnRetry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_hasil_skor);

        prefManager = new PrefManager(this);

        mtvHasilAkhir = findViewById(R.id.tvSkorAkhir);
        Motivation = findViewById(R.id.tvMotivation);
        mbtnMenu = findViewById(R.id.btnMenu);
        mbtnRetry = findViewById(R.id.btnRetry);
        Piala = findViewById(R.id.Piala);
        StarLeft = findViewById(R.id.StarLeft);
        StarRight = findViewById(R.id.StarRight);

        setSkor();

        mbtnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ScoreController.this, Main.class);
                startActivity(i);
            }
        });
    }

    public void setSkor() {
        String activity = getIntent().getStringExtra("activity");

        if (activity.equals("PilihanGanda")) {
            int scoreMultipleChose = 0;
            String skorPilGan = getIntent().getStringExtra("skorAkhirPG");
            scoreMultipleChose = Integer.parseInt(skorPilGan);
            if (scoreMultipleChose == 100) {
                Piala.setImageDrawable(getResources().getDrawable(R.drawable.icon_pialaon));
                StarLeft.setImageDrawable(getResources().getDrawable(R.drawable.icon_leftstaron));
                StarRight.setImageDrawable(getResources().getDrawable(R.drawable.icon_rightstaron));
                Motivation.setText(getResources().getString(R.string.motivation_100));
                Motivation.setTextColor(getResources().getColor(R.color.green));
            } else if (scoreMultipleChose >= 80) {
                Piala.setImageDrawable(getResources().getDrawable(R.drawable.icon_pialaon));
                StarLeft.setImageDrawable(getResources().getDrawable(R.drawable.icon_leftstaron));
                Motivation.setText(getResources().getString(R.string.motivation_80));
                Motivation.setTextColor(getResources().getColor(R.color.green));
            } else if (scoreMultipleChose >= 60) {
                Piala.setImageDrawable(getResources().getDrawable(R.drawable.icon_pialaon));
                Motivation.setText(getResources().getString(R.string.motivation_60));
            } else {
                mtvHasilAkhir.setTextColor(getResources().getColor(R.color.red_primary));
                Motivation.setText(getResources().getString(R.string.motivation_0));
            }

            mtvHasilAkhir.setText(skorPilGan);
            Integer valuePG = Integer.parseInt(skorPilGan);
            if (valuePG >= 60) {
                prefManager.saveSPString(prefManager.SCORE_MULTIPLE_CHOISE, skorPilGan);
            }

            prefManager.saveSPString(prefManager.SCORE_LAST, skorPilGan);

            mbtnRetry.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(ScoreController.this, MultipleChoiseMatriks.class);
                    startActivity(i);
                }
            });

        } else if (activity.equals("Essay")){
            int scoreEssay = 0;
            String skorEssay = getIntent().getStringExtra("skorAkhirEssay");
            scoreEssay = Integer.parseInt(skorEssay);
            if (scoreEssay == 100) {
                Piala.setImageDrawable(getResources().getDrawable(R.drawable.icon_pialaon));
                StarLeft.setImageDrawable(getResources().getDrawable(R.drawable.icon_leftstaron));
                StarRight.setImageDrawable(getResources().getDrawable(R.drawable.icon_rightstaron));
                Motivation.setText(getResources().getString(R.string.motivation_100));
                Motivation.setTextColor(getResources().getColor(R.color.green));
            } else if (scoreEssay >= 80) {
                Piala.setImageDrawable(getResources().getDrawable(R.drawable.icon_pialaon));
                StarLeft.setImageDrawable(getResources().getDrawable(R.drawable.icon_leftstaron));
                Motivation.setText(getResources().getString(R.string.motivation_80));
                Motivation.setTextColor(getResources().getColor(R.color.green));
            } else if (scoreEssay >= 60) {
                Piala.setImageDrawable(getResources().getDrawable(R.drawable.icon_pialaon));
                Motivation.setText(getResources().getString(R.string.motivation_60));
            } else {
                mtvHasilAkhir.setTextColor(getResources().getColor(R.color.red_primary));
                Motivation.setText(getResources().getString(R.string.motivation_0));
            }

            mtvHasilAkhir.setText(skorEssay);
            Integer valueEssay = Integer.parseInt(skorEssay);
            if (valueEssay >= 60) {
                prefManager.saveSPString(prefManager.SCORE_ESSAY, skorEssay);
            }

            prefManager.saveSPString(prefManager.SCORE_LAST, skorEssay);

            mbtnRetry.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(ScoreController.this, EssayMatriks.class);
                    startActivity(i);
                }
            });
        }

    }

    public void onBackPressed(){
        Toast.makeText(this, "Tidak bisa kembali, silahkan tekan menu", Toast.LENGTH_SHORT).show();
    }
}
