package com.chootdev.nems.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chootdev.nems.R;
import com.chootdev.nems.models.NotificationModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.Holder> {

    private Context context;
    private List<NotificationModel> items;

    public NotificationAdapter(Context context, List<NotificationModel> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.widget_notification, parent, false);
        return new Holder(row);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        NotificationModel model = items.get(position);

        holder.tvMessage.setText(model.description);
        holder.tvDate.setText(model.date);
    }

    @Override
    public int getItemCount() {
        return items != null ? items.size() : 0;
    }

    public class Holder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvMessage)
        TextView tvMessage;
        @BindView(R.id.tvDate)
        TextView tvDate;

        public Holder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
