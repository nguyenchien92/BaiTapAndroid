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
import androidx.fragment.app.FragmentTransaction;

import com.example.nguyen.mission1.R;
import com.example.nguyen.mission1.fragments.FragmentContainer;
import com.example.nguyen.mission1.fragments.FragmentFavorite;
import com.example.nguyen.mission1.fragments.FragmentGroupUser;
import com.example.nguyen.mission1.fragments.FragmentHome;
import com.example.nguyen.mission1.fragments.FragmentInfoMe;
import com.example.nguyen.mission1.fragments.FragmentMarketPlace;
import com.example.nguyen.mission1.fragments.FragmentNotification;

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

//        switch (position)
//        {
//            case 0:
//                return new FragmentHome();
//            case 1:
//                return new FragmentMarketPlace();
//            case 2:
//                return new FragmentGroupUser();
//            case 3:
//                return new FragmentFavorite();
//            case 4:
//                return new FragmentNotification();
//            case 5:
//                return new FragmentInfoMe();
//            default:
//                return null;
//        }
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

    public View getSelectedTabView(int position, FragmentManager mn) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_tab, null);

        ImageView ivTab = view.findViewById(R.id.iv_tab);

        ivTab.setImageResource(mImages.get(position));
        ivTab.setColorFilter(ContextCompat.getColor(context, R.color.colorTabSelected), PorterDuff.Mode.SRC_ATOP);

//        FragmentTransaction transaction = mn.beginTransaction();
//        transaction.replace(R.id.frame_container,new FragmentContainer());
//        transaction.addToBackStack(null);
//        transaction.commit();


        return view;
    }

    public void addFragment(Fragment fragment, String title, int resId) {

        fragmentList.add(fragment);
        mTitles.add(title);
        mImages.add(resId);
    }


}
