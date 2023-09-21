package com.fsck.k9.ui.messagelist

import android.content.res.Resources.Theme
import android.graphics.drawable.Drawable
import androidx.annotation.AttrRes
import com.fsck.k9.SwipeAction
import com.fsck.k9.ui.R
import com.fsck.k9.ui.resolveColorAttribute
import com.fsck.k9.ui.resolveDrawableAttribute

class SwipeResourceProvider(val theme: Theme) {
    val iconTint = theme.resolveColorAttribute(R.attr.messageListSwipeIconTint)

    private val selectIcon = theme.loadDrawable(R.attr.messageListSwipeSelectIcon)
    private val markAsReadIcon = theme.loadDrawable(R.attr.messageListSwipeMarkAsReadIcon)
    private val markAsUnreadIcon = theme.loadDrawable(R.attr.messageListSwipeMarkAsUnreadIcon)
    private val addStarIcon = theme.loadDrawable(R.attr.messageListSwipeAddStarIcon)
    private val removeStarIcon = theme.loadDrawable(R.attr.messageListSwipeRemoveStarIcon)
    private val archiveIcon = theme.loadDrawable(R.attr.messageListSwipeArchiveIcon)
    private val deleteIcon = theme.loadDrawable(R.attr.messageListSwipeDeleteIcon)
    private val spamIcon = theme.loadDrawable(R.attr.messageListSwipeSpamIcon)
    private val moveIcon = theme.loadDrawable(R.attr.messageListSwipeMoveIcon)

    private val noActionColor = theme.resolveColorAttribute(R.attr.messageListSwipeDisabledBackgroundColor)
    private val selectColor = theme.resolveColorAttribute(R.attr.messageListSwipeSelectBackgroundColor)
    private val toggleReadColor = theme.resolveColorAttribute(R.attr.messageListSwipeToggleReadBackgroundColor)
    private val toggleStarColor = theme.resolveColorAttribute(R.attr.messageListSwipeToggleStarBackgroundColor)
    private val archiveColor = theme.resolveColorAttribute(R.attr.messageListSwipeArchiveBackgroundColor)
    private val deleteColor = theme.resolveColorAttribute(R.attr.messageListSwipeDeleteBackgroundColor)
    private val spamColor = theme.resolveColorAttribute(R.attr.messageListSwipeSpamBackgroundColor)
    private val moveColor = theme.resolveColorAttribute(R.attr.messageListSwipeMoveBackgroundColor)

    private val selectText = theme.resources.getString(R.string.swipe_action_select)
    private val deselectText = theme.resources.getString(R.string.swipe_action_deselect)
    private val markAsReadText = theme.resources.getString(R.string.swipe_action_mark_as_read)
    private val markAsUnreadText = theme.resources.getString(R.string.swipe_action_mark_as_unread)
    private val addStarText = theme.resources.getString(R.string.swipe_action_add_star)
    private val removeStarText = theme.resources.getString(R.string.swipe_action_remove_star)
    private val archiveText = theme.resources.getString(R.string.swipe_action_archive)
    private val deleteText = theme.resources.getString(R.string.swipe_action_delete)
    private val spamText = theme.resources.getString(R.string.swipe_action_spam)
    private val moveText = theme.resources.getString(R.string.swipe_action_move)

    fun getIcon(item: MessageListItem, action: SwipeAction): Drawable {
        return when (action) {
            SwipeAction.None -> error("action == SwipeAction.None")
            SwipeAction.ToggleSelection -> selectIcon
            SwipeAction.ToggleRead -> if (item.isRead) markAsUnreadIcon else markAsReadIcon
            SwipeAction.ToggleStar -> if (item.isStarred) removeStarIcon else addStarIcon
            SwipeAction.Archive -> archiveIcon
            SwipeAction.Delete -> deleteIcon
            SwipeAction.Spam -> spamIcon
            SwipeAction.Move -> moveIcon
        }
    }

    fun getBackgroundColor(action: SwipeAction): Int {
        return when (action) {
            SwipeAction.None -> noActionColor
            SwipeAction.ToggleSelection -> selectColor
            SwipeAction.ToggleRead -> toggleReadColor
            SwipeAction.ToggleStar -> toggleStarColor
            SwipeAction.Archive -> archiveColor
            SwipeAction.Delete -> deleteColor
            SwipeAction.Spam -> spamColor
            SwipeAction.Move -> moveColor
        }
    }

    fun getActionName(item: MessageListItem, action: SwipeAction, isSelected: Boolean): String {
        return when (action) {
            SwipeAction.None -> error("action == SwipeAction.None")
            SwipeAction.ToggleSelection -> if (isSelected) deselectText else selectText
            SwipeAction.ToggleRead -> if (item.isRead) markAsUnreadText else markAsReadText
            SwipeAction.ToggleStar -> if (item.isStarred) removeStarText else addStarText
            SwipeAction.Archive -> archiveText
            SwipeAction.Delete -> deleteText
            SwipeAction.Spam -> spamText
            SwipeAction.Move -> moveText
        }
    }
}

private fun Theme.loadDrawable(@AttrRes attributeId: Int): Drawable {
    return resolveDrawableAttribute(attributeId).mutate()
}
