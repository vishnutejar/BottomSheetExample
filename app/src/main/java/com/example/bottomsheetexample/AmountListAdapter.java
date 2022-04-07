package com.example.bottomsheetexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AmountListAdapter extends RecyclerView.Adapter<AmountListAdapter.AmountViewholder> {
    List<String> _lst_amount;
    ClickListiner click;

    public AmountListAdapter(List<String> lst_amount, ClickListiner click) {
        _lst_amount = lst_amount;
        this.click = click;
    }

    @NonNull
    @Override
    public AmountViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context
                = parent.getContext();
        LayoutInflater inflater
                = LayoutInflater.from(context);

        // Inflate the layout

        View view
                = inflater
                .inflate(R.layout.item_amount,
                        parent, false);

        AmountViewholder viewHolder
                = new AmountViewholder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AmountViewholder viewHolder, int position) {
        viewHolder.amount
                .setText(_lst_amount.get(position));

        viewHolder._itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click.click(_lst_amount.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return _lst_amount.size();
    }

    class AmountViewholder extends RecyclerView.ViewHolder {
        TextView amount;

        View _itemView;

        public AmountViewholder(@NonNull View itemView) {
            super(itemView);

            amount = itemView.findViewById(R.id.txt_amount);
            _itemView = itemView;
        }
    }
}
