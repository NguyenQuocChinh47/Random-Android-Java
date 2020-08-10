package com.example.random;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText edtMin;
    EditText edtMax;
    TextView txtRandom;
    Button btnRandom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //gan value
        edtMin = findViewById(R.id.edt_min);
        edtMax = findViewById(R.id.edt_max);
        txtRandom = findViewById(R.id.txt_random);
        btnRandom =  findViewById(R.id.btn_random);

        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                String strMin = edtMin.getText().toString();
                String strMax = edtMax.getText().toString();

                if(strMax.isEmpty() || strMin.isEmpty()){
                    Toast.makeText(MainActivity.this, "Đề nghị nhập số", Toast.LENGTH_SHORT).show();
                }
                else {
                    final int min = Integer.parseInt(strMin);
                    final int max = Integer.parseInt(strMax);
                    if(min<=max) {
                        try {
                            int x = random.nextInt(max - min + 1);
                            int y = x + min;
                            txtRandom.setText(String.valueOf(y));
                        } catch (NumberFormatException nfe) {
                            Toast.makeText(MainActivity.this, "Đề nghị nhập lại cho đúng số", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(MainActivity.this, "Giá trị min không được lớn hơn giá trị max", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}