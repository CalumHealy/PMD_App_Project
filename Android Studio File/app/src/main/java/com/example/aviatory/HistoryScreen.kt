package com.example.aviatory

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign

@Composable
fun HistoryScreen( modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(red = 175, green = 175, blue = 255))
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Box (
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "The History of Aviation",
                    style = TextStyle(
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(red = 50, green = 0, blue = 150),
                        fontFamily = FontFamily.Serif,
                        textAlign = TextAlign.Center,
                    ),
                    modifier = Modifier
                        .padding(16.dp)
                )
            }
        }

        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(250.dp)
                    .padding(10.dp)
                    .border(width = 4.dp, color = Color(red = 0, green = 0, blue = 0)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.birdimg),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .matchParentSize()
                )
            }
        }

        item {
            Text(
                text = "Flight has always been a dream of many humans. Our land-oriented bodies may " +
                        "keep us from easily jumping up and joining the birds among the clouds, but " +
                        "we wanted more, and one advantage we do have, is our minds. Even way back " +
                        "during the Renaissance, Leonardo Da Vinci was designing flying machines that " +
                        "were hundreds of years ahead of his time. When materials and technology " +
                        "eventually advanced enough, the Montgolfier brothers created the hot-air " +
                        "balloon. As they discovered, hot air is less dense than cold air, and " +
                        "therefore rises. They got a huge balloon, a basket, and a flame, attached " +
                        "the basked to the bottom on the balloon, and heated the air in the balloon. ",
                style = TextStyle(fontSize = 16.sp),
                color = Color(red = 50, green = 0, blue = 150),
                modifier = Modifier.padding(end = 8.dp)
            )
        }

        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(250.dp)
                    .padding(10.dp)
                    .border(width = 4.dp, color = Color(red = 0, green = 0, blue = 0)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.bigballoonimg),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .matchParentSize()
                )
            }
        }

        item {
            Text(
                text = "Around the same time, hydrogen was discovered, leading to the invention of " +
                        "the hydrogen balloon. This eventually proved to be not the best idea. ",
                style = TextStyle(fontSize = 16.sp),
                color = Color(red = 50, green = 0, blue = 150),
                modifier = Modifier.padding(end = 8.dp)
            )
        }

        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(250.dp)
                    .padding(10.dp)
                    .border(width = 4.dp, color = Color(red = 0, green = 0, blue = 0)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.oopsiehydrogenblimpimg),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .matchParentSize()
                )
            }
        }

        item {
            Text(
                text = "The first heavier-than-air flying machines were gliders. These paved the " +
                        "way for modern aerodynamics, and inspired to Wright brothers to put an " +
                        "engine on an aircraft. This was the first aeroplane. ",
                style = TextStyle(fontSize = 16.sp),
                color = Color(red = 50, green = 0, blue = 150),
                modifier = Modifier.padding(end = 8.dp)
            )
        }

        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(250.dp)
                    .padding(10.dp)
                    .border(width = 4.dp, color = Color(red = 0, green = 0, blue = 0)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.wbplaneimg),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .matchParentSize()
                )
            }
        }

        item {
            Text(
                text = "The first half of the 20th century saw rapid development of aeroplanes. Planes " +
                        "started being made out of metal. Cockpits became enclosed. Planes got bigger " +
                        "and faster. By World War II, planes were being used as war machines, with " +
                        "complex and strenuous dog fights occurring over cities. ",
                style = TextStyle(fontSize = 16.sp),
                color = Color(red = 50, green = 0, blue = 150),
                modifier = Modifier.padding(end = 8.dp)
            )
        }

        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(250.dp)
                    .padding(10.dp)
                    .border(width = 4.dp, color = Color(red = 0, green = 0, blue = 0)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ww2planeimg),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .matchParentSize()
                )
            }
        }

        item {
            Text(
                text = "From here, we developed the jet engine, made planes big enough and powerful " +
                        "enough to carry other planes, and even space shuttles. Jet engines were " +
                        "eventually replaced by turbofan engines due to the increased efficiency. " +
                        "Planes became faster than sound in 1947, making quite the scene with their " +
                        "sonic booms whenever they passed. ",
                style = TextStyle(fontSize = 16.sp),
                color = Color(red = 50, green = 0, blue = 150),
                modifier = Modifier.padding(end = 8.dp)
            )
        }

        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(250.dp)
                    .padding(10.dp)
                    .border(width = 4.dp, color = Color(red = 0, green = 0, blue = 0)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.piggybackimg),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .matchParentSize()
                )
            }
        }

        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(250.dp)
                    .padding(10.dp)
                    .border(width = 4.dp, color = Color(red = 0, green = 0, blue = 0)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.sonicboomimg),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .matchParentSize()
                )
            }
        }

        item {
            Text(
                text = "With an average of almost 10,000 planes in the air at any one time, it is " +
                        "clear that the modern world relies heavily on the aviation industry. " +
                        "Whether it's for commercial transport, war, industrial transport, or " +
                        "political reasons, our world could not operate as it does today without " +
                        "these incredible displays of engineering. ",
                style = TextStyle(fontSize = 16.sp),
                color = Color(red = 50, green = 0, blue = 150),
                modifier = Modifier.padding(end = 8.dp)
            )
        }

        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(250.dp)
                    .padding(10.dp)
                    .border(width = 4.dp, color = Color(red = 0, green = 0, blue = 0)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.airbusyimg),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .matchParentSize()
                )
            }
        }

        item {
            Text(
                text = "It is interesting to think about what the future of aviation holds. With " +
                        "so many electric aircraft being invented, such as small drones for " +
                        "recreational use or quadcopter designs for transportation, it is clear that " +
                        "there is potential for an electric sky. However, the weight of modern batteries " +
                        "make current electric aircraft quite inefficient, with low ranges. We may " +
                        "not have a choice though, as the current rate of fuel consumption is drying " +
                        "up oil quickly, and harming the environment. The sooner we move away from " +
                        "combustion-powered flight and towards motorized propulsion, the better it " +
                        "is for everybody. ",
                style = TextStyle(fontSize = 16.sp),
                color = Color(red = 50, green = 0, blue = 150),
                modifier = Modifier.padding(end = 8.dp)
            )
        }

        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(250.dp)
                    .padding(10.dp)
                    .border(width = 4.dp, color = Color(red = 0, green = 0, blue = 0)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.droneimg),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .matchParentSize()
                )
            }
        }

        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(250.dp)
                    .padding(10.dp)
                    .border(width = 4.dp, color = Color(red = 0, green = 0, blue = 0)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.eplaneimg),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .matchParentSize()
                )
            }
        }
    }
}
