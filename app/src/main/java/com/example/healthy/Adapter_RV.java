package com.example.healthy;

import android.app.TimePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Dictionary;
import java.util.List;

public class Adapter_RV extends RecyclerView.Adapter<Adapter_RV.ViewHolder> {

    private ArrayList<Item_RV> list;
    private Context mContext;

    private Dictionary<String, Integer> list_water;
    private Dictionary<String, Integer> list_sleep;
    private Dictionary<String, Integer> list_eat;
    private Dictionary<String, Integer> list_drink;
    private Dictionary<String, Integer> list_activities;


    public Adapter_RV(ArrayList<Item_RV> mStutents, Context mContext) {
        this.list = mStutents;
        this.mContext = mContext;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View studentView = inflater.inflate(R.layout.item_rv, parent, false);

        ViewHolder viewHolder = new ViewHolder(studentView);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Item_RV students = list.get(position);

        holder.title.setText(students.getTitle());
        holder.number.setText(students.getNumber()+"");
        holder.pic.setImageResource(students.getPic());



        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, final int position, boolean isLongClick) {
                holder.btnPlus.setVisibility(View.VISIBLE);
                holder.layout.setBackgroundColor(Color.rgb(50,114,153));
                holder.btnPlus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int temp = Integer.parseInt(holder.number.getText().toString())+1;
                        holder.number.setText(temp+"");
                        list.get(position).setNumber(temp);


                    }
                });


                Calendar calendar = Calendar.getInstance();
                int h = calendar.get(Calendar.HOUR_OF_DAY);
                int m = calendar.get(Calendar.MINUTE);
                TimePickerDialog timePickerDialog = new TimePickerDialog(mContext, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Toast.makeText(mContext, hourOfDay+":"+minute, Toast.LENGTH_SHORT).show();
                    }
                }, h, m, true);
                timePickerDialog.show();

              }


        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }





    /**
     * Lớp nắm giữ cấu trúc view
     */
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ItemClickListener itemClickListener;

        private View itemview;
        public ImageView pic;
        public TextView title;
        public TextView number;
        public ImageButton btnPlus;
        public LinearLayout layout;

        public ViewHolder(View itemView) {
            super(itemView);
            itemview = itemView;
            pic = itemView.findViewById(R.id.pic);
            title = itemView.findViewById(R.id.name);
            number = itemView.findViewById(R.id.number);
            btnPlus = itemView.findViewById(R.id.btnPlus);
            layout = itemView.findViewById(R.id.layout);

            itemView.setOnClickListener(this);

        }

        public void setItemClickListener(ItemClickListener itemClickListener)
        {
            this.itemClickListener = itemClickListener;
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onClick(v,getAdapterPosition(),false);
        }


    }


}
