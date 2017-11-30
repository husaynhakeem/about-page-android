package husaynhakeem.com.aboutpage

import android.graphics.drawable.ColorDrawable
import android.support.test.InstrumentationRegistry
import android.support.v4.content.ContextCompat
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import org.junit.Assert.*
import org.junit.Test

class AboutPageShould {

    private val context = InstrumentationRegistry.getTargetContext()

    private val ANY_ICON = android.R.drawable.btn_default
    private val ANY_COLOR = android.R.color.darker_gray
    private val ANY_TEXT_RESOURCE_ID = R.string.title_email
    private val ANY_TEXT = context.getString(R.string.title_email)
    private val ANY_TITLE = "a title";
    private val ANY_ID = 0

    @Test
    fun setBackgroundColor() {
        val view = AboutPage(context).setBackground(ANY_COLOR).create()

        val background = view.background
        assertTrue(background is ColorDrawable)

        val backgroundColor = (background as ColorDrawable).color
        assertEquals(ContextCompat.getColor(context, ANY_COLOR), backgroundColor)
    }

    @Test
    fun setDescriptionFromStringResourceId() {
        val view = AboutPage(context).setDescription(ANY_TEXT_RESOURCE_ID).create()

        val descriptionTextView = view.findViewById<TextView>(R.id.tv_description)

        assertNotNull(descriptionTextView)
        assertEquals(context.getString(ANY_TEXT_RESOURCE_ID), descriptionTextView.text)
    }

    @Test
    fun setDescriptionFromString() {
        val view = AboutPage(context).setDescription(context.getString(ANY_TEXT_RESOURCE_ID)).create()

        val descriptionTextView = view.findViewById<TextView>(R.id.tv_description)

        assertNotNull(descriptionTextView)
        assertEquals(context.getString(ANY_TEXT_RESOURCE_ID), descriptionTextView.text.toString())
    }

    @Test
    fun addItemFromView() {
        val view = AboutPage(context).addItem(anyView()).create()

        val titleTextView = view.findViewById<TextView>(ANY_ID)

        assertNotNull(titleTextView)
        assertEquals(ANY_TITLE, titleTextView.text)
    }

    @Test
    fun addItemFromItemInstance() {
        val view = AboutPage(context).addItem(anyItem()).create()

        val titleTextView = view.findViewById<TextView>(R.id.tv_item_title)
        val iconImageView = view.findViewById<ImageView>(R.id.iv_item_icon)

        assertNotNull(titleTextView)
        assertNotNull(iconImageView)
        assertEquals(ANY_TITLE, titleTextView.text)
    }

    @Test
    fun addItemsInTheRightOrder() {
        val view = AboutPage(context)
                .addItem(anyItem())
                .addItem(anyView())
                .addFacebook(ANY_TITLE, ANY_TEXT)
                .addTwitter(ANY_TITLE, ANY_TEXT)
                .addInstagram(ANY_TITLE, ANY_TEXT)
                .addWebsite(ANY_TITLE, ANY_TEXT)
                .addEmail(ANY_TITLE, ANY_TEXT)
                .addGithub(ANY_TITLE, ANY_TEXT)
                .addItem(anyItem())
                .create()

        val elementsGroup = view.findViewById<ViewGroup>(R.id.ll_elements)

        // 9 views were added, when a view is added a separator is also added
        assertEquals(9 * 2, elementsGroup.childCount)
    }

    private fun anyView(): View {
        val textView = TextView(context)
        textView.id = ANY_ID
        textView.text = ANY_TITLE
        return textView
    }

    private fun anyItem(): Item {
        return Item(ANY_TITLE, ANY_ICON)
    }
}
