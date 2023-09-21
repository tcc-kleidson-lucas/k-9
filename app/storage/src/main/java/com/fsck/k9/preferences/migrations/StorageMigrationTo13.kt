package com.fsck.k9.preferences.migrations

import android.database.sqlite.SQLiteDatabase

/**
 * Rename `hideSpecialAccounts` to `showUnifiedInbox` (and invert value).
 */
class StorageMigrationTo13(
    private val db: SQLiteDatabase,
    private val migrationsHelper: StorageMigrationsHelper,
) {
    fun renameHideSpecialAccounts() {
        val hideSpecialAccounts = migrationsHelper.readValue(db, "hideSpecialAccounts")?.toBoolean() ?: false
        val showUnifiedInbox = !hideSpecialAccounts
        migrationsHelper.insertValue(db, "showUnifiedInbox", showUnifiedInbox.toString())
        migrationsHelper.writeValue(db, "hideSpecialAccounts", null)
    }
}
