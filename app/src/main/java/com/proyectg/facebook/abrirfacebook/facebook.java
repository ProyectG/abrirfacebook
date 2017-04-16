package com.proyectg.facebook.abrirfacebook;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class facebook extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //Inicializo el id del elemento
        final Button facebook = (Button) findViewById(R.id.fb);

        //Activo el listener y ejecuto la accion del boton
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
              abrirFB(facebook.this);
            }
        });

    }


    public static Intent abrirFB(Context context) {

        try {
            context.getPackageManager()
                    .getPackageInfo("com.facebook.katana", 0);
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("fb://page/id"));
        } catch (Exception e){

            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.facebook.com/pagina"));
        }
        /*
                Intento ver si existe alguna aplicacion con esta informacion del paquete
                Si es asi ejecuto el uri.parse con la simbologia para que abra la pagina con la aplicacion de fb
                si no ejecuta la direccion en un navegador.
                fb://page/id = fb://page/24782035495
                https://www.facebook.com/pagina = https://www.facebook.com/pagina_que_quieras_abrir

         */



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_facebook, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
