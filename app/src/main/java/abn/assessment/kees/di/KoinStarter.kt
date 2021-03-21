package abn.assessment.kees.di

import android.app.Application
import android.content.Context
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class KoinStarter {

    companion object {
        @JvmStatic
        fun start(context: Context) {
            if (context !is Application) throw IllegalStateException("Only pass application context when initialising Koin")
            startKoin {
                // use AndroidLogger as Koin Logger - default Level.INFO
                androidLogger()
                // use the Android context given there
                androidContext(context)
                // module list
                modules(
                    abnAssessmentModule
                )
            }
        }
    }
}


