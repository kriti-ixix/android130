package com.kriti.android1_30;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class AddFragment extends Fragment
{

    TextView textView;

    AddFragment() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add, container, false);

        textView = view.findViewById(R.id.fragmentTextView);
        Toast.makeText(getContext(), "Add Fragment", Toast.LENGTH_LONG).show();

        return view;
    }
}