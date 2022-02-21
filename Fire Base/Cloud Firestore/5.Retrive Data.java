DocumentReference docRef =FirebaseFirestore.getInstance().collection("cities").document("JSR");
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) // it will check if the data exist
                {
                    DocumentSnapshot doc = task.getResult();
                    if(doc.exists())
                    {
                       // Log.d("Document",doc.getData().toString());
                        Toast.makeText(getApplicationContext(), "Exists", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "No data", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
