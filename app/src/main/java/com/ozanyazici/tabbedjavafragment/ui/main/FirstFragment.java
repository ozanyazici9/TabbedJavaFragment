package com.ozanyazici.tabbedjavafragment.ui.main;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.ozanyazici.tabbedjavafragment.R;


public class FirstFragment extends Fragment {

    public static FirstFragment newinstance() {
        return new FirstFragment();
    }

    PageViewModel pageViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Aşagıkadi toast mesajını fragment içerisinde Context nasıl alınıyor onu göstermek için yaptık.
        //Toast.makeText(getActivity().getApplicationContext(),"Toast message",Toast.LENGTH_LONG).show();

        pageViewModel = new ViewModelProvider(requireActivity()).get(PageViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        return inflater.inflate(R.layout.fragment_first,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText editText = view.findViewById(R.id.editText);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            //text değişmeden önce ne yapılacağı
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            //text değişirken ne yapılacağı
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                pageViewModel.setName(charSequence.toString());
            }

            @Override
            //text değiştikten sonra ne yapılacağı
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}