package com.example.android.tourguide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Massimiliano on 08/02/2018.
 */

public class CategoryAdapter extends FragmentPagerAdapter {

    private Context context;
    private String tabTitles[] = new String[4];


    public CategoryAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
        tabTitles[0] = context.getApplicationContext().getString(R.string.category_historical);
        tabTitles[1] = context.getApplicationContext().getString(R.string.category_hotels);
        tabTitles[2] = context.getApplicationContext().getString(R.string.category_restaurants);
        tabTitles[3] = context.getApplicationContext().getString(R.string.category_events);

    }

    @Override
    public Fragment getItem(int position) {

        if (position == 0) {
            return new HistoricalFragment();
        } else if (position == 1){
            return new HotelsFragment();
        } else if (position == 2){
            return new RestaurantsFragment();
        }  else {
            return new EventsFragment();
        }

    }

    @Override
    public CharSequence getPageTitle(int position) {

        return tabTitles[position];

    }


    @Override
    public int getCount() {
        return 4;
    }

}
