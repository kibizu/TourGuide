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
public class HotelsFragment extends Fragment {

    private Activity context;

    public HotelsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.info_list, container,false);

        context = getActivity();

        final ArrayList<Info> infos = new ArrayList<Info>();

        infos.add(new Info(context.getResources().getString(R.string.assuntadomus), context.getResources().getString(R.string.addrassuntadomus), context.getResources().getString(R.string.positassuntadomus), R.drawable.assuntadomus, R.drawable.assuntadomusbig, context.getResources().getString(R.string.descrassuntadomus), R.drawable.tripadvisor,context.getResources().getString(R.string.tripadvisor)));
        infos.add(new Info(context.getResources().getString(R.string.demetra), context.getResources().getString(R.string.addrdemetra), context.getResources().getString(R.string.positdemetra), R.drawable.demetrahotel, R.drawable.demetrahotelbig, context.getResources().getString(R.string.descrdemetra), R.drawable.tripadvisor,context.getResources().getString(R.string.tripadvisor)));
        infos.add(new Info(context.getResources().getString(R.string.selectgarden), context.getResources().getString(R.string.addrselectgarden), context.getResources().getString(R.string.positselectgarden), R.drawable.selectgarden, R.drawable.selectgardenbig, context.getResources().getString(R.string.descrselectgarden), R.drawable.tripadvisor,context.getResources().getString(R.string.tripadvisor)));
        infos.add(new Info(context.getResources().getString(R.string.bbgiovy), context.getResources().getString(R.string.addrbbgiovy), context.getResources().getString(R.string.positbbgiovy), R.drawable.bbgiovy, R.drawable.bbgiovybig, context.getResources().getString(R.string.descrbbgiovy), R.drawable.tripadvisor,context.getResources().getString(R.string.tripadvisor)));
        infos.add(new Info(context.getResources().getString(R.string.abitart), context.getResources().getString(R.string.addrabitart), context.getResources().getString(R.string.positabitart), R.drawable.abitarthotel, R.drawable.abitarthotelbig, context.getResources().getString(R.string.descrabitart), R.drawable.tripadvisor,context.getResources().getString(R.string.tripadvisor)));
        infos.add(new Info(context.getResources().getString(R.string.ars), context.getResources().getString(R.string.addrars), context.getResources().getString(R.string.positars), R.drawable.arshotel, R.drawable.arshotelbig, context.getResources().getString(R.string.descrars), R.drawable.tripadvisor,context.getResources().getString(R.string.tripadvisor)));
        infos.add(new Info(context.getResources().getString(R.string.caravel), context.getResources().getString(R.string.addrcaravel), context.getResources().getString(R.string.positcaravel), R.drawable.caravelhotel, R.drawable.caravelhotelbig, context.getResources().getString(R.string.descrcaravel), R.drawable.tripadvisor,context.getResources().getString(R.string.tripadvisor)));
        infos.add(new Info(context.getResources().getString(R.string.rediroma), context.getResources().getString(R.string.addrrediroma), context.getResources().getString(R.string.positrediroma), R.drawable.hotelrediroma, R.drawable.hotelrediromabig, context.getResources().getString(R.string.descrrediroma), R.drawable.tripadvisor,context.getResources().getString(R.string.tripadvisor)));
        infos.add(new Info(context.getResources().getString(R.string.plusuniverso), context.getResources().getString(R.string.addrplusuniverso), context.getResources().getString(R.string.positplusuniverso), R.drawable.plushoteluniverso, R.drawable.plushoteluniversobig, context.getResources().getString(R.string.descrplusuniverso), R.drawable.tripadvisor,context.getResources().getString(R.string.tripadvisor)));
        infos.add(new Info(context.getResources().getString(R.string.luxuryriver), context.getResources().getString(R.string.addrluxuryriver), context.getResources().getString(R.string.positluxuryriver), R.drawable.luxuryontheriver, R.drawable.luxuryontheriverbig, context.getResources().getString(R.string.descrluxuryriver), R.drawable.tripadvisor,context.getResources().getString(R.string.tripadvisor)));

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
