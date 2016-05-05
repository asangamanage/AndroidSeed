package com.example.androidseed.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;


/**
 * Created by Asanga Manage on 5/05/2016.
 */
public class UI {
    public static void showFragment(FragmentActivity fragmentActivity, int fragmentPlaceHolder, Fragment fragment) {
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentActivity.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(fragmentPlaceHolder, fragment);
        fragmentTransaction.commit();
    }
}
