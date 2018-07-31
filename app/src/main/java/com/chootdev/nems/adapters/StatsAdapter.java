package com.chootdev.nems.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.chootdev.nems.R;
import com.chootdev.nems.helpers.Const;
import com.chootdev.nems.models.StatModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StatsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<StatModel> items;

    public StatsAdapter(Context context, List<StatModel> items) {
        this.context = context;
        this.items = items;

        this.generateItemList(items);
    }

    private void generateItemList(List<StatModel> items) {

        List<StatModel> generatedList = new ArrayList<>();

        List<StatModel> generatedListLights = new ArrayList<>();
        List<StatModel> generatedListFans = new ArrayList<>();
        List<StatModel> generatedListHeaters = new ArrayList<>();
        List<StatModel> generatedListTelevisions = new ArrayList<>();

        for (StatModel item : items) {

            if (item.itemType.equals("Lights")) {
                generatedListLights.add(item);
            } else if (item.itemType.equals("Fan")) {
                generatedListFans.add(item);
            } else if (item.itemType.equals("Heater")) {
                generatedListHeaters.add(item);
            } else if (item.itemType.equals("Television")) {
                generatedListTelevisions.add(item);
            }
        }

        if (generatedListLights.size() > 0) {
            generatedList.add(new StatModel(1,"Lights","Lights", "1000","122"));
            generatedList.addAll(generatedListLights);
        }
        if (generatedListFans.size() > 0) {
            generatedList.add(new StatModel(1,"Fan","Fan", "1000","122"));
            generatedList.addAll(generatedListFans);
        }
        if (generatedListHeaters.size() > 0) {
            generatedList.add(new StatModel(1,"Heater","Heater", "1000","122"));
            generatedList.addAll(generatedListHeaters);
        }
        if (generatedListTelevisions.size() > 0) {
            generatedList.add(new StatModel(1,"Television","Television", "1000","122"));
            generatedList.addAll(generatedListTelevisions);
        }

        this.items = new ArrayList<>(generatedList);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        switch (viewType) {
            case Const.STAT_ITEM:
                View viewHeade = inflater.inflate(R.layout.widget_stat, parent, false);
                viewHolder = new StatItemHolder(viewHeade);
                break;
            case Const.STAT_TYPE:
                View viewDb = inflater.inflate(R.layout.widget_stat_type, parent, false);
                viewHolder = new StatTypeHolder(viewDb);
                break;
            default:
                return null;
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        switch (holder.getItemViewType()) {
            case Const.STAT_ITEM:
                StatItemHolder item = (StatItemHolder) holder;
                configItem(position, item);
                break;
            case Const.STAT_TYPE:
                StatTypeHolder type = (StatTypeHolder) holder;
                configType(position, type);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return items != null ? items.size() : 0;
    }

    @Override
    public int getItemViewType(int position) {

        if (items.get(position).cellType == (Const.STAT_TYPE)) {
            return Const.STAT_TYPE;
        } else if (items.get(position).cellType == (Const.STAT_ITEM)) {
            return Const.STAT_ITEM;
        }

        return -1;
    }

    private void configType(int position, StatTypeHolder holder) {
        StatModel model = items.get(position);
        holder.tvType.setText(model.name);
    }

    private void configItem(int position, StatItemHolder holder) {
        StatModel model = items.get(position);

        holder.tvName.setText(model.name);
        holder.tvCurrent.setText("Current: "+model.current+" W");
        holder.tvTotal.setText("Total: "+model.total+" W");
    }

    public class StatTypeHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.imgIcon)
        ImageView imgIcon;
        @BindView(R.id.tvType)
        TextView tvType;


        public StatTypeHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public class StatItemHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvName)
        TextView tvName;
        @BindView(R.id.tvCurrent)
        TextView tvCurrent;
        @BindView(R.id.tvTotal)
        TextView tvTotal;

        public StatItemHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
