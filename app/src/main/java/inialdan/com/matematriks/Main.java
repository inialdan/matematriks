package inialdan.com.matematriks;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.shashank.sony.fancygifdialoglib.FancyGifDialog;
import com.shashank.sony.fancygifdialoglib.FancyGifDialogListener;

import inialdan.com.matematriks.menu.fragment.ProfileFragment;
import inialdan.com.matematriks.menu.fragment.BelajarFragment;
import inialdan.com.matematriks.menu.fragment.KalkulatorFragment;
import inialdan.com.matematriks.menu.fragment.LatihanFragment;
import inialdan.com.matematriks.helper.BottomNavigationBehavior;

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

public class Main extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView toolbarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) navigation.getLayoutParams();
        layoutParams.setBehavior(new BottomNavigationBehavior());
        toolbar = findViewById(R.id.toolbar_main);
        toolbarTitle = findViewById(R.id.toolbar_title);

        setSupportActionBar(toolbar);

        if (toolbar != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
        loadFragment(new BelajarFragment());
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_belajar:
                    fragment = new BelajarFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_latihan:
                    fragment = new LatihanFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_kalkulator:
                    fragment = new KalkulatorFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_profile:
                    fragment = new ProfileFragment();
                    loadFragment(fragment);
                    return true;
            }
            return false;
        }
    };

    /**
     *
     * @param fragment
     *
     */
    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_info) {
            new FancyGifDialog.Builder(this)
                    .setTitle("Developer by\nAldan Rizki Santosa, MTA.")
                    .setMessage("Content by\nIrma Rohima, S. Si\n\nCopyright (c) 2018\nGEN-13 RPL\nSMK Wikrama Bogor")
                    .setNegativeBtnText("Cancel")
                    .setPositiveBtnBackground("#FF4081")
                    .setPositiveBtnText("Ok")
                    .setNegativeBtnBackground("#FFA9A7A8")
                    .setGifResource(R.drawable.gif_developer)   //Pass your Gif here
                    .isCancellable(true)
                    .OnPositiveClicked(new FancyGifDialogListener() {
                        @Override
                        public void OnClick() {
                            //Toast.makeText(Main.this,"Ok",Toast.LENGTH_SHORT).show();
                        }
                    })
                    .OnNegativeClicked(new FancyGifDialogListener() {
                        @Override
                        public void OnClick() {
                            //Toast.makeText(Main.this,"Cancel",Toast.LENGTH_SHORT).show();
                        }
                    })
                    .build();
        }

        return super.onOptionsItemSelected(item);
    }

    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Apakah Anda yakin ingin keluar Aplikasi?")
                .setCancelable(false)
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Main.this.finish();
                    }
                })
                .setNegativeButton("Tidak", null)
                .show();
    }
}