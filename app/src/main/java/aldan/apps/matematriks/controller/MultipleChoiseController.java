package inialdan.apps.matematriks.controller;

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

public class MultipleChoiseController {

    public String Question[] = {
            "Manakah dibawah ini yang tidak termasuk Matriks Khusus ?",
            "Matriks yang hanya terdiri atas satu kolom adalah ...",
            "Matriks yang semua elemennya adalah 0 (nol) yaitu ...",
            "Matriks A berordo m × n adalah matriks yang diperoleh dari matriks A dengan menukar elemen baris menjadi elemen kolom dan sebaliknya adalah pengertian dari ?",
            "Berikut yang termasuk matriks, <i>kecuali</i> ?",
            "Matriks Ordo 2x2 adalah ...",
            "Tanda yang digunakan untuk melambangkan matriks umumnya adalah tanda ?",
            "Tanda [ dan ] termasuk kedalam ... matriks",
            "Matriks memiliki ... dan ...",
            "Det A = ad ... bc\ntanda yang tepat untuk melengkapi rumus determinan diatas adalah"
    };

    private String multipleChoice[][] = {
            {"Matriks Baris","Matriks Kolom","Matriks Matrix"},
            {"Matriks Kolom","Matriks Baris","Matriks Diagonal"},
            {"Matriks Kolom","Matriks Baris","Matriks Nol"},
            {"Determinan","Transpose","Minor"},
            {"Matriks Ordo 2x2","Matriks Ordo 3x4","Matriks 0x0"},
            {"Matriks dengan 2 baris dan 2 kolom","Matriks dengan 2 baris dan 0 kolom","Matriks dengan 0 baris dan 2 kolom"},
            {"< dan >","( dan )","[ dan ]"},
            {"Elemen","Jenis","Sifat"},
            {"Baris dan Baris","Baris dan Kolom","Kolom dan Kolom"},
            {"-","+","="},
    };
    
    private String Answer[] = {
            "Matriks Matrix",
            "Matriks Kolom",
            "Matriks Nol",
            "Transpose",
            "Matriks 0x0",
            "Matriks dengan 2 baris dan 2 kolom",
            "[ dan ]",
            "Elemen",
            "Baris dan Kolom",
            "-",
    };

    public String getQuestion(int x){
        String soal = Question[x];
        return soal;
    }

    public String getmultipleChoice1(int x){
        String jawaban1 = multipleChoice[x][0];
        return jawaban1;
    }

    public String getmultipleChoice2(int x){
        String jawaban2 = multipleChoice[x][1];
        return jawaban2;
    }

    public String getmultipleChoice3(int x){
        String jawaban3 = multipleChoice[x][2];
        return jawaban3;
    }

    public String getAnswer(int x){
        String jawaban = Answer[x];
        return jawaban;
    }
}