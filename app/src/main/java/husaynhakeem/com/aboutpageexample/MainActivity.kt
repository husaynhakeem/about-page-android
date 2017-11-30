package husaynhakeem.com.aboutpageexample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import husaynhakeem.com.aboutpage.AboutPage
import husaynhakeem.com.aboutpage.Item

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(AboutPage(this)
                .setBackground(android.R.color.white)
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
