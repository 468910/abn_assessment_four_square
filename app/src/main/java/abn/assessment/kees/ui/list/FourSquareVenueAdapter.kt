package abn.assessment.kees.ui.list

import abn.assessment.kees.databinding.ItemFoursquareVenueBinding
import abn.assessment.kees.domain.models.Venue
import abn.assessment.kees.ui.model.FourSquareVenueUIModel
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

class FourSquareVenueAdapter(val onVenueSelected: (id: String) -> Unit) : ListAdapter<FourSquareVenueUIModel, FourSquareVenueViewHolder>(diffUtil) {

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<FourSquareVenueUIModel>() {
            override fun areContentsTheSame(
                oldItem: FourSquareVenueUIModel,
                newItem: FourSquareVenueUIModel
            ): Boolean {
                return oldItem == newItem
            }

            override fun areItemsTheSame(
                oldItem: FourSquareVenueUIModel,
                newItem: FourSquareVenueUIModel
            ): Boolean {
                return oldItem === newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FourSquareVenueViewHolder {
        val binding = ItemFoursquareVenueBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FourSquareVenueViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FourSquareVenueViewHolder, position: Int) {
        holder.bind(getItem(position), onVenueSelected)
    }
}