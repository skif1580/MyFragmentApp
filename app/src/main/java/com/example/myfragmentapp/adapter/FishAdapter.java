package com.example.myfragmentapp.adapter;


import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.myfragmentapp.R;
import com.example.myfragmentapp.app.App;
import com.example.myfragmentapp.db.PrezenterDB;
import com.example.myfragmentapp.db.RepozitoriDB;
import com.example.myfragmentapp.model.Fishing;
import com.example.myfragmentapp.prezenter.InitianWindowPrezenter;
import com.example.myfragmentapp.ui.fragment.FragmentStart;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.CompletableObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class FishAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_FOOTER = 1;
    private static final int TYPE_ITEM = 2;
    private String name;
    private Context context;



    private List<Fishing> list;
    StartFragmentImage startFragmentImage;

    public void setOnClickImage(StartFragmentImage startFragmentImage) {
        this.startFragmentImage = startFragmentImage;
    }

    public FishAdapter(List<Fishing> list, Context context) {
        this.list = list;
        this.context=context;
        list.add(new Fishing());

    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_ITEM) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fish_item_adapter, parent, false);
            return new FishHolderView(view);
        } else if (viewType == TYPE_FOOTER) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_flooter, parent, false);
            return new FooterHolder(view);
        } else

            return null;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof FishHolderView) {
            FishHolderView holderView = (FishHolderView) holder;
            final Fishing fishing = list.get(position);
            holderView.textView.setText(fishing.getName());
            holderView.textData.setText(fishing.getDate());
            if (fishing.getImage() != null) {
                Uri uri = Uri.parse(fishing.getImage());
                Glide.with(holderView.imageView.getContext())
                        .load(uri)
                        .centerCrop()
                        .placeholder(R.drawable.images)
                        .into(holderView.imageView);
                holderView.imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (startFragmentImage != null) {
                            startFragmentImage.startFragmentImage(fishing);
                        }
                    }
                });
            }
            holderView.cardView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    startFragmentImage.onLongClickCardView(fishing);
                    return true;
                }
            });
            holderView.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startFragmentImage.onClickAddNote(fishing);

                }
            });


        } else if (holder instanceof FooterHolder) {
            FooterHolder footerHolder = (FooterHolder) holder;
            footerHolder.textView.setText("ADD fisching");
            footerHolder.textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final View view = View.inflate(context,R.layout.aler_dialog, null);
                    AlertDialog.Builder dialog = new AlertDialog.Builder(context);
                    dialog.setTitle("Add fishing")
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .setView(view)
                            .setPositiveButton("OK", (dialog1, which) -> {
                                EditText editText = view.findViewById(R.id.et_alert);
                                name = editText.getText().toString();
                                Fishing fishing = new Fishing();
                                new PrezenterDB().myComplit(fishing)
                                        .subscribeOn(Schedulers.io())
                                        .observeOn(AndroidSchedulers.mainThread())
                                        .subscribe(new CompletableObserver() {
                                            @Override
                                            public void onSubscribe(Disposable d) {

                                            }

                                            @Override
                                            public void onComplete() {


                                            }

                                            @Override
                                            public void onError(Throwable e) {


                                            }
                                        });
                                fishing.setName(name);
                                list.add(fishing);
                                RepozitoriDB.addFIshingDB(fishing);
                                setList(list);

                            })
                            .setNegativeButton("Cansel", null);

                    dialog.show();


                }
            });
        }

    }

    public void setList(List<Fishing> list) {
        this.list = list;
        notifyDataSetChanged();
    }
    @Override
    public int getItemViewType(int position) {
        if (position == list.size()-1 ) {
            return TYPE_FOOTER;
        } else
            return TYPE_ITEM;
    }
    @Override
    public int getItemCount() {
        return list.size() ;
    }


    public class FishHolderView extends RecyclerView.ViewHolder {
        private CardView cardView;
        private ImageView imageView;
        private TextView textView, textData;

        public FishHolderView(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.im_asses_item);
            cardView = itemView.findViewById(R.id.cr_view_container);
            textView = itemView.findViewById(R.id.tv_asses_item);
            textData = itemView.findViewById(R.id.tv_data);
        }
    }

    public class FooterHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public FooterHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_footer_text);
        }
    }

    public interface StartFragmentImage {
        void startFragmentImage(Fishing fishing);

        void onLongClickCardView(Fishing fishing);

        void onClickAddNote(Fishing fishing);
    }
}
