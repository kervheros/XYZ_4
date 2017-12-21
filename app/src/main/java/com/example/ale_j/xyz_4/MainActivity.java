package com.example.ale_j.xyz_4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    Button bu;
    Button ba;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        bu = (Button)findViewById( R.id.usuario );
        bu.setOnClickListener( this );

        ba = (Button)findViewById( R.id.agente );
        ba.setOnClickListener( this );
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.usuario:
                Intent u = new Intent( this, usuario.class );
                startActivity( u );
                break;
            case R.id.agente:
                Intent a = new Intent( this, casa.class );
                startActivity( a );
                break;
            default:
                break;
        }
    }
}
