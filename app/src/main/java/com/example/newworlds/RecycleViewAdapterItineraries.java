package com.example.newworlds;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class RecycleViewAdapterItineraries extends RecyclerView.Adapter<RecycleViewAdapterItineraries.ViewHolder>{
    public static final String TAG="RecyclerViewAdapter";
    private ArrayList<ArrayList<Itenerary>> allItineraries;
    private ArrayList<Itenerary> chosenItinerary;
    private Context mContext;

    private SparseBooleanArray itemStateArray= new SparseBooleanArray();

    public RecycleViewAdapterItineraries(ArrayList<ArrayList<Itenerary>> data, Context context){
        allItineraries=data;
        mContext=context;
    }

    @Override
    public RecycleViewAdapterItineraries.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LinearLayout view = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_card_itinerary_permutation,parent,false);
        CardView cardView = view.findViewById(R.id.cardRestaurant);
        RecycleViewAdapterItineraries.ViewHolder holder = new RecycleViewAdapterItineraries.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleViewAdapterItineraries.ViewHolder holder, final int position) {
        Log.d(TAG,"onBindViewHolder: called");
        ArrayList<Itenerary> itinerary = allItineraries.get(position);
        holder.place1.setText(itinerary.get(0).getName());
        holder.place2.setText(itinerary.get(1).getName());
        holder.place3.setText(itinerary.get(2).getName());
/*
        holder.selectItinerary.setOnClickListener(new View.onClickListener() {
            public void onClick(View view) {
                if (((CheckBox) view).isChecked()) {
                    chosenItinerary.add(allItineraries.get(getAdapterPosition()));
                }
            }
        });
        //we still have to debug the onClick method and onClickListeners for the check boxes to work.
        */
    }

    @Override


    public int getItemCount() {
        return allItineraries.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView place1, place2, place3;
        CheckBox selectItinerary;

        public ViewHolder(@NonNull LinearLayout itemView) {
            super(itemView);
            place1 = itemView.findViewById(R.id.place1);
            place2 = itemView.findViewById(R.id.place2);
            place3 = itemView.findViewById(R.id.place3);
        }
    }

}