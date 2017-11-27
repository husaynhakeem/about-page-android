package husaynhakeem.com.aboutpage

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log

private val TAG = "About Page"

fun sendEmail(context: Context, emailAddress: String) {
    val emailIntent = Intent(Intent.ACTION_SENDTO)
    emailIntent.setData(Uri.parse("mailto:" + emailAddress))
    try {
        context.startActivity(emailIntent)
    } catch (e: ActivityNotFoundException) {
        Log.e(TAG, "No available application found to handle email sending")
    }
}