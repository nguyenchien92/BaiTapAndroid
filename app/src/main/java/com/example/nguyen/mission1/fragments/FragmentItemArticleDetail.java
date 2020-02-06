package com.example.nguyen.mission1.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nguyen.mission1.R;
import com.example.nguyen.mission1.adapters.CommentUserAdapter;

public class FragmentItemArticleDetail extends Fragment {

    private View rootView;
    private RecyclerView rvItemComment;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.item_detail_article, container, false);

        rvItemComment = rootView.findViewById(R.id.rv_item_comment_user);

        CommentUserAdapter adapter = new CommentUserAdapter(getActivity());
        rvItemComment.setAdapter(adapter);
        rvItemComment.setLayoutManager(new LinearLayoutManager(getActivity()));

        return rootView;
    }
}
