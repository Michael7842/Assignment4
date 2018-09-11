package com.michael.customers.Fragments;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.michael.customers.HelperClass.DataAdapter;
import com.michael.customers.HelperClass.User;
import com.michael.customers.R;

import java.util.ArrayList;

import static android.app.Activity.RESULT_CANCELED;

public class UsersList extends Fragment implements View.OnClickListener {
    private static final String ARG_TEXT = "arg_text";
    private static final String ARG_COLOR = "arg_color";
    private String mText;
    private int mColor;
    Button sessions;

    private final String usersName[] = {
            "Michael",
            "Doae",
            "John",
            "Johnson",
            "Justin",
            "Terry",
            "Lampard",
            "Stevin",
            "Jarrad",
            "Hazzard"
    };

    private final int usersImages[] = {

            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,

    };

    public static Fragment newInstance(String text) {
        Fragment frag = new UsersList();
        Bundle args = new Bundle();
        args.putString(ARG_TEXT, text);
        frag.setArguments(args);
        return frag;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.user_list, container, false);


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        if (savedInstanceState == null) {
            Bundle args = getArguments();
            mText = args.getString(ARG_TEXT);
            mColor = args.getInt(ARG_COLOR);
        } else {
            mText = savedInstanceState.getString(ARG_TEXT);
            mColor = savedInstanceState.getInt(ARG_COLOR);
        }


        sessions = view.findViewById(R.id.session);
        sessions.setOnClickListener(this);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.users_list);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<User> userList = prepareData();
        DataAdapter adapter = new DataAdapter(getActivity(), userList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString(ARG_TEXT, mText);
        outState.putInt(ARG_COLOR, mColor);
        super.onSaveInstanceState(outState);
    }

    private ArrayList<User> prepareData() {

        ArrayList<User> android_version = new ArrayList<>();
        for (int i = 0; i < usersName.length; i++) {
            User user = new User();
            user.setUserName(usersName[i]);
            user.setUserImage(usersImages[i]);
            android_version.add(user);
        }
        return android_version;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.session:
                Fragment selectedFragment = SessionsList.newInstance("");
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, selectedFragment);
                transaction.addToBackStack(null);
                transaction.commit();
                break;

        }


    }
}