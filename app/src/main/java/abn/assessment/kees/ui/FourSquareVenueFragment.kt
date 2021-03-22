package abn.assessment.kees.ui

import abn.assessment.kees.AbnAssessmentViewModel
import abn.assessment.kees.R
import abn.assessment.kees.databinding.FragmentFoursquareVenueBinding
import abn.assessment.kees.ui.list.FourSquareVenueAdapter
import abn.assessment.kees.ui.model.FourSquareVenueUIModel
import abn.assessment.kees.util.fragmentViewBinding
import abn.assessment.kees.util.observe
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.TextView.OnEditorActionListener
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class FourSquareVenueFragment : Fragment(R.layout.fragment_foursquare_venue) {

    private val binding by fragmentViewBinding(FragmentFoursquareVenueBinding::bind)
    private val abnAssessmentViewModel: AbnAssessmentViewModel by sharedViewModel()

    private val fsAdapter = FourSquareVenueAdapter(onVenueSelected = ::onVenueSelected)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindView()
        bindViewModel()
    }

    private fun bindView() {
        binding.fourSquareVenuesRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = fsAdapter
        }
        binding.searchField.setOnEditorActionListener(OnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                abnAssessmentViewModel.filter.value = binding.searchField.text.toString()
                return@OnEditorActionListener true
            }
            false
        })
    }

    private fun bindViewModel() {
        observe(abnAssessmentViewModel.venues) {
            updateUI(it)
        }
    }

    private fun updateUI(list: List<FourSquareVenueUIModel>) {
        fsAdapter.submitList(list)
    }

    private fun onVenueSelected(id: String) {
        abnAssessmentViewModel.selectedVenueId.value = id
        findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
    }

}