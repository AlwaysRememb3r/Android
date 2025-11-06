package com.waikato.campuslife;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private boolean isClickable = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onButtonClick(View view) {
        if (!isClickable) return;
        isClickable = false;

        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        int sectionIndex = 0;


        if (view.getId() == R.id.btn_facilities) {
            sectionIndex = 0;
            Toast.makeText(this, "Facilities", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.btn_events) {
            sectionIndex = 1;
            Toast.makeText(this, "Events", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.btn_clubs) {
            sectionIndex = 2;
            Toast.makeText(this, "Clubs", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.btn_support) {
            sectionIndex = 3;
            Toast.makeText(this, "Support", Toast.LENGTH_SHORT).show();
        }

        intent.putExtra("SECTION_INDEX", sectionIndex);
        startActivity(intent);


        view.postDelayed(() -> isClickable = true, 500);
    }
}
