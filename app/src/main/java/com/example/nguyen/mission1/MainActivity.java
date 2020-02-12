package com.example.nguyen.mission1;

import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.nguyen.mission1.fragments.FragmentContent;
import com.example.nguyen.mission1.fragments.FragmentHomeContainer;
import com.example.nguyen.mission1.network.IOBackPressed;

public class MainActivity extends AppCompatActivity {

    private FrameLayout frameLayoutMain;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        moveTo();

    }

    private void moveTo() {
        FragmentManager mn = getSupportFragmentManager();
        FragmentTransaction transaction = mn.beginTransaction();
        transaction.replace(R.id.frame_layout_main, new FragmentContent(), FragmentContent.class.getSimpleName());
        transaction.addToBackStack(FragmentContent.class.getSimpleName());
        transaction.commit();
    }

    private void init() {
        frameLayoutMain = findViewById(R.id.frame_layout_main);
    }

    @Override
    public void onBackPressed() {
        Fragment fragmentCurrent = getSupportFragmentManager().findFragmentById(R.id.frame_layout_main);

        boolean check;

        if ((fragmentCurrent instanceof IOBackPressed) && fragmentCurrent != null) {

            check = ((FragmentContent) fragmentCurrent).onBackPressed();

            if (check) {
                super.onBackPressed();
            }else{

                ///.....
                Log.d("Result",check+"/"+fragmentCurrent.getTag());

            }
        } else {
            super.onBackPressed();
        }
    }
}
