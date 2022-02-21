// to set the data in database with unique id we use the .add method
        Map<String, Object> city2 = new HashMap<>();
        city2.put("name ", "Tokyo");
        city2.put("capital ", "Jpaan");
        city2.put("country ", "India");

        db.collection("cities").add(city2).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
            @Override
            public void onComplete(@NonNull Task<DocumentReference> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(getApplicationContext(), "Value added suuccessfully", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "value not added", Toast.LENGTH_SHORT).show();
                }
            }
        });
