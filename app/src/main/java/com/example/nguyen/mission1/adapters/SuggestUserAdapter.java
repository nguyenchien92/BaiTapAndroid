package com.example.nguyen.mission1.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nguyen.mission1.R;
import com.example.nguyen.mission1.models.User;

import java.util.List;

public class SuggestUserAdapter extends RecyclerView.Adapter<SuggestUserAdapter.SuggestUserViewHolder> {

    private Context context;
    private List<User> mUsers;

    public SuggestUserAdapter(Context context, List<User> mUsers) {
        this.context = context;
        this.mUsers = mUsers;
    }

    @NonNull
    @Override
    public SuggestUserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.fragment_item_suggest_user, parent, false);

        return new SuggestUserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SuggestUserViewHolder holder, int position) {
        User user = mUsers.get(position);

        holder.setLayoutUser(user,context);

    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }


    public class SuggestUserViewHolder extends RecyclerView.ViewHolder{

        private TextView tvName;


        public SuggestUserViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tv_title);
        }

        public void setLayoutUser(User user,Context context){
            tvName.setText(user.getName());
            Drawable img = context.getResources().getDrawable(user.getImage(),null);
            tvName.setCompoundDrawablesWithIntrinsicBounds(img,null,null,null);
        }
    }
}
//    Drawable img = getContext().getResources().getDrawable( R.drawable.smiley );
//txtVw.setCompoundDrawablesWithIntrinsicBounds( img, null, null, null);