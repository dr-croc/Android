FirebaseFirestore db = FirebaseFirestore.getInstance();

        Map<String, Object> city = new HashMap<>();
        city.put("name ", "Mirpur");
        city.put("state ", "Dhaka");
        city.put("country ", "India");

        db.collection("cities").document("JSR").set(city).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(getApplicationContext(), "Values added", Toast.LENGTH_SHORT).show();
            }
        });
