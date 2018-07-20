package com.amankriet.virusishere.tabview;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.app.Fragment;
import android.os.Bundle;
import android.widget.Toast;

public class ActionBarView extends Activity {

    public static Context mycontext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mycontext=getApplicationContext();
        try
        {
            ActionBar actionbar=getActionBar();
            actionbar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
            ActionBar.Tab tab1=actionbar.newTab().setText("Tab 1");
            ActionBar.Tab tab2=actionbar.newTab().setText("Tab 2");
            ActionBar.Tab tab3=actionbar.newTab().setText("Tab 3");
            ActionBar.Tab tab4=actionbar.newTab().setText("Tab 4");
            Fragment fragment1=new FirstFragment();
            Fragment fragment2=new SecondFragment();
            Fragment fragment3=new ThirdFragment();
            Fragment fragment4=new FourthFragment();
            tab1.setTabListener(new MyTabListener(fragment1));
            tab2.setTabListener(new MyTabListener(fragment2));
            tab3.setTabListener(new MyTabListener(fragment3));
            tab4.setTabListener(new MyTabListener(fragment4));
        }
        catch(Exception e)
        {
            Toast.makeText(getApplicationContext(),"NullPointerException",Toast.LENGTH_SHORT).show();

        }

    }
}
