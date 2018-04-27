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
public class RestaurantsFragment extends Fragment {

    private Activity context;

    public RestaurantsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.info_list, container,false);

        context = getActivity();

        final ArrayList<Info> infos = new ArrayList<Info>();

        infos.add(new Info(context.getResources().getString(R.string.culinaria), context.getResources().getString(R.string.addrculinaria), context.getResources().getString(R.string.positculinaria), R.drawable.culinaria, R.drawable.culinariabig, context.getResources().getString(R.string.descrculinaria), R.drawable.tripadvisor,context.getResources().getString(R.string.tripadvisor)));
        infos.add(new Info(context.getResources().getString(R.string.ipizzicaroli), context.getResources().getString(R.string.addripizzicaroli), context.getResources().getString(R.string.positipizzicaroli), R.drawable.ipizzicaroli, R.drawable.ipizzicarolibig, context.getResources().getString(R.string.descripizzicaroli), R.drawable.tripadvisor,context.getResources().getString(R.string.tripadvisor)));
        infos.add(new Info(context.getResources().getString(R.string.mimiecoco), context.getResources().getString(R.string.addrmimiecoco), context.getResources().getString(R.string.positmimiecoco), R.drawable.mimiecoco, R.drawable.mimiecocobig, context.getResources().getString(R.string.descrmimiecoco), R.drawable.tripadvisor,context.getResources().getString(R.string.tripadvisor)));
        infos.add(new Info(context.getResources().getString(R.string.ostimatti), context.getResources().getString(R.string.addrostimatti), context.getResources().getString(R.string.positostimatti), R.drawable.ostimatti, R.drawable.ostimattibig, context.getResources().getString(R.string.descrostimatti), R.drawable.tripadvisor,context.getResources().getString(R.string.tripadvisor)));
        infos.add(new Info(context.getResources().getString(R.string.nerone), context.getResources().getString(R.string.addrnerone), context.getResources().getString(R.string.positnerone), R.drawable.nerone, R.drawable.neronebig, context.getResources().getString(R.string.descrnerone), R.drawable.tripadvisor,context.getResources().getString(R.string.tripadvisor)));
        infos.add(new Info(context.getResources().getString(R.string.tonnarello), context.getResources().getString(R.string.addrtonnarello), context.getResources().getString(R.string.posittonnarello), R.drawable.tonnarello, R.drawable.tonnarellobig, context.getResources().getString(R.string.descrtonnarello), R.drawable.tripadvisor,context.getResources().getString(R.string.tripadvisor)));
        infos.add(new Info(context.getResources().getString(R.string.theloft), context.getResources().getString(R.string.addrtheloft), context.getResources().getString(R.string.posittheloft), R.drawable.theloft, R.drawable.theloftbig, context.getResources().getString(R.string.descrtheloft), R.drawable.tripadvisor,context.getResources().getString(R.string.tripadvisor)));
        infos.add(new Info(context.getResources().getString(R.string.believeat), context.getResources().getString(R.string.addrbelieveat), context.getResources().getString(R.string.positbelieveat), R.drawable.beliveat, R.drawable.beliveatbig, context.getResources().getString(R.string.descrbelieveat), R.drawable.tripadvisor,context.getResources().getString(R.string.tripadvisor)));
        infos.add(new Info(context.getResources().getString(R.string.felizianerie), context.getResources().getString(R.string.addrfelizianerie), context.getResources().getString(R.string.positfelizianerie), R.drawable.felizianerie, R.drawable.felizianeriebig, context.getResources().getString(R.string.descrfelizianerie), R.drawable.tripadvisor,context.getResources().getString(R.string.tripadvisor)));
        infos.add(new Info(context.getResources().getString(R.string.osteriacavaliere), context.getResources().getString(R.string.addrosteriacavaliere), context.getResources().getString(R.string.positosteriacavaliere), R.drawable.osteriacavaliere, R.drawable.osteriacavalierebig, context.getResources().getString(R.string.descrosteriacavaliere), R.drawable.tripadvisor,context.getResources().getString(R.string.tripadvisor)));

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
