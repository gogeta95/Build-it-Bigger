package saurabh.com.jokeui;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by singh on 12-06-2016.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.JokeHolder> {
    private List<Joke> jokes;
    private LayoutInflater inflater;

    public RecyclerAdapter(@NonNull List<Joke> jokes, @NonNull LayoutInflater inflater) {
        this.jokes = jokes;
        this.inflater = inflater;
    }

    @Override
    public JokeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new JokeHolder(inflater.inflate(R.layout.joke_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(JokeHolder holder, int position) {
        holder.joke.setText(jokes.get(position).getJoke());
    }

    @Override
    public int getItemCount() {
        return jokes == null ? 0 : jokes.size();
    }

    class JokeHolder extends RecyclerView.ViewHolder {
        TextView joke;

        JokeHolder(View itemView) {
            super(itemView);
            joke = (TextView) itemView.findViewById(R.id.joke);
        }
    }
}
