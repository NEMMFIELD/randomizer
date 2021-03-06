package com.rsschool.android2021;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements ChangeFragments{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openFirstFragment(0);
    }

    private void openFirstFragment(int previousNumber) {
        final Fragment firstFragment = FirstFragment.newInstance(previousNumber);
        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, firstFragment);
        // TODO: invoke function which apply changes of the transaction
        transaction.commit();
    }

    private void openSecondFragment(int min, int max) {
        // TODO: implement it
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Fragment secondFragment = SecondFragment.newInstance(min,max);
        ft.replace(R.id.container,secondFragment);
       // ft.addToBackStack(null);
        ft.commit();
    }

    @Override
    public void toFirst(int number) {
        openFirstFragment(number);
    }

    @Override
    public void toSecond(int min, int max) {
    openSecondFragment(min,max);
    }
}
