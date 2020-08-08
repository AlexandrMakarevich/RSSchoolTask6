package by.a_makarevich.rsschooltask6

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.api.load

class TedAdapterXML : RecyclerView.Adapter<TedViewHolderXML>() {

    private val items = mutableListOf<TedObjectXML>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TedViewHolderXML {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item_xml, null)
        Log.d("MyLog", "onCreateViewHolder")
        return TedViewHolderXML(view)
    }
    override fun getItemCount(): Int {
        return items.size
    }
    override fun onBindViewHolder(holder: TedViewHolderXML, position: Int) {
        holder.textViewTitle?.text = items[position].title1?.substringAfter('|')
        holder.textViewDescription?.text = items[position].description
        holder.bind(items[position].itunes_image)
        holder.textViewDuration?.text = items[position].itunesDuration
        Log.d("MyLog", "onBindViewHolder")
    }
    fun addItems(newItems: List<TedObjectXML>) {
        items.addAll(newItems)
        notifyDataSetChanged()
    }
}
class TedViewHolderXML(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val textViewTitle: TextView? = itemView.findViewById(R.id.textViewTitleXML)
    val textViewDescription: TextView? = itemView.findViewById(R.id.textViewDescriptionXML)
    val imageView = itemView.findViewById<ImageView>(R.id.imageView_xml)
    val textViewDuration: TextView? = itemView.findViewById(R.id.textViewDuration_xml)

    fun bind(imageURL: String?) {
        imageView.load(imageURL)
    }
}