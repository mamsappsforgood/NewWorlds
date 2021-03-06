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

/**
 * This class is the adapter for the final itinerary RecyclerView
 */
public class RecyclerViewAdapterFinal extends RecyclerView.Adapter<RecyclerViewAdapterFinal.ViewHolder>{
    public static final String TAG="RecyclerViewAdapter";
    private ArrayList<ArrayList<Itenerary>> lastItinerary;
    private Context mContext;

    /**
     * Creates a final itinerary RecyclerView
     * @param data array list of array list of itinerary objects selected from the itineraries RecyclerView
     * @param context the context of the class
     */
    public RecyclerViewAdapterFinal(ArrayList<ArrayList<Itenerary>> data, Context context){
        lastItinerary=data;
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
        ArrayList<Itenerary> finalItinerary = lastItinerary.get(0);
        for (int i = 0;i<finalItinerary.size();i++){
            if (i==0){
                holder.place1.setText(mContext.getResources().getString(R.string.one) + finalItinerary.get(i).getName());
                holder.address1.setText(finalItinerary.get(i).getAddress());
                Log.d("first place", finalItinerary.get(i).getName());
            }
            else
            if (i==1){
                holder.place2.setText(mContext.getResources().getString(R.string.two) + finalItinerary.get(i).getName());
                holder.address2.setText(finalItinerary.get(i).getAddress());
                Log.d("second place", finalItinerary.get(i).getName());
            }
            else
            if (i==2){
                holder.place3.setText(mContext.getResources().getString(R.string.three) + finalItinerary.get(i).getName());
                holder.address3.setText(finalItinerary.get(i).getAddress());
                Log.d("third place", finalItinerary.get(i).getName());
            }
        }

    }

    @Override


    public int getItemCount() {
        return lastItinerary.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView place1, place2, place3, address1, address2, address3;

        public ViewHolder(@NonNull LinearLayout itemView) {
            super(itemView);
            place1 = itemView.findViewById(R.id.place1);
            place2 = itemView.findViewById(R.id.place2);
            place3 = itemView.findViewById(R.id.place3);
            address1 = itemView.findViewById(R.id.address1);
            address2 = itemView.findViewById(R.id.address2);
            address3 = itemView.findViewById(R.id.address3);
        }
    }

}
