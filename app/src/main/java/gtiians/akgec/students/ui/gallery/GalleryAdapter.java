package gtiians.akgec.students.ui.gallery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import gtiians.akgec.students.R;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.GalleryViewAdapter> {

    private Context context;
    private List<String> images;

    public GalleryAdapter(Context context, List<String> images) {
        this.context = context;
        this.images = images;
    }

    @NonNull
    @Override
    public GalleryViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.gallery_image, parent, false);
        return new GalleryViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryViewAdapter holder, int position) {

        try {
            Glide.with(context).load(images.get(position)).into(holder.imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public class GalleryViewAdapter extends RecyclerView.ViewHolder {

        ImageView imageView;


        public GalleryViewAdapter(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image);
        }
    }
}
