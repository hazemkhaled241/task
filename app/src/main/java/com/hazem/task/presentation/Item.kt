package com.hazem.task.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hazem.task.R
import com.hazem.task.presentation.ui.theme.LARGE_SIZE
import com.hazem.task.presentation.ui.theme.SMALL_PADDING

@Composable
fun CategoryItem(
    title: String,
    description: String,
    owner: String,
    dateOfCreate: String,
    dateOfUpdate: String,
) {
    val localDensity = LocalDensity.current
    var titleWidthDp by remember {
        mutableStateOf(0.dp)
    }
    var descriptionWidth by remember {
        mutableStateOf((-20).dp)
    }

    Card(
        modifier = Modifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(SMALL_PADDING)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "",
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .size(100.dp)


            )
            Spacer(modifier = Modifier.size(15.dp))
            Column(
                modifier = Modifier

                    .onGloballyPositioned { coordinates ->
                        // Set column height using the LayoutCoordinates
                    }
            ) {
                Text(
                    modifier = Modifier.onGloballyPositioned { coordinates ->
                        // Set column height using the LayoutCoordinates
                        titleWidthDp = with(localDensity) { coordinates.size.width.toDp() }
                        descriptionWidth += titleWidthDp
                    },
                    text = "Double Cheese", style = TextStyle(
                        fontSize = 20.sp,
                        color = Color.Black,
                    ), maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
//                Text(
//                    modifier = Modifier.width(descriptionWidth),
//                    text = "jhgjhgjhgjfgdgdddddddddddd...",
//                    style = TextStyle(color = Color.Gray, fontSize = 15.sp),
//                    overflow = TextOverflow.Ellipsis,
//                    maxLines = 1
//
//                )
               // Spacer(modifier = Modifier.height(20.dp))
                Text(
                    modifier = Modifier,
                    text = "Created : 16/5/2024 09:25 AM",
                    style = TextStyle(color = Color.Gray, fontSize = 15.sp)
                )
                Text(
                    text = "Updated : 16/5/2024 09:25 AM",
                    style = TextStyle(color = Color.Gray, fontSize = 15.sp)
                )
                Row (horizontalArrangement = Arrangement.End,modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Min).padding(top=12.dp)){

                    Icon(imageVector = Icons.Default.Person, contentDescription = "")
                    Text(
                        modifier = Modifier.align(Alignment.CenterVertically),
                        text = "Kamel",
                        style = TextStyle(color = Color.Black, fontSize = 15.sp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RecipeItemPreview() {
    CategoryItem(
        title = "",
        description = "",
        dateOfCreate = "",
        dateOfUpdate = "",
        owner = ""
    )
}
