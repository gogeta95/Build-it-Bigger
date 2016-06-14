package saurabh.com.builditbigger;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Parcelable;
import android.support.v4.content.LocalBroadcastManager;

import com.example.saurabh.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import saurabh.com.jokeui.Joke;
import saurabh.com.jokeui.JokeActivity;

/**
 * Created by singh on 12-06-2016.
 */

public class FetchJokesTask extends AsyncTask<Void, Void, List<Joke>> {
    static final String ACTION_AD = "showAd";
    private static MyApi myApiService = null;
    private Context context;
    private ProgressDialog dialog;

    FetchJokesTask(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        if (myApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("https://build-it-bigger-1340.appspot.com/_ah/api/");
            myApiService = builder.build();
        }
        dialog = new ProgressDialog(context);
        dialog.setMessage("Getting Jokes...");
        dialog.setCancelable(true);
        dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                FetchJokesTask.this.cancel(true);
            }
        });
        dialog.show();
    }

    @Override
    protected List<Joke> doInBackground(Void... params) {
        List<Joke> jokes = new ArrayList<>();
        try {

            List<com.example.saurabh.myapplication.backend.myApi.model.Joke> jokeList = myApiService.getAllJokes().execute().getItems();
            for (com.example.saurabh.myapplication.backend.myApi.model.Joke joke : jokeList) {
                jokes.add(new Joke(joke.getJokeText()));
            }
            return jokes;
        } catch (IOException e) {
            e.printStackTrace();
            return jokes;
        }
    }

    @Override
    protected void onPostExecute(List<Joke> jokes) {
        dialog.dismiss();
        Intent intent = new Intent(ACTION_AD);
        intent.putParcelableArrayListExtra(ACTION_AD, (ArrayList<? extends Parcelable>) jokes);
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
        JokeActivity.start(context, (ArrayList<Joke>) jokes);
    }
}
