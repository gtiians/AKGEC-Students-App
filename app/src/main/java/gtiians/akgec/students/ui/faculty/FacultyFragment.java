package gtiians.akgec.students.ui.faculty;

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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import gtiians.akgec.students.R;

public class FacultyFragment extends Fragment {

    private RecyclerView appliedDepartment, civilDepartment, csDepartment, eeeDepartment, eceDepartment, meDepartment, itDepartment;
    private LinearLayout appliedNoData, civilNoData, csNoData, eeeNoData, eceNoData, meNoData, itNoData;
    private List<TeacherData> list1, list2, list3, list4, list5, list6, list7;

    private TeacherAdapter adapter;

    private DatabaseReference reference, dbRef;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_faculty, container, false);


        appliedDepartment = view.findViewById(R.id.appliedDepartment);
        civilDepartment = view.findViewById(R.id.civilDepartment);
        csDepartment = view.findViewById(R.id.csDepartment);
        eeeDepartment = view.findViewById(R.id.eeeDepartment);
        eceDepartment = view.findViewById(R.id.eceDepartment);
        meDepartment = view.findViewById(R.id.meDepartment);
        itDepartment = view.findViewById(R.id.itDepartment);

        appliedNoData = view.findViewById(R.id.appliedNoData);
        civilNoData = view.findViewById(R.id.civilNoData);
        csNoData = view.findViewById(R.id.csNoData);
        eeeNoData = view.findViewById(R.id.eeeNoData);
        eceNoData = view.findViewById(R.id.eceNoData);
        meNoData = view.findViewById(R.id.meNoData);
        itNoData = view.findViewById(R.id.itNoData);

        reference = FirebaseDatabase.getInstance("https://akgec-ghaziabad-2115402d-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference().child("Faculties");

        appliedDepartment();
        civilDepartment();
        csDepartment();
        eeeDepartment();
        eceDepartment();
        meDepartment();
        itDepartment();

        return view;

}


    private void appliedDepartment() {
        dbRef = reference.child("Applied Sciences & Humanities");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                list1 = new ArrayList<>();
                if (!snapshot.exists()){
                    appliedNoData.setVisibility(View.VISIBLE);
                    appliedDepartment.setVisibility(View.GONE);
                }else {

                    appliedNoData.setVisibility(View.GONE);
                    appliedDepartment.setVisibility(View.VISIBLE);

                    for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        list1.add(data);
                    }
                    appliedDepartment.setHasFixedSize(true);
                    appliedDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list1, getContext());
                    appliedDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void civilDepartment() {
        dbRef = reference.child("Civil Engineering");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                list2 = new ArrayList<>();
                if (!snapshot.exists()){
                    civilNoData.setVisibility(View.VISIBLE);
                    civilDepartment.setVisibility(View.GONE);
                }else {

                    civilNoData.setVisibility(View.GONE);
                    civilDepartment.setVisibility(View.VISIBLE);

                    for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        list2.add(data);
                    }
                    civilDepartment.setHasFixedSize(true);
                    civilDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list2, getContext());
                    civilDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void csDepartment() {
        dbRef = reference.child("Computer Science and Engineering");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                list3 = new ArrayList<>();
                if (!snapshot.exists()){
                    csNoData.setVisibility(View.VISIBLE);
                    csDepartment.setVisibility(View.GONE);
                }else {

                    csNoData.setVisibility(View.GONE);
                    csDepartment.setVisibility(View.VISIBLE);

                    for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        list3.add(data);
                    }
                    csDepartment.setHasFixedSize(true);
                    csDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list3, getContext());
                    csDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void eeeDepartment() {
        dbRef = reference.child("Electrical and Electronics Engineering");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                list4 = new ArrayList<>();
                if (!snapshot.exists()){
                    eeeNoData.setVisibility(View.VISIBLE);
                    eeeDepartment.setVisibility(View.GONE);
                }else {

                    eeeNoData.setVisibility(View.GONE);
                    eeeDepartment.setVisibility(View.VISIBLE);

                    for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        list4.add(data);
                    }
                    eeeDepartment.setHasFixedSize(true);
                    eeeDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list4, getContext());
                    eeeDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void eceDepartment() {
        dbRef = reference.child("Electronics and Communication Engineering");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                list5 = new ArrayList<>();
                if (!snapshot.exists()){
                    eceNoData.setVisibility(View.VISIBLE);
                    eceDepartment.setVisibility(View.GONE);
                }else {

                    eceNoData.setVisibility(View.GONE);
                    eceDepartment.setVisibility(View.VISIBLE);

                    for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        list5.add(data);
                    }
                    eceDepartment.setHasFixedSize(true);
                    eceDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list5, getContext());
                    eceDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void meDepartment() {
        dbRef = reference.child("Mechanical Engineering");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                list6 = new ArrayList<>();
                if (!snapshot.exists()){
                    meNoData.setVisibility(View.VISIBLE);
                    meDepartment.setVisibility(View.GONE);
                }else {

                    meNoData.setVisibility(View.GONE);
                    meDepartment.setVisibility(View.VISIBLE);

                    for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        list6.add(data);
                    }
                    meDepartment.setHasFixedSize(true);
                    meDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list6, getContext());
                    meDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void itDepartment() {
        dbRef = reference.child("Information Technology");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                list7 = new ArrayList<>();
                if (!snapshot.exists()){
                    itNoData.setVisibility(View.VISIBLE);
                    itDepartment.setVisibility(View.GONE);
                }else {

                    itNoData.setVisibility(View.GONE);
                    itDepartment.setVisibility(View.VISIBLE);

                    for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        list7.add(data);
                    }
                    itDepartment.setHasFixedSize(true);
                    itDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list7, getContext());
                    itDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }


}