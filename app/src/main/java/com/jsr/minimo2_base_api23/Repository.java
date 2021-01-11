package com.jsr.minimo2_base_api23;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Repository {
    @SerializedName("language")
    @Expose
    private String languaje;
    @SerializedName("name")
    @Expose
    private String reponame;

    public void setLanguaje (String languaje){this.languaje = languaje;}
    public String getLanguaje(){return this.languaje;}
    public void setRepoName (String reponame){this.reponame = reponame;}
    public String getRepoName(){return this.reponame;}
}
