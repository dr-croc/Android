

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface myApi {

    @GET("posts")
    Call<List<Users>> getUsers(@Query("userId") int userId,  // @Query("id")  inside the query you have to write the field in json file
                               @Query("userId") int userId2,
                               @Query("_sort") String sortby, // it will sort the data
                               @Query("_order") String orderBy // it will select in which order it will be sorted
                               );
    // it will show all the people whose userId is __

    // for post/1/comments
    // take input from user and show
    @GET("posts/{input}/comments") // input will be taken from
    Call<List<Comment>> getComments(@Path("input") int postId); // post id will be taken from user

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

    // DELETE
    @DELETE("posts/{id}")
    Call<Void> deletepost(@Path("id") int id);
}
