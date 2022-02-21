   //updating existing data
        DocumentReference ref = FirebaseFirestore.getInstance().collection("cities").document("JSR");
        ref.update("country ","Bangladesh");
