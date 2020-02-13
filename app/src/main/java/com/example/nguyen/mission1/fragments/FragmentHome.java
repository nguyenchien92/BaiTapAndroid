package com.example.nguyen.mission1.fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nguyen.mission1.R;
import com.example.nguyen.mission1.adapters.NewsAdapter;
import com.example.nguyen.mission1.adapters.SuggestFacebookGaming;
import com.example.nguyen.mission1.adapters.SuggestRecentlyPlayedAdapter;
import com.example.nguyen.mission1.adapters.SuggestUserAdapter;
import com.example.nguyen.mission1.models.ArticleNews;
import com.example.nguyen.mission1.models.Games;
import com.example.nguyen.mission1.models.User;
import com.example.nguyen.mission1.network.ClickItemListen;

import java.util.ArrayList;
import java.util.List;

public class FragmentHome extends Fragment {

    private View rootView;

    private SuggestUserAdapter mAdapter;
    private SuggestFacebookGaming mFaceAdapter;
    private SuggestRecentlyPlayedAdapter mRecentlyAdapter;
    private NewsAdapter newsAdapter;
    private RecyclerView mRecyclerView, mRvFaceGaming, mRvRecently, mRvArticleNews;
    private List<User> mList = new ArrayList<>();
    private List<Games> mGames = new ArrayList<>();
    private List<Games> mGameRecents = new ArrayList<>();
    private List<ArticleNews> mArticles = new ArrayList<>();
    private LinearLayoutManager manager, managerFb, mnRecentlyPlayed, mnNews;
    private ImageView ivMessaage;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_home, container, false);

        createDataUser();
        init();

        Log.d(FragmentHome.class.getSimpleName(),"onCreateView");

        return rootView;
    }

    private void createDataUser() {
        mList.add(new User("chien", R.drawable.ic_user));
        mList.add(new User("ha", R.drawable.ic_user));
        mList.add(new User("minh", R.drawable.ic_user));
        mList.add(new User("son", R.drawable.ic_user));
        mList.add(new User("hoang", R.drawable.ic_user));
        mList.add(new User("thao", R.drawable.ic_user));

        mGameRecents.add(new Games(R.drawable.image_game));
        mGameRecents.add(new Games(R.drawable.ic_game_stars));
        mGameRecents.add(new Games(R.drawable.ic_game_rainbows));
        mGameRecents.add(new Games(R.drawable.image_game));
        mGameRecents.add(new Games(R.drawable.image_game));

        mGames.add(new Games(R.drawable.image_game, R.drawable.image_game, "FaceGaming", "This is Describe Content"));
        mGames.add(new Games(R.drawable.ic_game_rainbows, R.drawable.ic_game_rainbows, "FaceGaming", "This is Describe Content"));
        mGames.add(new Games(R.drawable.ic_game_stars, R.drawable.ic_game_stars, "FaceGaming", "This is Describe Content"));

        mArticles.add(new ArticleNews(R.drawable.ic_tinh_te_news, "TinhTe",
                "Thứ tư 16:04", "Đại học đắt nhất Việt Nam", "http://....",
                999, 135, 35, R.drawable.ic_image_user, R.drawable.ic_vin_uni));
    }

    private void init() {
        mRecyclerView = rootView.findViewById(R.id.rvSuggestUser);
        mRvFaceGaming = rootView.findViewById(R.id.rvFaceBookGaming);
        mRvRecently = rootView.findViewById(R.id.rvRecentPlayed);
        mRvArticleNews = rootView.findViewById(R.id.rv_article_news);

        ivMessaage = rootView.findViewById(R.id.iv_message);

        setLayoutAdapters();
//        setColorTvDrawableStart();
        mAdapter.notifyDataSetChanged();
    }

    private void setColorTvDrawableStart() {

    }

    private void setLayoutAdapters() {

        newsAdapter = new NewsAdapter(getActivity(), mArticles);
        mnNews = new LinearLayoutManager(getActivity());
        newsAdapter.setItemListen(new ClickItemListen() {
            @Override
            public void clickItem(int position) {
                FragmentManager mn = getFragmentManager();
                FragmentTransaction transaction = mn.beginTransaction();
                transaction.replace(R.id.frame_container, new FragmentItemArticleDetail()
                                , FragmentItemArticleDetail.class.getSimpleName());
                transaction.addToBackStack(FragmentItemArticleDetail.class.getSimpleName());
                transaction.commit();
            }
        });


        mAdapter = new SuggestUserAdapter(getActivity(), mList);
        manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);

        mFaceAdapter = new SuggestFacebookGaming(getActivity(), mGames);
        managerFb = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);

        mRecentlyAdapter = new SuggestRecentlyPlayedAdapter(getActivity(), mGameRecents);
        mnRecentlyPlayed = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);


        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(manager);

        mRvFaceGaming.setAdapter(mFaceAdapter);
        mRvFaceGaming.setLayoutManager(managerFb);

        mRvRecently.setAdapter(mRecentlyAdapter);
        mRvRecently.setLayoutManager(mnRecentlyPlayed);

        mRvArticleNews.setAdapter(newsAdapter);
        mRvArticleNews.setLayoutManager(mnNews);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(FragmentHome.class.getSimpleName(),"activityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(FragmentHome.class.getSimpleName(),"onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(FragmentHome.class.getSimpleName(),"onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(FragmentHome.class.getSimpleName(),"onPause()");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(FragmentHome.class.getSimpleName(),"onStop()");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(FragmentHome.class.getSimpleName(),"onDestroyView");
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d(FragmentHome.class.getSimpleName(),"onAttach");
    }
}

