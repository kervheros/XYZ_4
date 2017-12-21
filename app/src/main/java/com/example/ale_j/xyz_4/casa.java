package com.example.ale_j.xyz_4;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.ale_j.xyz_4.RestApi.OnRestLoadListener;
import com.example.ale_j.xyz_4.RestApi.RestApi;

import org.json.JSONObject;

public class casa extends AppCompatActivity implements View.OnClickListener, OnRestLoadListener {
    Button mapa;

    EditText cant_hab;
    EditText cant_ban;
    EditText superficie;
    EditText a_contruccion;
    EditText tipo;
    EditText propietario;

    Button crearr;
    Button camara;
    Button subir;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_casa );
        mapa = (Button) findViewById( R.id.mapas );
        mapa.setOnClickListener( this );

        crearr = (Button) findViewById( R.id.button );
        crearr.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent crearr = new Intent( casa.this, galeria.class );
                startActivity( crearr );


            }
        } );

        cant_hab = (EditText) findViewById(R.id.hab);
        cant_ban = (EditText) findViewById(R.id.editText);
        a_contruccion = (EditText) findViewById(R.id.aconst);
        superficie= (EditText) findViewById(R.id.sup);
        tipo= (EditText) findViewById(R.id.tipo);
        propietario = (EditText) findViewById(R.id.duen);


        subir = (Button) findViewById( R.id.enviar );
        subir.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                RestApi api = new RestApi( "POST" );
                api.setOnRestLoadListener( casa.this, 11 );

                String cant_ha = cant_hab.getText().toString();

                String cant_ba = cant_ban.getText().toString();

                String superfici = superficie.getText().toString();

                String a_contruccio= a_contruccion.getText().toString();

                String tip = tipo.getText().toString();

                String propieta = propietario.getText().toString();

                api.addParams( "habitaciones", cant_ha );
                api.addParams( "baños", cant_ba );
                api.addParams( "superficie", superfici );
                api.addParams( "costrucion", a_contruccio );
                api.addParams( "tipo", tip );
                api.addParams( "dueño", propieta );

                api.execute("http://192.168.0.179:3000/inmueble");


            }
        } );

       /*
        camara.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent crearrr = new Intent( casa.this, camara.class );
                startActivity( crearrr );


            }
        } );*/

    }

    @SuppressLint("WrongViewCast")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mapas:
                Intent im = new Intent( this, MainUbicacion.class );
                startActivity( im );
                break;
            default:
                break;
        }







        final Button camra;
        camra = (Button) findViewById(R.id.button);
        camra.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
              // Intent editarr = new Intent(casa.this, camra.class);
                //startActivity(editarr);
            }
        });



    }


 /*   @Override
    public void onClick(View view) {

        RestApi api = new RestApi("POST");
        api.setOnRestLoadListener(casa.this, 11);
        String propieta = propietario.getText().toString();
        String tip = tipo.getText().toString();
        String cant_ha = cant_hab.getText().toString();
        String superfici = superficie.getText().toString();
        String añodecontruccion = a_contruccion.getText().toString();
        api.addParams("cuartos", propieta);
        api.addParams("salas", tip);
        api.addParams("baños", cant_ha);
        api.addParams("garage", superfici);
        api.addParams("direccion", añodecontruccion);


        api.execute("http://192.168.1.116:3000/inmueble");


    }*/

    @Override
    public void onRestLoadComplete(JSONObject rObject, int id) {
        if (id == 11) {
            Toast.makeText(this, rObject.toString(), Toast.LENGTH_SHORT).show();

        }
    }
}




