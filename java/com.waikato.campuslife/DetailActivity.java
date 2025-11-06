package com.waikato.campuslife;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        try {

            int sectionIndex = getIntent().getIntExtra("SECTION_INDEX", 0);
            if (sectionIndex < 0 || sectionIndex > 3) {
                sectionIndex = 0;
                showToast("Loading default section");
            }


            String[] titles = getResources().getStringArray(R.array.string_array_titles);
            String[] contents = getResources().getStringArray(R.array.string_array_content);
            String[] imageNames = getResources().getStringArray(R.array.string_array_images);

            if (titles.length != 4 || contents.length != 4 || imageNames.length != 4) {
                throw new Exception("Arrays must have exactly 4 items");
            }


            String title = titles[sectionIndex].trim();
            String content = contents[sectionIndex].trim();
            String imageName = imageNames[sectionIndex].trim();


            int imageResId = getResources().getIdentifier(
                    imageName, "drawable", getPackageName()
            );
            if (imageResId == 0) {

                throw new Exception("Image not found: " + imageName);
            }


            TextView tvTitle = findViewById(R.id.tv_detail_title);
            TextView tvContent = findViewById(R.id.tv_detail_content);
            ImageView ivImage = findViewById(R.id.iv_detail_image);

            if (tvTitle == null || tvContent == null || ivImage == null) {
                throw new Exception("UI elements not found in layout");
            }

            tvTitle.setText(title);
            tvContent.setText(content);
            tvContent.setLineSpacing(16, 1.1f);
            ivImage.setImageResource(imageResId);

        } catch (Exception e) {

            showToast("Error: " + e.getMessage());
            e.printStackTrace();
            finish();
        }
    }


    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
