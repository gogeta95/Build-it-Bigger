package saurabh.com.jokeui;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by singh on 12-06-2016.
 */

public class Joke implements Parcelable {
    public static final Creator<Joke> CREATOR = new Creator<Joke>() {
        @Override
        public Joke createFromParcel(Parcel in) {
            return new Joke(in);
        }

        @Override
        public Joke[] newArray(int size) {
            return new Joke[size];
        }
    };
    private String joke;

    public Joke(String joke) {

        this.joke = joke;
    }

    protected Joke(Parcel in) {
        joke = in.readString();
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(joke);
    }
}
