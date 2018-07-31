package com.chootdev.nems.fragments;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;

import com.akexorcist.roundcornerprogressbar.RoundCornerProgressBar;
import com.chootdev.nems.R;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Choota.
 */

public class HomeFragment extends Fragment {

    @BindView(R.id.progress)
    RoundCornerProgressBar progress;
    Unbinder unbinder;
    @BindView(R.id.btnStartDate)
    Button btnStartDate;
    @BindView(R.id.btnEndDate)
    Button btnEndDate;

    private int sYear, sMonth, sDay;
    private int eYear, eMonth, eDay;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, rootView);

        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.btnStartDate, R.id.btnEndDate})
    public void onViewClicked(View view) {

        final Calendar c = Calendar.getInstance();
        sYear = c.get(Calendar.YEAR);
        sMonth = c.get(Calendar.MONTH);
        sDay = c.get(Calendar.DAY_OF_MONTH);

        switch (view.getId()) {
            case R.id.btnStartDate:
                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        btnStartDate.setText("From: "+dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                        sYear = year;
                        sMonth = monthOfYear;
                        sDay = dayOfMonth;
                    }
                }, sYear, sMonth, sDay);

                datePickerDialog.show();

                break;
            case R.id.btnEndDate:

                DatePickerDialog datePickerDialogEnd = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        btnEndDate.setText("To: "+dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                    }
                }, sYear, sMonth, sDay);

                datePickerDialogEnd.show();

                break;
        }
    }
}
