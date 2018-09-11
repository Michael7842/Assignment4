package com.michael.customers.Fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.michael.customers.R;

import static android.app.Activity.RESULT_CANCELED;

public class UserImage extends Fragment implements View.OnClickListener {
    private static final String ARG_TEXT = "arg_text";
    private static final String ARG_COLOR = "arg_color";
    private String mText;
    private int mColor;
    Button mSave, mCapture;
    Bitmap bitmap = null;
    private int CAMERA_REQUEST;
    ImageView userImage;

    public static Fragment newInstance(String text) {
        Fragment frag = new UserImage();
        Bundle args = new Bundle();
        args.putString(ARG_TEXT, text);
        frag.setArguments(args);
        return frag;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.user_image, container, false);


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


        mSave = view.findViewById(R.id.save);
        mCapture = view.findViewById(R.id.capture_image);

        mSave.setOnClickListener(this);
        mCapture.setOnClickListener(this);

        userImage = view.findViewById(R.id.user_image);

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

            case R.id.save:

                if (bitmap == null) {

                    Toast.makeText(getActivity(), "Capture image first", Toast.LENGTH_LONG).show();

                } else {
                    Fragment selectedFragment = UsersList.newInstance("");
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.container, selectedFragment);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }

                break;

            case R.id.capture_image:

                Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, CAMERA_REQUEST);

                break;

        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {


        if (requestCode == CAMERA_REQUEST) {
            bitmap = (Bitmap) data.getExtras().get("data");
            userImage.setImageBitmap(bitmap);
        } else if (resultCode == RESULT_CANCELED) {

            Toast.makeText(getActivity(), " Picture was not taken ", Toast.LENGTH_SHORT).show();
        } else {

            Toast.makeText(getActivity(), " Picture was not taken ", Toast.LENGTH_SHORT).show();
        }
    }
}