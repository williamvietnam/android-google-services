package com.rikkeisoft.project_training.adapters.new_way;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.rikkeisoft.project_training.adapters.new_way.clicked.OnSubItem2Clicked;
import com.rikkeisoft.project_training.databinding.SubItemTwoBinding;
import com.rikkeisoft.project_training.models.SubItem;

import java.util.ArrayList;
import java.util.List;

public class SubItem2ListAdapter extends ListAdapter<SubItem, SubItem2ListAdapter.SubItem2ViewHolder> {

    private final OnSubItem2Clicked onSubItem2Clicked;

    public SubItem2ListAdapter(@NonNull DiffUtil.ItemCallback<SubItem> diffCallback, OnSubItem2Clicked onSubItem2Clicked) {
        super(diffCallback);
        this.onSubItem2Clicked = onSubItem2Clicked;
    }

    @NonNull
    @Override
    public SubItem2ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SubItem2ViewHolder(SubItemTwoBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SubItem2ViewHolder holder, int position) {
        holder.setData(getItem(position));
    }

    class SubItem2ViewHolder extends RecyclerView.ViewHolder {

        private final SubItemTwoBinding binding;

        public SubItem2ViewHolder(SubItemTwoBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            binding.tvDelete.setOnClickListener(view -> onSubItem2Clicked.onDelete2(getAdapterPosition()));
        }

        void setData(SubItem item) {
            binding.imageView.setImageResource(item.getImageRes());
            binding.tvContent.setText(item.getContent());
        }
    }

    @Override
    public void submitList(@Nullable List<SubItem> list) {
        super.submitList(list != null ? new ArrayList<>(list) : null);
    }
}
