package com.mosjak.snackbar.presentation.common

import android.view.View
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import com.mosjak.snackbar.R

interface SnackbarTrait {

  //region View

  var snackbarTrait: View?

  val snackbarTraitViewId: Int
    get() = R.id.rootView

  //endregion

  //region Undo

  fun showUndoDeleteSnackbar(
    undoAction: () -> Unit,
    dismissedAction: () -> Unit) {
    Snackbar
      .make(requireNotNull(snackbarTrait), R.string.delete_snackbar,
        Snackbar.LENGTH_LONG)
      .setAction(R.string.undo) { undoAction.invoke() }
      .addCallback(object : BaseTransientBottomBar.BaseCallback<Snackbar>() {
        override fun onDismissed(transientBottomBar: Snackbar?, event: Int) {

          // Invoke dismiss action only after enough time pass.
          if (event == DISMISS_EVENT_TIMEOUT)
            dismissedAction.invoke()
          super.onDismissed(transientBottomBar, event)
        }
      })
      .show()
  }

  //endregion
}
