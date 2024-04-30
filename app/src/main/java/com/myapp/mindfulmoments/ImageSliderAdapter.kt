import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.myapp.mindfulmoments.R

class ImageSliderAdapter(private val context: Context) : PagerAdapter() {

    private val images = intArrayOf(
        R.drawable.hone1,
        R.drawable.home2,
        R.drawable.home3,
        R.drawable.home4
    )

    override fun getCount(): Int {
        return images.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = LayoutInflater.from(context)
        val layout = inflater.inflate(R.layout.image_slider_item, container, false)

        val imageView = layout.findViewById<ImageView>(R.id.imageView)
        imageView.setImageResource(images[position])

        container.addView(layout)
        return layout
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}
