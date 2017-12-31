package aldan.apps.matematriks.session;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefManager {

    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;

    int PRIVATE_MODE = 0;

    private static final String PREF_NAME = "MATEMATRIKS";
    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";

    public static final String SCORE_BELAJAR_MATRIKS = "belajar_matriks";
    public static final String SCORE_BELAJAR_DETERMINAN = "belajar_determinan";
    public static final String SCORE_BELAJAR_MINOR = "belajar_minor";

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

    public String getScoreBelajarDeterminan(){
        return pref.getString(SCORE_BELAJAR_DETERMINAN, "");
    }

    public String getScoreBelajarMinor(){
        return pref.getString(SCORE_BELAJAR_MINOR, "");
    }

}
