<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout 
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".DetailActivity">

    
    <ImageView
        android:id="@+id/iv_detail_image"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:scaleType="centerCrop"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHeight_percent="0.3"/>

   
    <TextView
        android:id="@+id/tv_detail_title"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:text="This is a title" 
        android:textSize="24sp"
        android:textStyle="bold"
        android:layout_marginStart="24dp"
        android:layout_marginEnd="24dp"
        android:layout_marginTop="16dp"
        app:layout_constraintTop_toBottomOf="@id/iv_detail_image"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"/>


    <ScrollView
        android:layout_width="0dp"
        android:layout_height="0dp"
        android:layout_marginStart="24dp"
        android:layout_marginEnd="24dp"
        android:layout_marginTop="16dp"
        android:layout_marginBottom="24dp"
        app:layout_constraintTop_toBottomOf="@id/tv_detail_title"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintBottom_toBottomOf="parent">

        <TextView
            android:id="@+id/tv_detail_content"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="This is content" 
            android:textSize="16sp"
            android:lineSpacingExtra="8dp"/>

    </ScrollView>
package com.waikato.campuslife;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

      
        int sectionIndex = getIntent().getIntExtra("SECTION_INDEX", 0); 

      
        String[] titles = getResources().getStringArray(R.array.string_array_titles);
        String[] contents = getResources().getStringArray(R.array.string_array_content);
        String[] imageNames = getResources().getStringArray(R.array.string_array_images);

      
        String title = titles[sectionIndex];
        String content = contents[sectionIndex];
        String imageName = imageNames[sectionIndex];

     
        int imageResId = getResources().getIdentifier(
            imageName, 
            "drawable", 
            getPackageName()
        );

     
        TextView tvTitle = findViewById(R.id.tv_detail_title);
        TextView tvContent = findViewById(R.id.tv_detail_content);
        ImageView ivImage = findViewById(R.id.iv_detail_image);

        tvTitle.setText(title);
        tvContent.setText(content);
        ivImage.setImageResource(imageResId);
    }
}
</androidx.constraintlayout.widget.ConstraintLayout>
