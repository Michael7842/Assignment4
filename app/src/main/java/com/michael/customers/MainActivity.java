package com.michael.customers;


import android.os.Bundle;

import android.view.View;
import android.widget.Toast;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;


import com.michael.customers.Fragments.NewUser;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Logged In: " + getResources().getString(R.string.logged_in));

        Fragment selectedFragment = NewUser.newInstance("");
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, selectedFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void showToast(View view) {
        Toast.makeText(this, "Logging you off", Toast.LENGTH_SHORT).show();
        setContentView(R.layout.activity_main);
    }
}
