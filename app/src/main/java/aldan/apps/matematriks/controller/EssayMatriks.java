package aldan.apps.matematriks.controller;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sdsmdg.tastytoast.TastyToast;

import java.util.ArrayList;
import java.util.List;

import aldan.apps.matematriks.R;

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

public class EssayMatriks extends AppCompatActivity {
    TextView mtvSkor2,mtvSoal2;
    ImageView mivGambar;
    EditText medtJawaban;
    Button mbtnSubmit2;
    int x=0;
    int arr;
    int skor;
    String jawaban;
    List<Integer> randomList;

    EssayController essay = new EssayController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_quiz_essay);

        mtvSkor2 = findViewById(R.id.tvSkor2);
        mtvSoal2 = findViewById(R.id.tvSoal2);
        mivGambar = findViewById(R.id.ivGambar);
        medtJawaban = findViewById(R.id.edtJawaban);
        mbtnSubmit2 = findViewById(R.id.btnSubmit2);

        setKonten();

        mbtnSubmit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cekJawaban();
            }
        });
    }

    public void setKonten(){
        medtJawaban.setText(null);
        arr = essay.pertanyaan.length;
        int Question = 5;
        if (x == 0) {
            randomList = new ArrayList<>();
            for (int i = 0; i < arr; i++) randomList.add(i);
            java.util.Collections.shuffle(randomList);
        }
        if(x >= Question){
            String jumlahSkor = String.valueOf(skor);
            Intent i = new Intent(EssayMatriks.this, ScoreController.class);
            i.putExtra("skorAkhirEssay",jumlahSkor);
            i.putExtra("activity","Essay");
            startActivity(i);
        }else{
            int No = x + 1;
            mtvSoal2.setText(essay.getPertanyaan(x));
            changeContentPict();
            jawaban = essay.getJawabanBenar(x);
        }
        x++;
    }

    public void changeContentPict(){
        Resources res = getResources();
        String mPhoto = essay.getStringGambar(x);
        int resID = res.getIdentifier(mPhoto, "drawable", getPackageName());
        Drawable drawable = res.getDrawable(resID);
        mivGambar.setImageDrawable(drawable);
    }

    public void cekJawaban(){
        if(!medtJawaban.getText().toString().isEmpty()){
            if(medtJawaban.getText().toString().equalsIgnoreCase(jawaban)){
                skor = skor + 10;
                mtvSkor2.setText(""+skor);
                if (Build.VERSION.SDK_INT >= 21) {
                    TastyToast.makeText(this, "Jawaban Benar", TastyToast.LENGTH_SHORT, TastyToast.SUCCESS);
                }else{
                    Toast.makeText(this, "Jawaban Benar", Toast.LENGTH_SHORT).show();
                }
                setKonten();
            }else{
                mtvSkor2.setText(""+skor);
                if (Build.VERSION.SDK_INT >= 21) {
                    TastyToast.makeText(this, "Jawaban Salah", TastyToast.LENGTH_SHORT, TastyToast.ERROR);
                }else{
                    Toast.makeText(this, "Jawaban Salah", Toast.LENGTH_SHORT).show();
                }
                setKonten();
            }
        }else{
            if (Build.VERSION.SDK_INT >= 21) {
                TastyToast.makeText(this, "Ayo Coba! Kamu belum jawab soal", TastyToast.LENGTH_SHORT, TastyToast.WARNING);
            }else{
                Toast.makeText(this, "Ayo Coba! Kamu belum jawab soal", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void onBackPressed(){
        if (Build.VERSION.SDK_INT >= 21) {
            TastyToast.makeText(this, "Selesaikan Quiz, Jangan Kabur", TastyToast.LENGTH_SHORT, TastyToast.INFO).show();
        }else{
            Toast.makeText(this, "Selesaikan Quiz, Jangan Kabur", Toast.LENGTH_SHORT).show();
        }
    }
}