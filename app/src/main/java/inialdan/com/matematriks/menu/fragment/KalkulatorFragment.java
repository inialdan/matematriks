package inialdan.com.matematriks.menu.fragment;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

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

@SuppressWarnings("deprecation")
public class KalkulatorFragment extends Fragment {

    private static final String TAG = KalkulatorFragment.class.getSimpleName();
    private EditText M11, M12, M21, M22;
    private TextView textM11, textM12, textM21, textM22;
    private TextView textRealM11, textRealM12, textRealM21, textRealM22;
    private TextView textRealM11T, textRealM12T, textRealM21T, textRealM22T;
    private TextView Determinan;
    Integer B11, B12, B21, B22;
    View RootView;

    public KalkulatorFragment() {
        // Required empty public constructor
    }

    public static KalkulatorFragment newInstance(String param1, String param2) {
        KalkulatorFragment fragment = new KalkulatorFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RootView = inflater.inflate(R.layout.menu_calculator_2x2, container, false);
        setHasOptionsMenu(true);

        initView();
        return RootView;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    public void initView(){
        M11 = RootView.findViewById(R.id.B11);
        M12 = RootView.findViewById(R.id.B12);
        M21 = RootView.findViewById(R.id.B21);
        M22 = RootView.findViewById(R.id.B22);
        Determinan = RootView.findViewById(R.id.Determinan);

        textM11 = RootView.findViewById(R.id.tM11);
        textM12 = RootView.findViewById(R.id.tM12);
        textM21 = RootView.findViewById(R.id.tM21);
        textM22 = RootView.findViewById(R.id.tM22);

        textRealM11 = RootView.findViewById(R.id.tRealM11);
        textRealM12 = RootView.findViewById(R.id.tRealM12);
        textRealM21 = RootView.findViewById(R.id.tRealM21);
        textRealM22 = RootView.findViewById(R.id.tRealM22);

        textRealM11T = RootView.findViewById(R.id.tRealM11T);
        textRealM12T = RootView.findViewById(R.id.tRealM12T);
        textRealM21T = RootView.findViewById(R.id.tRealM21T);
        textRealM22T = RootView.findViewById(R.id.tRealM22T);

        final View resultMatriks = RootView.findViewById(R.id.menu_matriks);
        final View resultDeterminan = RootView.findViewById(R.id.menu_kalkulator);
        final View resultMinor = RootView.findViewById(R.id.menu_minor);

        resultMatriks.setVisibility(View.GONE);
        resultDeterminan.setVisibility(View.GONE);
        resultMinor.setVisibility(View.GONE);

        Button Proses = RootView.findViewById(R.id.Proses);
        Proses.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((M11.getText().length() > 0) && (M12.getText().length() > 0)
                        && (M21.getText().length() > 0) && (M22.getText().length() > 0)) {
                    resultMatriks.setVisibility(View.VISIBLE);
                    resultDeterminan.setVisibility(View.VISIBLE);
                    resultMinor.setVisibility(View.VISIBLE);
                    Matriks();
                    Determinan();
                    Minor();
                }else{
                    Toast.makeText(getActivity(), "Mohon untuk mengisi kolom matriks", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void Matriks(){
        String text11 = M11.getText().toString();
        String text12 = M12.getText().toString();
        String text21 = M21.getText().toString();
        String text22 = M22.getText().toString();

        textRealM11.setText(text11);
        textRealM12.setText(text12);
        textRealM21.setText(text21);
        textRealM22.setText(text22);

        textRealM11T.setText(text11);
        textRealM12T.setText(text21);
        textRealM21T.setText(text12);
        textRealM22T.setText(text22);
    }

    public void Determinan() {
        B11 = Integer.parseInt(M11.getText().toString());
        B12 = Integer.parseInt(M12.getText().toString());
        B21 = Integer.parseInt(M21.getText().toString());
        B22 = Integer.parseInt(M22.getText().toString());

        Integer ResultC1 = B11 * B22;
        Integer ResultC2 = B12 * B21;
        Integer Result = ResultC1 - ResultC2;

        Determinan.setText("" +
                "Hasil Determinan\n" +
                "det A = (a x d) - (b x c)\n" +
                "det A = (" + B11 + " x " + B22 + ") - (" + B12 + " x " + B21 + ")\n"
                + String.valueOf(ResultC1) + " - " + String.valueOf(ResultC2) + "\nadalah " + String.valueOf(Result));
    }

    public void Minor() {
        String text11 = M22.getText().toString();
        String text12 = M21.getText().toString();
        String text21 = M12.getText().toString();
        String text22 = M11.getText().toString();

        textM11.setText(Html.fromHtml("M<sub>11</sub> = " + text11));
        textM12.setText(Html.fromHtml("M<sub>12</sub> = " + text12));
        textM21.setText(Html.fromHtml("M<sub>21</sub> = " + text21));
        textM22.setText(Html.fromHtml("M<sub>22</sub> = " + text22));
    }
}