package cpm.peak.chao.api;

import cpm.peak.chao.annotation.GET;
import cpm.peak.chao.annotation.Path;
import cpm.peak.chao.call.Call;
import cpm.peak.chao.model.GitHubModel;

import java.util.List;

public interface GitHubApi {
    @GET("https://www.apiopen.top/login")
    Call<List<GitHubModel>> login(@Path("name") String name, @Path("pwd") String password);

}
