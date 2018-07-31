package com.chootdev.nems.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chootdev.nems.R;
import com.chootdev.nems.activities.StatDetailActivity;
import com.chootdev.nems.adapters.StatsAdapter;
import com.chootdev.nems.alerts.AddApplianceDialog;
import com.chootdev.nems.database.DatabaseManager;
import com.chootdev.nems.models.StatModel;
import com.chootdev.nems.repo.StatsRepo;
import com.chootdev.recycleclick.RecycleClick;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Choota.
 */

public class StatsFragment extends Fragment implements AddApplianceDialog.AddApplianceDialogCallback {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    Unbinder unbinder;
    private StatsRepo statsRepo;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_stats, container, false);
        unbinder = ButterKnife.bind(this, rootView);

        DatabaseManager.init(getActivity());
        statsRepo = new StatsRepo();
        deleteAll();

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        populateScreen();

        return rootView;
    }

    private void deleteAll() {
        try {
            statsRepo.truncate(StatModel.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        addDataToDatabase();
    }

    private void addDataToDatabase() {
        //statsRepo.create(new StatModel(1,"Lights","Lights", "1000","122"));
        statsRepo.create(new StatModel(2, "Light", "Lights 1", "1000", "122"));
        statsRepo.create(new StatModel(2, "Light", "Lights 2", "1000", "122"));
        statsRepo.create(new StatModel(2, "Light", "Lights 3", "1000", "122"));

        //statsRepo.create(new StatModel(1,"Fan","Fan", "1000","122"));
        statsRepo.create(new StatModel(2, "Fan", "Fan 1", "1000", "122"));
        statsRepo.create(new StatModel(2, "Fan", "Fan 2", "1000", "122"));

        //statsRepo.create(new StatModel(1,"Heater","Heater", "1000","122"));
        statsRepo.create(new StatModel(2, "Heater", "Heater 1", "1000", "122"));
        statsRepo.create(new StatModel(2, "Heater", "Heater 2", "1000", "122"));
        statsRepo.create(new StatModel(2, "Heater", "Heater 2", "1000", "122"));

        //statsRepo.create(new StatModel(1,"Television","Television", "1000","122"));
        statsRepo.create(new StatModel(2, "Television", "Television 1", "1000", "122"));
        statsRepo.create(new StatModel(2, "Television", "Television 2", "1000", "122"));
        statsRepo.create(new StatModel(2, "Television", "Television 2", "1000", "122"));
        statsRepo.create(new StatModel(2, "Television", "Television 2", "1000", "122"));
    }

    private void populateScreen() {

        List<StatModel> dataSet = (List<StatModel>) statsRepo.findAll();

        StatsAdapter adapter = new StatsAdapter(getActivity(), dataSet);
        recyclerView.setAdapter(adapter);

        RecycleClick.addTo(recyclerView).setOnItemClickListener(new RecycleClick.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                startActivity(new Intent(getActivity(), StatDetailActivity.class));
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.fab)
    public void onViewClicked() {
        new AddApplianceDialog(getActivity(), this).show();
    }

    @Override
    public void onAddApplianceCalled(String name, String type) {
        statsRepo.create(new StatModel(2, type, name, "0", "0"));
        populateScreen();
    }
}
