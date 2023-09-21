package com.fsck.k9

import android.view.ContextThemeWrapper
import androidx.lifecycle.LifecycleOwner
import androidx.work.WorkerParameters
import com.fsck.k9.job.MailSyncWorker
import com.fsck.k9.ui.R
import com.fsck.k9.ui.changelog.ChangeLogMode
import com.fsck.k9.ui.changelog.ChangelogViewModel
import com.fsck.k9.ui.endtoend.AutocryptKeyTransferActivity
import com.fsck.k9.ui.endtoend.AutocryptKeyTransferPresenter
import com.fsck.k9.ui.folders.FolderIconProvider
import com.fsck.k9.ui.folders.FolderNameFormatter
import com.fsck.k9.ui.helper.SizeFormatter
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.annotation.KoinInternalApi
import org.koin.core.logger.PrintLogger
import org.koin.core.parameter.parametersOf
import org.koin.java.KoinJavaComponent
import org.koin.test.AutoCloseKoinTest
import org.koin.test.check.checkModules
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.openintents.openpgp.OpenPgpApiManager
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(application = App::class)
class DependencyInjectionTest : AutoCloseKoinTest() {
    private val lifecycleOwner = mock<LifecycleOwner> {
        on { lifecycle } doReturn mock()
    }
    private val autocryptTransferView = mock<AutocryptKeyTransferActivity>()

    @KoinInternalApi
    @Test
    fun testDependencyTree() {
        KoinJavaComponent.getKoin().setupLogger(PrintLogger())

        getKoin().checkModules {
            withParameter<OpenPgpApiManager> { lifecycleOwner }
            withParameters<AutocryptKeyTransferPresenter> { parametersOf(lifecycleOwner, autocryptTransferView) }
            withParameter<FolderNameFormatter> { RuntimeEnvironment.getApplication() }
            withParameter<SizeFormatter> { RuntimeEnvironment.getApplication() }
            withParameter<ChangelogViewModel> { ChangeLogMode.CHANGE_LOG }
            withParameter<MailSyncWorker> { mock<WorkerParameters>() }
            withParameter<FolderIconProvider> {
                ContextThemeWrapper(RuntimeEnvironment.getApplication(), R.style.Theme_K9_DayNight).theme
            }
        }
    }
}
