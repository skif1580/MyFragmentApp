package com.example.myfragmentapp.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myfragmentapp.R;
import com.example.myfragmentapp.model.Fish;
import com.example.myfragmentapp.model.Fishing;

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
        holder.imageView.setImageResource(fishing.getImage());
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (startFragmentImage != null) {
                    startFragmentImage.startFragmentImage(fishing);
                }
            }
        });

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
    }
}
