package com.example.imageslogger.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.imageslogger.ImagesViewModel
import com.example.imageslogger.model.Photo


@Composable
fun HomePage(navController: NavController, viewModel: ImagesViewModel) {
    val selectedImages = viewModel.selectedPhotos.collectAsState(ArrayList<Photo>())

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        contentAlignment = Alignment.TopCenter
    ) {
        Button(modifier = Modifier.padding(20.dp),
            onClick = {
                viewModel.fetchImages()
                navController.navigate(route = "images_page")
            }) {
            Text(text = "click",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            )
        }

        LazyColumn(modifier = Modifier
            .padding(top = 80.dp, bottom = 20.dp)) {
            items(selectedImages.value) { item ->
                Text(text = "clicked ${item}",
                    modifier = Modifier.padding(5.dp),
                    style = TextStyle(
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp
                    )
                )
            }
        }


    }
}