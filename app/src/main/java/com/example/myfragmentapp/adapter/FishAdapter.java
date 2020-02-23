package com.example.myfragmentapp.adapter;


import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myfragmentapp.R;
import com.example.myfragmentapp.app.App;
import com.example.myfragmentapp.model.Fishing;
import com.example.myfragmentapp.ui.fragment.FragmentStart;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class FishAdapter extends RecyclerView.Adapter<FishAdapter.FishHolderView> {
    private List<Fishing> list;
    StartFragmentImage startFragmentImage;

    public void setOnClickImage(StartFragmentImage startFragmentImage) {
        this.startFragmentImage = startFragmentImage;
    }

    public FishAdapter(List<Fishing> list) {
        this.list = list;

    }

    @NonNull
    @Override
    public FishHolderView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fish_item_adapter, parent, false);
        return new FishHolderView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FishHolderView holder, int position) {
        final Fishing  fishing= list.get(position);
        holder.textView.setText(fishing.getName());
        holder.textData.setText(fishing.getDate());
       if(fishing.getImage()!=null){
           Uri uri=Uri.parse(fishing.getImage());
            Glide.with(holder.imageView.getContext())
                   .load(uri)
                    .centerCrop()
                    .placeholder(R.drawable.images)
                    .into(holder.imageView );


            holder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (startFragmentImage != null) {
                        startFragmentImage.startFragmentImage(fishing);
                    }
                }
            });
        }
        holder.cardView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                startFragmentImage.onLongClickCardView(fishing);
                return true;
            }
        });
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startFragmentImage.onClickAddNote(fishing);

            }
        });

    }
    public void setList(List<Fishing> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class FishHolderView extends RecyclerView.ViewHolder {
        private CardView cardView;
        private ImageView imageView;
        private TextView textView,textData;

        public FishHolderView(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.im_asses_item);
            cardView = itemView.findViewById(R.id.cr_view_container);
            textView = itemView.findViewById(R.id.tv_asses_item);
            textData=itemView.findViewById(R.id.tv_data);
        }
    }

    public interface StartFragmentImage {
        void startFragmentImage(Fishing fishing);
        void onLongClickCardView(Fishing fishing);
        void onClickAddNote(Fishing fishing);
    }
}
