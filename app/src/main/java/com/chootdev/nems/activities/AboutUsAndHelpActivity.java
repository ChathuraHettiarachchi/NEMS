package com.chootdev.nems.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.chootdev.nems.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class AboutUsAndHelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us_and_help);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnBack)
    public void onViewClicked() {
        finish();
    }
}
