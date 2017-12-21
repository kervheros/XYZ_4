package com.example.ale_j.xyz_4;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import java.io.File;
import java.io.FileNotFoundException;

import cz.msebera.android.httpclient.Header;

public class galeria extends AppCompatActivity {

    private final String CARPETA_RAIZ = "misImagenes/";
    private final String RUTA_IMAGEN = CARPETA_RAIZ + "misFotos";
    final int COD_SELECCIONA = 10;
    final int COD_FOTO = 20;

    private Button guardar;
    Button volver ;
    Button selec;
    ImageView imagen;
    String path;
  //  private FloatingActionButton fab;

       /* Toolbar toolbar = (Toolbar) findViewById( R.id.toolbar );
        setSupportActionBar( toolbar );

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make( view, "Replace with your own action", Snackbar.LENGTH_LONG )
                        .setAction( "Action", null ).show();
            }
        } );*/


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_galeria);
         //   LoadEvents();

            guardar=(Button)findViewById(R.id.gbutton);

            guardar.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent guardar=new Intent(galeria.this,galeria.class);
                    startActivity(guardar);
                 //   Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                   // intent.setType("image/*");
                    // onActivityResult(guardar);

                }
            });

        volver=(Button)findViewById(R.id.btvolver);

        volver.setOnClickListener(new View.OnClickListener() {
              @Override
                 public void onClick(View v) {
                  Intent crearr = new Intent(galeria.this, casa.class);
                  startActivity(crearr);

              }
        });

            imagen = (ImageView) findViewById(R.id.idimage2);

            selec=(Button)findViewById(R.id.idselec);

            selec.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                        cargarImagen();
                    }

                    private void cargarImagen() {

                        final CharSequence[] opciones = {"Tomar Foto", "Caragar Imagen", "Cancelar"};
                        final AlertDialog.Builder alertOpciones = new AlertDialog.Builder(galeria.this);
                        alertOpciones.setTitle("Seleccione una Opcion");
                        alertOpciones.setItems(opciones, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                if (opciones[i].equals("Tomar Foto")) {
                                    tomarFotogrfia();
                                } else {
                                    if (opciones[i].equals("Caragar Imagen")) {

                                        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                                        intent.setType("image/");
                                        startActivityForResult(intent.createChooser(intent, "Seleccionar la aplicacion"), COD_SELECCIONA);
                                    } else {
                                        dialogInterface.dismiss();

                                    }
                                }
                            }
                        });
                        alertOpciones.show();

                    }

                    private void tomarFotogrfia() {

                        File fileImagen = new File( Environment.getExternalStorageDirectory(), RUTA_IMAGEN);
                        boolean isCreada = fileImagen.exists();
                        String nombreImagen = "";
                        if (isCreada == false) {
                            isCreada = fileImagen.mkdirs();
                        }
                        if (isCreada == true) {
                            nombreImagen = (System.currentTimeMillis() / 1000) + ".jpg";
                        }

                        path = Environment.getExternalStorageDirectory() +
                                File.separator + RUTA_IMAGEN + File.separator + nombreImagen;
                        File imagen = new File(path);

                        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(imagen));
                        startActivityForResult(intent, COD_FOTO);

                    }


            });
        }


    /* public void onclick(View view) {

         cargarImagen();
     }

     private void cargarImagen() {

         final CharSequence[] opciones = {"Tomar Foto", "Caragar Imagen", "Cancelar"};
         final AlertDialog.Builder alertOpciones = new AlertDialog.Builder(galeria.this);
         alertOpciones.setTitle("Seleccione una Opcion");
         alertOpciones.setItems(opciones, new DialogInterface.OnClickListener() {
             @Override
             public void onClick(DialogInterface dialogInterface, int i) {
                 if (opciones[i].equals("Tomar Foto")) {
                     tomarFotogrfia();
                 } else {
                     if (opciones[i].equals("Caragar Imagen")) {

                         Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                         intent.setType("image/");
                         startActivityForResult(intent.createChooser(intent, "Seleccionar la aplicacion"), COD_SELECCIONA);
                     } else {
                         dialogInterface.dismiss();

                     }
                 }
             }
         });
         alertOpciones.show();

     }

     private void tomarFotogrfia() {

         File fileImagen = new File( Environment.getExternalStorageDirectory(), RUTA_IMAGEN);
         boolean isCreada = fileImagen.exists();
         String nombreImagen = "";
         if (isCreada == false) {
             isCreada = fileImagen.mkdirs();
         }
         if (isCreada == true) {
             nombreImagen = (System.currentTimeMillis() / 1000) + ".jpg";
         }

         path = Environment.getExternalStorageDirectory() +
                 File.separator + RUTA_IMAGEN + File.separator + nombreImagen;
         File imagen = new File(path);

         Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
         intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(imagen));
         startActivityForResult(intent, COD_FOTO);

     }*/
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {

            switch (requestCode) {
                case COD_SELECCIONA:
                    Uri mpath = data.getData();
                    imagen.setImageURI(mpath);

                    Uri imagenn = data.getData();
                    String url = this.getPath(imagenn);
                    File myFile = new File(url);
                    RequestParams params2 = new RequestParams();
                    try {
                        params2.put("image", myFile);
                    } catch (FileNotFoundException e) {
                    }

                    AsyncHttpClient client2 = new AsyncHttpClient();
                    client2.post("http://192.168.0.179:3000/sendimage", params2, new AsyncHttpResponseHandler() {
                        @Override
                        public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                            agregado_con_exito();

                        }


                        @Override
                        public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                            fallo_al_agregar();
                        }

                    });


                    break;
                 case COD_FOTO:
                    MediaScannerConnection.scanFile(this,new String[]{path},null,
                            new MediaScannerConnection.OnScanCompletedListener() {
                                @Override
                                public void onScanCompleted(String path, Uri uri) {
                                    Log.i("Ruta de almacenamiento","Path:"+path);
                                }
                            });
                    Bitmap bitmap= BitmapFactory.decodeFile(path);
                    imagen.setImageBitmap(bitmap);
                    break;
            }


        }
    }
    private String getPath(Uri uri) {
        int column_index;
        String[] projection = {MediaStore.MediaColumns.DATA};
        Cursor cursor = managedQuery(uri, projection, null, null, null);
        column_index = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }

    private void fallo_al_agregar() {
        Toast.makeText(this, "error al agregar", Toast.LENGTH_LONG).show();
    }


    private void agregado_con_exito() {
        Toast.makeText(this, "agregado con exito", Toast.LENGTH_LONG).show();
    }


}


