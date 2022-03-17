img = findViewById(R.id.reg_image);

bind_reg_b.regImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent,"Title"),image_code);
            }
        });


// outside of main method
@Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == image_code){
            if(data!= null){ // if we have something
                image_uri = data.getData();
                img.setImageURI(image_uri);
            }
        }
    }
