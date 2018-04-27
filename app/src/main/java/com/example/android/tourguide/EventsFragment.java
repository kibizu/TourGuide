package com.example.android.tourguide;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventsFragment extends Fragment {

    private Activity context;


    public EventsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.info_list, container,false);

        context = getActivity();

        final ArrayList<Info> infos = new ArrayList<Info>();

        infos.add(new Info(context.getResources().getString(R.string.cittapizza), context.getResources().getString(R.string.addrcittapizza), context.getResources().getString(R.string.positcittapizza), R.drawable.cittapizza, R.drawable.cittapizzabig, context.getResources().getString(R.string.descrcittapizza), R.drawable.info,context.getResources().getString(R.string.informations)));
        infos.add(new Info(context.getResources().getString(R.string.gelatofestival), context.getResources().getString(R.string.addrgelatofestival), context.getResources().getString(R.string.positgelatofestival), R.drawable.gelatofestival, R.drawable.gelatofestivalbig, context.getResources().getString(R.string.descrgelatofestival), R.drawable.info,context.getResources().getString(R.string.informations)));
        infos.add(new Info(context.getResources().getString(R.string.hiroshige), context.getResources().getString(R.string.addrhiroshige), context.getResources().getString(R.string.posithiroshige), R.drawable.hiroshige, R.drawable.hiroshigebig, context.getResources().getString(R.string.descrhiroshige), R.drawable.info,context.getResources().getString(R.string.informations)));
        infos.add(new Info(context.getResources().getString(R.string.klimtexperience), context.getResources().getString(R.string.addrklimtexperience), context.getResources().getString(R.string.positklimtexperience), R.drawable.klimtexperience, R.drawable.klimtexperiencebig, context.getResources().getString(R.string.descrklimtexperience), R.drawable.info,context.getResources().getString(R.string.informations)));
        infos.add(new Info(context.getResources().getString(R.string.liubolin), context.getResources().getString(R.string.addrliubolin), context.getResources().getString(R.string.positliubolin), R.drawable.liubolin, R.drawable.liubolinbig, context.getResources().getString(R.string.descrliubolin), R.drawable.info,context.getResources().getString(R.string.informations)));
        infos.add(new Info(context.getResources().getString(R.string.terryoneill), context.getResources().getString(R.string.addrterryoneill), context.getResources().getString(R.string.positterryoneill), R.drawable.terryoneill, R.drawable.terryoneillbig, context.getResources().getString(R.string.descrterryoneill), R.drawable.info,context.getResources().getString(R.string.informations)));
        infos.add(new Info(context.getResources().getString(R.string.turner), context.getResources().getString(R.string.addrturner), context.getResources().getString(R.string.positturner), R.drawable.turnertate, R.drawable.turnertatebig, context.getResources().getString(R.string.descrturner), R.drawable.info,context.getResources().getString(R.string.informations)));

        InfoAdapter adapter = new InfoAdapter(getActivity(), infos, R.color.category);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Info info = infos.get(position);

                Intent infoIntent = new Intent( context, InfoActivity.class);

                infoIntent.putExtra("NAME_INFO", info.getNameInfo());
                infoIntent.putExtra("ADDRESS", info.getAddress());
                infoIntent.putExtra("POSITION", info.getPositionLink());
                infoIntent.putExtra("IMAGE_RESOURCE_ID_IA", info.getImageResourceIdIA());
                infoIntent.putExtra("MEDIA_LINK", info.getMediaLink());
                infoIntent.putExtra("DESCRIPTION_VTEXT", info.getDescrSourceText());
                infoIntent.putExtra("DESCRIPTION_LINK", info.getDescription());
                infoIntent.putExtra("DESCRIPTION_ICON", info.getImageResourceIdDI());

                startActivity(infoIntent);

            }
        });

        return rootView;


    }

}
