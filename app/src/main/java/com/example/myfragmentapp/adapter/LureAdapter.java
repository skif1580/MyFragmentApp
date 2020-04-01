package com.example.myfragmentapp.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myfragmentapp.R;
import com.example.myfragmentapp.db.RepozitoriDB;
import com.example.myfragmentapp.model.LureModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class LureAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static int TYPE_VOBLER = 1;
    public static int TYPE_SILIKON = 2;
    public static int TYPE_SPOON = 3;
    private List<LureModel> listLure;
    private LureModel lureModel;
    private Context context;
    OnClickListenerItem onClickListenerItem;


    public LureAdapter(List<LureModel> listLure, Context context) {
        this.listLure = listLure;
        this.context = context;
    }

    public void setOnClickImage(OnClickListenerItem onClickImage) {
        this.onClickListenerItem = onClickImage;
    }

    @NonNull
    @Override
    public LureHolderView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_lure, parent, false);
        return new LureHolderView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        LureHolderView lureHolderView = (LureHolderView) holder;
        if (getItemViewType(position) == TYPE_VOBLER) {
            lureModel = listLure.get(position);
            lureHolderView.tvName.setText(lureModel.getNameProducer());
            lureHolderView.tvSybname.setText(lureModel.getNameModel());
            lureHolderView.imageView.setImageResource(R.drawable.vobbler);
            //  Uri uri= Uri.parse(lureModel.getImage());
            // Glide.with(context)
            //       .load(uri)
            //     .centerCrop()
            //   .placeholder(R.drawable.vobbler)
            // .into(lureHolderView.imageView);
            lureHolderView.imageView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onClickListenerItem != null) {
                        onClickListenerItem.clickImageListener(lureModel);
                    }

                }
            });
            lureHolderView.cardView.setOnLongClickListener(v -> {
                if (onClickListenerItem !=null){
                    onClickListenerItem.itemClickListener(lureModel);
                }
                return true;
            });
        } else if (getItemViewType(position) == TYPE_SILIKON) {
            lureModel = listLure.get(position);
            lureHolderView.tvName.setText(lureModel.getNameProducer());
            lureHolderView.tvSybname.setText(lureModel.getNameModel());
            lureHolderView.imageView.setImageResource(R.drawable.silikon);
            lureHolderView.imageView.setOnClickListener(v -> {
                if (onClickListenerItem!=null){
                    onClickListenerItem.itemClickListener(lureModel);
                }
            });
            lureHolderView.cardView.setOnLongClickListener(v -> {
                if (onClickListenerItem!=null){
                    onClickListenerItem.itemClickListener(lureModel);
                }
                return true;
            });
        } else {
            lureModel = listLure.get(position);
            lureHolderView.tvName.setText(lureModel.getNameProducer());
            lureHolderView.tvSybname.setText(lureModel.getNameModel());
            lureHolderView.imageView.setImageResource(R.drawable.spoon);
            lureHolderView.imageView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onClickListenerItem!=null){
                        onClickListenerItem.clickImageListener(lureModel);
                    }
                }
            });
            lureHolderView.cardView.setOnLongClickListener(v -> {
                if (onClickListenerItem!=null){
                    onClickListenerItem.itemClickListener(lureModel);
                }
                return true;
            });
        }
    }


    @Override
    public int getItemViewType(int position) {
        if (listLure.get(position).getTypeLure().equals("VOBBLER")) {
            return TYPE_VOBLER;
        } else if (listLure.get(position).getTypeLure().equals("SILIKON")) {
            return TYPE_SILIKON;
        } else {
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

    public interface OnClickListenerItem {
        void itemClickListener(LureModel lureModel);
        void clickImageListener(LureModel lureModel);
    }
}
