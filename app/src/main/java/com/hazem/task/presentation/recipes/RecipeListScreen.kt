package com.hazem.task.presentation.recipes

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.hazem.task.presentation.recipes.view_model.RecipesViewModel
import com.hazem.task.presentation.ui.theme.MEDIUM_SIZE
import com.hazem.task.presentation.ui.theme.SMALL_PADDING
import org.koin.androidx.compose.koinViewModel

@Composable
fun RecipeListScreen(
    recipesViewModel: RecipesViewModel = koinViewModel()
) {
    val stateValue = recipesViewModel.state.value
    val recipes=stateValue.recipes
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn (contentPadding = PaddingValues( start = MEDIUM_SIZE, end = MEDIUM_SIZE, bottom = SMALL_PADDING)){
            items(recipes.size) { index ->
                RecipeItem(
                    image = recipes[index].image,
                    name =recipes[index].name,
                    fats =recipes[index].fats,
                    carb =recipes[index].carbos,
                    calories =recipes[index].calories
                )
            }
        }
        if (stateValue.errorMessage.isNotBlank()) {
            Text(
                text = stateValue.errorMessage,
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = MEDIUM_SIZE)
                    .align(Alignment.Center)
            )
        }
        if (stateValue.isLoading) {
           ShimmerListItem(Modifier.fillMaxSize())
        }
    }
}