package com.example.onesignal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.iid.FirebaseInstanceId;
import com.onesignal.OneSignal;


import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private static final String ONESIGNAL_APP_ID = "Put-Your-OneSignal-App_id";
    private static final String LOGTAG = "android-fcm";
    private Button btnToken;


    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;
    MovieAdapter mMovieAdapter;

    LinearLayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setUp();

        // Enable verbose OneSignal logging to debug issues if needed.
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE);

        // OneSignal Initialization
        OneSignal.initWithContext(this);
        OneSignal.setAppId(ONESIGNAL_APP_ID);

        if (getIntent().getExtras() != null) {
            Log.d(LOGTAG, "DATOS RECIBIDOS (INTENT)");
            Log.d(LOGTAG, "Usuario: " + getIntent().getExtras().getString("usuario"));
            Log.d(LOGTAG, "Estado: " + getIntent().getExtras().getString("estado"));
        }

        btnToken = (Button)findViewById(R.id.btnToken);
        btnToken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Se obtiene el token actualizado
                String refreshedToken = FirebaseInstanceId.getInstance().getToken();

                Log.d(LOGTAG, "Token actualizado: " + refreshedToken);
            }
        });


    }

    private void setUp() {
        mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(RecyclerView.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mMovieAdapter = new MovieAdapter(new ArrayList<>());

        prepareDemoContent();
    }

    private void prepareDemoContent() {

        ArrayList<Movie> mMovies = new ArrayList<>();
        String[] id= getResources().getStringArray(R.array.id);
        String[] url = getResources().getStringArray(R.array.url);
        String[] title = getResources().getStringArray(R.array.title);
        String[] info = getResources().getStringArray(R.array.info);
        String[] rating = getResources().getStringArray(R.array.rating);
        String[] description = getResources().getStringArray(R.array.info);

        for (int i = 0; i < id.length; i++) {
            mMovies.add(new Movie(id[i],title[i], info[i], rating[i], description[i],url[i]));
        }
        mMovieAdapter.addItems(mMovies);
        mRecyclerView.setAdapter(mMovieAdapter);

    }
}