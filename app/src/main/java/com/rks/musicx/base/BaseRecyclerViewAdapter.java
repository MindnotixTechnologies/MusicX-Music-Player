package com.rks.musicx.base;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/*
 * Created by Coolalien on 6/28/2016.
 */

/*
 * ©2017 Rajneesh Singh
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

public abstract class BaseRecyclerViewAdapter<TData, TViewHolder extends RecyclerView.ViewHolder>
        extends RecyclerView.Adapter<TViewHolder> {

    private final Context context;
    private final LayoutInflater inflater;
    public List<TData> data = new ArrayList<TData>();
    private OnItemClickListener mOnItemClickListener;
    private OnLongClickListener onLongClickListener;

    public BaseRecyclerViewAdapter(@NonNull final Context context) {
        this.context = context.getApplicationContext();
        this.inflater = LayoutInflater.from(context);
        data = new ArrayList<>();
    }

    public BaseRecyclerViewAdapter(@NonNull final Context context, @NonNull List<TData> data) {
        this.context = context.getApplicationContext();
        this.inflater = LayoutInflater.from(context);
        this.data = new ArrayList<>(data);
    }

    protected Context getContext() {
        return context;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public TData getItem(int position) throws ArrayIndexOutOfBoundsException {
        return data.get(position);
    }

    public boolean add(TData object) {
        return data.add(object);
    }

    public boolean remove(TData object) {
        return data.remove(object);
    }

    public TData remove(int position) {
        return data.remove(position);
    }

    public void clear() {
        data.clear();
    }

    public boolean addAll(@NonNull Collection<? extends TData> collection) {
        return data.addAll(collection);
    }

    public void addDataList(List<TData> tDataList) {
        data = tDataList;
        notifyDataSetChanged();
    }

    public List<TData> getSnapshot() {
        return data;
    }

    protected LayoutInflater getInflater() {
        return inflater;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mOnItemClickListener = listener;
    }

    public void setOnLongClickListener(OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void triggerOnItemClickListener(int position, View view) {
        if (mOnItemClickListener != null) {
            mOnItemClickListener.onItemClick(position, view);
        }
    }

    public void triggerOnLongClickListener(int pos) {
        if (onLongClickListener != null) {
            onLongClickListener.onLongItemClick(pos);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position, View view);
    }

    public interface OnLongClickListener {
        void onLongItemClick(int pos);
    }
}
