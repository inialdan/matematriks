package aldan.apps.matematriks;

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

public class SoalPGController {

    public String Question[] = {
            "Manakah dibawah ini yang tidak termasuk Matrik Khusus ?",
            "Matriks yang hanya terdiri atas satu kolom adalah ...",
            "Matriks yang semua elemennya adalah 0 (nol) yaitu ...",
            "Matriks A berordo m × n adalah matriks yang diperoleh dari matriks A dengan menukar elemen baris menjadi elemen kolom dan sebaliknya adalah pengertian dari ?",
            "Berikut yang termasuk matriks, <i>kecuali</i> ?",
            "Matriks Ordo 2x2 adalah ...",
            "Tanda yang digunakan untuk melambangkan matrik umumnya adalah tanda ?",
    };

    private String multipleChoice[][] = {
            {"Matriks Baris","Matriks Kolom","Matrix"},
            {"Matriks Kolom","Matriks Baris","Matriks Diagonal"},
            {"Matriks Kolom","Matriks Baris","Matriks Nol"},
            {"Determinan","Transpos","Minor"},
            {"Matriks Ordo 2x2","Matrik Ordo 3x4","Matriks 0x0"},
            {"Matriks dengan 2 baris dan 2 kolom","Matriks dengan 2 baris dan 0 kolom","Matriks dengan 0 baris dan 2 kolom"},
            {"< dan >","( dan ) ","[ dan ]"},
    };
    
    private String Answer[] = {
            "Matrix",
            "Matriks Kolom",
            "Matriks Nol",
            "Transpos",
            "Matriks 0x0",
            "Matriks dengan 2 baris dan 2 kolom",
            "[ dan ]",
    };

    //membuat getter untuk mengambil Question
    public String getQuestion(int x){
        String soal = Question[x];
        return soal;
    }

    //membuat getter untuk mengambil pilihan jawaban 1
    public String getmultipleChoice1(int x){
        String jawaban1 = multipleChoice[x][0];
        return jawaban1;
    }

    //membuat getter untuk mengambil pilihan jawaban 2
    public String getmultipleChoice2(int x){
        String jawaban2 = multipleChoice[x][1];
        return jawaban2;
    }

    //membuat getter untuk mengambil pilihan jawaban 3
    public String getmultipleChoice3(int x){
        String jawaban3 = multipleChoice[x][2];
        return jawaban3;
    }

    //membuat getter untuk mengambil jawaban benar
    public String getAnswer(int x){
        String jawaban = Answer[x];
        return jawaban;
    }
}