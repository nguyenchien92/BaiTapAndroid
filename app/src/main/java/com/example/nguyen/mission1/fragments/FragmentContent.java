package com.example.nguyen.mission1.fragments;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.example.nguyen.mission1.R;

import com.example.nguyen.mission1.adapters.PagerTabAdapterLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.tabs.TabLayout;


public class FragmentContent extends Fragment {

    private View rootView;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    private PagerTabAdapterLayout adapterLayout;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.frag_content, container, false);

        init();

        return rootView;
    }

    private void init() {
        viewPager = rootView.findViewById(R.id.view_pager);
        tabLayout = rootView.findViewById(R.id.tab);

        adapterLayout = new PagerTabAdapterLayout(getFragmentManager(), getContext());
        adapterLayout.addFragment(new FragmentContainer(), "Home", R.drawable.ic_newspaper_v2);


        adapterLayout.addFragment(new FragmentMarketPlace(), "Market place", R.drawable.ic_shop_online_24);
        adapterLayout.addFragment(new FragmentGroupUser(), "Group user", R.drawable.ic_group_user_24);
        adapterLayout.addFragment(new FragmentFavorite(), "Favorite", R.drawable.ic_favorite_24);
        adapterLayout.addFragment(new FragmentNotification(), "Notification", R.drawable.ic_notification_24);
        adapterLayout.addFragment(new FragmentInfoMe(), "Info", R.drawable.ic_menu_26);



        viewPager.setAdapter(adapterLayout);
        tabLayout.setupWithViewPager(viewPager);

        highLightCurrentTab(0);
        setEventTabLayout();

    }

    private void setEventTabLayout() {

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                highLightCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void highLightCurrentTab(int position) {

        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            if (tab != null) {
                tab.setCustomView(null);
                tab.setCustomView(adapterLayout.getTabView(i));
            }
        }


        TabLayout.Tab tab = tabLayout.getTabAt(position);
        if (tab != null) {
            tab.setCustomView(null);
            tab.setCustomView(adapterLayout.getSelectedTabView(position,getFragmentManager()));
        }
    }


}