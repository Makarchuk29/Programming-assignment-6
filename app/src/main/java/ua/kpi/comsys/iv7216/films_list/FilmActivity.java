package ua.kpi.comsys.iv7216.films_list;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

import ua.kpi.comsys.iv7216.R;

public class FilmActivity extends AppCompatActivity {
    private ArrayList<Film> defaultFilms;
    private ArrayList<Film> filmsList = new ArrayList<>();
    private FilmAdapter filmAdapter;
    private ListView listView;
    private EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film);
        try {
            defaultFilms = FilmParse.parse(this);
            for (Film film : defaultFilms) {
                Film tmp = (Film) film.clone();
                tmp.setPoster(getPosterId(this, film.getPoster().replace(".jpg", "")));
                filmsList.add(tmp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        listView = findViewById(R.id.list_view);
        input = findViewById(R.id.inputSearch);
        filmAdapter = new FilmAdapter(this, filmsList);
        listView.setAdapter(filmAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(FilmActivity.this, AboutFilmActivity.class);
                intent.putExtra("film_list", filmsList);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });
        SwipeDismissListViewTouchListener touchListener =
                new SwipeDismissListViewTouchListener(
                        listView,
                        new SwipeDismissListViewTouchListener.DismissCallbacks() {
                            @Override
                            public boolean canDismiss(int position) {
                                return true;
                            }

                            @Override
                            public void onDismiss(ListView listView, int[] reverseSortedPositions) {
                                for (int position : reverseSortedPositions) {
                                    removeFromList(position);
                                }

                            }
                        });
        listView.setOnTouchListener(touchListener);

    }

    public static String getPosterId(Context context, String name) {
        name = name.toLowerCase();
        if (name.equals("") || context.getResources().getIdentifier(name, "drawable", context.getPackageName()) == 0) {
            return context.getResources().getIdentifier("poster_error", "drawable", context.getPackageName()) + "";
        }
        return context.getResources().getIdentifier(name, "drawable", context.getPackageName()) + "";
    }


    public void onClickSearch(View view) {
        String text = input.getText().toString().toLowerCase();
        ArrayList<Film> filmsSearch = new ArrayList<>();

        if (text.length() == 0) {
            Toast toast = Toast.makeText(getApplicationContext(), "Please, input text", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        } else {
            for (int i = 0; i < filmsList.size(); i++) {
                if (filmsList.get(i).getTitle() != null) {
                    String temp = filmsList.get(i).getTitle().toLowerCase();
                    if (temp.contains(text)) {
                        filmsSearch.add(filmsList.get(i));
                    }
                }
            }
            if (filmsSearch.isEmpty()) {
                Toast toast = Toast.makeText(getApplicationContext(), "There are no results", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            } else {
                listView = (ListView) findViewById(R.id.list_view);
                filmAdapter = new FilmAdapter(this, filmsSearch);
                listView.setAdapter(filmAdapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(FilmActivity.this, AboutFilmActivity.class);
                        intent.putExtra("film_list", filmsSearch);
                        intent.putExtra("position", position);
                        startActivity(intent);
                    }
                });
            }
        }
    }

    public void removeFromList(int position) {
        filmsList.remove(position);
        filmAdapter = new FilmAdapter(this, filmsList);
        listView.setAdapter(filmAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Film film = new Film();
        film.setTitle(getIntent().getStringExtra("title"));
        film.setYear(getIntent().getStringExtra("year"));
        film.setType(getIntent().getStringExtra("type"));
        film.setPoster(getPosterId(this, ""));

        filmsList.add(film);
        listView = findViewById(R.id.list_view);
        filmAdapter = new FilmAdapter(this, filmsList);
        listView.setAdapter(filmAdapter);
    }

    public void addFilmClick(View view) {
        Intent intent = new Intent(this, AddFilmActivity.class);
        startActivity(intent);
    }
}
