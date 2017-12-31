package aldan.apps.matematriks;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import aldan.apps.matematriks.fragment.ProfileFragment;
import aldan.apps.matematriks.fragment.BelajarFragment;
import aldan.apps.matematriks.fragment.KalkulatorFragment;
import aldan.apps.matematriks.fragment.LatihanFragment;
import aldan.apps.matematriks.helper.BottomNavigationBehavior;


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

public class MainActivity extends AppCompatActivity {

    private ActionBar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = getSupportActionBar();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        // attaching bottom sheet behaviour - hide / show on scroll
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) navigation.getLayoutParams();
        layoutParams.setBehavior(new BottomNavigationBehavior());

        // load the store fragment by default
        toolbar.setTitle(R.string.app_name);
        toolbar.setSubtitle("Belajar");
        loadFragment(new BelajarFragment());
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_belajar:
                    toolbar.setTitle(R.string.app_name);
                    toolbar.setSubtitle("Belajar");
                    fragment = new BelajarFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_latihan:
                    toolbar.setTitle(R.string.app_name);
                    toolbar.setSubtitle("Latihan");
                    fragment = new LatihanFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_kalkulator:
                    toolbar.setTitle(R.string.app_name);
                    toolbar.setSubtitle("Kalkulator");
                    fragment = new KalkulatorFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_profile:
                    toolbar.setTitle(R.string.app_name);
                    toolbar.setSubtitle("Profile");
                    fragment = new ProfileFragment();
                    loadFragment(fragment);
                    return true;
            }

            return false;
        }
    };

    /**
     * loading fragment into FrameLayout
     *
     * @param fragment
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
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_info) {
            new AlertDialog.Builder(this)
                    .setMessage("Copyright 2017 (c) Al Reserved")
                    .setCancelable(false)
                    .setPositiveButton("Ok", null)
                    .show();
        }

        return super.onOptionsItemSelected(item);
    }

    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Apakah Anda yakin ingin keluar Aplikasi?")
                .setCancelable(false)
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        MainActivity.this.finish();
                    }
                })
                .setNegativeButton("Tidak", null)
                .show();
    }

}
