package com.hazem.task.presentation.recipes

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.rememberAsyncImagePainter
import com.hazem.task.R
import com.hazem.task.presentation.ui.theme.CARD_BORDER
import com.hazem.task.presentation.ui.theme.LARGE_SIZE
import com.hazem.task.presentation.ui.theme.MEDIUM_FONT_SIZE
import com.hazem.task.presentation.ui.theme.MEDIUM_SIZE
import com.hazem.task.presentation.ui.theme.RECIPE_NAME_FONT_SIZE
import com.hazem.task.presentation.ui.theme.RECIPE_NAME_SIZE
import com.hazem.task.presentation.ui.theme.SMALL_PADDING

@Composable
fun RecipeItem(
    image: String?,
    name: String?,
    fats: String?,
    carb: String?,
    calories: String?,
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = SMALL_PADDING),
        border = BorderStroke(CARD_BORDER, Color.Black),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(SMALL_PADDING)
        ) {
            Image(
                painter = rememberAsyncImagePainter(image),
                contentDescription = stringResource(R.string.recipe_image),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .size(LARGE_SIZE)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.size(MEDIUM_SIZE))
            Column {
                Text(
                    modifier = Modifier.width(RECIPE_NAME_SIZE),
                    text = name ?: stringResource(R.string.not_found), style = TextStyle(
                        fontSize = RECIPE_NAME_FONT_SIZE,
                        color = Color.Black,
                        fontFamily = FontFamily(Font(R.font.courgette_regular))
                    ),maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = "Fats : $fats",
                    style = TextStyle(color = Color.Black, fontSize = MEDIUM_FONT_SIZE)
                )
                Text(
                    text = "Carb : $carb",
                    style = TextStyle(color = Color.Black, fontSize = MEDIUM_FONT_SIZE)
                )
                Text(
                    text = "Calories : $calories",
                    style = TextStyle(color = Color.Black, fontSize = MEDIUM_FONT_SIZE)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RecipeItemPreview() {
    RecipeItem(
        image = "",
        name = "Crispy Fish Goujons",
        fats = "8 g",
        carb = "47 g",
        calories = "516 kcal"
    )
}