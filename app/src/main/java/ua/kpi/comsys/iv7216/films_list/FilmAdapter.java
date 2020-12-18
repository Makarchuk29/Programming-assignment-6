package ua.kpi.comsys.iv7216.films_list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import ua.kpi.comsys.iv7216.R;

public class FilmAdapter extends BaseAdapter {
    private ArrayList<Film> films;
    private LayoutInflater mLayoutInflater;

    FilmAdapter(Context context, ArrayList<Film> films) {
        this.films = films;
        this.mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return films.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = mLayoutInflater.inflate(R.layout.list_item, null);

        ImageView image = convertView.findViewById(R.id.imageViewIcon);
        image.setImageResource(Integer.parseInt(films.get(position).getPoster()));

        TextView titleTextView = convertView.findViewById(R.id.textViewTitle);
        titleTextView.setText(films.get(position).getTitle());

        TextView dateTextView = convertView.findViewById(R.id.textViewDate);
        dateTextView.setText(films.get(position).getYear());

        TextView typeTextView = convertView.findViewById(R.id.textViewType);
        typeTextView.setText(films.get(position).getType());

        return convertView;
    }
}
