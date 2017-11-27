package husaynhakeem.com.aboutpage

import android.content.Context
import android.support.annotation.DrawableRes
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.layout_item.view.*


fun addItem(layoutInflater: LayoutInflater, context: Context, elementsGroup: ViewGroup, @DrawableRes icon: Int, title: String): View {
    val itemView = viewFromItem(layoutInflater, context, icon, title)
    elementsGroup.addView(itemView)
    return itemView
}

fun viewFromItem(layoutInflater: LayoutInflater, context: Context, @DrawableRes icon: Int, title: String): View {
    val itemView = layoutInflater.inflate(R.layout.layout_item, null)
    itemView.iv_item_icon.setImageDrawable(ContextCompat.getDrawable(context, icon))
    itemView.tv_item_title.text = title
    return itemView
}