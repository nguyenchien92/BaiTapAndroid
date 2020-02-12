package com.example.nguyen.mission1.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.nguyen.mission1.R;
import com.example.nguyen.mission1.network.IOBackPressed;

import java.util.List;

public class FragmentHomeContainer extends Fragment {
    private View rootView;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_container, container, false);

        getChildFragmentManager().beginTransaction().replace(R.id.frame_container, new FragmentHome(), FragmentHome.class.getSimpleName())
                .commit();


        return rootView;
    }


}
