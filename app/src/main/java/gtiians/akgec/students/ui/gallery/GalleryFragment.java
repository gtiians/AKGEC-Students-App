package gtiians.akgec.students.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import gtiians.akgec.students.R;

public class GalleryFragment extends Fragment {


    private RecyclerView convocationRecycler, alumniRecycler, freshersRecycler, farewellRecycler, independenceRecycler, republicRecycler, holiRecycler, vishwakarmaRecycler;
    private GalleryAdapter adapter;

    private DatabaseReference reference;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);

        convocationRecycler = view.findViewById(R.id.convocationRecycler);
        alumniRecycler = view.findViewById(R.id.alumniRecycler);
        freshersRecycler = view.findViewById(R.id.freshersRecycler);
        farewellRecycler = view.findViewById(R.id.farewellRecycler);
        independenceRecycler = view.findViewById(R.id.independenceRecycler);
        republicRecycler = view.findViewById(R.id.republicRecycler);
        holiRecycler = view.findViewById(R.id.holiRecycler);
        vishwakarmaRecycler = view.findViewById(R.id.vishwakarmaRecycler);

        reference = FirebaseDatabase.getInstance("https://akgec-ghaziabad-2115402d-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference().child("Gallery");

        getconvocationRecycler();
        getalumniRecycler();
        getfreshersRecycler();
        getfarewellRecycler();
        getindependenceRecycler();
        getrepublicRecycler();
        getholiRecycler();
        getvishwakarmaRecycler();



        return view;
}


    private void getconvocationRecycler() {
/*
        reference.child("Convocation").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                    String data = (String) snapshot.getValue();
                    imageList.add(data);
                }
                adapter = new GalleryAdapter(getContext(), imageList);
                convocationRecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
                convocationRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
*/
    }

    private void getalumniRecycler() {
 /*       reference.child("Alumni Meet").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                    String data = (String) snapshot.getValue();
                    imageList.add(data);
                }
                adapter = new GalleryAdapter(getContext(), imageList);
                alumniRecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
                alumniRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
*/
    }

    private void getfreshersRecycler() {
/*        reference.child("Freshers Party").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                    String data = (String) snapshot.getValue();
                    imageList.add(data);
                }
                adapter = new GalleryAdapter(getContext(), imageList);
                freshersRecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
                freshersRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
*/
    }

    private void getfarewellRecycler() {
/*        reference.child("Farewell Party").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                    String data = (String) snapshot.getValue();
                    imageList.add(data);
                }
                adapter = new GalleryAdapter(getContext(), imageList);
                farewellRecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
                farewellRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
*/
    }
    private void getindependenceRecycler() {
/*        reference.child("Independence Day").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                    String data = (String) snapshot.getValue();
                    imageList.add(data);
                }
                adapter = new GalleryAdapter(getContext(), imageList);
                independenceRecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
                independenceRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
*/
    }
    private void getrepublicRecycler() {
/*        reference.child("Republic Day").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                    String data = (String) snapshot.getValue();
                    imageList.add(data);
                }
                adapter = new GalleryAdapter(getContext(), imageList);
                republicRecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
                republicRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
*/
    }

    private void getholiRecycler() {
/*        reference.child("Holi Celebration").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                    String data = (String) snapshot.getValue();
                    imageList.add(data);
                }
                adapter = new GalleryAdapter(getContext(), imageList);
                holiRecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
                holiRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
*/
    }

    private void getvishwakarmaRecycler() {
/*
        reference.child("Vishwakarma Puja").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                    String data = (String) snapshot.getValue();
                    imageList.add(data);
                }
                adapter = new GalleryAdapter(getContext(), imageList);
                vishwakarmaRecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
                vishwakarmaRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
 */
    }

}