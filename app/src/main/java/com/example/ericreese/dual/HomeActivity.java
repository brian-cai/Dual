package com.example.ericreese.dual;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;


/**
 * Created by ericreese on 3/24/18.
 */

public class HomeActivity extends AppCompatActivity {
    private Button swipe;
    private Button profile;
    private Button currentmatches;
    private Button add_category;
    private Button support;
    private Button signout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        this.swipe = (Button) this.findViewById(R.id.swipe);
        this.profile = (Button) this.findViewById(R.id.profile);
        this.currentmatches = (Button) this.findViewById(R.id.current_matches);
        this.add_category =  (Button) this.findViewById(R.id.add_category);
        this.signout = (Button) this.findViewById(R.id.sign_out);

        this.swipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent gotoswipe = new Intent(context, SwipeCardsActivity.class);
                startActivity(gotoswipe);
                finish();
            }
        });

        this.profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent goToEditProfile = new Intent(context, EditProfileActivity.class);
                startActivity(goToEditProfile );
                finish();
            }
        });
        /*
        //Matches
        this.currentmatches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent gotomatches = new Intent(context, EditProfileActivity.class);
                startActivity(gotomatches);
                finish();
            }
        });
        */
        /*
        this.support.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent getsupport = new Intent(context, EditProfileActivity.class);
                startActivity(getsupport);
                finish();
            }
        });
        */
        this.add_category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Context context = v.getContext();
                Intent goToEditProfile = new Intent(context, EditProfileActivity.class);
                startActivity(goToEditProfile );
                finish();
            }
        });
        this.signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                MainActivity.loggedIn = false;
                Intent signout = new Intent(context, MainActivity.class);
                startActivity(signout);
                finish();

            }
        });

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        ActionBar ab = getSupportActionBar();
        ab.show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    //fetches different subreddits
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.clear();
        for (int i = 0; i < MainActivity.keys.size(); i++) {
            menu.add(0, menu.size(), Menu.NONE, MainActivity.keys.get(i));
        }
        return super.onPrepareOptionsMenu(menu);
    }

    //decides what to do when you press a category
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return true;
    }
}
