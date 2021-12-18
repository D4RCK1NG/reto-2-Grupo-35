package com.example.reto2;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

/**
 * @author DAVID AMAYA
 */

public class MainActivity extends AppCompatActivity {

    Fragment pantproductos, pantservicios, pantsucursales, pantfavoritos, pantinicio;
    FragmentTransaction intercambio;

    private Button product;
    private Button servicio;
    private Button sucursal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pantinicio = new FragmentInicio();
        pantproductos = new FragmentProductos();
        pantservicios = new FragmentServicios();
        pantsucursales = new FragmentSucursales();
        pantfavoritos = new FragmentFavoritos();

        getSupportFragmentManager().beginTransaction().add(R.id.contenedor, pantinicio).commit();


        product = (Button) findViewById(R.id.product);
        product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intercambio = getSupportFragmentManager().beginTransaction();
                intercambio.replace(R.id.contenedor, pantproductos).commit();
            }
        });

        servicio = (Button) findViewById(R.id.servicio);
        servicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intercambio = getSupportFragmentManager().beginTransaction();
                intercambio.replace(R.id.contenedor, pantservicios).commit();
            }
        });
        sucursal = (Button) findViewById(R.id.sucursal);
        sucursal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intercambio = getSupportFragmentManager().beginTransaction();
                intercambio.replace(R.id.contenedor, pantsucursales).commit();
            }
        });
    }

    /**
     *  Metodo para mostrar y ocultar el menu
     */


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menugeneral, menu);
        return true;
    }

    /**
     * Metodo para agregar las acciones
     */

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.productos) {
            intercambio = getSupportFragmentManager().beginTransaction();
            intercambio.replace(R.id.contenedor, pantproductos).addToBackStack(null).commit();
        }
        if (id == R.id.servicios) {
            intercambio = getSupportFragmentManager().beginTransaction();
            intercambio.replace(R.id.contenedor, pantservicios).addToBackStack(null).commit();
        }
        if (id == R.id.sucursales) {
            intercambio = getSupportFragmentManager().beginTransaction();
            intercambio.replace(R.id.contenedor, pantsucursales).addToBackStack(null).commit();
        }
        return super.onOptionsItemSelected(item);

    }
}