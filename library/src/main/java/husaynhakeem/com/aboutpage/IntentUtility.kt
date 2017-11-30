package husaynhakeem.com.aboutpage

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.util.Log

private val TAG = "About Page"
private val EMAIL_URI_PREFIX = "mailto:"

fun sendEmail(context: Context, emailAddress: String) {
    try {
        context.startActivity(Intent(Intent.ACTION_SENDTO, Uri.parse(EMAIL_URI_PREFIX + emailAddress)))
    } catch (e: ActivityNotFoundException) {
        Log.e(TAG, "No available application found to handle email sending")
        e.printStackTrace()
    }
}

fun openWebPage(context: Context, webPageUrl: String) {
    try {
        context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(webPageUrl)))
    } catch (e: ActivityNotFoundException) {
        Log.e(TAG, "No available application found to handle webpage opening")
        e.printStackTrace()
    }
}

fun openFacebookPage(context: Context, facebookUsername: String) {
    var facebookUri = Uri.parse("http://m.facebook.com/" + facebookUsername)
    try {
        val applicationInfo = context.packageManager.getApplicationInfo("com.facebook.katana", 0)
        if (applicationInfo.enabled)
            facebookUri = Uri.parse("fb://facewebmodal/f?href=" + facebookUsername)
    } catch (e: PackageManager.NameNotFoundException) {
        Log.e(TAG, "Facebook application uninstalled on current device")
    }
    context.startActivity(Intent(Intent.ACTION_VIEW, facebookUri))
}

fun openTwitter(context: Context, twitterId: String) {
    var twitterUri = Uri.parse("http://twitter.com/intent/user?screen_name=" + twitterId)
    try {
        val applicationInfo = context.packageManager.getApplicationInfo("com.twitter.android", 0)
        if (applicationInfo.enabled)
            twitterUri = Uri.parse("twitter://user?screen_name=" + twitterId)
    } catch (e: PackageManager.NameNotFoundException) {
        Log.e(TAG, "Twitter application uninstalled on current device")
    }
    context.startActivity(Intent(Intent.ACTION_VIEW, twitterUri))
}

fun openYoutube(context: Context, youtubeChannel: String) {
    val youtubeIntent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/user/channel/" + youtubeChannel))
    try {
        youtubeIntent.setPackage("com.google.android.youtube")
        context.startActivity(youtubeIntent)
    } catch (e: ActivityNotFoundException) {
        Log.e(TAG, "Youtube application uninstalled on current device")
        context.startActivity(youtubeIntent)
    }
}

fun openPlayStore(context: Context, playStoreId: String) {
    try {
        context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + playStoreId)))
    } catch (e: ActivityNotFoundException) {
        Log.e(TAG, "Play store not installed on current device")
        e.printStackTrace()
    }
}

fun openInstagram(context: Context, userId: String) {
    val instagramIntent = Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/_u/" + userId))
    try {
        instagramIntent.setPackage("com.instagram.android")
        context.startActivity(instagramIntent)
    } catch (e: ActivityNotFoundException) {
        Log.e(TAG, "Instagram application uninstalled on current device")
        context.startActivity(instagramIntent)
    }
}

fun openGithub(context: Context, userId: String) {
    val githubIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/" + userId))
    try {
        githubIntent.addCategory(Intent.CATEGORY_BROWSABLE)
        context.startActivity(githubIntent)
    } catch (e: ActivityNotFoundException) {
        Log.e(TAG, "No available application found to handle -github- webpage opening")
        e.printStackTrace()
    }
}

fun openPinterest(context: Context, userId: String) {
    try {
        context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("pinterest://www.pinterest.com/<profile-name>")))
    } catch (e: ActivityNotFoundException) {
        Log.e(TAG, "Pinterest application uninstalled on current device")
        context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.pinterest.com/<profile-name>")))
    }
}