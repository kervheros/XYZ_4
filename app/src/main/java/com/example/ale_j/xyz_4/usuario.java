package com.example.ale_j.xyz_4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class usuario extends AppCompatActivity implements View.OnClickListener
{
    ImageButton bs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_usuario );
        bs = (ImageButton)findViewById( R.id.reg );
        bs.setOnClickListener( this );
    }

    @Override
    public void onClick(View view)
    {
        Intent is = new Intent( this, login.class );
        startActivity( is );
    }
}
