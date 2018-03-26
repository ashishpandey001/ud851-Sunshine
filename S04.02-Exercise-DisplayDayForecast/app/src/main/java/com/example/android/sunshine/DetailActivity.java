package com.example.android.sunshine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private static final String FORECAST_SHARE_HASHTAG = " #SunshineApp";

    private String weatherData;

    private TextView weatherForDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        // TODO (2) Display the weather forecast that was passed from MainActivity
        weatherForDay = (TextView) findViewById(R.id.tv_weather_for_day);
        Intent parentIntent = getIntent();
        if (parentIntent.hasExtra("weatherData")) {
            weatherData = parentIntent.getStringExtra("weatherData");
            weatherForDay.setText(weatherData);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.share_weather_data) {
            String dialogTitle = "Share Weather Details";
            String mimeType = "text/plain";
            ShareCompat.IntentBuilder
                    .from(this)
                    .setChooserTitle(dialogTitle)
                    .setType(mimeType)
                    .setText(weatherData)
                    .startChooser();
        }
        return true;
    }
}