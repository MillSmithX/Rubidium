package com.planktonleap.rubidium.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.planktonleap.rubidium.R;
import com.planktonleap.rubidium.fragments.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.contentView,MainFragment.newInstance("",""))
                .commit();
    }
}
