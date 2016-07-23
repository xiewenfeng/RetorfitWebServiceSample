package com.smilexie.retrofitsoapsample.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.smilexie.retrofitsoapsample.R;

import java.util.ArrayList;
import java.util.List;


/**
 * 天气结果展示adapter
 * Created by SmileXie on 16/7/15.
 */
public class WeatherResponseAdapter extends RecyclerView.Adapter<WeatherResponseAdapter.MyViewHolder>{

    private List<String> mDatas;

    public WeatherResponseAdapter(List<String> weatherResult) {
        mDatas = weatherResult;
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from( parent.getContext() ).inflate(R.layout.weather_result_item, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.bind( mDatas.get( position ) );
    }

    protected static class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView weather_result_tv;

        public MyViewHolder(View itemView) {
            super(itemView);
            weather_result_tv= (TextView)itemView.findViewById(R.id.weather_result_tv);
        }

        public void bind(String data){
            weather_result_tv.setText(data);
        }

    }

}
