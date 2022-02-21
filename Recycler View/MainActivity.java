
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    List<ModelClass> userList;
    Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initData();
        initRecyclerView();

    }

    private void initRecyclerView() {

        recyclerView = findViewById(R.id.recylerView);
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new Adapter(userList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    private void initData() {
        userList = new ArrayList<>();
        userList.add(new ModelClass(R.mipmap.ic_launcher,"patanjali","10:34pm", "Fuck you"));
        userList.add(new ModelClass(R.mipmap.ic_launcher,"patanjali","10:34pm", "Fuck you"));
        userList.add(new ModelClass(R.mipmap.ic_launcher,"patanjali","10:34pm", "Fuck you"));
        userList.add(new ModelClass(R.mipmap.ic_launcher,"patanjali","10:34pm", "Fuck you"));
        userList.add(new ModelClass(R.mipmap.ic_launcher,"patanjali","10:34pm", "Fuck you"));
        userList.add(new ModelClass(R.mipmap.ic_launcher,"patanjali","10:34pm", "Fuck you"));
        userList.add(new ModelClass(R.mipmap.ic_launcher,"patanjali","10:34pm", "Fuck you"));
        userList.add(new ModelClass(R.mipmap.ic_launcher,"patanjali","10:34pm", "Fuck you"));
    }
}
