package com.example.onesignal;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;


public abstract class MovieViewHolder extends RecyclerView.ViewHolder {

    private int mCurrentPosition;

    public MovieViewHolder(View itemView) {
        super(itemView);
    }

    protected abstract void clear();

    public void onBind(int position) {
        mCurrentPosition = position;
        clear();
    }

    public int getCurrentPosition() {
        return mCurrentPosition;
    }
}