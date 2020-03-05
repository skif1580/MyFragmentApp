package com.example.myfragmentapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myfragmentapp.R;
import com.example.myfragmentapp.model.LureModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class LureAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static int TYPE_VOBLER = 1;
    public static int TYPE_SILIKON = 2;
    public static int TYPE_SPOON = 3;
    private static final int TYPE_FLOOTER = 1;
    private static final int TYPE_ITEM = 2;
    private List<LureModel> listLure;
    private LureModel lureModel;


    public LureAdapter(List<LureModel> listLure) {
        this.listLure = listLure;
    }

    @NonNull
    @Override
    public LureHolderView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_lure, parent, false);
            return new LureHolderView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        LureHolderView lureHolderView=(LureHolderView) holder;
            if (getItemViewType(position) == TYPE_VOBLER) {
                lureModel = listLure.get(position);
                lureHolderView.tvName.setText(lureModel.getName());
                lureHolderView.imageView.setImageResource(R.drawable.vobbler);
            } else if (getItemViewType(position) == TYPE_SILIKON) {
                lureModel = listLure.get(position);
                lureHolderView.tvName.setText(lureModel.getName());
                lureHolderView.imageView.setImageResource(R.drawable.silikon);
            } else {
                lureModel = listLure.get(position);
                lureHolderView.tvName.setText(lureModel.getName());
                lureHolderView.imageView.setImageResource(R.drawable.spoon);
            }
        }





    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position, @NonNull List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
    }

    @Override
    public int getItemViewType(int position) {
        if (listLure.get(position).getTypeLure().equals("VOBBLER")) {
            return TYPE_VOBLER;
        } else if (listLure.get(position).getTypeLure().equals("SILIKON")) {
            return TYPE_SILIKON;
        } else{
            return TYPE_SPOON;
        }

    }



    @Override
    public int getItemCount() {
        return listLure.size();
    }


    public void setList(List<LureModel> list) {
        this.listLure = list;
        notifyDataSetChanged();
    }

    public class LureHolderView extends RecyclerView.ViewHolder {
        private CardView cardView;
        private ImageView imageView;
        private TextView tvName, tvSybname;

        public LureHolderView(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cv_lure_container);
            imageView = itemView.findViewById(R.id.im_lure_item);
            tvName = itemView.findViewById(R.id.tv_lure_name);
            tvSybname = itemView.findViewById(R.id.tv_lure_sybname);

        }
    }

}
