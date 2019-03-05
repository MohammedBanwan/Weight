package com.banwan.myweight;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {
        RadioGroup rgPlanets;
        EditText txtWeight;
        TextView lblResult;
        ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        iv = findViewById(R.id.imageView);
        rgPlanets = findViewById(R.id.rgPlanets);
        txtWeight = findViewById(R.id.txtName);
        lblResult = findViewById(R.id.lblResult);
        FloatingActionButton fab = findViewById(R.id.fab);
        rgPlanets.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                try {
                    int s = rgPlanets.getCheckedRadioButtonId();
                    RadioButton r = findViewById(s);
                    switch (r.getText().toString()) {
                        case "The Moon":
                            lblResult.setText("Your Weight: "+Double.toString(Double.parseDouble(txtWeight.getText().toString()) * 1.62 / 9.81));
                            iv.setImageResource(R.drawable.themoon);
                            iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
                            break;
                        case "Mars":
                            lblResult.setText("Your Weight: "+Double.toString(Double.parseDouble(txtWeight.getText().toString()) * 3.711 / 9.81));
                            iv.setImageResource(R.drawable.mars);
                            iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
                            break;
                        case "Jupiter":
                            lblResult.setText("Your Weight: "+Double.toString(Double.parseDouble(txtWeight.getText().toString()) * 24.79 / 9.81));
                            iv.setImageResource(R.drawable.jupiter);
                            iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
                            break;
                        case "Mercury":
                            lblResult.setText("Your Weight: "+Double.toString(Double.parseDouble(txtWeight.getText().toString()) * 3.7 / 9.81));
                            iv.setImageResource(R.drawable.mercury);
                            iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
                            break;
                        case "Venus":
                            lblResult.setText("Your Weight: "+Double.toString(Double.parseDouble(txtWeight.getText().toString()) * 8.87 / 9.81));
                            iv.setImageResource(R.drawable.venus);
                            iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
                            break;

                    }

                }
                catch (Exception e){
                    Toast.makeText(getBaseContext(),"Please Enter a valid weight",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
