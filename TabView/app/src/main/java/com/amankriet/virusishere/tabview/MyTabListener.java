package com.amankriet.virusishere.tabview;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.widget.Toast;

public class MyTabListener implements ActionBar.TabListener {

    public Fragment fragment;
    public MyTabListener(Fragment fragment)
    {
        this.fragment=fragment;
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction transaction) {

        Toast.makeText(ActionBarView.mycontext, "You have clicked again!", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction transaction) {

        transaction.replace(R.id.actionbar, fragment);

    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction transaction) {

        transaction.remove(fragment);

    }

}
