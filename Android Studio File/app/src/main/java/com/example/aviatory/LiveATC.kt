package com.example.aviatory

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun LiveATC( modifier: Modifier = Modifier) {
    Box(modifier.fillMaxSize().background(Color.Green),
        contentAlignment = Alignment.Center
    ){
        WebViewScreen(url = "https://www.liveatc.net/")
        // WebViewScreen(url = "https://www.flightradar24.com/")
    }
}

@Composable
fun WebViewScreen(url: String) {
    AndroidView(
        factory = { context ->
            WebView(context).apply {
                webViewClient = WebViewClient()
                settings.javaScriptEnabled = true
                loadUrl(url)
            }
        },
        update = {webView ->
            webView.loadUrl(url)
        },
        modifier = Modifier.fillMaxSize()
    )
}
