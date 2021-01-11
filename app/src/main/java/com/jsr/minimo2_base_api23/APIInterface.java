package com.jsr.minimo2_base_api23;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface APIInterface {
    //Extra URL from BASE_URL at APIClient.java for query
    //@GET,@DELETE,@POST...

    @GET("{username}")
    Call<User> SearchRepo(@Path ("username") String username);
    //Call<Result_Format> Funtion(Extra variables);
    //Extra variables:
    //[@Path ("path_variable") Format id] = path param inside URL
    //@Body = extra fields after URL



    @GET("{username}/repos")
    Call<List<Repository>> SearchReposList(@Path ("username") String username);

}
