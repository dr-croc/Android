
public class MainActivity extends AppCompatActivity {
   ActivityMainBinding am;
   
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        am = ActivityMainBinding.inflate(getLayoutInflater());
        //setContentView(R.layout.activity_main);
        setContentView(am.getRoot());
        
        // retriving dat from the data base
        HashMap<String , Object> map2 = new HashMap<>();
        map2.put("n1", "Java");
        map2.put("n2", "Kotlin");
        map2.put("n3", "Flutter");
        map2.put("n4", "React Native");

        FirebaseDatabase.getInstance().getReference().child("Information").child("Languages").updateChildren(map2);
        
        ArrayList<String> list = new ArrayList<>();
        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,list);
        am.listView.setAdapter(adapter);
        
        // to add value in the list by user input
        am.am1BtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    String data = am.am1EdtName.getText().toString();

                    //pushing the data in the data base
                    FirebaseDatabase.getInstance()
                            .getReference()
                            .child("Information").child("Languages")
                            .child("name")
                            .setValue(data);
            }
        });
        
        // to access the data base we need to get the value of the data base
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Information").child("Languages");
        // to access all the value of 1 branch
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();
                // to iterate through the branch
                for(DataSnapshot snapshot1 : snapshot.getChildren())
                {
                    list.add(snapshot1.getValue().toString());
                }
                adapter.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

        }
}

