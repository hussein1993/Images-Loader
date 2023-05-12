package com.example.imageslogger.services

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.example.imageslogger.R

const val DEFAULT_IMG = R.drawable.ic_launcher_foreground


@SuppressLint("UnrememberedMutableState")
@Composable
fun loadPicture(
    url: String
): MutableState<Bitmap?> {
    val bitmapImg : MutableState<Bitmap?> =
        mutableStateOf(null)

    Glide.with(LocalContext.current)
        .asBitmap()
        .load(DEFAULT_IMG)
        .into(object : CustomTarget<Bitmap>(){
            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                bitmapImg.value = resource
            }

            override fun onLoadCleared(placeholder: Drawable?) {

            }

        })

    Glide.with(LocalContext.current)
        .asBitmap()
        .load(url)
        .into(object : CustomTarget<Bitmap>(){
            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                bitmapImg.value = resource
            }

            override fun onLoadCleared(placeholder: Drawable?) {
            }
        })
    return bitmapImg
}
