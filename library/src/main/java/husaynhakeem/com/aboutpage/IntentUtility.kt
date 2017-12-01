package husaynhakeem.com.aboutpage

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.util.Log

private val TAG = "About Page"
private val EMAIL_URI_PREFIX = "mailto:"
private val FACEBOOK_DEEPLINK_URL_PREFIX = "fb://facewebmodal/f?href="
private val FACEBOOK_WEB_URL_LINK = "http://m.facebook.com/"
private val FACEBOOK_PACKAGE_ID = "com.facebook.katana"
private val TWITTER_WEB_URL_PREFIX = "http://twitter.com/intent/user?screen_name="
private val TWITTER_DEEPLINK_URL_PREFIX = "twitter://user?screen_name="
private val TWITTER_PACKAGE_ID = "com.twitter.android"
private val YOUTUBE_URL_PREFIX = "http://www.youtube.com/user/channel/"
private val YOUTUBE_PACKAGE_ID = "com.google.android.youtube"
private val INSTAGRAM_URL_PREFIX = "http://instagram.com/_u/"
private val INSTAGRAM_PACKAGE_ID = "com.instagram.android"
private val PLAY_STORE_URL_PREFIX = "market://details?id="
private val GITHUB_URL_PREFIX = "https://github.com/"

internal fun sendEmail(context: Context, emailAddress: String) {
    try {
        context.startActivity(Intent(Intent.ACTION_SENDTO, Uri.parse(EMAIL_URI_PREFIX + emailAddress)))
    } catch (e: ActivityNotFoundException) {
        Log.e(TAG, "No available application found to handle email sending")
        e.printStackTrace()
    }
}

internal fun openWebPage(context: Context, webPageUrl: String) {
    try {
        context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(webPageUrl)))
    } catch (e: ActivityNotFoundException) {
        Log.e(TAG, "No available application found to handle webpage opening")
        e.printStackTrace()
    }
}

internal fun openFacebookPage(context: Context, facebookUsername: String) {
    var facebookUri = Uri.parse(FACEBOOK_WEB_URL_LINK + facebookUsername)
    try {
        val applicationInfo = context.packageManager.getApplicationInfo(FACEBOOK_PACKAGE_ID, 0)
        if (applicationInfo.enabled)
            facebookUri = Uri.parse(FACEBOOK_DEEPLINK_URL_PREFIX + facebookUsername)
    } catch (e: PackageManager.NameNotFoundException) {
        Log.e(TAG, "Facebook application uninstalled on current device")
    }
    context.startActivity(Intent(Intent.ACTION_VIEW, facebookUri))
}

internal fun openTwitter(context: Context, twitterId: String) {
    var twitterUri = Uri.parse(TWITTER_WEB_URL_PREFIX + twitterId)
    try {
        val applicationInfo = context.packageManager.getApplicationInfo(TWITTER_PACKAGE_ID, 0)
        if (applicationInfo.enabled)
            twitterUri = Uri.parse(TWITTER_DEEPLINK_URL_PREFIX + twitterId)
    } catch (e: PackageManager.NameNotFoundException) {
        Log.e(TAG, "Twitter application uninstalled on current device")
    }
    context.startActivity(Intent(Intent.ACTION_VIEW, twitterUri))
}

internal fun openYoutube(context: Context, youtubeChannel: String) {
    val youtubeIntent = Intent(Intent.ACTION_VIEW, Uri.parse(YOUTUBE_URL_PREFIX + youtubeChannel))
    try {
        youtubeIntent.setPackage(YOUTUBE_PACKAGE_ID)
        context.startActivity(youtubeIntent)
    } catch (e: ActivityNotFoundException) {
        Log.e(TAG, "Youtube application uninstalled on current device")
        context.startActivity(youtubeIntent)
    }
}

internal fun openPlayStore(context: Context, playStoreId: String) {
    try {
        context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(PLAY_STORE_URL_PREFIX + playStoreId)))
    } catch (e: ActivityNotFoundException) {
        Log.e(TAG, "Play store not installed on current device")
        e.printStackTrace()
    }
}

internal fun openInstagram(context: Context, userId: String) {
    val instagramIntent = Intent(Intent.ACTION_VIEW, Uri.parse(INSTAGRAM_URL_PREFIX + userId))
    try {
        instagramIntent.setPackage(INSTAGRAM_PACKAGE_ID)
        context.startActivity(instagramIntent)
    } catch (e: ActivityNotFoundException) {
        Log.e(TAG, "Instagram application uninstalled on current device")
        context.startActivity(instagramIntent)
    }
}

internal fun openGithub(context: Context, userId: String) {
    val githubIntent = Intent(Intent.ACTION_VIEW, Uri.parse(GITHUB_URL_PREFIX + userId))
    try {
        githubIntent.addCategory(Intent.CATEGORY_BROWSABLE)
        context.startActivity(githubIntent)
    } catch (e: ActivityNotFoundException) {
        Log.e(TAG, "No available application found to handle -github- webpage opening")
        e.printStackTrace()
    }
}
