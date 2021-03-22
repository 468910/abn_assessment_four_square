package abn.assessment.kees.ui

import abn.assessment.kees.AbnAssessmentViewModel
import abn.assessment.kees.R
import abn.assessment.kees.data.room.VenueRoomModel.Companion.mapFrom
import abn.assessment.kees.databinding.FragmentFoursquareVenueDetailBinding
import abn.assessment.kees.domain.models.Venue
import abn.assessment.kees.ui.model.FourSquareVenueDetailUIModel
import abn.assessment.kees.ui.model.FourSquareVenueUIModel
import abn.assessment.kees.ui.model.FourSquareVenueUIModel.Companion.map
import abn.assessment.kees.util.fragmentViewBinding
import abn.assessment.kees.util.observe
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class FourSquareVenueDetailFragment : Fragment(R.layout.fragment_foursquare_venue_detail) {

    private val binding by fragmentViewBinding(FragmentFoursquareVenueDetailBinding::bind)

    private val abnAssessmentViewModel: AbnAssessmentViewModel by sharedViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindViewModel()
    }

    private fun bindViewModel() {
        observe(abnAssessmentViewModel.venue) {
            updateUI(FourSquareVenueDetailUIModel.map(it))
        }
    }

    private fun updateUI(uiModel: FourSquareVenueDetailUIModel) {
        binding.venueName.text = uiModel.titleAndRating
        binding.phoneNumberLabel.text = uiModel.phoneNumber
        binding.venueAddress.text = uiModel.address
    }
}