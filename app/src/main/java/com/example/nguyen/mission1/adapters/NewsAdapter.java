package com.example.nguyen.mission1.adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nguyen.mission1.R;
import com.example.nguyen.mission1.models.ArticleNews;
import com.example.nguyen.mission1.network.ClickItemListen;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsHolder> {

    private Activity context;
    private List<ArticleNews> mNews;
    private ClickItemListen itemListen;

    public NewsAdapter(Activity context, List<ArticleNews> mNews) {
        this.context = context;
        this.mNews = mNews;
    }

    public void setItemListen(ClickItemListen itemListen) {
        this.itemListen = itemListen;
    }

    @NonNull
    @Override
    public NewsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_article_content, parent, false);
        return new NewsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsHolder holder, final int position) {
        ArticleNews news = mNews.get(position);

//        holder.configUI(news);

        Drawable drawable = context.getResources().getDrawable(R.drawable.ic_like_24);
        drawable = DrawableCompat.wrap(drawable);
        DrawableCompat.setTint(drawable, Color.rgb(66,104,178));
        DrawableCompat.setTintMode(drawable, PorterDuff.Mode.SRC_IN);
        holder.tvCountNumberLike.setCompoundDrawablesWithIntrinsicBounds(drawable,null,null,null);


        holder.frameLayoutContentImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemListen.clickItem(position);
            }
        });
    }


//    Drawable drawable = getResources().getDrawable(R.drawable.circle);
//drawable = DrawableCompat.wrap(drawable);
//DrawableCompat.setTint(drawable, Color.GREEN);
//DrawableCompat.setTintMode(drawable, PorterDuff.Mode.SRC_IN);
//textview.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);

    @Override
    public int getItemCount() {
        return mNews.size();
    }

    public class NewsHolder extends RecyclerView.ViewHolder {

        TextView tvCountNumberLike, tvNameSite, tvTimeArticle, tvDescribeContent, tvInfo, tvCountCommentShare;
        ImageView ivIconArticle, ivImageUser, ivImageContent;
        FrameLayout frameLayoutContentImage;

        public NewsHolder(@NonNull View itemView) {
            super(itemView);

            tvCountNumberLike = itemView.findViewById(R.id.tv_count_number_like);
            tvNameSite = itemView.findViewById(R.id.tv_name_site);
            tvTimeArticle = itemView.findViewById(R.id.tv_time_article);
            tvDescribeContent = itemView.findViewById(R.id.tv_describe_content);
            tvInfo = itemView.findViewById(R.id.tv_info);
            tvCountCommentShare = itemView.findViewById(R.id.tv_count_comment_share);

            ivIconArticle = itemView.findViewById(R.id.iv_icon_article);
            ivImageUser = itemView.findViewById(R.id.iv_image_user);
            ivImageContent = itemView.findViewById(R.id.iv_image_content);

            frameLayoutContentImage = itemView.findViewById(R.id.frame_layout_content_image);
        }

        public void configUI(ArticleNews articleNew) {
            ivIconArticle.setImageResource(articleNew.getImageIconSite());
            ivImageUser.setImageResource(articleNew.getImageUser());
            ivImageContent.setImageResource(articleNew.getImageArticle());

            tvCountCommentShare.setText(articleNew.getNumberLike() + "");
            tvNameSite.setText(articleNew.getNameSite());
            tvTimeArticle.setText(articleNew.getTimePost());
            tvDescribeContent.setText(articleNew.getCommentArticle());
            tvInfo.setText(articleNew.getCommentLink());
            tvCountCommentShare.setText(articleNew.getNumberLike()+" bình luận " + articleNew.getNumberShare() + " chia sẻ");
        }
    }
}
