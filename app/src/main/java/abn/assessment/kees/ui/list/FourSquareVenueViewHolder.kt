package abn.assessment.kees.ui.list

import abn.assessment.kees.databinding.ItemFoursquareVenueBinding
import abn.assessment.kees.domain.models.Venue
import abn.assessment.kees.ui.model.FourSquareVenueUIModel
import androidx.recyclerview.widget.RecyclerView

class FourSquareVenueViewHolder(val binding: ItemFoursquareVenueBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(venue: FourSquareVenueUIModel, onVenueSelected: (id: String) -> Unit) {
        with(binding){
            venueTitle.text = venue.name
            venueLocation.text = venue.location
        }

        itemView.setOnClickListener {
            onVenueSelected(venue.id)
        }
    }
}