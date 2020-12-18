package ua.kpi.comsys.iv7216.films_list;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import ua.kpi.comsys.iv7216.R;

public class AboutFilmActivity extends AppCompatActivity {
    ArrayList<Film> films;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_film);
        films = (ArrayList<Film>) getIntent().getSerializableExtra("film_list");
        int position = getIntent().getExtras().getInt("position");

        ImageView image_about = findViewById(R.id.image);
        TextView title_about = findViewById(R.id.title);
        TextView year_about = findViewById(R.id.year);
        TextView genre_about = findViewById(R.id.genre);
        TextView director_about = findViewById(R.id.director);
        TextView actors_about = findViewById(R.id.actors);
        TextView country_about = findViewById(R.id.country);
        TextView lang_about = findViewById(R.id.language);
        TextView prod_about = findViewById(R.id.production);
        TextView release_about = findViewById(R.id.release);
        TextView runtime_about = findViewById(R.id.runtime);
        TextView awards_about = findViewById(R.id.awards);
        TextView rating_about = findViewById(R.id.rating);
        TextView plot_about = findViewById(R.id.plot);

        image_about.setImageResource(Integer.parseInt(films.get(position).getPoster()));
        title_about.setText(films.get(position).getTitle());
        year_about.setText(films.get(position).getYear());
        genre_about.setText(films.get(position).getGenre());
        director_about.setText(films.get(position).getDirector());
        actors_about.setText(films.get(position).getActors());
        country_about.setText(films.get(position).getCountry());
        lang_about.setText(films.get(position).getLanguage());
        prod_about.setText(films.get(position).getProduction());
        release_about.setText(films.get(position).getReleased());
        runtime_about.setText(films.get(position).getRuntime());
        awards_about.setText(films.get(position).getAwards());
        rating_about.setText(films.get(position).getRating());
        plot_about.setText(films.get(position).getPlot());
    }
}