// > merging some value to the database
        // to merge data we will open a new map and add data to it

       Map<String, Object> city2 = new HashMap<>();
         city2.put("captital", "Mirpur2");

        db.collection("cities").document("JSR").set(city2, SetOptions.merge()).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(getApplicationContext(), "Merge SuccessFul", Toast.LENGTH_SHORT).show();
            }
        });
