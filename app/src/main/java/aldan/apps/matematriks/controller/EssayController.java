package aldan.apps.matematriks.controller;

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

public class EssayController {
    public String pertanyaan[] = {
            "Nilai Det (AB + C) dari Gambar diatas adalah",
            "Nilai x + y dari gambar diatas adalah",
            "Determinan dari P adalah",
            "Determinan A dan determinan B sama, maka harga x yang memenuhi adalah",
            "Tentukan nilai a + b + x + y dari matriks-matriks diatas ini, Diketahui bahwa P = Q",
    };

    private String image[] = {
            "essay_matrik_1",
            "essay_matrik_2",
            "essay_matrik_3",
            "essay_matrik_4",
            "essay_matrik_5",
    };

    private String jawabanBenar[] = {
            "-6",
            "8",
            "1",
            "x = 3 atau x = -4",
            "16",
    };

    public String getPertanyaan(int x){
        String soal = pertanyaan[x];
        return soal;
    }

    public String getStringGambar(int x){
        String gambar = image[x];
        return gambar;
    }

    public String getJawabanBenar(int x){
        String jawaban = jawabanBenar[x];
        return jawaban;
    }
}
