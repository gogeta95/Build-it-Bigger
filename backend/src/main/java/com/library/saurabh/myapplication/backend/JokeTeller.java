/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.library.saurabh.myapplication.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.myapplication.saurabh.example.com",
                ownerName = "backend.myapplication.saurabh.example.com",
                packagePath = ""
        )
)
public class JokeTeller {


    @ApiMethod(name = "getAllJokes")
    public List<Joke> getAllJokes() {
        String[] rawJokes= com.library.JokeTeller.getAllJokes();
        List<Joke> jokes= new ArrayList<>();
        if(rawJokes!=null&&rawJokes.length>0){
            for (String rawJoke:rawJokes){
                jokes.add(new Joke(rawJoke));
            }
        }
        return jokes;
    }


}
