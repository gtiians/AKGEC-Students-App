package gtiians.akgec.students.ui.notice;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import gtiians.akgec.students.R;

public class NoticeFragment extends Fragment {

    private RecyclerView deleteNoticeRecycler;

    private ArrayList<NoticeData> list;
    private NoticeAdapter adapter;

    private DatabaseReference reference;

    ShimmerFrameLayout shimmerFrameLayout;
    LinearLayout shimmerNotice;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notice, container, false);


        deleteNoticeRecycler = view.findViewById(R.id.deleteNoticeRecycler);

        reference = FirebaseDatabase.getInstance("https://akgec-ghaziabad-2115402d-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference().child("News Feed");

        deleteNoticeRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        deleteNoticeRecycler.setHasFixedSize(true);

        shimmerFrameLayout = view.findViewById(R.id.shimmer_view_container);
        shimmerNotice = view.findViewById(R.id.shimmerNotice);
        getNotice();

        return view;

    }

    private void getNotice() {

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                list = new ArrayList<>();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    NoticeData data = dataSnapshot.getValue(NoticeData.class);
                    list.add(0,data);
                }
                adapter = new NoticeAdapter(getContext(), list);
                adapter.notifyDataSetChanged();
                deleteNoticeRecycler.setAdapter(adapter);
//                Toast.makeText(getContext(), "News Feed Found Successfully", Toast.LENGTH_SHORT).show();
                shimmerFrameLayout.stopShimmer();
                shimmerNotice.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public void onPause() {
        shimmerFrameLayout.stopShimmer();
        super.onPause();
    }

    @Override
    public void onResume() {
        shimmerFrameLayout.stopShimmer();
        super.onResume();
    }
}