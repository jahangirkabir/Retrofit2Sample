package com.jahanbabu.retrofit2sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by jahangirkabir on 2/7/16.
 */

public class MainActivity extends AppCompatActivity {
    Button getNormalButton, getQueryButton, postButton, postFileButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getNormalButton = (Button) findViewById(R.id.getNormalButton);
        getQueryButton = (Button) findViewById(R.id.getQueryButton);
        postButton = (Button) findViewById(R.id.postButton);
        postFileButton = (Button) findViewById(R.id.postFileButton);

        getNormalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showResult("getNormal");
            }
        });

        getQueryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showResult("getWithQuery");
            }
        });

        postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showResult("postNormal");
            }
        });

        postFileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showResult("postMultipart");
            }
        });
    }

    private void showResult(String requestType) {
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("type", requestType);
        startActivity(intent);
    }
}
