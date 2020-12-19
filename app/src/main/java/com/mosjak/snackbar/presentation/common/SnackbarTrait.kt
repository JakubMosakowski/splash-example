package com.mosjak.snackbar.presentation.common

import android.view.View
import com.mosjak.snackbar.R

interface SnackbarTrait {

  //region View

  var snackbarTrait: View?

  val snackbarTraitViewId: Int
    get() = R.id.rootView

  //endregion

  //region Long

  //endregion
}
