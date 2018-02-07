package aldan.apps.matematriks.controller;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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

public class MultipleChoiseMatriks extends AppCompatActivity {
    TextView mtvSkor, mtvSoal, mtvNumbering;
    RadioGroup mrgPilihanJawaban;
    RadioButton mrbPilihanJawaban1, mrbPilihanJawaban2, mrbPilihanJawaban3;
    TextView fontSmall, fontMedium, fontLarge;
    Button mbtnSubmit;
    List<Integer> randomList;
    int skor = 0;
    int arr;
    int x;
    String jawaban;

    MultipleChoiseController soalPG = new MultipleChoiseController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_quiz_test);

        mtvSkor = findViewById(R.id.tvSkor);
        mtvSoal = findViewById(R.id.tvSoal);
        mtvNumbering = findViewById(R.id.tvNumberSoal);
        mrgPilihanJawaban = findViewById(R.id.rgPilihanJawaban);
        mrbPilihanJawaban1 = findViewById(R.id.rbPilihanJawaban1);
        mrbPilihanJawaban2 = findViewById(R.id.rbPilihanJawaban2);
        mrbPilihanJawaban3 = findViewById(R.id.rbPilihanJawaban3);

        fontSmall = findViewById(R.id.small);
        fontMedium = findViewById(R.id.medium);
        fontLarge = findViewById(R.id.large);

        mbtnSubmit = findViewById(R.id.btnSubmit);

        mtvSkor.setText("" + skor);
        setKonten();
        setFont();

        mbtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cekJawaban();
            }
        });
    }

    public void setFont(){
        findViewById(R.id.small).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mtvSoal.setTextSize(18);
                fontSmall.setTypeface(Typeface.DEFAULT_BOLD);
                fontMedium.setTypeface(Typeface.DEFAULT);
                fontLarge.setTypeface(Typeface.DEFAULT);
                fontSmall.setTextColor(getResources().getColor(R.color.black));
                fontMedium.setTextColor(getResources().getColor(R.color.white));
                fontLarge.setTextColor(getResources().getColor(R.color.white));
            }
        });

        findViewById(R.id.medium).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mtvSoal.setTextSize(22);
                fontSmall.setTypeface(Typeface.DEFAULT);
                fontMedium.setTypeface(Typeface.DEFAULT_BOLD);
                fontLarge.setTypeface(Typeface.DEFAULT);
                fontSmall.setTextColor(getResources().getColor(R.color.white));
                fontMedium.setTextColor(getResources().getColor(R.color.black));
                fontLarge.setTextColor(getResources().getColor(R.color.white));
            }
        });

        findViewById(R.id.large).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mtvSoal.setTextSize(25);
                fontSmall.setTypeface(Typeface.DEFAULT);
                fontMedium.setTypeface(Typeface.DEFAULT);
                fontLarge.setTypeface(Typeface.DEFAULT_BOLD);
                fontSmall.setTextColor(getResources().getColor(R.color.white));
                fontMedium.setTextColor(getResources().getColor(R.color.white));
                fontLarge.setTextColor(getResources().getColor(R.color.black));
            }
        });
    }
    public void setKonten(){
        mrgPilihanJawaban.clearCheck();
        arr = soalPG.Question.length;
        int Question = 5;
        if (x == 0) {
            randomList = new ArrayList<>();
            for (int i = 0; i < arr; i++) randomList.add(i);
            java.util.Collections.shuffle(randomList);
        }
        if(x >= Question){
            String jumlahSkor = String.valueOf(skor);
            Intent i = new Intent(MultipleChoiseMatriks.this, ScoreController.class);
            i.putExtra("skorAkhirPG",jumlahSkor);
            i.putExtra("activity","PilihanGanda");
            startActivity(i);
        }else{
            int No = x + 1;
            mtvNumbering.setText(No + " dari " + Question);
            mtvSoal.setText(No + ".) " + soalPG.getQuestion(randomList.get(x)));
            mrbPilihanJawaban1.setText(soalPG.getmultipleChoice1(randomList.get(x)));
            mrbPilihanJawaban2.setText(soalPG.getmultipleChoice2(randomList.get(x)));
            mrbPilihanJawaban3.setText(soalPG.getmultipleChoice3(randomList.get(x)));
            jawaban = soalPG.getAnswer(randomList.get(x));
        }
        x++;
    }

    public void cekJawaban(){
        if(mrbPilihanJawaban1.isChecked()){
            if(mrbPilihanJawaban1.getText().toString().equals(jawaban)){
                skor = skor + 20;
                mtvSkor.setText("" + skor);
                if (Build.VERSION.SDK_INT >= 21) {
                    TastyToast.makeText(this, "Jawaban Benar", TastyToast.LENGTH_SHORT, TastyToast.SUCCESS);
                }else{
                    Toast.makeText(this, "Jawaban Benar", Toast.LENGTH_SHORT).show();
                }
                setKonten();
            }else{
                mtvSkor.setText("" + skor);
                if (Build.VERSION.SDK_INT >= 21) {
                    TastyToast.makeText(this, "Jawaban Salah", TastyToast.LENGTH_SHORT, TastyToast.ERROR);
                }else{
                    Toast.makeText(this, "Jawaban Salah", Toast.LENGTH_SHORT).show();
                }
                setKonten();
            }
        }else if(mrbPilihanJawaban2.isChecked()){
            if(mrbPilihanJawaban2.getText().toString().equals(jawaban)){
                skor = skor + 20;
                mtvSkor.setText("" + skor);
                if (Build.VERSION.SDK_INT >= 21) {
                    TastyToast.makeText(this, "Jawaban Benar", TastyToast.LENGTH_SHORT, TastyToast.SUCCESS);
                }else{
                    Toast.makeText(this, "Jawaban Benar", Toast.LENGTH_SHORT).show();
                }
                setKonten();
            }else{
                mtvSkor.setText("" + skor);
                if (Build.VERSION.SDK_INT >= 21) {
                    TastyToast.makeText(this, "Jawaban Salah", TastyToast.LENGTH_SHORT, TastyToast.ERROR);
                }else{
                    Toast.makeText(this, "Jawaban Salah", Toast.LENGTH_SHORT).show();
                }
                setKonten();
            }
        }else if(mrbPilihanJawaban3.isChecked()){
            if(mrbPilihanJawaban3.getText().toString().equals(jawaban)){
                skor = skor + 20;
                mtvSkor.setText("" + skor);
                if (Build.VERSION.SDK_INT >= 21) {
                    TastyToast.makeText(this, "Jawaban Benar", TastyToast.LENGTH_SHORT, TastyToast.SUCCESS);
                }else{
                    Toast.makeText(this, "Jawaban Benar", Toast.LENGTH_SHORT).show();
                }
                setKonten();
            }else{
                mtvSkor.setText("" + skor);
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