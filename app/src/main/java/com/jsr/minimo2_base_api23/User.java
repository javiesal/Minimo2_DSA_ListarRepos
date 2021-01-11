package com.jsr.minimo2_base_api23;

import java.util.List;

public class User {
    private String login;
    private int id;
    private String avatar_url;
    private String name;
    private int public_repos;
    private String repos_url;
    private int followers;

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    private int following;
    private List<User> userFollowers;
    private List<Repository> userRepos;

    public List<Repository> getUserRepos() {
        return userRepos;
    }

    public void setUserRepos(List<Repository> userRepos) {
        this.userRepos = userRepos;
    }

    public List<User> getUserFollowers() {
        return userFollowers;
    }

    public void setUserFollowers(List<User> userFollowers) {
        this.userFollowers = userFollowers;
    }

    public User() {}

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPublic_repos() {
        return public_repos;
    }

    public void setPublic_repos(int public_repos) {
        this.public_repos = public_repos;
    }

    public void setRepos_url (String repos_url){this.repos_url = repos_url;}
    public String getRepos_url (){return repos_url;}
    public int getFollowing() {
        return following;
    }

    public void setFollowing(int following) {
        this.following = following;
    }

}
