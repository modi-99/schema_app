package com.example.schema;

import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.MyViewHolder> {

    Context context;
    public static final String ID_VALUE = "ID";
    public static final String DATE_VALUE = "DATE";
    public static final String LUNCH_VALUE = "LUNCH";
    public static final String DINNER_VALUE = "DINNER";

    public ScheduleAdapter(Context context){this.context=context;}

    @NonNull
    @Override
    public ScheduleAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.r_view_rad, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //holder.date.setText(Data.data.getDate().get(position));
        holder.emp_1=Data.data.getDate().get(position);
        holder.date.setText(holder.emp_1.getDate());


        if(holder.emp_1.getLunchShift() == false&&holder.emp_1.getDinnerShift()==false){
            holder.dinnerBtn.setVisibility(View.INVISIBLE);
            holder.lunchBtn.setVisibility(View.INVISIBLE);
        }
        else if (holder.emp_1.getLunchShift()&&holder.emp_1.getDinnerShift()==false){
            holder.lunchBtn.setVisibility(View.VISIBLE);
            holder.dinnerBtn.setVisibility(View.INVISIBLE);

        } else if(holder.emp_1.getLunchShift()==false&&holder.emp_1.getDinnerShift()){
            holder.dinnerBtn.setVisibility(View.VISIBLE);
            holder.lunchBtn.setVisibility(View.INVISIBLE);
        }

    }

    @Override
    public int getItemCount() {
        return Data.data.cDate.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView date;
        Employee emp_1;
        Button lunchBtn;
        Button dinnerBtn;
        int position;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            position=getAdapterPosition();
            date= itemView.findViewById(R.id.t_view_Datum);
            lunchBtn=itemView.findViewById(R.id.btn_LunchSkift);
            dinnerBtn=itemView.findViewById(R.id.btn_MiddagSkift);

            lunchBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    final Intent intent;
                    intent = new Intent(itemView.getContext(), Pop.class);
                    intent.putExtra(ID_VALUE, emp_1.getId());
                    intent.putExtra(DINNER_VALUE, emp_1.getDinnerShift());
                    intent.putExtra(LUNCH_VALUE, emp_1.getLunchShift());
                    intent.putExtra(DATE_VALUE, emp_1.getDate());
                    itemView.getContext().startActivity(intent);

                }
            });

            dinnerBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final Intent intent;
                    intent = new Intent(itemView.getContext(), Pop.class);
                    intent.putExtra(ID_VALUE, emp_1.getId());
                    intent.putExtra(DINNER_VALUE, emp_1.getDinnerShift());
                    intent.putExtra(LUNCH_VALUE, emp_1.getLunchShift());
                    intent.putExtra(DATE_VALUE, emp_1.getDate());
                    itemView.getContext().startActivity(intent);

                }
            });






        }
    }
}
