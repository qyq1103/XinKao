package com.xinkao.xinkao.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xinkao.xinkao.R;

public class ContactsList extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contacts_list_view = inflater.inflate(R.layout.contacts_list, null);
        TextView textView = contacts_list_view.findViewById(R.id.contact_list_tv);
        textView.setText("联系人");
        return contacts_list_view;
    }
}
