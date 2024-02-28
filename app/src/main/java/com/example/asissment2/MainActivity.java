package com.example.asissment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.view.View;
import android.widget.Toast;


import java.util.Collections;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    private ListView lvCount;
    private ArrayList arrayList;
    private ArrayAdapter ArrayAdapter;
    private Button btnPlus;
    private Button btnSub;
    private Button btnMul;
    private Button btnDiv;
    private EditText textA;
    private EditText textB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textA = findViewById(R.id.editTextA);

        textB = findViewById(R.id.editTextB);

        btnPlus = findViewById(R.id.btn_plus);
        btnSub = findViewById(R.id.btn_sub);
        btnMul = findViewById(R.id.btn_mul);
        btnDiv = findViewById(R.id.btn_div);

        lvCount = findViewById(R.id.lv_count);
        arrayList = new ArrayList<String>();
        ArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,arrayList);
        lvCount.setAdapter(ArrayAdapter);


        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
        float a = Float.parseFloat(textA.getText().toString());
        float b = Float.parseFloat(textB.getText().toString());

                float sum = a + b;
                arrayList.add(a +" + "+b +" = "+ sum);
                ArrayAdapter.notifyDataSetChanged();
           }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double input_a = Double.parseDouble(textA.getText().toString());
                double input_b = Double.parseDouble(textB.getText().toString());
                double sum = input_a * input_b;

                arrayList.add(input_a +" * "+input_b +" = "+ sum);
                ArrayAdapter.notifyDataSetChanged();

            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double input_a = Double.parseDouble(textA.getText().toString());
                double input_b = Double.parseDouble(textB.getText().toString());
                double sum = input_a - input_b;

                arrayList.add(input_a +" - "+input_b +" = "+ sum);
                ArrayAdapter.notifyDataSetChanged();

            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double input_a = Double.parseDouble(textA.getText().toString());
                double input_b = Double.parseDouble(textB.getText().toString());
                double sum = input_a / input_b;

                arrayList.add(input_a +" / "+input_b +" = "+ sum);
                ArrayAdapter.notifyDataSetChanged();

            }
        });
        lvCount.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                arrayList.remove(position);
                ArrayAdapter.notifyDataSetChanged();
                return false;
            }
        });
        lvCount.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra("operator", arrayList.get(position).toString());
                startActivity(intent);
            }
        });
        }
    }