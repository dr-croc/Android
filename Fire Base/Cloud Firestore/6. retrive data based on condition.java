   FirebaseFirestore.getInstance().collection("cities").whereEqualTo("capital",true)

.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful())
                {
                    for (QueryDocumentSnapshot doc : task.getResult())
                    {
                        Log.d("Document",doc.getId()+ " => "+doc.getData());
                    }

                }
            }
        });
        }
