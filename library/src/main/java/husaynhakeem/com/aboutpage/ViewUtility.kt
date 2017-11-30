package husaynhakeem.com.aboutpage

import android.content.Context
import android.content.res.Resources
import android.support.annotation.ColorRes
import android.support.annotation.DrawableRes
import android.support.v4.content.ContextCompat
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.layout_item.view.*

private val TAG = "About Page"
private val RESOURCE_TYPE_DRAWABLE = "drawable"
private val RESOURCE_TYPE_COLOR = "color"

fun addItem(layoutInflater: LayoutInflater, context: Context, elementsGroup: ViewGroup, @DrawableRes icon: Int, @ColorRes iconTint: Int, title: String): View {
    val itemView = viewFromItem(layoutInflater, context, icon, iconTint, title)
    elementsGroup.addView(itemView)
    addSeparator(layoutInflater, context, elementsGroup)
    return itemView
}

fun addItem(layoutInflater: LayoutInflater, context: Context, elementsGroup: ViewGroup, view: View) {
    elementsGroup.addView(view)
    addSeparator(layoutInflater, context, elementsGroup)
}

fun addItem(layoutInflater: LayoutInflater, context: Context, elementsGroup: ViewGroup, item: Item) {
    val itemView = layoutInflater.inflate(R.layout.layout_item, null)
    itemView.tv_item_title.text = item.title
    when (item.icon) {
        null -> itemView.iv_item_icon.visibility = View.GONE
        else -> itemView.iv_item_icon.setImageDrawable(ContextCompat.getDrawable(context, item.icon))
    }
    itemView.setOnClickListener(item.onClickListener)
    addItem(layoutInflater, context, elementsGroup, itemView)
}

fun viewFromItem(layoutInflater: LayoutInflater, context: Context, @DrawableRes icon: Int, @ColorRes iconTint: Int, title: String): View {
    val itemView = layoutInflater.inflate(R.layout.layout_item, null)
    itemView.iv_item_icon.setImageDrawable(ContextCompat.getDrawable(context, icon))
    itemView.iv_item_icon.setColorFilter(ContextCompat.getColor(context, iconTint), android.graphics.PorterDuff.Mode.SRC_IN);
    itemView.tv_item_title.text = title
    return itemView
}

fun addSeparator(layoutInflater: LayoutInflater, context: Context, elementsGroup: ViewGroup) {
    elementsGroup.addView(layoutInflater.inflate(R.layout.layout_separator, null), ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, context.resources.getDimensionPixelSize(R.dimen.separator_height)))
}

fun setViewBackground(context: Context, view: View, background: Int) {
    try {
        val backgroundType: String = context.resources.getResourceTypeName(background)
        when (backgroundType) {
            RESOURCE_TYPE_DRAWABLE -> view.background = ContextCompat.getDrawable(context, background)
            RESOURCE_TYPE_COLOR -> view.setBackgroundColor(ContextCompat.getColor(context, background))
            else -> throw Resources.NotFoundException("Background resource must be a drawable or color")
        }
    } catch (e: Resources.NotFoundException) {
        Log.e(TAG, e.message)
    }
}
