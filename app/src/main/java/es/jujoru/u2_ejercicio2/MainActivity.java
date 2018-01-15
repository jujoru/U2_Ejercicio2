package es.jujoru.u2_ejercicio2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /*
    *   Declaramos el ListView y el array de String que contrendrá los datos para
    *   mostrar en el listView
    * */
    ListView listView;
    final String[] datos =
            new String[]{"Maria Garcia","Jose Perez","Juan Gutierrez","Javier Solana","Jose Romero",
                    "Alejandro Ferrer","Nuria Rodriguez", "Pedro Alcaraz", "Africa Bernal","David Gomez"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //Hacemos referencia a la vista del ListView para instanciarlo.
        listView = (ListView)findViewById(R.id.listView);

        //Creamos un ArrayAdapter que recibe el contexto, el tipo de lista y los datos
        ArrayAdapter<String> adaptador= new ArrayAdapter<String>(this,
                android.R.layout.simple_expandable_list_item_1,datos);

        //Asociamos al ListView el adaptador
        listView.setAdapter(adaptador);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = datos[position];
                String[] nombre_completo = item.split(" ");
                Toast.makeText(getApplicationContext(),"Nombre: "+nombre_completo[0]+"\nApellidos: "+nombre_completo[1],Toast.LENGTH_LONG).show();
            }
        });
    }
}
