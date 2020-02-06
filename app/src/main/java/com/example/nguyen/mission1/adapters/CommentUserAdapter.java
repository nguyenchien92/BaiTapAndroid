package com.example.nguyen.mission1.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nguyen.mission1.R;
import com.example.nguyen.mission1.models.ArticleNews;

import java.util.List;

public class CommentUserAdapter extends RecyclerView.Adapter<CommentUserAdapter.CommentHolder> {

    private Context context;
    private List<ArticleNews> mListArticle;

    public CommentUserAdapter(Context context,List<ArticleNews> mListArticle) {
        this.context = context;
        this.mListArticle = mListArticle;
    }

    public CommentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_comment_user, parent, false);

        return new CommentHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentHolder holder, int position) {
        ArticleNews mArticle = mListArticle.get(position);


        holder.setDisplayUI(mArticle);
    }

    @Override
    public int getItemCount() {
        return mListArticle.size();
    }

    public class CommentHolder extends RecyclerView.ViewHolder{

        TextView tvUser,tvComment;
        ImageView ivIconUser,ivImageComment;

        public CommentHolder(@NonNull View itemView) {
            super(itemView);

            tvUser = itemView.findViewById(R.id.tv_account);
            tvComment = itemView.findViewById(R.id.tv_comment_user);
            ivIconUser = itemView.findViewById(R.id.iv_ic_user);
            ivImageComment = itemView.findViewById(R.id.iv_image_user_comment);
        }

        public void setDisplayUI(ArticleNews articleNew)
        {
            tvUser.setText(articleNew.getCommentArticle());
            tvComment.setText(articleNew.getCommentLink());
            ivIconUser.setImageResource(articleNew.getImageUser());
            ivImageComment.setImageResource(articleNew.getImageUser());
        }
    }
}
