package com.example.android.tourguide;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * {@link PlaceAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link Place} objects.
 */
public class PlaceAdapter extends ArrayAdapter<Place> {

    /**
     * Resource ID for the background color for this list of words
     */
    private int mColorResourceId;

    /**
     * Create a new {@link PlaceAdapter} object.
     *
     * @param context         is the current context (i.e. Activity) that the adapter is being created in.
     * @param words           is the list of {@link Place}s to be displayed.
     * @param colorResourceId is the resource ID for the background color for this list of words
     */
    public PlaceAdapter(Context context, ArrayList<Place> words, int colorResourceId) {
        super(context, 0, words);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Place} object located at this position in the list
        Place currentPlace = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID name_text_view.
        TextView nameTextView = listItemView.findViewById(R.id.name_text_view);
        // Get Place Name
        nameTextView.setText(currentPlace.getNameResourceId());

        // Find the TextView in the list_item.xml layout with the ID default_text_view.
        TextView websiteTextView = listItemView.findViewById(R.id.website_text_view);
        // Get Place website
        if (currentPlace.hasWebsite()) {
            websiteTextView.setText(currentPlace.getWebsiteResourceId());
            websiteTextView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide
            websiteTextView.setVisibility(View.GONE);
        }

        // Find the TextView in the list_item.xml layout with the ID default_text_view.
        TextView addressTextView = listItemView.findViewById(R.id.address_text_view);
        // Get Place address
        if (currentPlace.hasAddress()) {
            addressTextView.setText(currentPlace.getAddressResourceId());
            addressTextView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide
            addressTextView.setVisibility(View.GONE);
        }

        // Find the ImageView in the list_item.xml layout with the ID image.
        ImageView imageView = listItemView.findViewById(R.id.image);
        // Check if an image is provided for this word or not
        if (currentPlace.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            imageView.setImageResource(currentPlace.getImageResourceId());
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return listItemView;
    }
}