package com.owncloud.android.ui.adapter;

import android.databinding.BindingAdapter;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.owncloud.android.databinding.UserInfoDetailsTableItemBinding;
import com.owncloud.android.ui.components.UserInfoDetailsItem;

import java.util.LinkedList;
import java.util.List;

public class UserInfoAdapter extends RecyclerView.Adapter<UserInfoAdapter.ViewHolder> {
    protected List<UserInfoDetailsItem> mDisplayList;
    @ColorInt
    protected int mTintColor;

    public UserInfoAdapter(List<UserInfoDetailsItem> displayList, @ColorInt int tintColor) {
        mDisplayList = displayList == null ? new LinkedList<>() : displayList;
        mTintColor = tintColor;
    }

    public void setData(List<UserInfoDetailsItem> displayList) {
        mDisplayList = displayList == null ? new LinkedList<>() : displayList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserInfoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        UserInfoDetailsTableItemBinding binding = UserInfoDetailsTableItemBinding.inflate(layoutInflater, parent, false);

        return new ViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        UserInfoDetailsItem item = mDisplayList.get(position);

        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return mDisplayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final UserInfoDetailsTableItemBinding binding;

        public ViewHolder(UserInfoDetailsTableItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(UserInfoDetailsItem item) {
            binding.setUserInfoDetailsItem(item);
            binding.executePendingBindings();
        }
    }

    @BindingAdapter({"android:src"})
    public static void setImageViewResource(ImageView imageView, int resource) {
        imageView.setImageResource(resource);
    }
}
