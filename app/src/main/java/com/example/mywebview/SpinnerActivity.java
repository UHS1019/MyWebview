package com.example.mywebview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class SpinnerActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        String[] items = {"설계", "제어", "시스템", "정보통신"};
        Spinner spinner = findViewById(R.id.spinner_exam);
        ArrayAdapter<String> adapter
                = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        String name = adapterView.getItemAtPosition(position).toString();
        Toast.makeText(SpinnerActivity.this, position + "번째 " + adapterView.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
        setTitle(name + "의 웹뷰");
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}