public class UserAdapter extends  RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    Context context;
    ArrayList<UserModelClass> userModelClasses; // this is the model class that has been used.
    // building a constructor
    public UserAdapter(Context context, ArrayList<UserModelClass>userModelClasses){
        this.context = context;
        this.userModelClasses = userModelClasses;
    }



    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_conversation, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        UserModelClass user = userModelClasses.get(position);
        holder.binding.dashboardRowUsername.setText(user.getName());

        Glide.with(context).load(user.getProfileImage())
                .placeholder(R.drawable.user_image)
                .into(holder.binding.dashboardRowProfile);

    }

    @Override
    public int getItemCount() {
        return userModelClasses.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder{
        RowConversationBinding binding;
        public UserViewHolder(View itemView){
            super(itemView);
            binding = RowConversationBinding.bind(itemView);
        }
    }
}
