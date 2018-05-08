package com.example.android.tourguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class BarsFragment extends Fragment {

    public BarsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.place_list, container, false);

        // Create a list of restaurants

        final ArrayList<Place> places = new ArrayList<>();

        places.add(new Place(R.string.wish, R.string.address_wish,
                R.string.website_wish, R.drawable.bar_wish));

        places.add(new Place(R.string.aldeao_bar, R.string.address_aldeao_bar,
                R.string.website_aldeao_bar, R.drawable.bar_aldeao));

        places.add(new Place(R.string.baia_sunset, R.string.address_baia_sunset,
                R.string.website_baia_sunset, R.drawable.bar_baia_sunset));

        places.add(new Place(R.string.denisov_cafe, R.string.address_denisov,
                R.string.website_denisov, R.drawable.bar_denisov));

        places.add(new Place(R.string.rochas_bar, R.string.address_rochas,
                R.string.website_rochas, R.drawable.bar_rochas));

        places.add(new Place(R.string.ruamachines, R.string.address_ruamachines,
                R.string.website_ruamachines, R.drawable.bar_ruamachines));


        // Create an {@link PlaceAdapter}, whose data source is a list of {@link Place}s. The
        // adapter knows how to create list items for each item in the list.
        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places, R.color.category_bars);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // place_list.xml layout file.
        ListView listView = rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link PlaceAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Place} in the list.
        listView.setAdapter(adapter);

        // Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Get the {@link Place} object at the given position the user clicked on
                Place place = places.get(position);
                if (place.hasWebsite()) {
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(getString(place.getWebsiteResourceId())));
                    startActivity(i);
                }
            }
        });

        return rootView;
    }
}
