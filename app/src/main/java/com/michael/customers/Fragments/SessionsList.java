package com.michael.customers.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.michael.customers.HelperClass.DataAdapter;
import com.michael.customers.HelperClass.Session;
import com.michael.customers.HelperClass.SessionAdapter;
import com.michael.customers.HelperClass.User;
import com.michael.customers.R;

import java.util.ArrayList;

public class SessionsList extends Fragment implements View.OnClickListener {
    private static final String ARG_TEXT = "arg_text";
    private static final String ARG_COLOR = "arg_color";
    private String mText;
    private int mColor;
    Button createSession;

    private final String usersName[] = {
            "Michael",
            "Doae",
            "John",

    };

    private final String durations[] = {
            "10:00 am - 12:00 pm",
            "10:00 am - 12:00 pm",
            "10:00 am - 12:00 pm",


    };


    public static Fragment newInstance(String text) {
        Fragment frag = new SessionsList();
        Bundle args = new Bundle();
        args.putString(ARG_TEXT, text);
        frag.setArguments(args);
        return frag;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.sessions_list, container, false);


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


        createSession = view.findViewById(R.id.create_session);
        createSession.setOnClickListener(this);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.sessions_list);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<Session> sessions = prepareData();
        SessionAdapter adapter = new SessionAdapter(getActivity(), sessions);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString(ARG_TEXT, mText);
        outState.putInt(ARG_COLOR, mColor);
        super.onSaveInstanceState(outState);
    }

    private ArrayList<Session> prepareData() {

        ArrayList<Session> android_version = new ArrayList<>();
        for (int i = 0; i < usersName.length; i++) {
            Session session = new Session();
            session.setUserName(usersName[i]);
            session.setUserImage(durations[i]);
            android_version.add(session);
        }
        return android_version;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {


            case R.id.create_session:
                Fragment selectedFragment = NewSession.newInstance("");
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, selectedFragment);
                transaction.addToBackStack(null);
                transaction.commit();
                break;
        }


    }
}