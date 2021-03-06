package ua.kpi.comsys.iv7216.films_list;

import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import ua.kpi.comsys.iv7216.R;

public class FilmParse {
    private static int[] filmsInfo = {
            R.raw.tt0076759,
            R.raw.tt0080684,
            R.raw.tt0086190,
            R.raw.tt0120915,
            R.raw.tt0121765,
            R.raw.tt0121766,
            R.raw.tt0796366,
            R.raw.tt2488496,
            R.raw.tt2527336,
            R.raw.tt3748528
    };

    public static ArrayList<Film> parse(Context context) throws IOException, JSONException {
        ArrayList<Film> films = new ArrayList<>();
        for (int value : filmsInfo) {
            String jsonText = readText(context, value);
            JSONObject jo = new JSONObject(jsonText);

            String title = jo.getString("Title");
            String year = jo.getString("Year");
            String type = jo.getString("Type");
            String released = jo.getString("Released");
            String runtime = jo.getString("Runtime");
            String genre = jo.getString("Genre");
            String director = jo.getString("Director");
            String actors = jo.getString("Actors");
            String plot = jo.getString("Plot");
            String country = jo.getString("Country");
            String awards = jo.getString("Awards");
            String poster = jo.getString("Poster");
            String rating = jo.getString("imdbRating");
            String production = jo.getString("Production");
            String language = jo.getString("Language");

            Film film = new Film(title,
                    year,
                    type,
                    released,
                    runtime,
                    genre,
                    director,
                    actors,
                    plot,
                    country,
                    awards,
                    poster,
                    rating,
                    production,
                    language);
            films.add(film);
        }
        return films;
    }

    private static String readText(Context context, int resId) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(context.getResources().openRawResource(resId)));
        String sb = "", s;
        while ((s = br.readLine()) != null)
            sb += s + "\n";
        return sb;
    }
}
