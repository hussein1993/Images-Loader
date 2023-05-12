package com.example.imageslogger.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.imageslogger.ImagesViewModel
import com.example.imageslogger.model.Photo
import com.example.imageslogger.services.loadPicture


@Composable
fun ImagesPage(
    navController: NavController,
    viewModel: ImagesViewModel
) {
    val currImages = viewModel.images.collectAsState(ArrayList<Photo>())
    if (currImages.value.isEmpty()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularProgressIndicator()
        }
    } else {
        Box {
            LazyColumn(Modifier.fillMaxWidth()) {
                itemsIndexed(currImages.value) { index,img ->

                    ImageCard(index,img, viewModel = viewModel)
                    Spacer(
                        modifier = Modifier
                            .height(10.dp)
                            .background(color = MaterialTheme.colors.secondaryVariant)
                    )


                }
            }
        }
    }
}

@Composable
fun ImageCard(index: Int, img: Photo, viewModel: ImagesViewModel) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp)
        .clickable {
            img.id?.let {
                viewModel.updateSelectedPhoto(index,it)
            }
        }
    ) {
        img.src?.portrait?.let {
            val currPhoto = loadPicture(url = it).value
            currPhoto?.let {
                Image(
                    bitmap = it.asImageBitmap(),
                    contentDescription = "pImg",
                    modifier = Modifier
                        .fillMaxSize()
                        .height(225.dp),
                    contentScale = ContentScale.FillWidth
                )

            }
        }

    }
}
