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
public class BeachesFragment extends Fragment {

    public BeachesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.place_list, container, false);

        // Create a list of beaches
        final ArrayList<Place> places = new ArrayList<>();

        places.add(new Place(R.string.praia_baia, R.string.address_praia_baia,
                R.drawable.praia_baia));

        places.add(new Place(R.string.praia_espinho, R.string.espinho, R.drawable.praia_espinho));

        places.add(new Place(R.string.praia_paramos, R.string.espinho, R.drawable.praia_paramos));

        places.add(new Place(R.string.praia_frente_azul, R.string.espinho,
                R.drawable.praia_frente_azul));

        places.add(new Place(R.string.praia_marbelo, R.string.address_praia_marbelo,
                R.drawable.praia_marbelo));

        places.add(new Place(R.string.praia_pescadores, R.string.address_praia_pescadores,
                R.drawable.praia_pescadores));

        // Create an {@link PlaceAdapter}, whose data source is a list of {@link Place}s. The
        // adapter knows how to create list items for each item in the list.
        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places, R.color.category_beaches);

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

