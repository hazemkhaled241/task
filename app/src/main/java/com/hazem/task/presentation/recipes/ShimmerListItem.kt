package com.hazem.task.presentation.recipes

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.IntSize
import com.hazem.task.presentation.ui.theme.CORNER_SHAPE_SIZE
import com.hazem.task.presentation.ui.theme.HIGH_HEIGHT
import com.hazem.task.presentation.ui.theme.LARGE_SIZE
import com.hazem.task.presentation.ui.theme.MEDIUM_SIZE
import com.hazem.task.presentation.ui.theme.RECIPE_CALORIES_SIZE
import com.hazem.task.presentation.ui.theme.RECIPE_FATS_SIZE
import com.hazem.task.presentation.ui.theme.RECIPE_NAME_SIZE
import com.hazem.task.presentation.ui.theme.SMALL_HEIGHT
import com.hazem.task.presentation.ui.theme.SMALL_PADDING

@Composable
fun ShimmerListItem(
    modifier: Modifier = Modifier
) {
    LazyColumn(contentPadding = PaddingValues( start = MEDIUM_SIZE, end = MEDIUM_SIZE, bottom = SMALL_PADDING)) {
        items(10){
        Row(modifier = modifier) {
            Spacer(modifier = Modifier.height(MEDIUM_SIZE))

            Box(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .size(LARGE_SIZE)
                    .clip(CircleShape)
                    .shimmerEffect()

                ,
            )
            Spacer(modifier = Modifier.width(MEDIUM_SIZE))
            Column(
                modifier = Modifier.weight(1f).align(Alignment.CenterVertically)
                    .padding(top = MEDIUM_SIZE)
            ) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(CORNER_SHAPE_SIZE))
                        .width(RECIPE_NAME_SIZE)
                        .height(HIGH_HEIGHT)
                        .shimmerEffect()
                )
                Spacer(modifier = Modifier.height(SMALL_HEIGHT))
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(CORNER_SHAPE_SIZE))
                        .width(RECIPE_FATS_SIZE)
                        .height(MEDIUM_SIZE)
                        .shimmerEffect()
                )
                Spacer(modifier = Modifier.height(SMALL_HEIGHT))
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(CORNER_SHAPE_SIZE))
                        .width(RECIPE_FATS_SIZE)
                        .height(MEDIUM_SIZE)
                        .shimmerEffect()
                )
                Spacer(modifier = Modifier.height(SMALL_HEIGHT))
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(CORNER_SHAPE_SIZE))
                        .width(RECIPE_CALORIES_SIZE)
                        .height(MEDIUM_SIZE)
                        .shimmerEffect()
                )
                Spacer(modifier = Modifier.height(MEDIUM_SIZE))


            }
        }
    }
}
}
fun Modifier.shimmerEffect(): Modifier = composed {
    var size by remember {
        mutableStateOf(IntSize.Zero)
    }
    val transition = rememberInfiniteTransition(label = "")
    val startOffsetX by transition.animateFloat(
        initialValue = -2 * size.width.toFloat(),
        targetValue = 2 * size.width.toFloat(),
        animationSpec = infiniteRepeatable(
            animation = tween(1000)
        ), label = ""
    )

    background(
        brush = Brush.linearGradient(
            colors = listOf(
                Color(0xFFB8B5B5),
                Color(0xFF8F8B8B),
                Color(0xFFB8B5B5),
            ),
            start = Offset(startOffsetX, 0f),
            end = Offset(startOffsetX + size.width.toFloat(), size.height.toFloat())
        )
    )
        .onGloballyPositioned {
            size = it.size
        }
}