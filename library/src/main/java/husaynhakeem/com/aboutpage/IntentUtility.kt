package husaynhakeem.com.aboutpage

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.util.Log


private val TAG = "About Page"
private val EMAIL_URI_PREFIX = "mailto:"
private val FACEBOOK_PACKAGE_NAME = "com.facebook.katana"
private val FACEBOOK_URI_PREFIX = "fb://facewebmodal/f?href="

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
    var facebookUsernameUri = Uri.parse(facebookUsername)
    try {
        val applicationInfo = context.packageManager.getApplicationInfo(FACEBOOK_PACKAGE_NAME, 0)
        if (applicationInfo.enabled)
            facebookUsernameUri = Uri.parse(FACEBOOK_URI_PREFIX + facebookUsername)
    } catch (e: PackageManager.NameNotFoundException) {
        Log.e(TAG, "Facebook application uninstalled on device")
        e.printStackTrace()
    }
    context.startActivity(Intent(Intent.ACTION_VIEW, facebookUsernameUri))
}