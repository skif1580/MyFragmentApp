package com.example.myfragmentapp.ui.fragment;


import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toolbar;

import com.example.myfragmentapp.R;
import com.example.myfragmentapp.adapter.FishAdapter;
import com.example.myfragmentapp.db.PrezenterDB;
import com.example.myfragmentapp.db.RepozitoriDB;
import com.example.myfragmentapp.model.Fishing;
import com.example.myfragmentapp.prezenter.InitianWindowPrezenter;
import com.example.myfragmentapp.ui.GetStartFragmentImage;
import com.example.myfragmentapp.ui.fragment.interfaces.InitianWindow;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.CompletableObserver;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import moxy.MvpAppCompatFragment;
import moxy.presenter.InjectPresenter;

import static android.app.Activity.RESULT_CANCELED;


public class FragmentStart extends MvpAppCompatFragment implements InitianWindow {
    private RecyclerView recyclerView;
    private List<Fishing> listFishing;
    private FishAdapter fishAdapter;
    private Toolbar toolbar;
    private String name;
    private static final int GALLERY_REQUEST = 1000;
    private long key;
    private Snackbar snackbar;
    @InjectPresenter
    InitianWindowPrezenter prezenter;




    public interface StfrtFragment2 {
        void stertFrag();
    }

    StfrtFragment2 stfrtFragment2;


    public static FragmentStart newInstans() {
        FragmentStart fragmentStart = new FragmentStart();

        return fragmentStart;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            stfrtFragment2 = (StfrtFragment2) context;
        } catch (RuntimeException e) {

        }
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_start_layout, container, false);
        new PrezenterDB().getFisingList()
                .subscribe(new Observer<List<Fishing>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<Fishing> list) {
                        listFishing = list;
                        fishAdapter = new FishAdapter(listFishing,getActivity());

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
        toolbar = view.findViewById(R.id.toolbar);
        toolbar.setTitle("Рибалка");
        toolbar.inflateMenu(R.menu.mymenu);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.mn_add:

                        break;
                    default:
                }
                return true;
            }

        });
        final FishAdapter.StartFragmentImage startFragmentImage = new FishAdapter.StartFragmentImage() {
            @Override
            public void startFragmentImage(Fishing fishing) {
                ((GetStartFragmentImage) getContext()).startImageFragment(fishing);
            }

            @Override
            public void onLongClickCardView(Fishing fishing) {
                addToImageViewFoto(fishing);
            }

            @Override
            public void onClickAddNote(Fishing fishing) {
                deleteFishing(fishing);
            }
        };
        recyclerView = view.findViewById(R.id.rv_list);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));
        recyclerView.setAdapter(fishAdapter);
        fishAdapter.setOnClickImage(startFragmentImage);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        snackbar = Snackbar.make(view, "Ok", BaseTransientBottomBar.LENGTH_LONG);


    }

    private void deleteFishing(final Fishing fishing) {
        AlertDialog.Builder dialogDelet = new AlertDialog.Builder(getActivity());
        dialogDelet.setTitle("Delete List ?")
                .setPositiveButton("Ok", (dialog, which) -> {
                    RepozitoriDB.deleteFishing(fishing);
                    listFishing.remove(fishing);
                    fishAdapter.setList(listFishing);


                });
        dialogDelet.show();

    }

    private void addToImageViewFoto(final Fishing fishing) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Додати фото")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        key = fishing.getId();
                        Intent intent = new Intent(Intent.ACTION_PICK);
                        intent.setType("image/*");
                        String[] mimeTypes = {"image/jpeg", "image/png"};
                        intent.putExtra(Intent.EXTRA_MIME_TYPES, mimeTypes);
                        startActivityForResult(intent, GALLERY_REQUEST);
                    }
                });
        builder.show();


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_CANCELED) {
            if (requestCode == GALLERY_REQUEST) {
                Uri uri = data.getData();
                String pathName = String.valueOf(uri);
                new PrezenterDB().getItemFishingInDB(key)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new SingleObserver<Fishing>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onSuccess(Fishing fishing) {
                                fishing.setImage(pathName);
                                RepozitoriDB.addFIshingDB(fishing);
                                List<Fishing> list;
                                list = RepozitoriDB.getListFishing();
                                fishAdapter.setList(list);

                            }

                            @Override
                            public void onError(Throwable e) {

                            }
                        });
                //new PrezenterDB().getItemFishing(key)
                //          .subscribeOn(Schedulers.io())
                //            .observeOn(AndroidSchedulers.mainThread())
                //              .subscribe(new Consumer<Fishing>() {
                //                    @Override
                //                      public void accept(Fishing fishing) throws Exception {
                //                            fishing.setImage(uristr);
                //                              RepozitoriDB.addFIshingDB(fishing);
//
                //                          }
//
                //     });


            }

        }
    }


    public String getPathFromURI2(Uri contentUri) {
        String res = null;
        String[] proj = {MediaStore.Images.Media.DATA};
        Cursor cursor = getContext().getContentResolver().query(contentUri, proj, null, null, null);
        if (cursor.moveToFirst()) {
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            res = cursor.getString(column_index);
        }
        cursor.close();
        return res;
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    private String getPathFromUri(Uri uri) {
        String filePath = null;
        try {

            String wholeID = DocumentsContract.getDocumentId(uri);
            String id = wholeID.split("=")[1];

            String[] column = {MediaStore.Images.Media.DATA};
            String sel = MediaStore.Images.Media._ID + "=?";
            Cursor cursor = getContext().getContentResolver().
                    query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                            column, sel, new String[]{id}, null);
            int columnIndex = cursor.getColumnIndex(column[0]);
            if (cursor.moveToFirst()) {
                filePath = cursor.getString(columnIndex);
            }
            cursor.close();
        } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
            filePath = getPathFromGalleryV14(uri);
        }
        return filePath;
    }

    private String getPathFromGalleryV14(Uri uri) {
        if (uri == null) {
            return null;
        }
        String filePath = "";
        Cursor cursor = null;
        java.io.File file = null;

        switch (0) {
            case 0: {
                cursor = getContext().getContentResolver().query(uri, new String[]{MediaStore.Images.ImageColumns.DATA}, null, null, null);
                if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
                    filePath = cursor.getString(cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA));
                }
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }

                if (filePath != null && !TextUtils.isEmpty(filePath)) {
                    file = new java.io.File(filePath);
                    if (file.exists()) {
                        break;
                    }
                }
            }
            case 1: {
                cursor = getContext().getContentResolver().query(uri, new String[]{MediaStore.Video.VideoColumns.DATA}, null, null, null);
                if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
                    filePath = cursor.getString(cursor.getColumnIndex(MediaStore.Video.VideoColumns.DATA));
                }
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }

                if (filePath != null && !TextUtils.isEmpty(filePath)) {
                    file = new java.io.File(filePath);
                    if (file.exists()) {
                        break;
                    }
                }
            }
            case 2: {
                filePath = uri.getPath();
                if (filePath != null && !TextUtils.isEmpty(filePath)) {
                    file = new java.io.File(filePath);
                    if (file.exists()) {
                        break;
                    }
                }
            }
            default: {
                return null;
            }
        }
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
        if (filePath != null && !TextUtils.isEmpty(filePath)) {
            filePath = filePath.trim();
        }
        return filePath;
    }

    public interface GowFragmentNetwork {
        public void getFragmentNetwork();

    }

}


