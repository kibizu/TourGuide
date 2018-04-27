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

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HistoricalFragment extends Fragment {

    private Activity context;

    public HistoricalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.info_list, container,false);

        context = getActivity();

        final ArrayList<Info> infos = new ArrayList<Info>();

        infos.add(new Info(context.getResources().getString(R.string.colosseo), context.getResources().getString(R.string.addrcolosseo), context.getResources().getString(R.string.positcolosseo), R.drawable.colosseo, R.drawable.colosseum, context.getResources().getString(R.string.descrcolosseo), R.drawable.wikipedia,context.getResources().getString(R.string.vidcolosseo),context.getResources().getString(R.string.wikipedia)));
        infos.add(new Info(context.getResources().getString(R.string.pantheon), context.getResources().getString(R.string.addrpantheon), context.getResources().getString(R.string.positpantheon), R.drawable.pantheon, R.drawable.pantheonbig, context.getResources().getString(R.string.descrpantheon), R.drawable.wikipedia, context.getResources().getString(R.string.vidpantheon),context.getResources().getString(R.string.wikipedia)));
        infos.add(new Info(context.getResources().getString(R.string.circomassimo), context.getResources().getString(R.string.addrcircomassimo), context.getResources().getString(R.string.positcircomassimo) , R.drawable.circo_massimo, R.drawable.circomassimobig, context.getResources().getString(R.string.descrcircomassimo), R.drawable.wikipedia, context.getResources().getString(R.string.vidcircomassimo),context.getResources().getString(R.string.wikipedia)));
        infos.add(new Info(context.getResources().getString(R.string.santamariamaggiore), context.getResources().getString(R.string.addrsantamariamaggiore), context.getResources().getString(R.string.positsantamariamaggiore), R.drawable.santa_maria_maggiore, R.drawable.santamariamaggiorebig , context.getResources().getString(R.string.descrsantamariamaggiore), R.drawable.wikipedia, context.getResources().getString(R.string.vidsantamariamaggiore),context.getResources().getString(R.string.wikipedia)));
        infos.add(new Info(context.getResources().getString(R.string.fororomano), context.getResources().getString(R.string.addrfororomano), context.getResources().getString(R.string.positfororomano), R.drawable.foro_romano, R.drawable.fororomanobig, context.getResources().getString(R.string.descrfororomano), R.drawable.wikipedia, context.getResources().getString(R.string.vidfororomano),context.getResources().getString(R.string.wikipedia)));
        infos.add(new Info(context.getResources().getString(R.string.sangiovanni), context.getResources().getString(R.string.addrsangiovanni), context.getResources().getString(R.string.positsangiovanni), R.drawable.san_giovanni_laterano, R.drawable.sangiovannibig, context.getResources().getString(R.string.descrsangiovanni), R.drawable.wikipedia, context.getResources().getString(R.string.vidsangiovanni),context.getResources().getString(R.string.wikipedia)));
        infos.add(new Info(context.getResources().getString(R.string.piazzanavona), context.getResources().getString(R.string.addrpiazzanavona),context.getResources().getString(R.string.positpiazzanavona), R.drawable.piazza_navona, R.drawable.piazzanavonabig, context.getResources().getString(R.string.descrpiazzanavona), R.drawable.wikipedia,context.getResources().getString(R.string.vidpiazzanavona),context.getResources().getString(R.string.wikipedia)));
        infos.add(new Info(context.getResources().getString(R.string.sanpietro), context.getResources().getString(R.string.addrsanpietro), context.getResources().getString(R.string.positsanpietro), R.drawable.basilica_san_pietro, R.drawable.sanpietrobig, context.getResources().getString(R.string.descrsanpietro), R.drawable.wikipedia,context.getResources().getString(R.string.vidsanpietro),context.getResources().getString(R.string.wikipedia)));
        infos.add(new Info(context.getResources().getString(R.string.mercatitraiano), context.getResources().getString(R.string.addrmercatitraiano), context.getResources().getString(R.string.positmercatitraiano), R.drawable.mercati_traiano, R.drawable.mercatitraianobig, context.getResources().getString(R.string.descrmercatitraiano), R.drawable.wikipedia,context.getResources().getString(R.string.vidmercatitraiano),context.getResources().getString(R.string.wikipedia)));
        infos.add(new Info(context.getResources().getString(R.string.foroaugusto), context.getResources().getString(R.string.addrforoaugusto), context.getResources().getString(R.string.positforoaugusto), R.drawable.foro_di_augusto, R.drawable.foroaugustobig,context.getResources().getString(R.string.descrforoaugusto), R.drawable.wikipedia,context.getResources().getString(R.string.vidforoaugusto),context.getResources().getString(R.string.wikipedia)));

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
