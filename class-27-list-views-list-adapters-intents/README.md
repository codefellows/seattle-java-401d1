# ![CF](http://i.imgur.com/7v5ASc8.png) List Views, List Adapters and Intents

## Reading
This is a lot of reading. You don't have to read it word for word, but please
peruse the chapters and try to gain a general understanding of what Fragments
are and how Lists are created in Android. Extra-good sections with shorter
reading spans are called out specifically, like the section about Singletons.

* Read Big Nerd Ranch
* **Your Second Activity** (pages 91-112)
* **UI Fragments** (pages 123-156)
* **Displaying Lists with RecyclerView** (pages 157-180)
* **Singletons and centralized data storage** (pages 159-160)
* **An abstract Activity class** (pages 162-164)
* Gain an understanding of `Fragments` vs `Activites`
* When and why were `Fragments` first introduced to Android?
* What advantage does creating an Abstract Activity class with a single abstract
  method to define a fragment offer?
* What parts do the following classes play when showing lists?
  * `RecyclerView`
  * `ViewHolder`
  * `Adapter`

## Code Samples

#### Add Second Activity to Manifest
Add a second activity to `AndroidManifest.xml`

```xml
<application
		android:allowBackup="true"
		android:icon="@mipmap/ic_launcher"
		android:label="@string/app_name"
		android:roundIcon="@mipmap/ic_launcher_round"
		android:supportsRtl="true"
		android:theme="@style/AppTheme">
		<activity android:name=".MainActivity">
				<intent-filter>
						<action android:name="android.intent.action.MAIN" />

						<category android:name="android.intent.category.LAUNCHER" />
				</intent-filter>
		</activity>
		<activity android:name=".SecondActivity"></activity>
</application>
```

#### Start Second Activity On Button Press
```java
mButton = findViewById(R.id.goToTwo);
mButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, SecondActivty.class);
        startActivity(intent);
    }
});
```

#### Start Second Activity For Result
* Make a public static final int to identify results when they come back.
* Use `startActivityForResult` inside a button press identifying the request
  with the identifying int code you just created.
* inside `onActivityResult`
	* Check to make sure that the result came back ok,
	* Check to make sure the result matches the int code you requested
		(to differentiate between different possible results coming back)
  * Check to make sure that the result actually came back with data
  * Get an `extra` keyed according to a constant defined in the other Activity.

```java
public class FirstActivity {
	public static final int REQUEST_GET_ANIMAL = 1;

	Intent intent = new Intent(MainActivity.this, ChooseAnimalActivity.class);
	startActivityForResult(intent, REQUEST_GET_ANIMAL);

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
			if (resultCode != Activity.RESULT_OK) {
					return;
			}

			if (requestCode == REQUEST_GET_ANIMAL) {
					if (data == null) {
							return;
					}

					String favorite = data.getStringExtra(ChooseAnimalActivity.FAVORITE_ANIMAL);
					String message = "You're favorite animal is a: " + favorite;
					mFavoriteAnimal.setText(message);
			}
	}
}
```

```java
public class ChooseAnimalActivity {
    public static final String FAVORITE_ANIMAL = "favorite-animal";

		public void calledFromSomeClickListener(String favoriteAnimal) {
				Intent data = new Intent();
				data.putExtra(FAVORITE_ANIMAL, favoriteAnimal);
				setResult(RESULT_OK, data);

				ChooseAnimalActivity.this.finish();
		}
}
```
