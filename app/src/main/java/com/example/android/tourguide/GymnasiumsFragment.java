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
public class GymnasiumsFragment extends Fragment {

    public GymnasiumsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.place_list, container, false);

        // Create a list of restaurants
        final ArrayList<Place> places = new ArrayList<>();
        places.add(new Place(R.string.place_espinho, R.string.address_place_espinho,
                R.string.website_place_espinho, R.drawable.gym_place));

        places.add(new Place(R.string.victoria_gym, R.string.address_victoria_gym,
                R.string.website_victoria_gym, R.drawable.gym_victoria));

        places.add(new Place(R.string.progresso_fitness_academy, R.string.address_progresso,
                R.string.website_progresso, R.drawable.gym_progresso));

        places.add(new Place(R.string.ginasio_ativa, R.string.address_ginasio_ativa,
                R.string.website_ginasio_ativa, R.drawable.gym_ativa));

        places.add(new Place(R.string.onfit, R.string.address_onfit,
                R.string.website_onfit, R.drawable.gym_onfit));

        places.add(new Place(R.string.fitbox, R.string.address_fitbox,
                R.string.website_fitbox, R.drawable.gym_fitbox));

        places.add(new Place(R.string.esmoriz_ginasio_clube, R.string.address_esmoriz,
                R.string.website_esmoriz, R.drawable.gym_esmoriz));

        // Create an {@link PlaceAdapter}, whose data source is a list of {@link Place}s. The
        // adapter knows how to create list items for each item in the list.
        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places, R.color.category_gyms);

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
