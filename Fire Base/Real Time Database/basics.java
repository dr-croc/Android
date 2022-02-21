 // this will create a branch in the data base with value abcd
        FirebaseDatabase.getInstance().getReference().child("Programming knowledge").setValue("abcd");

        // >> to add multiple values
        // to add map  we use update childern method
        HashMap<String , Object> map = new HashMap<>();
        map.put("name", "Rishav");
        map.put("Email", "rishav@gmail.com");

        FirebaseDatabase.getInstance().getReference().child("Programming knowledge").child("multiple values").updateChildren(map);

        // >> to get value from user and save it in the database
        am.am1BtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data =am.am1EdtName.getText().toString();

                //pushing the data in the data base
                FirebaseDatabase.getInstance()
                        .getReference()
                        .child("Programming knowledge")
                        .push()
                        .child("name")
                        .setValue(data);// it will save the data with an unique id
            }
        });
