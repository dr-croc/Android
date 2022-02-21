import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.CustomViewHolder> {

    private List<PostPojo> dataList;
    private Context context;

    public Adapter(List<PostPojo> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }
    class CustomViewHolder extends RecyclerView.ViewHolder{

        TextView titles, posts;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);

            titles = itemView.findViewById(R.id.adapter_title);
            posts = itemView.findViewById(R.id.adapter_body);

        }
    }
    @NonNull
    @Override
    public Adapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.design,parent,false);
        return new CustomViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull Adapter.CustomViewHolder holder, int position) {
        holder.titles.setText(dataList.get(position).getTitle());
        holder.posts.setText(dataList.get(position).getBody());
    }
    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
