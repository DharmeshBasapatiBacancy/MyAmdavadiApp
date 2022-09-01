package com.example.myamdavadiapp.ui

import android.util.Log
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
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
import com.example.myamdavadiapp.utils.AppContentType

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
fun MyCityApp(windowSize: WindowWidthSizeClass, modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = AppScreens.valueOf(
        backStackEntry?.destination?.route ?: AppScreens.Category.name
    )
    val viewModel: CityViewModel = viewModel()
    val contentType: AppContentType
    when (windowSize) {
        WindowWidthSizeClass.Compact -> {
            Log.d("TAG", "MyCityApp: Compact Screen")
            contentType = AppContentType.LIST_ONLY
        }
        WindowWidthSizeClass.Medium -> {
            Log.d("TAG", "MyCityApp: Medium Screen")
            contentType = AppContentType.LIST_ONLY
        }
        WindowWidthSizeClass.Expanded -> {
            Log.d("TAG", "MyCityApp: Expanded Screen")
            contentType = AppContentType.LIST_AND_DETAIL
        }
        else -> {
            Log.d("TAG", "MyCityApp: Else Screen")
            contentType = AppContentType.LIST_ONLY
        }
    }

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
                CategoryListScreen(contentType) {
                    viewModel.setCategoryId(it)
                    navController.navigate(AppScreens.Recommendation.name)
                }
            }

            composable(route = AppScreens.Recommendation.name) {
                if (contentType == AppContentType.LIST_AND_DETAIL) {
                    RecommendationListWithDetailScreen(
                        selectedCategoryId,
                        contentType,
                        1
                    ) {
                        viewModel.setOptionId(it)
                        navController.navigate(AppScreens.Detail.name)
                    }
                } else {
                    RecommendationsListScreen(selectedCategoryId, contentType) {
                        viewModel.setOptionId(it)
                        navController.navigate(AppScreens.Detail.name)
                    }
                }
            }

            composable(route = AppScreens.Detail.name) {
                if (contentType == AppContentType.LIST_AND_DETAIL) {
                    RecommendationListWithDetailScreen(
                        selectedCategoryId,
                        contentType,
                        selectedOptionId
                    ) {
                        viewModel.setOptionId(it)
                        navController.navigate(AppScreens.Detail.name)
                    }
                } else {
                    RecommendationDetailScreen(selectedOptionId, contentType)
                }
            }
        }
    }
}

@Composable
fun RecommendationListWithDetailScreen(
    selectedCategoryId: Int,
    contentType: AppContentType,
    selectedOptionId: Int,
    onListItemClicked: (Int) -> Unit
) {
    Row {
        Box(modifier = Modifier.weight(1f)) {
            RecommendationsListScreen(selectedCategoryId, contentType) { onListItemClicked(it) }
        }
        Box(modifier = Modifier.weight(1f)) {
            RecommendationDetailScreen(selectedOptionId, contentType)
        }
    }
}
