package com.example.bottomsheetexample;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.example.bottomsheetexample.BottomSheetDialog;

public class MainActivity extends AppCompatActivity {

    TextView bottomsheet, open_thanks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomsheet = findViewById(R.id.bottomsheet);
        open_thanks = findViewById(R.id.open_thanks);
        bottomsheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomSheetDialog bottomSheet = new BottomSheetDialog();
                bottomSheet.show(getSupportFragmentManager(),
                        "ModalBottomSheet");
            }
        });
        final Dialog[] dialog = new Dialog[1];
        open_thanks.setOnClickListener(view -> {
            dialog[0] = new Dialog(MainActivity.this);
            dialog[0].requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog[0].setCancelable(false);
            dialog[0].setContentView(R.layout.dialog_thanks);
            dialog[0].getWindow().setBackgroundDrawableResource(android.R.color.transparent);

            dialog[0].show();
            dialog[0].findViewById(R.id.view).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog[0].dismiss();
                }
            });

        });

    }
}