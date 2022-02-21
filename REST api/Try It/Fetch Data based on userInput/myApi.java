import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface myApi {
    
    // for post/1/comments
    // take input from user and show
    @GET("posts/{input}/comments") // input will be taken from
    Call<List<Comment>> getComments(@Path("input") int postId); // post id will be taken from user
}
