package co.rita.handspeak.gesture.fragment

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import co.rita.handspeak.databinding.ItemGestureRecognizerResultBinding
import co.rita.handspeak.gesture.GestureResource
import java.util.*


class GestureRecognizerResultsAdapter :
    RecyclerView.Adapter<GestureRecognizerResultsAdapter.ViewHolder>() {

    private var adapterCategories: MutableList<GestureResource> = mutableListOf()
    private var adapterSize: Int = 0
    private var currentPosition: Int = 0

    @SuppressLint("NotifyDataSetChanged")
    fun updateResults(categories: List<GestureResource>) {
        adapterCategories.clear()
        adapterCategories.addAll(categories)
        adapterSize = categories.size
        currentPosition = 0
        notifyDataSetChanged()
    }

    fun updateAdapterSize(size: Int) {
        adapterSize = size
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding = ItemGestureRecognizerResultBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        adapterCategories[position].let { gestureRes ->
            holder.ivGesture1.setImageResource(gestureRes.letterImg)
            holder.ivGesture2.setImageResource(gestureRes.gestureImg)
            holder.ivGesture2.visibility = View.VISIBLE
        }
    }

    override fun getItemCount(): Int = adapterCategories.size

    // ADICIONADO
    inner class ViewHolder(private val binding: ItemGestureRecognizerResultBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val ivGesture1: ImageView = binding.ivGesture1
        val ivGesture2: ImageView = binding.ivGesture2
    }
}
