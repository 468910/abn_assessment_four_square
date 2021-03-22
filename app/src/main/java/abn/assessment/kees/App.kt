package abn.assessment.kees

import abn.assessment.kees.di.KoinStarter
import android.app.Application


class App : Application() {
    override fun onCreate() {
        super.onCreate()
        KoinStarter.start(applicationContext)
    }
}