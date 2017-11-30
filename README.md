# Android About Page (Still under construction)

### Based on [Android About Page](https://github.com/medyo/android-about-page)
This library is based on [Android About Page](https://github.com/medyo/android-about-page) by [Mehdi Sakout](https://github.com/medyo) which was written entirely in Java. This project is an attempt to rewrite it in Kotlin.

### Set up
The first step is to include about-page into your project, for example, as a Gradle compile dependency:

```groovy
compile husaynhakeem.com.aboutpage.1.0
```

### Usage
#### Set Image
Set the image (could be your application's logo or launcher icon) you want to be visible on the About page.

```kotlin
setImage(Int)
```

#### Set description
Set the description you want visible on the About page.

```kotlin
setDescription(Int)
```

#### Set background image/color
Set the background color or image for the entire About page.

```kotlin
setImage(Int)
```

#### Add reference to social media
Showcase your presence on social media! Use one of the predefined methods to add a reference to any of your accounts on social media.

```kotlin
addFacebook(facebookId: String)
addTwitter(twitterId: String)
addYoutube(youtubeChannedId: String)
addPlayStore(appPackageId: String)
addInstagram(instagramUserId: String)
addGitHub(githubUserId: String)
```

#### Add a custom item
If the predefined items aren't enough for you, add a custom item of your own either by passing a `view` or `Item` instance to the addItem() method.

```kotlin
addItem(Item("AboutApp Version 1.0))
```

### Sample application
Checkout the sample app for a simple example of how to use this library.
[husaynhakeem/android-about-page/app/](https://github.com/husaynhakeem/android-about-page/tree/master/app)
