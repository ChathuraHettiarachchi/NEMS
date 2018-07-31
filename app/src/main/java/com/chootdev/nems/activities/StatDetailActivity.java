package com.chootdev.nems.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.chootdev.nems.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class StatDetailActivity extends AppCompatActivity {

    @BindView(R.id.tvtitle)
    TextView tvtitle;
    @BindView(R.id.tvToday)
    TextView tvToday;
    @BindView(R.id.tvWeek)
    TextView tvWeek;
    @BindView(R.id.tvMonth)
    TextView tvMonth;
    @BindView(R.id.tvYear)
    TextView tvYear;
    @BindView(R.id.chart)
    LineChart chart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stat_detail);
        ButterKnife.bind(this);

        temp();
    }

    @OnClick(R.id.btnBack)
    public void onViewClicked() {
        finish();
    }

    private void temp(){
        List<Entry> entries = new ArrayList<Entry>();

        entries.add(new Entry(1f, 100f));
        entries.add(new Entry(3f, 10f));
        entries.add(new Entry(5f, 30f));
        entries.add(new Entry(6f, 50f));
        entries.add(new Entry(7f, 60f));
        entries.add(new Entry(9f, 40f));
        entries.add(new Entry(10f, 66f));
        entries.add(new Entry(12f, 0f));
        entries.add(new Entry(13f, 10f));
        entries.add(new Entry(15f, 134f));
        entries.add(new Entry(16f, 14f));
        entries.add(new Entry(17f, 40f));
        entries.add(new Entry(18f, 15f));
        entries.add(new Entry(19f, 10f));
        entries.add(new Entry(20f, 1f));
        entries.add(new Entry(21f, 10f));
        entries.add(new Entry(22f, 45f));
        entries.add(new Entry(25f, 100f));

        LineDataSet dataSet = new LineDataSet(entries, "Label");

        LineData lineData = new LineData(dataSet);
        chart.setData(lineData);
        chart.invalidate();
    }
}
