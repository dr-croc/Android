import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<ModelClass> userList;

    public Adapter(List<ModelClass> userList) {
        this.userList = userList;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_design,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        int res =userList.get(position).getImageView1();
        String name =userList.get(position).getTexrView1();
        String msg =userList.get(position).getTexrView3();
        String time =userList.get(position).getTexrView2();

        holder.setData(res, name , msg , time);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView txt1,txt2,txt3;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView1);
            txt1 = itemView.findViewById(R.id.textView1);
            txt2 = itemView.findViewById(R.id.textView2);
            txt3 = itemView.findViewById(R.id.textView3);
        }

        public void setData(int res, String name, String msg, String time) {
            imageView.setImageResource(res);
            txt1.setText(name);
            txt2.setText(time);
            txt3.setText(msg);

        }
    }
}
