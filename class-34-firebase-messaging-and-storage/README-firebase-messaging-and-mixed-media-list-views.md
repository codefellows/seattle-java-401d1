# ![CF](http://i.imgur.com/7v5ASc8.png) Firebase Auth

## Resources
* [Into to Firebase Auth](https://firebase.google.com/docs/auth/)
* [Users in Firebase](https://firebase.google.com/docs/auth/users)
* [Setting Up Firebase Auth](https://firebase.google.com/docs/auth/android/start/)
* [Anonymous Sign In](https://firebase.google.com/docs/auth/android/anonymous-auth)

## Check for Understanding
* What are the five fixed basic properties on all Firebase Users?
* How do you keep track of additional information for a user?

```java
@Override
public void onStart() {
    super.onStart();
    // Check if user is signed in (non-null) and update UI accordingly.
    FirebaseUser currentUser = mAuth.getCurrentUser();
}
```

#### Create New Users
```java
mAuth.createUserWithEmailAndPassword(email, password)
.addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
		@Override
		public void onComplete(@NonNull Task<AuthResult> task) {
				if (task.isSuccessful()) {
						// Sign in success, update UI with the signed-in user's information
						Log.d(TAG, "createUserWithEmail:success");
						FirebaseUser user = mAuth.getCurrentUser();
						updateUI(user);
				} else {
						// If sign in fails, display a message to the user.
						Log.w(TAG, "createUserWithEmail:failure", task.getException());
						Toast.makeText(EmailPasswordActivity.this, "Authentication failed.",
										Toast.LENGTH_SHORT).show();
						updateUI(null);
				}

				// ...
		}
});
```

#### Sign in Existing Users

```java
mAuth.signInWithEmailAndPassword(email, password)
.addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
		@Override
		public void onComplete(@NonNull Task<AuthResult> task) {
				if (task.isSuccessful()) {
						// Sign in success, update UI with the signed-in user's information
						Log.d(TAG, "signInWithEmail:success");
						FirebaseUser user = mAuth.getCurrentUser();
						updateUI(user);
				} else {
						// If sign in fails, display a message to the user.
						Log.w(TAG, "signInWithEmail:failure", task.getException());
						Toast.makeText(EmailPasswordActivity.this, "Authentication failed.",
										Toast.LENGTH_SHORT).show();
						updateUI(null);
				}

				// ...
		}
});
```

#### Obtain User Information

```java
FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
if (user != null) {
    // Name, email address, and profile photo Url
    String name = user.getDisplayName();
    String email = user.getEmail();
    Uri photoUrl = user.getPhotoUrl();

    // Check if user's email is verified
    boolean emailVerified = user.isEmailVerified();

    // The user's ID, unique to the Firebase project. Do NOT use this value to
    // authenticate with your backend server, if you have one. Use
    // FirebaseUser.getIdToken() instead.
    String uid = user.getUid();
}
```

#### Anonymous Sign In
```java
mAuth.signInAnonymously()
.addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
		@Override
		public void onComplete(@NonNull Task<AuthResult> task) {
				if (task.isSuccessful()) {
						// Sign in success, update UI with the signed-in user's information
						Log.d(TAG, "signInAnonymously:success");
						FirebaseUser user = mAuth.getCurrentUser();
						updateUI(user);
				} else {
						// If sign in fails, display a message to the user.
						Log.w(TAG, "signInAnonymously:failure", task.getException());
						Toast.makeText(AnonymousAuthActivity.this, "Authentication failed.",
										Toast.LENGTH_SHORT).show();
						updateUI(null);
				}

				// ...
		}
});
```
