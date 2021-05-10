package com.jsstech.spinneractivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    String[] SPINNERVALUES = {"ANDROID","PHP"};
    String SpinnerValue;
    Button GOTO;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            spinner =(Spinner)findViewById(R.id.spinner);

            GOTO = (Button)findViewById(R.id.bt_go);

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,R.layout.item_view,SPINNERVALUES);

            spinner.setAdapter(adapter);

            //Adding setOnItemSelectedListener method on spinner.

            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView,View view,int i,long l) {
                    SpinnerValue = (String)spinner.getSelectedItem();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });



            GOTO.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub

                    switch(SpinnerValue){

                        case "ANDROID":
                            intent = new Intent(MainActivity.this, Android_Activity.class);
                            startActivity(intent);
                            break;

                        case "PHP":
                            intent = new Intent(MainActivity.this, PHP_Activity.class);
                            startActivity(intent);
                            break;

//                        case "BLOGGER":
//                            intent = new Intent(MainActivity.this, BLOGGER_Activity.class);
//                            startActivity(intent);
//                            break;


                    }
                }
            });

        }

    }