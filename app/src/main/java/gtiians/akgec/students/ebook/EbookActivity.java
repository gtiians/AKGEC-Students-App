package gtiians.akgec.students.ebook;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import gtiians.akgec.students.R;

public class EbookActivity extends AppCompatActivity {

    private RecyclerView ebookRecycler;
    private DatabaseReference reference;
    private List<EbookData> list;
    private EbookAdapter adapter;

    ShimmerFrameLayout shimmerFrameLayout;
    LinearLayout shimmerEbook;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ebook);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Study Notes");


        ebookRecycler = findViewById(R.id.ebookRecycler);

        reference = FirebaseDatabase.getInstance("https://akgec-ghaziabad-2115402d-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference().child("Study Materials");

        shimmerFrameLayout = findViewById(R.id.shimmer_view_container);
        shimmerEbook = findViewById(R.id.shimmerEbook);
        getData();

    }

    private void getData() {

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list = new ArrayList<>();
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    EbookData data = dataSnapshot.getValue(EbookData.class);
                    list.add(data);
                }
                adapter = new EbookAdapter(EbookActivity.this,list);
                ebookRecycler.setLayoutManager(new LinearLayoutManager(EbookActivity.this));
                ebookRecycler.setAdapter(adapter);
                shimmerFrameLayout.stopShimmer();
                shimmerEbook.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(EbookActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onPause() {
        shimmerFrameLayout.stopShimmer();
        super.onPause();
    }

    @Override
    protected void onResume() {
        shimmerFrameLayout.stopShimmer();
        super.onResume();
    }
}