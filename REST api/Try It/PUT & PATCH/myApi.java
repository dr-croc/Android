public interface myApi {

    // put usually used for updating
    // if you don't put anything as value put will automatically put null as value.
    // put update all the data of a specific object
    @PUT("posts/{id}")
    Call<Users> putpost(@Path("id") int postid, @Body  Users user);

    //  On the other hand
    // patch also used for data update
    // it will update only selected data.
    // but if you don't put any value it will now automatically place it as null
    @PATCH("posts/{id}")
    Call<Users> patchpost(@Path("id") int id,@Body Users user);

}
