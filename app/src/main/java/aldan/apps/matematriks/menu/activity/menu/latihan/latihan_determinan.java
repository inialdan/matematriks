package inialdan.apps.matematriks.menu.activity.menu.latihan;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import inialdan.com.matematriks.R;

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

public class latihan_determinan extends AppCompatActivity {

    private TextView M11, M12, M21, M22;
    private EditText answer;
    Integer B11, B12, B21, B22;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slide_latihan_determinan_1);

        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }

        M11 = findViewById(R.id.valueM11);
        M12 = findViewById(R.id.valueM12);
        M21 = findViewById(R.id.valueM21);
        M22 = findViewById(R.id.valueM22);

        Integer min = 1;
        Integer max = 50;
        Integer iM11 = new Random().nextInt(max) + min;
        Integer iM12 = new Random().nextInt(max) + min;
        Integer iM21 = new Random().nextInt(max) + min;
        Integer iM22 = new Random().nextInt(max) + min;

        M11.setText(iM11.toString());
        M12.setText(iM12.toString());
        M21.setText(iM21.toString());
        M22.setText(iM22.toString());

        Button Proses = findViewById(R.id.btnAnswer);
        Proses.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            Determinan();
            }
        });
    }

    public void Determinan() {
        B11 = Integer.parseInt(M11.getText().toString());
        B12 = Integer.parseInt(M12.getText().toString());
        B21 = Integer.parseInt(M21.getText().toString());
        B22 = Integer.parseInt(M22.getText().toString());

        Integer ResultC1 = B11 * B22;
        Integer ResultC2 = B12 * B21;
        Integer Result = ResultC1 - ResultC2;

        answer = findViewById(R.id.Answer);

        String CheckAnswer = answer.getText().toString();
        String TheAnswer = Result.toString();

        if (CheckAnswer.equals(TheAnswer)){
            Toast.makeText(this, "TRUE", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Jawaban Salah", Toast.LENGTH_SHORT).show();
        }
    }

}
