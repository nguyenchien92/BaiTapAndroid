package com.example.nguyen.mission1.adapters;

import android.content.Context;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.nguyen.mission1.R;

import java.util.ArrayList;
import java.util.List;

public class PagerTabAdapterLayout extends FragmentStatePagerAdapter {

    private List<Fragment> fragmentList = new ArrayList<>();
    private Context context;
    private List<String> mTitles = new ArrayList<>();
    private List<Integer> mImages = new ArrayList<>();

    public PagerTabAdapterLayout(@NonNull FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }


    public View getTabView(int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_tab, null);

        ImageView ivTab = view.findViewById(R.id.iv_tab);

        //set property effect for ivTab

        ivTab.setImageResource(mImages.get(position));

        return view;
    }

    public View getSelectedTabView(int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_tab, null);

        ImageView ivTab = view.findViewById(R.id.iv_tab);

        ivTab.setImageResource(mImages.get(position));
        ivTab.setColorFilter(ContextCompat.getColor(context, R.color.colorTabSelected), PorterDuff.Mode.SRC_ATOP);

        return view;
    }

    public void addFragment(Fragment fragment, String title, int resId) {

        fragmentList.add(fragment);
        mTitles.add(title);
        mImages.add(resId);
    }


}
