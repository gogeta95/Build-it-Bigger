package saurabh.com.builditbigger;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;

import com.example.saurabh.myapplication.backend.myApi.MyApi;
import com.example.saurabh.myapplication.backend.myApi.MyApiRequest;
import com.example.saurabh.myapplication.backend.myApi.MyApiRequestInitializer;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.json.jackson2.JacksonFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import saurabh.com.jokeui.Joke;
import saurabh.com.jokeui.JokeActivity;

/**
 * Created by singh on 12-06-2016.
 */

public class FetchJokesTask extends AsyncTask<Void, Void, List<Joke>> {
    private static MyApi myApiService = null;
    private Context context;
    private ProgressDialog dialog;

    public FetchJokesTask(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        if (myApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new JacksonFactory(), null)
                    .setRootUrl("http://10.0.3.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new MyApiRequestInitializer() {
                        @Override
                        protected void initializeMyApiRequest(MyApiRequest<?> request) throws IOException {
                            request.setDisableGZipContent(true);
                        }
                    });
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
            return jokes;
        }
    }

    @Override
    protected void onPostExecute(List<Joke> jokes) {
        dialog.dismiss();
        JokeActivity.start(context, (ArrayList<Joke>) jokes);
    }
}
