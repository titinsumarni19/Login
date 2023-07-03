package com.titinsumarni202102246.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    private Button _viewmahasiswa;

    private Button _tampilforex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        _viewmahasiswa = findViewById(R.id.ViewMahasiswa);

        _viewmahasiswa.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ViewMahasiswa.class);
                startActivity(intent);
            }
        });

        _tampilforex = findViewById(R.id.TampilForex);

        _tampilforex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TampilForex.class);
                startActivity(intent);
            }
        });
    }

}