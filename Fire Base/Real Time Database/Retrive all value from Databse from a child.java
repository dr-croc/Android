public class MainActivity extends AppCompatActivity {
   ActivityMainBinding am;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        am = ActivityMainBinding.inflate(getLayoutInflater());
        //setContentView(R.layout.activity_main);
        setContentView(am.getRoot());

HashMap<String , Object> map3 = new HashMap<>();
        map3.put("email:", "Java");
        map3.put("name:", "Kotlin");

        FirebaseDatabase.getInstance().getReference().child("Info").child("branch1").updateChildren(map3);

        HashMap<String , Object> map4 = new HashMap<>();
        map4.put("email:", "python");
        map4.put("name:", "React Nativ");

        FirebaseDatabase.getInstance().getReference().child("Info").child("branch2").updateChildren(map4);

        // retrive complete branch as a single object
        //crate a model class : information. we have name and children. So we will create two private variables

        ArrayList<String> list2 = new ArrayList<>();
        ArrayAdapter adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,list2);
        am.listView.setAdapter(adapter2);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Info").child("branch2");
        // to access all the value of 1 branch
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list2.clear();
                // to iterate through the branch
                for(DataSnapshot snapshot1 : snapshot.getChildren())
                {
                    Information information = snapshot1.getValue(Information.class);
                    String em = information.getName()+" : " +information.getEmail();

                    list2.add(em);
                }
                adapter2.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
      
              }
}

