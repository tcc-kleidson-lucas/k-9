package com.fsck.k9.widget.list

import app.k9mail.ui.widget.list.MessageListWidgetConfig
import org.koin.dsl.module

val messageListWidgetConfigModule = module {
    single<MessageListWidgetConfig> { K9MessageListWidgetConfig() }
}
