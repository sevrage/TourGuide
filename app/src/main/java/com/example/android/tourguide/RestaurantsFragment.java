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
public class RestaurantsFragment extends Fragment {

    public RestaurantsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.place_list, container, false);

        // Create a list of restaurants
        final ArrayList<Place> places = new ArrayList<>();
        places.add(new Place(R.string.grao_de_soja, R.string.address_grao_de_soja,
                R.string.website_grao_de_soja, R.drawable.grao_de_soja));

        places.add(new Place(R.string.terra_viva, R.string.address_terra_viva,
                R.string.website_terra_viva, R.drawable.terra_viva));

        places.add(new Place(R.string.baliza, R.string.address_baliza,
                R.string.website_baliza, R.drawable.baliza));

        places.add(new Place(R.string.a_cabana, R.string.address_a_cabana,
                R.string.website_a_cabana, R.drawable.a_cabana));

        places.add(new Place(R.string.aquario, R.string.address_aquario,
                R.string.website_aquario, R.drawable.aquario));

        places.add(new Place(R.string.terminal_8, R.string.address_terminal_8,
                R.string.website_terminal_8, R.drawable.terminal_8));

        places.add(new Place(R.string.hora_h, R.string.address_hora_h,
                R.string.website_hora_h, R.drawable.hora_h));

        places.add(new Place(R.string.a_fornalha, R.string.address_a_fornalha,
                R.string.website_a_fornalha, R.drawable.a_fornalha));


        // Create an {@link PlaceAdapter}, whose data source is a list of {@link Place}s. The
        // adapter knows how to create list items for each item in the list.
        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places, R.color.category_restaurants);

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
