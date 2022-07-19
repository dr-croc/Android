// this button will launch the gallery
binding.btnAddImageSlider.setOnClickListener {
            getImage.launch("image/*")
        }


val getImage = registerForActivityResult(
            ActivityResultContracts.GetContent(),
            {
                binding.imgSlider.setImageURI(it) // this is a imageView where is setted the image.
            }
        )


