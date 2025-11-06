package com.waikato.campuslife;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    
    public void onButtonClick(View view) {
        switch (view.getId()) {
            case R.id.btn_facilities:
                Toast.makeText(this, "Facilities clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_events:
                Toast.makeText(this, "Events clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_clubs:
                Toast.makeText(this, "Clubs clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_support:
                Toast.makeText(this, "Support clicked", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
