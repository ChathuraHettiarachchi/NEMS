package com.chootdev.nems.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chootdev.nems.R;
import com.chootdev.nems.adapters.StatsAdapter;
import com.chootdev.nems.database.DatabaseManager;
import com.chootdev.nems.models.StatModel;
import com.chootdev.nems.repo.StatsRepo;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Choota.
 */

public class StatsFragment extends Fragment {

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
        statsRepo.create(new StatModel(2, "Lights", "Lights 1", "1000", "122"));
        statsRepo.create(new StatModel(2, "Lights", "Lights 2", "1000", "122"));
        statsRepo.create(new StatModel(2, "Lights", "Lights 3", "1000", "122"));
        statsRepo.create(new StatModel(2, "Lights", "Lights 4", "1000", "122"));

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

    private void populateScreen(){

        List<StatModel> dataSet = (List<StatModel>) statsRepo.findAll();

        StatsAdapter adapter = new StatsAdapter(getActivity(), dataSet);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
