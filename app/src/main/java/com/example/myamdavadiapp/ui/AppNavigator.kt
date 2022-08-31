package com.example.myamdavadiapp.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.myamdavadiapp.R

enum class AppScreens(@StringRes val title: Int) {
    Category(R.string.txt_categories),
    Recommendation(R.string.txt_recommendations),
    Detail(R.string.txt_details)
}

@Composable
fun MyCityAppBar(
    @StringRes currentScreenTitle: Int,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(stringResource(currentScreenTitle)) },
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        }
    )
}

@Composable
fun MyCityApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = AppScreens.valueOf(
        backStackEntry?.destination?.route ?: AppScreens.Category.name
    )
    val viewModel: CityViewModel = viewModel()

    Scaffold(

        topBar = {
            MyCityAppBar(
                currentScreenTitle = currentScreen.title,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        }
    ) { innerPadding ->

        val selectedCategoryId by viewModel.selectedCategoryId.collectAsState()
        val selectedOptionId by viewModel.selectedOptionId.collectAsState()

        NavHost(
            navController = navController,
            startDestination = AppScreens.Category.name,
            modifier = modifier.padding(innerPadding),
        ) {
            composable(route = AppScreens.Category.name) {
                CategoryListScreen {
                    viewModel.setCategoryId(it)
                    navController.navigate(AppScreens.Recommendation.name)
                }
            }

            composable(route = AppScreens.Recommendation.name) {
                RecommendationsListScreen(selectedCategoryId) {
                    viewModel.setOptionId(it)
                    navController.navigate(AppScreens.Detail.name)
                }
            }

            composable(route = AppScreens.Detail.name) {
                RecommendationDetailScreen(selectedOptionId)
            }
        }
    }
}