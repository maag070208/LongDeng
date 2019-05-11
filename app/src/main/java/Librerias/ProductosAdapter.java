package Librerias;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.prctica8guillen.R;

import org.w3c.dom.Text;

public class ProductosAdapter extends ArrayAdapter<Productos> {
    public ProductosAdapter (Context contexto){
        super(contexto,R.layout.elementos_lista,R.id.txtCantidadListaInv);
    }
    public View getView(int posicion, View convertView, ViewGroup ventana) {
        View view=super.getView(posicion,convertView,ventana);
        TextView txtCodigo=(TextView)view.findViewById(R.id.txtCodigoListaInv);
        TextView txtPrecio=(TextView)view.findViewById(R.id.txtPrecioListaInv);
        TextView txtDescripcion=(TextView)view.findViewById(R.id.txtDescripcionListaInv);
        ImageView imagen=(ImageView)view.findViewById(R.id.imgListaInventario);
        Productos producto=getItem(posicion);
        txtCodigo.setText("Codigo: "+producto.getCodigo());
        txtDescripcion.setText("Descricion: "+producto.getDescripcion());
        txtPrecio.setText("Precio: "+producto.getPrecio());
        imagen.setImageResource(producto.getImagen());

        return view;
    }
}
