import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
    int[] flags;
    String[] countryNames;
    Context context;

    // iflater convert xml file to view file

    private LayoutInflater inflater;

    CustomAdapter(Context context, String[] countryNames, int[] flags )
    {
        this.context=context;
        this.flags = flags;
        this.countryNames = countryNames;
    }
    
    @Override
    public int getCount() {
        // returns total number of Item
        return countryNames.length;
    }
    @Override
    public Object getItem(int position) {
        return null;
    }
    @Override
    public long getItemId(int position) {
        return 0;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // will convert the sample_view.xml to  view
        // that is why we need a inflater
        if(convertView==null)
        {
            // WE need this service to inflate the layout
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.sample_view,parent,false);
        }
        ImageView imageView =convertView.findViewById(R.id.sample_view_ImageViewer);
        TextView textView = convertView.findViewById(R.id.sample_view_TextView_countryName);

        imageView.setImageResource(flags[position]);
        textView.setText(countryNames[position]);
        
        return convertView;
    }
}
