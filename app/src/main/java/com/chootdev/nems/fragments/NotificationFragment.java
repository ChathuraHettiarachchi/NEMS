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
import com.chootdev.nems.adapters.NotificationAdapter;
import com.chootdev.nems.models.NotificationModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Choota.
 */

public class NotificationFragment extends Fragment {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_notifications, container, false);
        unbinder = ButterKnife.bind(this, rootView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        loadData();

        return rootView;
    }

    private void loadData(){

        List<NotificationModel> items = new ArrayList<>();

        items.add(new NotificationModel("This is sample push notification view", "2018-12-12 12:12"));
        items.add(new NotificationModel("This is sample push notification viewsample push notification viewsample push notification viewsample push notification view", "2018-12-12 12:12"));
        items.add(new NotificationModel("This is sample push notificasample push notification viewsample push notification viewtion view", "2018-12-12 12:12"));
        items.add(new NotificationModel("This is sample push notifisample push notification viewcation view", "2018-12-12 12:12"));
        items.add(new NotificationModel("This is sample push notificasample push notification viewtion view", "2018-12-12 12:12"));
        items.add(new NotificationModel("This is sample push notificasample push notification viewsample push notification viewsample push notification viewtion view", "2018-12-12 12:12"));
        items.add(new NotificationModel("This is sample push notifisample push notsample push notification viewification viewcation view", "2018-12-12 12:12"));
        items.add(new NotificationModel("This is sample push notifisample push notsample push notification viewification viewcation view", "2018-12-12 12:12"));
        items.add(new NotificationModel("This is sample push notifisample push notsample push notification viewification viewcation view", "2018-12-12 12:12"));

        NotificationAdapter adapter = new NotificationAdapter(getActivity(), items);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
