package ua.kpi.comsys.iv7216;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

import ua.kpi.comsys.iv7216.drawing.DrawingActivity;
import ua.kpi.comsys.iv7216.films_list.FilmActivity;
import ua.kpi.comsys.iv7216.image_list.ImageActivity;

public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost tabHost = getTabHost();
        TabHost.TabSpec tabSpec;

        tabSpec = tabHost.newTabSpec("tag1");
        tabSpec.setIndicator("Films list");
        tabSpec.setContent(new Intent(this, FilmActivity.class));
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("tag2");
        tabSpec.setIndicator("Image list");
        tabSpec.setContent(new Intent(this, ImageActivity.class));
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("tag3");
        tabSpec.setIndicator("Drawing");
        tabSpec.setContent(new Intent(this, DrawingActivity.class));
        tabHost.addTab(tabSpec);

    }


}