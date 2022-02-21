public interface myApi {
    // DELETE
    @DELETE("posts/{id}")
    Call<Void> deletepost(@Path("id") int id);
}
