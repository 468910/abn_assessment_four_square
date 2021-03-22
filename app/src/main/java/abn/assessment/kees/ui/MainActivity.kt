package abn.assessment.kees.ui

import abn.assessment.kees.AbnAssessmentViewModel
import abn.assessment.kees.R
import abn.assessment.kees.data.api.FourSquareService
import abn.assessment.kees.databinding.ActivityMainBinding
import abn.assessment.kees.di.KoinStarter
import abn.assessment.kees.util.viewBinding
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val binding by viewBinding(ActivityMainBinding::inflate)
    private val nearbyMeViewModel: AbnAssessmentViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}