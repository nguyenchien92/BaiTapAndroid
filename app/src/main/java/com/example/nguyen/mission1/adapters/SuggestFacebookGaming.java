package com.example.nguyen.mission1.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nguyen.mission1.R;
import com.example.nguyen.mission1.models.Games;

import java.util.List;

public class SuggestFacebookGaming extends RecyclerView.Adapter<SuggestFacebookGaming.ViewHolder>{


    private Context context;
    private List<Games> mGames;

    public SuggestFacebookGaming(Context context, List<Games> mGames) {
        this.context = context;
        this.mGames = mGames;
    }

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context)
                .inflate(R.layout.fragment_item_game, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Games game = mGames.get(position);

        holder.setLayoutFbGaming(game);
    }

    @Override
    public int getItemCount() {
        return mGames.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private LinearLayout lnTapPlay;
        private TextView tvClose,tvTitle,tvDescibeContent;
        private ImageView ivImageGame,ivIconGame;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            lnTapPlay = itemView.findViewById(R.id.ln_tap_play);
            tvClose = itemView.findViewById(R.id.tv_close);
            tvTitle = itemView.findViewById(R.id.tv_title_game);
            tvDescibeContent = itemView.findViewById(R.id.tv_describe_content);
            ivImageGame = itemView.findViewById(R.id.iv_game);
            ivIconGame = itemView.findViewById(R.id.iv_icon_game);
        }

        public void setLayoutFbGaming(Games game)
        {
            ivImageGame.setImageResource(game.getIvImageBackGround());
            ivIconGame.setImageResource(game.getIvImageIcon());
            tvTitle.setText(game.getTvTitle());
            tvDescibeContent.setText(game.getTvDescripsion());
        }
    }
}
