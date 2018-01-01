package aldan.apps.matematriks;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

public class ScoreResults extends AppCompatActivity {

    private static TextView mtvHasilAkhir;
    private static ImageView Piala,StarLeft,StarRight;
    private PrefManager prefManager;
    Button mbtnMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_hasil_skor);

        prefManager = new PrefManager(this);

        mtvHasilAkhir = findViewById(R.id.tvSkorAkhir);
        mbtnMenu = findViewById(R.id.btnMenu);
        Piala = findViewById(R.id.Piala);
        StarLeft = findViewById(R.id.StarLeft);
        StarRight = findViewById(R.id.StarRight);

        setSkor();

        mbtnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ScoreResults.this, Main.class);
                startActivity(i);
            }
        });
    }

    public void setSkor(){
        String activity = getIntent().getStringExtra("activity");
        String skorPilGan = getIntent().getStringExtra("skorAkhirPG");
        String skorEssay = getIntent().getStringExtra("skorAkhirEssay");
        int scoreMultipleChose = Integer.parseInt(skorPilGan);

        if (scoreMultipleChose == 100){
            Piala.setImageDrawable(getResources().getDrawable(R.drawable.icon_pialaon));
            StarLeft.setImageDrawable(getResources().getDrawable(R.drawable.icon_leftstaron));
            StarRight.setImageDrawable(getResources().getDrawable(R.drawable.icon_rightstaron));
        }else if (scoreMultipleChose >= 80){
            Piala.setImageDrawable(getResources().getDrawable(R.drawable.icon_pialaon));
            StarLeft.setImageDrawable(getResources().getDrawable(R.drawable.icon_leftstaron));
        }else if(scoreMultipleChose >= 60){
            Piala.setImageDrawable(getResources().getDrawable(R.drawable.icon_pialaon));
        }else{
            mtvHasilAkhir.setTextColor(getResources().getColor(R.color.red_primary));
        }

        if(activity.equals("PilihanGanda")){
            mtvHasilAkhir.setText(skorPilGan);
            Integer skor = Integer.parseInt(skorPilGan);
            if (skor >= 60){
                prefManager.saveSPString(prefManager.SCORE_MULTIPLE_CHOISE, skorPilGan);
            }
        }else{
            mtvHasilAkhir.setText(skorEssay);
        }
    }

    public void onBackPressed(){
        Toast.makeText(this, "Tidak bisa kembali, silahkan tekan menu", Toast.LENGTH_SHORT).show();
    }
}
