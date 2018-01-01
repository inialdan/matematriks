package aldan.apps.matematriks.session;

import android.content.Context;
import android.content.SharedPreferences;

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

public class PrefManager {

    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;

    int PRIVATE_MODE = 0;

    private static final String PREF_NAME = "MATEMATRIKS";
    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";

    public static final String SCORE_BELAJAR_MATRIKS = "belajar_matriks";
    public static final String SCORE_BELAJAR_JENIS_MATRIKS = "belajar_jenis_matriks";
    public static final String SCORE_BELAJAR_TRANSPOS = "belajar_transpos_matriks";
    public static final String SCORE_BELAJAR_KESAMAAN_MATRIKS = "belajar_kesamaan_matriks";
    public static final String SCORE_PERTAMBAHAN_PENGURANGAN_MATRIKS = "belajar_pertambahan_pengurangan_matriks";
    public static final String SCORE_BELAJAR_DETERMINAN = "belajar_determinan_matriks";
    public static final String SCORE_BELAJAR_MINOR = "belajar_minor_matriks";

    public static final String SCORE_MULTIPLE_CHOISE = "multiple_choise";

    public PrefManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void saveSPString(String keySP, String value){
        editor.putString(keySP, value);
        editor.commit();
    }

    public void saveSPInt(String keySP, int value){
        editor.putInt(keySP, value);
        editor.commit();
    }

    public void saveSPBoolean(String keySP, boolean value){
        editor.putBoolean(keySP, value);
        editor.commit();
    }

    public void setFirstTimeLaunch(boolean isFirstTime) {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();
    }

    public boolean isFirstTimeLaunch() {
        return pref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }

    public String getScoreBelajarMatriks(){
        return pref.getString(SCORE_BELAJAR_MATRIKS, "");
    }

    public String getScoreBelajarJenisMatriks(){
        return pref.getString(SCORE_BELAJAR_JENIS_MATRIKS, "");
    }

    public String getScoreBelajarTranspos(){
        return pref.getString(SCORE_BELAJAR_TRANSPOS, "");
    }

    public String getScoreBelajarKesamaanMatriks(){
        return pref.getString(SCORE_BELAJAR_KESAMAAN_MATRIKS, "");
    }

    public String getScoreBelajarPertambahanPenguranganMatriks(){
        return pref.getString(SCORE_PERTAMBAHAN_PENGURANGAN_MATRIKS, "");
    }

    public String getScoreBelajarDeterminan(){
        return pref.getString(SCORE_BELAJAR_DETERMINAN, "");
    }

    public String getScoreBelajarMinor(){
        return pref.getString(SCORE_BELAJAR_MINOR, "");
    }

    public String getScoreMultipleChoise(){
        return pref.getString(SCORE_MULTIPLE_CHOISE, "");
    }

}
