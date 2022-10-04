1. create the main activity for chat, where users text and receiver text will be shown. It will contain the edit text for writing and sending the text. dont do any work in the activity.java, just design the xml file
2. create the sample layout for sending text
3. create the sample layout for reciving text
4. create the chats modal class which will hold the values like message_id, messages, sender_id, feeling etc
5. now work on the chats adapter, as you have two adapter you have to have two viewholder, always create the viewholder first by extending the RecyclerView.ViewHolder, then move forward to create the RecyclerView.Adapter
6. now back to chats activity that was created in the first step, the following task you have to do -> create the arrayList for  storing the value by holding the modal class, create the unique id by  adding the sender  and reciver id ,then first set the value in the database by creating childs, and the set the value  for both reciver and sender, then also get the value for setting in the Arraylist and then set the adapter
7. 


