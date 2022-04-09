package com.codeandroid.app.View;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.codeandroid.app.Model.Dog;
import com.codeandroid.dogapp.R;
import com.codeandroid.dogapp.databinding.LayoutItemDogBinding;

import java.util.List;

public class DogAdapter extends RecyclerView.Adapter<DogAdapter.ViewHolder> {
    List<Dog> list;
    Context context;

    public DogAdapter(List<Dog> list, Context context) {
        this.list = list;
        this.context = context;
    }

    IOnClickDog iOnClickDog;

    public IOnClickDog getiOnClickDog() {
        return iOnClickDog;
    }

    public void setiOnClickDog(IOnClickDog iOnClickDog) {
        this.iOnClickDog = iOnClickDog;
    }

    @NonNull
    @Override
    public DogAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        LayoutItemDogBinding binding = DataBindingUtil.inflate(inflater, R.layout.layout_item_dog , parent, false);
        return new DogAdapter.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull DogAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Dog dog= list.get(position);
        holder.binding.tvName.setText(dog.getName());
        holder.binding.tvBredFor.setText(dog.getBred_for());

        Glide.with(context).load(dog.getUrl()).centerCrop().into(holder.binding.img);

        holder.binding.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iOnClickDog.iOnclickDog(dog, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        LayoutItemDogBinding binding;
        public ViewHolder(@NonNull LayoutItemDogBinding binding) {
            super(binding.getRoot());
            this.binding= binding;
        }
    }

    public List<Dog> getList() {
        return list;
    }

    public void setList(List<Dog> list) {
        this.list = list;
        notifyDataSetChanged();
    }
}
