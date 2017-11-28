package husaynhakeem.com.aboutpageexample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import husaynhakeem.com.aboutpage.AboutPage

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val rootView = AboutPage(this)
                .addEmail("husaynhakeem@gmail.com")
                .addFacebook("husaynhakeem")
                .addGithub("husaynhakeem")
                .addInstagram("husaynhakeem")
                .addPinterest("husaynhakeem")
                .addPlayStore("com.maketrumptweetseightagain")
                .addTwitter("husaynhakeem")
                .addWebsite("http://www.google.com")
                .addYoutube("Cyprien")
                .create()

        setContentView(rootView)
    }
}
