public interface myApi {

    @GET("posts")
    Call<List<Users>> getUsers(@Query("userId") int userId,  // @Query("id")  inside the query you have to write the field in json file
                               @Query("userId") int userId2,
                               @Query("_sort") String sortby, // it will sort the data
                               @Query("_order") String orderBy // it will select in which order it will be sorted
                               );
    // it will show all the people whose userId is __
}
