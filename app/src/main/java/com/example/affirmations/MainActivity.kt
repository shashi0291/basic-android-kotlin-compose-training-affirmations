/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.affirmations

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.affirmations.model.AffirmationModel
import com.example.affirmations.ui.theme.AffirmationsTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AffirmationsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AffirmationsApp()
                }
            }
        }
    }
}

@Composable
fun AffirmationsApp() {
    AffirmationList(
        affirmations = getAffirmationList(),
        modifier = Modifier.fillMaxSize()
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AffirmationItem(
    modifier: Modifier = Modifier,
    affirmation: AffirmationModel
) {
    Card(
        onClick = { },
        modifier = modifier
            .background(color = Color.White)
            .padding(8.dp)
    ) {
        Column(modifier = modifier) {
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(id = affirmation.drawable),
                contentDescription = null,
                contentScale = ContentScale.FillWidth
            )
            Text(
                modifier = Modifier.padding(8.dp),
                text = stringResource(id = affirmation.text),
                style = TextStyle()
            )
        }
    }
}

@Composable
fun AffirmationList(
    modifier: Modifier = Modifier,
    affirmations: List<AffirmationModel>
) {

    LazyColumn {
        items(affirmations) { affirmation ->
            AffirmationItem(modifier = modifier, affirmation = affirmation)
        }
    }
}


@Preview
@Composable
fun PreviewAffirmationItem() {
    AffirmationsTheme {
        AffirmationItem(
            affirmation = AffirmationModel(
                drawable = R.drawable.image1, text = R.string.affirmation1
            )
        )
    }
}

@Preview
@Composable
fun PreviewAffirmationList() {
    val affirmationList = getAffirmationList()
    AffirmationList(affirmations = affirmationList, modifier = Modifier.fillMaxSize())
}

private fun getAffirmationList(): List<AffirmationModel> {
    return listOf(
        AffirmationModel(
            drawable = R.drawable.image1, text = R.string.affirmation1
        ),
        AffirmationModel(
            drawable = R.drawable.image2, text = R.string.affirmation2
        ),
        AffirmationModel(
            drawable = R.drawable.image3, text = R.string.affirmation3
        ),
        AffirmationModel(
            drawable = R.drawable.image4, text = R.string.affirmation4
        ),
        AffirmationModel(
            drawable = R.drawable.image5, text = R.string.affirmation5
        ),
        AffirmationModel(
            drawable = R.drawable.image6, text = R.string.affirmation6
        ),
        AffirmationModel(
            drawable = R.drawable.image7, text = R.string.affirmation7
        ),
        AffirmationModel(
            drawable = R.drawable.image8, text = R.string.affirmation8
        ),
        AffirmationModel(
            drawable = R.drawable.image9, text = R.string.affirmation9
        ),
        AffirmationModel(
            drawable = R.drawable.image10, text = R.string.affirmation10
        ),
    )
}
