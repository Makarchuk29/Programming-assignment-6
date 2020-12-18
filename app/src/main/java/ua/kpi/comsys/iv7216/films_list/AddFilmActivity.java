package ua.kpi.comsys.iv7216.films_list;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import ua.kpi.comsys.iv7216.R;

public class AddFilmActivity extends AppCompatActivity {

    public void onClickAddFilm(View view) {
        Intent intent = new Intent(this, FilmActivity.class);

        EditText inputTitle = (EditText) findViewById(R.id.inputTitle);
        EditText inputYear = (EditText) findViewById(R.id.inputYear);
        EditText inputType = (EditText) findViewById(R.id.inputType);

        if (inputYear.getText().toString().matches("[1-9][0-9]*")) {
            intent.putExtra("title", inputTitle.getText().toString());
            intent.putExtra("year", inputYear.getText().toString());
            intent.putExtra("type", inputType.getText().toString());
            startActivity(intent);
            finish();
        } else {
            CharSequence message = "Wrong data";
            Toast toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_film);
    }
}