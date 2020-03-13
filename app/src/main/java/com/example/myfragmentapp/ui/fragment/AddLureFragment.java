package com.example.myfragmentapp.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.myfragmentapp.R;
import com.example.myfragmentapp.prezenter.LurePrezenter;
import com.example.myfragmentapp.ui.fragment.interfaces.LureView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import moxy.MvpAppCompatFragment;
import moxy.presenter.InjectPresenter;

public class AddLureFragment extends MvpAppCompatFragment implements LureView, View.OnClickListener {
    private RadioGroup radioGroup;
    private RadioButton rbVobbler, rbSilikon, rbSpoon;
    private EditText etNameProduser, etNameModel;
    private ImageView imageView;
    private Button btSaveLure, btExsit;
    private String typeLure;

    @InjectPresenter
    LurePrezenter prezenter;

    public static AddLureFragment newInstance() {

        Bundle args = new Bundle();

        AddLureFragment fragment = new AddLureFragment();
        fragment.setArguments(args);
        return fragment;
    }
      LureColectionListener lureColectionListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        lureColectionListener=(LureColectionListener) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_lure_fragment, container, false);
        initView(view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.rb_add_vobbler:
                    typeLure = "VOBBLER";
                    break;
                case R.id.rd_add_silikon:
                    typeLure = "SILIKON";
                    break;
                case R.id.rd_add_spoon:
                    typeLure = "SPOON";
                    break;
            }
        });

    }

    private void initView(View view) {
        radioGroup = view.findViewById(R.id.rg_add_lure);
        rbVobbler = view.findViewById(R.id.rb_add_vobbler);
        rbSilikon = view.findViewById(R.id.rd_add_silikon);
        rbSpoon = view.findViewById(R.id.rd_add_spoon);
        etNameModel = view.findViewById(R.id.et_add_name_model_lure);
        etNameProduser = view.findViewById(R.id.et_add_name_lure);
        btSaveLure = view.findViewById(R.id.bt_save_lure);
        btSaveLure.setOnClickListener(this);
        btExsit = view.findViewById(R.id.bt_cancel_save_lure);
        btExsit.setOnClickListener(this);
        imageView = view.findViewById(R.id.iv_add_lure_image);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_save_lure:
                String nameProduser = etNameProduser.getText().toString();
                String nameModelLure = etNameModel.getText().toString();
                if (etNameProduser.length() > 0 && etNameModel.length() > 0) {
                    if (typeLure != null) {
                        prezenter.addNewLureModel(nameProduser, nameModelLure, typeLure);
                    } else {
                        Toast.makeText(getActivity(), "Виберіть тип приманки", Toast.LENGTH_SHORT).show();
                    }

                } else
                    Toast.makeText(getActivity(), "Заповніть всі поля", Toast.LENGTH_SHORT).show();

                break;
            case R.id.bt_cancel_save_lure:
                if (lureColectionListener!=null){
                    lureColectionListener.getLureColectionListener();
                }
                break;
        }

    }

    @Override
    public void schowMessage() {
        Toast.makeText(getActivity(), "Збереженно", Toast.LENGTH_SHORT).show();
        radioGroup.clearCheck();
        etNameModel.getText().clear();
        etNameProduser.getText().clear();

    }

    @Override
    public void onDetach() {
        super.onDetach();
        lureColectionListener=null;
    }

    public interface LureColectionListener{
        void getLureColectionListener();
    }
}
