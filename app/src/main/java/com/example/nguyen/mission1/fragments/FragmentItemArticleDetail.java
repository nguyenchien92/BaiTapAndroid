package com.example.nguyen.mission1.fragments;

import android.os.Bundle;
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
import com.example.nguyen.mission1.adapters.CommentUserAdapter;
import com.example.nguyen.mission1.models.ArticleNews;

import java.util.ArrayList;
import java.util.List;

public class FragmentItemArticleDetail extends Fragment {

    private View rootView;
    private RecyclerView rvItemComment;
    private List<ArticleNews> mList = new ArrayList<>();
    private ImageView ivBack;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.item_detail_article, container, false);

        rvItemComment = rootView.findViewById(R.id.rv_item_comment_user);
        ivBack = rootView.findViewById(R.id.iv_back);

        createData();

        CommentUserAdapter adapter = new CommentUserAdapter(getActivity(), mList);
        rvItemComment.setAdapter(adapter);
        rvItemComment.setLayoutManager(new LinearLayoutManager(getActivity()));

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager mn = getFragmentManager();
                Fragment mHome = mn.findFragmentByTag(FragmentHome.class.getSimpleName());

                if (mHome instanceof FragmentHome) {
                    mn.popBackStack();
                }
            }
        });

        return rootView;
    }

    private void createData() {

        ArticleNews mNew1 = new ArticleNews();

        mNew1.setImageUser(R.drawable.ic_image_user);
        mNew1.setImageArticle(R.drawable.ic_vin_uni);
        mNew1.setCommentArticle("HaluHa3");
        mNew1.setCommentLink("Mot ngay khong xa");

        ArticleNews mNew2 = new ArticleNews();

        mNew2.setImageUser(R.drawable.ic_image_user);
        mNew2.setImageArticle(R.drawable.ic_vin_uni);
        mNew2.setCommentArticle("HaluHa3");
        mNew2.setCommentLink("Mot ngay khong xa");

        ArticleNews mNew3 = new ArticleNews();

        mNew3.setImageUser(R.drawable.ic_image_user);
        mNew3.setImageArticle(R.drawable.ic_vin_uni);
        mNew3.setCommentArticle("HaluHa3");
        mNew3.setCommentLink("Mot ngay khong xa");


        mList.add(mNew1);
        mList.add(mNew2);
        mList.add(mNew3);

    }


}
