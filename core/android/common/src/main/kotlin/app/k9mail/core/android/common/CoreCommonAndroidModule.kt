package app.k9mail.core.android.common

import app.k9mail.core.android.common.contact.contactModule
import app.k9mail.core.common.coreCommonModule
import org.koin.core.module.Module
import org.koin.dsl.module

val coreCommonAndroidModule: Module = module {
    includes(coreCommonModule)

    includes(contactModule)
}
