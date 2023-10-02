package gtiians.akgec.students.ui.about;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

import gtiians.akgec.students.R;

public class AboutFragment extends Fragment {

    private ViewPager viewPager;
    private BranchAdapter adapter;
    private List<BranchModel> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        list = new ArrayList<>();

        list.add(new BranchModel(R.drawable.ic_civil,"Civil Engineering", "Civil Engineering started in xyz year. At present intake sheet in I-year is XYZ students, and in lateral entries XYZ"));
        list.add(new BranchModel(R.drawable.ic_computer,"Computer Science & Engineering", "Computer Science & Engineering started in xyz year. At present intake sheet in I-year is XYZ students, and in lateral entries XYZ"));
        list.add(new BranchModel(R.drawable.ic_electrical,"Electrical and Electronics Engineering", "Electircal & Electronics Engineering started in xyz year. At present intake sheet in I-year is XYZ students, and in lateral entries XYZ"));
        list.add(new BranchModel(R.drawable.ic_machanical,"Machanical Engineering", "Machanical Engineering started in xyz year. At present intake sheet in I-year is XYZ students, and in lateral entries XYZ"));
        list.add(new BranchModel(R.drawable.ic_electrical,"Electronics and Communication Engineering", "Electronics and Communication Engineering started in xyz year. At present intake sheet in I-year is XYZ students, and in lateral entries XYZ"));
        list.add(new BranchModel(R.drawable.ic_computer,"Information Technology", "Information Technology started in xyz year. At present intake sheet in I-year is XYZ students, and in lateral entries XYZ"));


        adapter = new BranchAdapter(getContext(),list);
        viewPager = view.findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);

//        ImageView imageView = view.findViewById(R.id. URL );
//        Glide.with(getContext()).load("Fire Base URL").into(imageView);

    return view;
    }

}