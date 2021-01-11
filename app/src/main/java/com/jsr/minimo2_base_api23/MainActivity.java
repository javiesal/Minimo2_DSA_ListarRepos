package com.jsr.minimo2_base_api23;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    APIInterface apiInterface;
    EditText editText1;
    ProgressBar progressBar;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        apiInterface = APIClient.getClient().create(APIInterface.class);
        editText1 = findViewById(R.id.editTextTextPersonName);
        progressBar = findViewById(R.id.progressBar);
        sharedPref = getApplicationContext().getSharedPreferences("SEARCH_DATA", Context.MODE_PRIVATE);
        editor = sharedPref.edit();
        name = sharedPref.getString("Searching_field","");
        editText1.setText(name);
    }
    public void Searchrepos (android.view.View v)
    {
        String name = String.valueOf(editText1.getText());
        if (name.equals(""))
        {
            Toast.makeText(getApplicationContext(), "Put some user", Toast.LENGTH_LONG).show();
            editor.putString("Searching_field",name);
            editor.commit();
        }
        else
        {
            editor.putString("Searching_field",name);
            editor.commit();
            Call<User> repoCall = apiInterface.SearchRepo(name); //Try to query for User data
            repoCall.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) { //Response format User class
                    progressBar.setVisibility(View.VISIBLE);
                    User userFound = response.body();
                    Call<List<Repository>> reposCall = apiInterface.SearchReposList(name); //Try to query for User's repositories
                    reposCall.enqueue(new Callback<List<Repository>>() {
                        @Override
                        public void onResponse(Call<List<Repository>> call, Response<List<Repository>> response) { //Response format List(Repos)
                            userFound.setUserRepos(response.body());
                            SingletonUser.getInstance().setUser(userFound);  //Use Singleton to only have ONE instance open
                            progressBar.setVisibility(View.GONE);
                            Intent intent = new Intent(getApplicationContext(), ListareposActivity.class);
                            startActivity(intent);

                        }

                        @Override
                        public void onFailure(Call<List<Repository>> call, Throwable t) { //When connection to api error execute
                            Toast.makeText(getApplicationContext(), "Error connecting to find followers", Toast.LENGTH_LONG).show();
                        }
                    });
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) { //When connection to api error execute
                    Toast.makeText(getApplicationContext(), "Error connecting to find user", Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}