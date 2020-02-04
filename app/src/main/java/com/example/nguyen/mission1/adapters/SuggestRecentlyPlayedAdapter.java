package com.example.nguyen.mission1.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nguyen.mission1.R;
import com.example.nguyen.mission1.models.Games;

import java.util.List;

public class SuggestRecentlyPlayedAdapter extends RecyclerView.Adapter<SuggestRecentlyPlayedAdapter.ViewHolder> {


    private Context context;
    private List<Games> games;

    public SuggestRecentlyPlayedAdapter(Context context, List<Games> games) {
        this.context = context;
        this.games = games;
    }

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater
                .from(context).inflate(R.layout.fragment_item_recently_played,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Games game = games.get(position);

        holder.ivImage.setImageResource(game.getIvImageBackGround());
    }

    @Override
    public int getItemCount() {
        return games.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{


        private ImageView ivImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivImage = itemView.findViewById(R.id.iv_image);
        }


    }
}
