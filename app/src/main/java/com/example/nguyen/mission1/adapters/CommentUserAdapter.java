package com.example.nguyen.mission1.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nguyen.mission1.R;

public class CommentUserAdapter extends RecyclerView.Adapter<CommentUserAdapter.CommentHolder> {

    private Context context;


    public CommentUserAdapter(Context context) {
        this.context = context;
    }

    public CommentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_comment_user, parent, false);

        return new CommentHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class CommentHolder extends RecyclerView.ViewHolder{



        public CommentHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
