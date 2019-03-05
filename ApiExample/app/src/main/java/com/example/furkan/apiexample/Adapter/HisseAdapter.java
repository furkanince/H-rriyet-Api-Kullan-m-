package com.example.furkan.apiexample.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.furkan.apiexample.Classes.Hisse;
import com.example.furkan.apiexample.R;

import java.util.ArrayList;

public class HisseAdapter extends RecyclerView.Adapter<HisseAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<Hisse> mHisse;

    public HisseAdapter(Context context,ArrayList<Hisse> hisse){

        mContext=context;
        mHisse=hisse;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.list_item,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Hisse currentItem = mHisse.get(i);

        String kod_Adi = currentItem.getKod();
        String tip_Adi = currentItem.getTip();
        String sirket_Adi = currentItem.getSirket();

        viewHolder.mKod_adi.setText("Koad Adı:" + kod_Adi);
        viewHolder.mSirket_Adi.setText("Şirket Adı:" + sirket_Adi);
        viewHolder.mTip_adi.setText("Tip Adı:" + tip_Adi);

    }

    @Override
    public int getItemCount() {
        return mHisse.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView mKod_adi,mSirket_Adi,mTip_adi;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mKod_adi=itemView.findViewById(R.id.text_view_kod);
            mSirket_Adi=itemView.findViewById(R.id.text_view_sirket);
            mTip_adi=itemView.findViewById(R.id.text_view_tip);
        }
    }
}
