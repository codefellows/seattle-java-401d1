# ![CF](http://i.imgur.com/7v5ASc8.png) Firebase Database Integration on Android

Read the Firebase docs for working with the Firebase Database and Android.

## Resources
* [Get Started](https://firebase.google.com/docs/database/android/start/)
* [Structure Data](https://firebase.google.com/docs/database/android/structure-data)
* [Read and Write Data](https://firebase.google.com/docs/database/android/read-and-write)
* [Work with Lists of Data](https://firebase.google.com/docs/database/android/lists-of-data)

### Write to Your Database
```java
// Write a message to the database
FirebaseDatabase database = FirebaseDatabase.getInstance();
DatabaseReference myRef = database.getReference("message");

myRef.setValue("Hello, World!");
```

### Read From Your Database
```java
// Read from the database
myRef.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        // This method is called once with the initial value and again
        // whenever data at this location is updated.
        String value = dataSnapshot.getValue(String.class);
        Log.d(TAG, "Value is: " + value);
    }

    @Override
    public void onCancelled(DatabaseError error) {
        // Failed to read value
        Log.w(TAG, "Failed to read value.", error.toException());
    }
});
```

### Java Compared to Firebase Database
This shows how to interact with Firebase to save a complex object you have in
your application. Compare your understanding of how the class creates a Map to
represent itself to how it interacts with Firebase to save itself.

#### Vanilla Java Interactions
```java
public class Post {

    public String uid;
    public String author;
    public String title;
    public String body;
    public int starCount = 0;
    public Map<String, Boolean> stars = new HashMap<>();

    public Post() {
        // Default constructor required for calls to DataSnapshot.getValue(Post.class)
    }

    public Post(String uid, String author, String title, String body) {
        this.uid = uid;
        this.author = author;
        this.title = title;
        this.body = body;
    }

    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("uid", uid);
        result.put("author", author);
        result.put("title", title);
        result.put("body", body);
        result.put("starCount", starCount);
        result.put("stars", stars);

        return result;
    }
}
```

#### Saving to Firebase Database
```java
private void writeNewPost(String userId, String username, String title, String body) {
    // Create new post at /user-posts/$userid/$postid and at
    // /posts/$postid simultaneously
    String key = mDatabase.child("posts").push().getKey();
    Post post = new Post(userId, username, title, body);
    Map<String, Object> postValues = post.toMap();

    Map<String, Object> childUpdates = new HashMap<>();
    childUpdates.put("/posts/" + key, postValues);
    childUpdates.put("/user-posts/" + userId + "/" + key, postValues);

    mDatabase.updateChildren(childUpdates);
}
```
