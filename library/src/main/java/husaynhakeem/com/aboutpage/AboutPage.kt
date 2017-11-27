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

    fun addEmail(title: String, email: String): AboutPage {
        val itemView = addItem(R.drawable.ic_email, title)
        itemView.setOnClickListener({ sendEmail(context, email) })
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
