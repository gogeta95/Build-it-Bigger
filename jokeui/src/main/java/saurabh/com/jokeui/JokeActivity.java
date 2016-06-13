package saurabh.com.jokeui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class JokeActivity extends AppCompatActivity {
    private static final String KEY_JOKES="jokes";

    public static void start(Context context, ArrayList<Joke> jokes) {
        Intent starter = new Intent(context, JokeActivity.class);
        starter.putParcelableArrayListExtra(KEY_JOKES,jokes);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        List<Joke> jokes;
        jokes= getIntent().getParcelableArrayListExtra(KEY_JOKES);
        if(jokes!=null&&!jokes.isEmpty()){
            RecyclerView recyclerView= (RecyclerView) findViewById(R.id.recycler_view);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(new RecyclerAdapter(jokes,getLayoutInflater()));
        }

    }
}
