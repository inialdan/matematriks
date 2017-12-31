package aldan.apps.matematriks;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

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

public class QuizTest extends AppCompatActivity {
    TextView mtvSkor, mtvSoal;
    RadioGroup mrgPilihanJawaban;
    RadioButton mrbPilihanJawaban1, mrbPilihanJawaban2, mrbPilihanJawaban3;
    Button mbtnSubmit;
    List<Integer> randomList;
    int skor = 0;
    int arr;
    int x;
    String jawaban;

    SoalPGController soalPG = new SoalPGController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_quiz_test);

        mtvSkor = findViewById(R.id.tvSkor);
        mtvSoal = findViewById(R.id.tvSoal);
        mrgPilihanJawaban = findViewById(R.id.rgPilihanJawaban);
        mrbPilihanJawaban1 = findViewById(R.id.rbPilihanJawaban1);
        mrbPilihanJawaban2 = findViewById(R.id.rbPilihanJawaban2);
        mrbPilihanJawaban3 = findViewById(R.id.rbPilihanJawaban3);
        mbtnSubmit = findViewById(R.id.btnSubmit);

        mtvSkor.setText("" + skor);
        setKonten();

        mbtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cekJawaban();
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
            Intent i = new Intent(QuizTest.this, HasilSkor.class);
            i.putExtra("skorAkhir",jumlahSkor);
            i.putExtra("activity","PilihanGanda");
            startActivity(i);
        }else{
            int No = x + 1;
            mtvSoal.setText(No + ". " + soalPG.getQuestion(randomList.get(x)));
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
                skor = skor + 10;
                mtvSkor.setText("" + skor);
                Toast.makeText(this, "Jawaban Benar", Toast.LENGTH_SHORT).show();
                setKonten();
            }else{
                mtvSkor.setText("" + skor);
                Toast.makeText(this, "Jawaban Salah", Toast.LENGTH_SHORT).show();
                setKonten();
            }
        }else if(mrbPilihanJawaban2.isChecked()){
            if(mrbPilihanJawaban2.getText().toString().equals(jawaban)){
                skor = skor + 10;
                mtvSkor.setText("" + skor);
                Toast.makeText(this, "Jawaban Benar", Toast.LENGTH_SHORT).show();
                setKonten(); //update next konten
            }else{
                mtvSkor.setText("" + skor);
                Toast.makeText(this, "Jawaban Salah", Toast.LENGTH_SHORT).show();
                setKonten();
            }
        }else if(mrbPilihanJawaban3.isChecked()){
            if(mrbPilihanJawaban3.getText().toString().equals(jawaban)){
                skor = skor + 10;
                mtvSkor.setText("" + skor);
                Toast.makeText(this, "Jawaban Benar", Toast.LENGTH_SHORT).show();
                setKonten(); //update next konten
            }else{
                mtvSkor.setText("" + skor);
                Toast.makeText(this, "Jawaban Salah", Toast.LENGTH_SHORT).show();
                setKonten();
            }
        }else{
            Toast.makeText(this, "Silahkan Pilih Jawaban dulu!", Toast.LENGTH_SHORT).show();
        }
    }

    public void onBackPressed(){
        Toast.makeText(this, "Selesaikan kuis, jangan kabur!", Toast.LENGTH_SHORT).show();
    }
}
