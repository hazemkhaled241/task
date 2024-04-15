package com.hazem.task.presentation
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.input.pointer.PointerInputChange
import androidx.compose.ui.input.pointer.pointerInput

@Composable
fun GanttChart() {

        val gridState = GridState()

        Canvas(
            modifier = Modifier
                .fillMaxSize()
                .pointerInput(Unit) {
                    detectDragGestures { change, _ ->
                        handleDrag(
                            gridState,
                            change,
                            Size(width = size.width.toFloat(), height = size.height.toFloat())
                        )
                    }
                }
        ) {
            gridState.drawGrid(this, verticalSpacing = size.width / gridState.numVerticalLines, horizontalSpacing = size.height / gridState.numHorizontalLines)
        }

}

class GridState {
    var numHorizontalLines = 10
    var numVerticalLines = 10

    // Create a 2D array to store the color information for each grid square
    var gridColors = mutableStateOf(Array(numHorizontalLines) { Array(numVerticalLines) { Color.Transparent } })

    fun drawGrid(drawScope: DrawScope, verticalSpacing: Float, horizontalSpacing: Float) {
        val gridColor = Color.Black
        val strokeWidth = 2f

        val startX = 0f
        val endX = drawScope.size.width
        val startY = 0f
        val endY = drawScope.size.height

        // Draw horizontal grid lines
        for (i in 0 until numHorizontalLines) {
            val y = i * horizontalSpacing
            drawScope.drawLine(
                color = gridColor,
                start = Offset(startX, y),
                end = Offset(endX, y),
                strokeWidth = strokeWidth
            )
        }

        // Draw vertical grid lines
        for (i in 0 until numVerticalLines) {
            val x = i * verticalSpacing
            drawScope.drawLine(
                color = gridColor,
                start = Offset(x, startY),
                end = Offset(x, endY),
                strokeWidth = strokeWidth
            )
        }

        // Fill each grid square with its corresponding color
        for (row in 0 until numHorizontalLines) {
            for (col in 0 until numVerticalLines) {
                drawScope.drawRect(
                    color = gridColors.value[row][col],
                    topLeft = Offset(col * verticalSpacing, row * horizontalSpacing),
                    size = Size(verticalSpacing, horizontalSpacing)
                )
            }
        }
    }

    fun update() {
        gridColors.value = gridColors.value.copyOf()
    }
}

fun handleDrag(gridState: GridState, change: PointerInputChange,canvasSize: Size) {
    val horizontalSpacing = canvasSize.height / gridState.numHorizontalLines
    val verticalSpacing = canvasSize.width / gridState.numVerticalLines

    // Calculate the row and column of the grid square being swiped to
    val row = (change.position.y / horizontalSpacing).toInt()
    val col = (change.position.x / verticalSpacing).toInt()

    // Update the color of the grid square
    if (row in 0 until gridState.numHorizontalLines && col in 0 until gridState.numVerticalLines) {
        gridState.gridColors.value[row][col] = Color.Red // Set your desired color here
        gridState.update()
    }
}
