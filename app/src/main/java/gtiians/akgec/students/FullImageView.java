package gtiians.akgec.students;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;

public class FullImageView extends AppCompatActivity {

    private String image;
    private PhotoView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_image_view);

        String image = getIntent().getStringExtra("image");

        imageView = findViewById(R.id.imageView);

        Glide.with(this).load(image).into(imageView);
    }
}