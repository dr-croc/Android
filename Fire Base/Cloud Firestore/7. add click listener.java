// adding a real time listener

        FirebaseFirestore.getInstance().collection("cities").document("JSR").addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {

            }
        });
