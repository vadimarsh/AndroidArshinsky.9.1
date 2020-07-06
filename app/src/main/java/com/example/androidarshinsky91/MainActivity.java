package com.example.androidarshinsky91;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private Locale locale;
    private Spinner spinnerColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Util.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_main);
        init();

    }

    private void init() {
        spinnerColor = findViewById(R.id.spinnercolor);

        findViewById(R.id.buttoncolor).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (spinnerColor.getSelectedItemPosition()) {
                    case 0:
                        Util.changeToTheme(MainActivity.this, Util.THEME_BlACK);
                        break;
                    case 1:
                        Util.changeToTheme(MainActivity.this, Util.THEME_GREEN);
                        break;
                    case 2:
                        Util.changeToTheme(MainActivity.this, Util.THEME_BLUE);
                        break;
                }
            }
        });

        Spinner spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    locale = new Locale("ru");

                } else {
                    locale = new Locale("en");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Configuration config = new Configuration();
                config.setLocale(locale);
                getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                recreate();
            }
        });
    }
}
