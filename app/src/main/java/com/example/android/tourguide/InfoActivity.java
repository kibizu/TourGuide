package com.example.android.tourguide;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.android.tourguide.databinding.ActivityInfoBinding;


public class InfoActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ActivityInfoBinding binding;
    private String nameInfo;
    private String mediaLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_info);
        nameInfo = getIntent().getExtras().getString("NAME_INFO");

        binding.infoImage.setImageResource(getIntent().getExtras().getInt("IMAGE_RESOURCE_ID_IA"));

        binding.address.setText(getIntent().getExtras().getString("ADDRESS"));

        binding.descriptionimage.setImageResource(getIntent().getExtras().getInt("DESCRIPTION_ICON"));

        binding.descrSource.setText(getIntent().getExtras().getString("DESCRIPTION_VTEXT"));

        binding.position.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(getIntent().getExtras().getString("POSITION")));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }

            }

        });

        mediaLink = getIntent().getExtras().getString("MEDIA_LINK");


        if (mediaLink == null){

            binding.youtubeSource.setText("");
            binding.youtubeicon.setVisibility(View.INVISIBLE);

        } else {
            binding.youtubeSource.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(mediaLink));
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    }

                }

            });

        }


        binding.descrSource.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(getIntent().getExtras().getString("DESCRIPTION_LINK")));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }

            }

        });

        initToolBar();

    }





    public void initToolBar(){

        toolbar = binding.toolBar.tbar;
        toolbar.setTitle(nameInfo);
        toolbar.setTitleTextColor(getResources().getColor(R.color.title_text_color));
        toolbar.setBackgroundColor(getResources().getColor(R.color.tan_background));
        toolbar.setTitleMargin(0    ,0,0,0);

        setSupportActionBar(toolbar);

        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);

    }
}
