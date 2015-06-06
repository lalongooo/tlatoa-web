package com.xihuani.permutasep.service;

import com.xihuani.permutasep.model.Post;
import com.xihuani.permutasep.model.User;

import java.util.List;
import java.util.Map;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.PATCH;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;
import retrofit.http.QueryMap;

public interface  IPermutasSEPService {

    @POST("/users/")
    void newUser(@Body User user, Callback<User> callback);

    @GET("/users/{id}/posts")
    void myPosts(@Path("id") int id, Callback<List<Post>> callback);

    @POST("/posts/")
    void newPost(@Body Post post, Callback<Post> callback);

    @GET("/posts/")
    void getPosts(Callback<List<Post>> callback);

    @GET("/posts/")
    void searchPosts(@QueryMap Map<String, String> parameters, Callback<List<Post>> callback);

}