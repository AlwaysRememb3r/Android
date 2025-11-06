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
    Intent intent = new Intent(MainActivity.this, DetailActivity.class);
   
    switch (view.getId()) {
        case R.id.btn_facilities:
            intent.putExtra("SECTION_INDEX", 0);
            break;
        case R.id.btn_events:
            intent.putExtra("SECTION_INDEX", 1);
            break;
        case R.id.btn_clubs:
            intent.putExtra("SECTION_INDEX", 2);
            break;
        case R.id.btn_support:
            intent.putExtra("SECTION_INDEX", 3);
            break;
        default:
            break;
    }
    startActivity(intent); // 启动DetailActivity
}
}
