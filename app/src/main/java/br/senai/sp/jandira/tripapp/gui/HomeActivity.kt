package br.senai.sp.jandira.tripapp.gui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.tripapp.R
import br.senai.sp.jandira.tripapp.gui.ui.theme.TripAppTheme
import br.senai.sp.jandira.tripapp.model.Category
import br.senai.sp.jandira.tripapp.repository.CategoryRepository

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.i(
            "ds2m",
            "id"
        )
        setContent {
            TripAppTheme {
                Column() {
                    HomeScreen(CategoryRepository.getCategories())
                }
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                }
            }
        }
    }
}

@Composable
fun HomeScreen(categories: List<Category>) {
    Surface(
    ) {
        Column() {
            Card(
                modifier = Modifier.height(200.dp),
                elevation = 4.dp,
                shape = RectangleShape,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.paris),
                    contentDescription = "",
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp, end = 12.dp),
                    horizontalAlignment = Alignment.End
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.susanna_profile),
                        contentDescription = stringResource(id = R.string.susanna_description),
                        modifier = Modifier
                            .size(62.dp)
                            .clip(shape = CircleShape)
                            .border(2.dp, Color.White, shape = CircleShape)
                    )
                    Text(
                        text = stringResource(id = R.string.susanna_hoffs),
                        modifier = Modifier.padding(top = 6.dp),
                        color = Color.White
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Row() {
                        Icon(
                            painter = painterResource(id = R.drawable.location_24),
                            contentDescription = stringResource(id = R.string.location_description),
                            tint = Color.White
                        )
                        Text(stringResource(id = R.string.youre_in_paris), color = Color.White)
                    }
                    Text(
                        text = stringResource(id = R.string.my_trips),
                        modifier = Modifier.padding(start = 26.dp, bottom = 10.dp),
                        color = Color.White,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                    )
                }
            }
            Column(

            ) {
                Text(
                    text = stringResource(id = R.string.categories),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp),
                )
                LazyRow() {
                    items(categories){
                        Card(
                            modifier = Modifier
                                .size(width = 109.dp, height = 80.dp)
                                .padding(vertical = 8.dp, horizontal = 4.dp),
                            backgroundColor = Color(207, 6, 240)
                        ){
                          Column(horizontalAlignment = Alignment.CenterHorizontally,
                              verticalArrangement = Arrangement.Center

                              ) {
                              Image(
                                  painter = it.categoryIcon,
                                  contentDescription = it.categoryName
                              )
                              Text(
                                  text = it.categoryName,
                                  fontSize = 14.sp,
                                  color = Color.White
                              )
                          }
                        }
                    }
                }
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    shape = RoundedCornerShape(16.dp),
                    placeholder = {
                        Text(text = stringResource(id = R.string.search_your_destiny))
                    },
                    trailingIcon = {
                        IconButton(onClick = {}

                        ) {
                            Icon(imageVector = Icons.Default.Search, contentDescription = "")
                        }
                    }
                )

            }
        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Homew() {
    TripAppTheme {
        HomeScreen(CategoryRepository.getCategories())
    }
}