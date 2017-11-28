package husaynhakeem.com.aboutpage

import android.content.Context
import android.support.annotation.DrawableRes
import android.support.annotation.StringRes
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.about_page.view.*

class AboutPage(var context: Context) {

    var layoutInflater: LayoutInflater
    var rootView: View
    var elementsGroup: ViewGroup

    init {
        layoutInflater = LayoutInflater.from(context)
        rootView = layoutInflater.inflate(R.layout.about_page, null, false)
        elementsGroup = rootView.findViewById(R.id.ll_elements)
    }

    fun setImage(@DrawableRes logoResId: Int): AboutPage {
        rootView.iv_logo.setImageDrawable(ContextCompat.getDrawable(context, logoResId))
        return this
    }

    fun setDescription(@StringRes stringResId: Int): AboutPage {
        return setDescription(context.getString(stringResId))
    }

    fun setDescription(text: String): AboutPage {
        rootView.tv_description.text = text
        return this
    }

    fun addEmail(email: String): AboutPage {
        return addEmail(context.getString(R.string.title_email), email)
    }

    fun addEmail(title: String, email: String): AboutPage {
        val itemView = addItem(layoutInflater, context, elementsGroup, R.drawable.ic_email, title)
        itemView.setOnClickListener({ sendEmail(context, email) })
        return this
    }

    fun addWebsite(websiteUrl: String): AboutPage {
        return addWebsite(context.getString(R.string.title_email), websiteUrl)
    }

    fun addWebsite(title: String, websiteUrl: String): AboutPage {
        val itemView = addItem(layoutInflater, context, elementsGroup, R.drawable.ic_website, title)
        itemView.setOnClickListener({ openWebPage(context, websiteUrl) })
        return this
    }

    fun addFacebook(facebookUsername: String): AboutPage {
        return addFacebook(context.getString(R.string.title_email), facebookUsername)
    }

    fun addFacebook(title: String, facebookUsername: String): AboutPage {
        val itemView = addItem(layoutInflater, context, elementsGroup, R.drawable.ic_facebook, title)
        itemView.setOnClickListener({ openFacebookPage(context, facebookUsername) })
        return this
    }

    fun addTwitter(twitterId: String): AboutPage {
        return addTwitter(context.getString(R.string.title_email), twitterId)
    }

    fun addTwitter(title: String, twitterId: String): AboutPage {
        val itemView = addItem(layoutInflater, context, elementsGroup, R.drawable.ic_twitter, title)
        itemView.setOnClickListener({ openTwitter(context, twitterId) })
        return this
    }

    fun addYoutube(youtubeChannel: String): AboutPage {
        return addYoutube(context.getString(R.string.title_email), youtubeChannel)
    }

    fun addYoutube(title: String, youtubeChannel: String): AboutPage {
        val itemView = addItem(layoutInflater, context, elementsGroup, R.drawable.ic_youtube, title)
        itemView.setOnClickListener({ openYoutube(context, youtubeChannel) })
        return this
    }

    fun addPlayStore(playStoreId: String): AboutPage {
        return addPlayStore(context.getString(R.string.title_email), playStoreId)
    }

    fun addPlayStore(title: String, playStoreId: String): AboutPage {
        val itemView = addItem(layoutInflater, context, elementsGroup, R.drawable.ic_playsotre, title)
        itemView.setOnClickListener({ openPlayStore(context, playStoreId) })
        return this
    }

    fun addInstagram(userId: String): AboutPage {
        return addInstagram(context.getString(R.string.title_email), userId)
    }

    fun addInstagram(title: String, userId: String): AboutPage {
        val itemView = addItem(layoutInflater, context, elementsGroup, R.drawable.ic_instagram, title)
        itemView.setOnClickListener({ openInstagram(context, userId) })
        return this
    }

    fun addGithub(userId: String): AboutPage {
        return addGithub(context.getString(R.string.title_email), userId)
    }

    fun addGithub(title: String, userId: String): AboutPage {
        val itemView = addItem(layoutInflater, context, elementsGroup, R.drawable.ic_github, title)
        itemView.setOnClickListener({ openGithub(context, userId) })
        return this
    }

    fun addPinterest(userId: String): AboutPage {
        return addPinterest(context.getString(R.string.title_email), userId)
    }

    fun addPinterest(title: String, userId: String): AboutPage {
        val itemView = addItem(layoutInflater, context, elementsGroup, R.drawable.ic_pinterest, title)
        itemView.setOnClickListener({ openPinterest(context, userId) })
        return this
    }
}
