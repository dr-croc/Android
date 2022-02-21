import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.practice1.databinding.FragmentBlankBinding;

public class BlankFragment extends Fragment {


    FragmentBlankBinding fragmentBlankBinding;// just type binding. find the binding that match with you xml file

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        fragmentBlankBinding = FragmentBlankBinding.inflate(inflater, container,false);

        fragmentBlankBinding.fragmentTextView.setText("Ho ho");
        fragmentBlankBinding.fragmentTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Fragment", Toast.LENGTH_SHORT).show();
            }
        });
        return fragmentBlankBinding.getRoot();

    }
}
