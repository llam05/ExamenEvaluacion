package mmanjaag7alumnes.edu.ub.examenfinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by mmanjaag7.alumnes on 07/07/16.
 */
public class DespesaAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Despesa> items;

    public DespesaAdapter(Context context, ArrayList<Despesa> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return this.items.size();
    }

    @Override
    public Object getItem(int position) {
        return this.items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;

        if (convertView == null) {
            // Create a new view into the list.
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.activity_objeto2, parent, false);
        }

        // Set data into the view.
        TextView nom = (TextView) rowView.findViewById(R.id.nombre);
        TextView des = (TextView) rowView.findViewById(R.id.desc);

        Despesa item = this.items.get(position);
        nom.setText(item.getCantidad());
        des.setText(item.getCategoria()+" "+item.getFecha());

        return rowView;
    }
}
