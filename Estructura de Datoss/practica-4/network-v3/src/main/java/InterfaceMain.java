public class InterfaceMain {
    
    public static void main(String[] args) {
        MessagePost post = new MessagePost("alejo", "tum tum tum tum tum saur");
        PhotoPost fotopost = new PhotoPost("alejo", "tum.jpg", "tum tum tum tum tum saur");
        NewsFeed feed = new NewsFeed();

        post.addComment("crocrodrillo bombariño");
        post.unlike();
        post.like();
        post.like();

        fotopost.addComment("crocrodrillo bombariño");
        fotopost.like();
        fotopost.like();
        fotopost.like();
        fotopost.like();
        fotopost.like();

        feed.addPost(fotopost);
        feed.addPost(post);
        feed.show();

        EventPost event1 = new EventPost("alejo");
        event1.addFriend("lauty");
        event1.addFriend("lauty2");
        event1.removeFriend("lauty2");
        event1.showFriends();
    }
}
