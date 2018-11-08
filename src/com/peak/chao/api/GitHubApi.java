package com.peak.chao.api;

import com.peak.chao.annotation.Field;
import com.peak.chao.annotation.GET;
import com.peak.chao.annotation.POST;
import com.peak.chao.annotation.Query;
import com.peak.chao.call.Call;
import com.peak.chao.model.GitHubModel;

import java.util.List;

public interface GitHubApi {

    @POST("https://www.apiopen.top/createUser")
    Call<List<GitHubModel>> register(@Field("key") String key, @Field("phone") String name, @Query("passwd") String password);

    @GET("https://www.apiopen.top/login")
    Call<List<GitHubModel>> login(@Field("key") String key, @Query("phone") String name, @Query("passwd") String password);

}
