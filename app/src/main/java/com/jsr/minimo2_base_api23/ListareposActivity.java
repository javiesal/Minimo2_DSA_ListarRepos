package com.jsr.minimo2_base_api23;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ListareposActivity extends AppCompatActivity {
    User user;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listarepos);

        TextView fullName = findViewById(R.id.FullnameTxt);
        TextView surname = findViewById(R.id.SurnameTxt);
        TextView followers = findViewById(R.id.FollowersTxt);
        TextView following = findViewById(R.id.FollowingTxt);
        recyclerView = findViewById(R.id.FollowersRecycleView);

        user = SingletonUser.getInstance().getUser();

        Picasso.with(getApplicationContext()).load(user.getAvatar_url()).into((ImageView) findViewById(R.id.ProfilePhoto)); //Use picasso to Avatar_url to image

        //Fill data fields for user
        fullName.setText(user.getName());
        surname.setText("Username: "+ user.getLogin());
        followers.setText("Followers: "+ String.valueOf(user.getFollowers()));
        following.setText("Following: " + String.valueOf(user.getFollowing()));

        //RecyclerView setup
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        List<Repository> input = user.getUserRepos();
        mAdapter = new RecyclerAdapter(input);
        recyclerView.setAdapter(mAdapter);

    }
}