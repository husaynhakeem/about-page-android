package husaynhakeem.com.aboutpage

import android.content.Context
import android.support.annotation.DrawableRes
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.layout_item.view.*

class AboutPage(var context: Context) {

    var layoutInflater: LayoutInflater
    var view: View
    var elementsGroup: ViewGroup

    init {
        layoutInflater = LayoutInflater.from(context)
        view = layoutInflater.inflate(R.layout.about_page, null, false)
        elementsGroup = view.findViewById(R.id.ll_elements)
    }

    fun addEmail(email: String): AboutPage {
        return addEmail(context.getString(R.string.title_email), email)
    }

    fun addEmail(title: String, email: String): AboutPage {
        val itemView = addItem(R.drawable.ic_email, title)
        itemView.setOnClickListener({ sendEmail(context, email) })
        return this
    }

    fun addWebsite(websiteUrl: String): AboutPage {
        return addWebsite(context.getString(R.string.title_email), websiteUrl)
    }

    fun addWebsite(title: String, websiteUrl: String): AboutPage {
        val itemView = addItem(R.drawable.ic_website, title)
        itemView.setOnClickListener({ openWebPage(context, websiteUrl) })
        return this
    }

    fun addFacebook(facebookUsername: String): AboutPage {
        return addFacebook(context.getString(R.string.title_email), facebookUsername)
    }

    fun addFacebook(title: String, facebookUsername: String): AboutPage {
        val itemView = viewFromItem(R.drawable.ic_facebook, title)
        itemView.setOnClickListener({ openFacebookPage(context, facebookUsername) })
        return this
    }

    fun addTwitter(twitterId: String): AboutPage {
        return addTwitter(context.getString(R.string.title_email), twitterId)
    }

    fun addTwitter(title: String, twitterId: String): AboutPage {
        val itemView = viewFromItem(R.drawable.ic_twitter, title)
        itemView.setOnClickListener({ openTwitter(context, twitterId) })
        return this
    }

    fun addYoutube(youtubeChannel: String): AboutPage {
        return addYoutube(context.getString(R.string.title_email), youtubeChannel)
    }

    fun addYoutube(title: String, youtubeChannel: String): AboutPage {
        val itemView = viewFromItem(R.drawable.ic_youtube, title)
        itemView.setOnClickListener({ openYoutube(context, youtubeChannel) })
        return this
    }

    fun addPlayStore(playStoreId: String): AboutPage {
        return addPlayStore(context.getString(R.string.title_email), playStoreId)
    }

    fun addPlayStore(title: String, playStoreId: String): AboutPage {
        val itemView = viewFromItem(R.drawable.ic_playsotre, title)
        itemView.setOnClickListener({ openPlayStore(context, playStoreId) })
        return this
    }

    fun addInstagram(userId: String): AboutPage {
        return addInstagram(context.getString(R.string.title_email), userId)
    }

    fun addInstagram(title: String, userId: String): AboutPage {
        val itemView = viewFromItem(R.drawable.ic_instagram, title)
        itemView.setOnClickListener({ openInstagram(context, userId) })
        return this
    }

    fun addGithub(userId: String): AboutPage {
        return addGithub(context.getString(R.string.title_email), userId)
    }

    fun addGithub(title: String, userId: String): AboutPage {
        val itemView = viewFromItem(R.drawable.ic_github, title)
        itemView.setOnClickListener({ openGithub(context, userId) })
        return this
    }

    fun addPinterest(userId: String): AboutPage {
        return addPinterest(context.getString(R.string.title_email), userId)
    }

    fun addPinterest(title: String, userId: String): AboutPage {
        val itemView = viewFromItem(R.drawable.ic_pinterest, title)
        itemView.setOnClickListener({ openPinterest(context, userId) })
        return this
    }

    private fun addItem(@DrawableRes icon: Int, title: String): View {
        val itemView = viewFromItem(icon, title)
        elementsGroup.addView(itemView)
        return itemView
    }

    private fun viewFromItem(@DrawableRes icon: Int, title: String): View {
        val itemView = layoutInflater.inflate(R.layout.layout_item, null)
        itemView.iv_item_icon.setImageDrawable(ContextCompat.getDrawable(context, icon))
        itemView.tv_item_title.text = title
        return itemView
    }
}
