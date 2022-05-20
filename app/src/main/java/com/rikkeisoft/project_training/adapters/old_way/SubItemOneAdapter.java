package com.rikkeisoft.project_training.adapters.old_way;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rikkeisoft.project_training.databinding.SubItemOneBinding;
import com.rikkeisoft.project_training.models.SubItem;

import java.util.List;

public class SubItemOneAdapter extends RecyclerView.Adapter<SubItemOneAdapter.ViewHolder> {

    private final List<SubItem> listItem;

    public SubItemOneAdapter(List<SubItem> listItem) {
        this.listItem = listItem;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(SubItemOneBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SubItem itemChild = listItem.get(position);
        holder.setData(itemChild);
        holder.binding.tvDelete.setOnClickListener(view -> {
            listItem.remove(holder.getAdapterPosition());
            notifyItemRemoved(holder.getAdapterPosition());
        });
    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private final SubItemOneBinding binding;

        ViewHolder(SubItemOneBinding itemOneBinding) {
            super(itemOneBinding.getRoot());
            binding = itemOneBinding;
        }

        void setData(@NonNull SubItem item) {
            binding.imageView.setImageResource(item.getImageRes());
        }
    }
}
