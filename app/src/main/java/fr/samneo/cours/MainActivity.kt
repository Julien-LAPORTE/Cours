package fr.samneo.cours

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.samneo.cours.data.DataSource
import fr.samneo.cours.model.Theme
import fr.samneo.cours.ui.theme.CoursTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoursTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    CoursApp()
                }
            }
        }
    }
}

@Composable
fun CoursApp(modifier: Modifier = Modifier) {
    ThemeCardGrid(themesList = DataSource.themes)
}

@Composable
fun ThemeCard(theme: Theme, modifier: Modifier = Modifier) {
    Card(modifier) {
        Row() {
            Image(
                painterResource(id = theme.image),
                stringResource(id = theme.themeText),
                Modifier.size(68.dp)
            )
            Column(
                Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp),
                verticalArrangement = Arrangement.Bottom
            ) {
                Text(
                    stringResource(id = theme.themeText),
                    Modifier.padding(bottom = 8.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
                Row(
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painterResource(id = R.drawable.ic_grain),
                        null,
                        Modifier.padding(end = 8.dp)
                    )
                    Text(
                        text = theme.numberOfCourses.toString(),
                        style = MaterialTheme.typography.labelMedium,


                        )
                }
            }
        }
    }
}

@Composable
fun ThemeCardGrid(themesList: List<Theme>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
    ) {
        items(themesList) { theme ->
            ThemeCard(theme = theme, Modifier.padding(8.dp))
        }
    }
}

@Preview
@Composable
fun ThemeCardGridPreview() {
    ThemeCardGrid(themesList = DataSource.themes)
}

@Preview
@Composable
fun ThemeCardPreview() {
    ThemeCard(Theme(R.drawable.photography, R.string.photography, 321))
}