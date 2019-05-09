package com.example.newworlds;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewAdapterFinal extends RecyclerView.Adapter<RecyclerViewAdapterFinal.ViewHolder>{
    public static final String TAG="RecyclerViewAdapter";
    //private ArrayList<ArrayList<Itenerary>> allItineraries;
    private ArrayList<Itenerary> chosenItinerary;
    private Context mContext;

    public RecyclerViewAdapterFinal(ArrayList<Itenerary> data, Context context){
        chosenItinerary=data;
        mContext=context;
    }

    @Override
    public RecyclerViewAdapterFinal.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LinearLayout view = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_card_final_itinerary,parent,false);
        CardView cardView = view.findViewById(R.id.cardItinerary);
        RecyclerViewAdapterFinal.ViewHolder holder = new RecyclerViewAdapterFinal.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterFinal.ViewHolder holder, final int position) {
        Log.d(TAG,"onBindViewHolder: called");
        ArrayList<Itenerary> finalItinerary = chosenItinerary;
        holder.place1.setText(finalItinerary.get(0).getName());
        holder.place2.setText(finalItinerary.get(1).getName());
        holder.place3.setText(finalItinerary.get(2).getName());

    }

    @Override


    public int getItemCount() {
        return chosenItinerary.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView place1, place2, place3;

        public ViewHolder(@NonNull LinearLayout itemView) {
            super(itemView);
            place1 = itemView.findViewById(R.id.place1);
            place2 = itemView.findViewById(R.id.place2);
            place3 = itemView.findViewById(R.id.place3);
        }
    }

}