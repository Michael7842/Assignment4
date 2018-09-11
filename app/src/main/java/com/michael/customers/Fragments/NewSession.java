package com.michael.customers.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.michael.customers.R;


public class NewSession extends Fragment implements View.OnClickListener {
    private static final String ARG_TEXT = "arg_text";
    private static final String ARG_COLOR = "arg_color";
    private String mText;
    private int mColor;
    Button mPrint,mEmail;
    EditText custName,creditCard,amount;


    public static Fragment newInstance(String text) {
        Fragment frag = new NewSession();
        Bundle args = new Bundle();
        args.putString(ARG_TEXT, text);
        frag.setArguments(args);
        return frag;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.new_session, container, false);


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



        mPrint = view.findViewById(R.id.print);
        mEmail = view.findViewById(R.id.email);

        custName = view.findViewById(R.id.cust_name);
        creditCard = view.findViewById(R.id.credit_card);
        amount = view.findViewById(R.id.amount);

        mPrint.setOnClickListener(this);
        mEmail.setOnClickListener(this);


    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString(ARG_TEXT, mText);
        outState.putInt(ARG_COLOR, mColor);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.print:

                if (custName.getText().toString().isEmpty() || amount.getText().toString().isEmpty() || creditCard.getText().toString().isEmpty()) {

                    Toast.makeText(getActivity(), "Fill empty fields", Toast.LENGTH_LONG).show();

                } else {

                    Toast.makeText(getActivity(), "Printed Successfully", Toast.LENGTH_LONG).show();


                }

                break;


            case R.id.email:

                if (custName.getText().toString().isEmpty() || amount.getText().toString().isEmpty() || creditCard.getText().toString().isEmpty()) {

                    Toast.makeText(getActivity(), "Fill empty fields", Toast.LENGTH_LONG).show();

                } else {

                    Toast.makeText(getActivity(), "Email sent", Toast.LENGTH_LONG).show();


                }

                break;

        }
    }
}