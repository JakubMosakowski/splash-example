package com.mosjak.snackbar.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.mosjak.snackbar.R

class MainActivity : AppCompatActivity() {

  //region Lifecycle

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    // Initialize navigation controller.
    initializeNavigationController()
  }

  //endregion

  //region Navigation Controller

  private var navigationController: NavController? = null

  private fun initializeNavigationController() {

    // Search for navigation host fragment.
    val host = supportFragmentManager
      .findFragmentById(R.id.navFragment) ?: return

    // Find nav controller.
    navigationController =
      (host as NavHostFragment).navController
  }

  //endregion
}
