public interface myApi {

    // 1st way to post something
    @POST("posts")
    Call<Users>createPost(@Body  Users user ); // you want to post the info in the body that is you need the body method

    // second way to post something
    @FormUrlEncoded
    @POST("posts")
    Call<Users> createPost(
            @Field("userId") int userId,
            @Field("body") String text,
            @Field("title") String title
    );

}
