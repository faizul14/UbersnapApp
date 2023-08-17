package com.faezolfp.ubersnaptodoapp.ui.componen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.faezolfp.ubersnaptodoapp.ui.theme.UbersnapTodoAppTheme


@Composable
fun TaskItem(
    tittle: String,
    description: String,
    date: String,
    modifier: Modifier = Modifier
) {

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 16.dp, bottom = 4.dp, top = 4.dp, end = 16.dp),
//        elevation = 4.dp,
        shape = RoundedCornerShape(16.dp),
//        backgroundColor = Color.White
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = tittle,
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 1,
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = date,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.background
            )
        }
    }
}

@Preview(showBackground = false)
@Composable
fun TaskItemPreview() {
    UbersnapTodoAppTheme {
        TaskItem(tittle = "Learning Android",
            description = "Lorem ispum dolor is amet, lipsum lipsum, lispsum lipsum.",
            date = "17 August 2023")
    }
    
}