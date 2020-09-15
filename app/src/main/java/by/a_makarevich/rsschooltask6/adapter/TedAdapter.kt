package by.a_makarevich.rsschooltask6

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.api.load

class TedAdapter : RecyclerView.Adapter<TedViewHolder>() {

    private var items = listOf<TedObject>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TedViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, null)
        Log.d("MyLog", "onCreateViewHolder")
        return TedViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: TedViewHolder, position: Int) {
        holder.textViewTitle?.text = items[position].title?.substringAfter('|')
        holder.textViewDescription?.text = items[position].description
        holder.bind(items[position].url)
        holder.textViewDuration?.text = items[position].text
        Log.d("MyLog", "onBindViewHolder")
    }
    fun setItems(newItems: List<TedObject>) {
        items = newItems
        notifyDataSetChanged()
    }
}
class TedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val textViewTitle: TextView? = itemView.findViewById(R.id.textViewTitle)
    val textViewDescription: TextView? = itemView.findViewById(R.id.textViewDescription)
    val imageView = itemView.findViewById<ImageView>(R.id.imageView)
    val textViewDuration: TextView? = itemView.findViewById(R.id.textViewDuration)

    fun bind(imageURL: String?) {
        imageView.load(imageURL)
    }
}