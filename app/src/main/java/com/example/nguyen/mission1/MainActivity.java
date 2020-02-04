package com.example.nguyen.mission1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.nguyen.mission1.fragments.FragmentContent;

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
        transaction.replace(R.id.frame_layout_main,new FragmentContent(), FragmentContent.class.getSimpleName());
        transaction.addToBackStack(FragmentContent.class.getSimpleName());
        transaction.commit();
    }

    private void init() {
        frameLayoutMain = findViewById(R.id.frame_layout_main);
    }

}
//    private var frameLayoutMain: FrameLayout? = null
//
//        override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        init()
//        moveTo()
//        }
//
//private fun init() {
//        frameLayoutMain = findViewById(R.id.frame_layout_main)
//        }
//
//private fun moveTo() {
//        var mn = supportFragmentManager
//        var transaction = mn.beginTransaction()
//        transaction
//        .replace(R.id.frame_layout_main,new FragmentContent(),)
//        transaction.addToBackStack()
//        transaction.commit()
//        }