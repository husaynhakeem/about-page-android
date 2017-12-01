# About Page - Android

![alt text](https://github.com/husaynhakeem/about-page/blob/master/app/icon_launcher_web.png)

Android library for easily creating an about page for your Android apps.
```kotlin
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(AboutPage(this)
                .setBackground(android.R.color.white)
                .setImage(R.mipmap.ic_launcher)
                .addItem(Item("AboutPage Version 1.0"))
                .addEmail("husaynhakeem@gmail.com")
                .addFacebook("linkinpark")
                .addGithub("husaynhakeem")
                .addInstagram("husaynhakeem")
                .addPlayStore("com.maketrumptweetseightagain")
                .addTwitter("oneplus")
                .addWebsite("http://www.google.com")
                .addYoutube("UCyWqModMQlbIo8274Wh_ZsQ")
                .addItem(Item("Thank you for downloading", null, View.OnClickListener { Toast.makeText(this, "Enjoy!", Toast.LENGTH_SHORT).show() }))
                .create())
    }
}
```

This library is based on [Android About Page](https://github.com/medyo/android-about-page) by [Mehdi Sakout](https://github.com/medyo) which was written entirely in Java. This project is an attempt to rethink it, refine it and rewrite it in Kotlin.

### Download
1. Add below code in your root build.gradle at the end of repositories
```groovy
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```
2. Add the dependency
```groovy
dependencies {
    compile 'com.github.husaynhakeem:about-page:0.1.1'
}
```

### Sample application
For additional information on how to use this library, check out the [sample application](https://github.com/husaynhakeem/about-page/tree/master/app).

![alt text](https://github.com/husaynhakeem/about-page/blob/master/app/about-page.png)

### Contributing
If you would like to contribute code you can do so through GitHub by forking the repository and sending a pull request.
When submitting code, please make every effort to follow existing conventions and style in order to keep the code as readable as possible.
