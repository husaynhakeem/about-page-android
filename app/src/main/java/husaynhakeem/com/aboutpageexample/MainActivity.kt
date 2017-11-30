package husaynhakeem.com.aboutpageexample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import husaynhakeem.com.aboutpage.AboutPage

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val headerTextView = TextView(this)
        headerTextView.text = "Contact us"

        val footerTextView = TextView(this)
        footerTextView.text = "Copyright stuff"

        val rootView = AboutPage(this)
                .setBackground(android.R.color.holo_green_light)
                .addItem(headerTextView)
                .addEmail("husaynhakeem@gmail.com")
                .addFacebook("husaynhakeem")
                .addGithub("husaynhakeem")
                .addInstagram("husaynhakeem")
                .addPinterest("husaynhakeem")
                .addPlayStore("com.maketrumptweetseightagain")
                .addTwitter("husaynhakeem")
                .addWebsite("http://www.google.com")
                .addYoutube("Cyprien")
                .addItem(footerTextView)
                .create()

        setContentView(rootView)
    }
}
