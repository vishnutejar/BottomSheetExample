package com.example.bottomsheetexample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;
import java.util.List;

public class BottomSheetDialog extends BottomSheetDialogFragment implements ClickListiner {

    RecyclerView rec_amount_lst;

    EditText et_amount;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable
            ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.layout_bottomsheet_wallet,
                container, false);
        rec_amount_lst = v.findViewById(R.id.rec_amount_lst);
        et_amount = v.findViewById(R.id.et_amount);

        AmountListAdapter amountListAdapter = new AmountListAdapter(getData(), this::click);
        rec_amount_lst.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        rec_amount_lst.setAdapter(amountListAdapter);

        return v;
    }

    private List<String> getData() {
        List<String> list = new ArrayList<>();

        for (int i = 1; i <= 100; i++)
            list.add(i * 100 + "");


        return list;
    }

    @Override
    public void click(String amount) {

        if (amount != null)
            et_amount.setText(amount);
    }
}
