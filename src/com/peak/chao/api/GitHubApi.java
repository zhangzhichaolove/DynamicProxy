package com.peak.chao.api;

import com.peak.chao.annotation.GET;
import com.peak.chao.annotation.Path;
import com.peak.chao.call.Call;
import com.peak.chao.model.GitHubModel;

import java.util.List;

public interface GitHubApi {

    @GET("https://www.apiopen.top/register")
    Call<List<GitHubModel>> register(@Path("name") String name, @Path("pwd") String password);

    @GET("https://www.apiopen.top/login")
    Call<List<GitHubModel>> login(@Path("name") String name, @Path("pwd") String password);

}
