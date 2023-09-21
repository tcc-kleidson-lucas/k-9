package com.fsck.k9.mail.store.imap

import com.fsck.k9.mail.MessagingException
import com.fsck.k9.mail.ServerSettings
import com.fsck.k9.mail.oauth.OAuth2TokenProvider
import com.fsck.k9.mail.ssl.TrustedSocketFactory

interface ImapStore {
    @Throws(MessagingException::class)
    fun checkSettings()

    fun getFolder(name: String): ImapFolder

    @Throws(MessagingException::class)
    fun getFolders(): List<FolderListItem>

    fun closeAllConnections()

    companion object {
        fun create(
            serverSettings: ServerSettings,
            config: ImapStoreConfig,
            trustedSocketFactory: TrustedSocketFactory,
            oauthTokenProvider: OAuth2TokenProvider?,
        ): ImapStore {
            return RealImapStore(serverSettings, config, trustedSocketFactory, oauthTokenProvider)
        }
    }
}
