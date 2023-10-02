package gtiians.akgec.students.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderLayout;

import gtiians.akgec.students.R;


public class HomeFragment extends Fragment {

    private SliderLayout sliderLayout;

    private ImageView map;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        sliderLayout = view.findViewById(R.id.slider);
        sliderLayout.setIndicatorAnimation(IndicatorAnimations.FILL);
        sliderLayout.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderLayout.setScrollTimeInSec(1);
        setSliderViews();

        map = view.findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMap();
            }
        });


        return view;

    }

    private void openMap() {
        Uri uri = Uri.parse("geo:0, 0?q=Ajay Kumar Garg Engineering College Ghaziabad");

        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.setPackage("com.google.android.apps.map");
        startActivity(intent);
    }

    private void setSliderViews() {

        for (int i=0; i<5; i++){
            DefaultSliderView sliderView = new DefaultSliderView(getContext());
            switch (i){
                case 0:
                    sliderView.setImageUrl("");
                    sliderView.setDescription("Top College");
                    break;

                case 1:
                    sliderView.setImageUrl("");
                    sliderView.setDescription("Second");
                    break;
                case 2:
                    sliderView.setImageUrl("");
                    sliderView.setDescription("third");
                    break;

                case 3:
                    sliderView.setImageUrl("");
                    sliderView.setDescription("fourth");
                    break;

                case 4:
                    sliderView.setImageUrl("");
                    sliderView.setDescription("fifth");
                    break;
            }
            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
            sliderLayout.addSliderView(sliderView);

        }

    }
}