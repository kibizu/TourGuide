package com.example.android.tourguide;


import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Massimiliano on 11/02/2018.
 */

public class InfoAdapter extends ArrayAdapter<Info> {

    int mColorResourceId;


    public InfoAdapter(Activity context, ArrayList<Info> infos, int colorResourceId) {
        super(context, 0, infos);
        this.mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Info} object located at this position in the list
        Info currentInfo = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID tour_text_view
        TextView tourTextView = (TextView) listItemView.findViewById(R.id.tour_text_view);

        // Get the tour info from the current Info object and
        // set this text on the info TextView
        tourTextView.setText(currentInfo.getNameInfo());

        // Find the TextView in the list_item.xml layout with the ID default_text_view
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        // Get the address of the place from the current Info object and
        // set this text on the default address TextView
        defaultTextView.setText(currentInfo.getAddress());

        // Find the ImageView in the list_item.xml layout with the ID image_view
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        // Get the image from the current Word object and
        // set this text on the miwok TextView
        if (currentInfo.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            imageView.setImageResource(currentInfo.getImageResourceId());
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }

        View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(),mColorResourceId);
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;


    }

}
