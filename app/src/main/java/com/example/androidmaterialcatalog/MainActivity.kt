package com.example.androidmaterialcatalog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.androidmaterialcatalog.ui.theme.AndroidMaterialCatalogTheme

data class ComposablesItem(
    val name: String,
    val lightImageResourceId: Int? = null,
    val darkImageResourceId: Int? = null
)

object Composables {
    val items = listOf(
        ComposablesItem("Badge", R.drawable.badge_light, R.drawable.buttons_dark),
        ComposablesItem("Buttons", R.drawable.buttons_light, R.drawable.buttons_dark),
        ComposablesItem("Card", R.drawable.card_light, R.drawable.card_dark),
        ComposablesItem("Checkbox", R.drawable.checkbox_light, R.drawable.checkbox_dark),
        ComposablesItem("Chips", R.drawable.chip_light, R.drawable.chip_dark),
        ComposablesItem("Extended FAB", R.drawable.extendedfab_light, R.drawable.extendedfab_dark),
        ComposablesItem("FAB", R.drawable.fab_light, R.drawable.fab_dark),
        ComposablesItem("Progress Indicators", R.drawable.progress_indicator_light, R.drawable.progress_indicator_dark),
        ComposablesItem("Sliders", R.drawable.slider_light, R.drawable.slider_dark),
        ComposablesItem("Switch", R.drawable.switch_light, R.drawable.switch_dark),
    )
}

data class ComposableDetail(
    val description: String,
    val example: @Composable (NavHostController) -> Unit
)

val exampleComposables: Map<String, @Composable () -> Unit> = mapOf(
    "Badge Example" to { BadgeExample() },
    "Elevated Button Example" to { ElevatedButtonExample() },
    "Filled Button Example" to { FilledButtonExample() },
    "Filled Tonal Button Example" to { FilledTonalButtonExample() },
    "Outlined Button Example" to { OutlinedButtonExample() },
    "Text Button Example" to { TextButtonExample() },
    "Elevated Card Example" to { ElevatedCardExample() },
    "Filled Card Example" to { FilledCardExample() },
    "Outlined Card Example" to { OutlinedCardExample() },
    "Checkbox Example" to { CheckboxExample() },
    "Assist Chip Example" to { AssistChipExample() },
    "Filter Chip Example" to { FilterChipExample() },
    "Suggestion Chip Example" to { SuggestionChipExample() },
    "Extended FAB Example" to { ExtendedFABExample() },
    "FAB Example" to { FABExample() },
    "Small FAB Example" to { SmallFABExample() },
    "Large FAB Example" to { LargeFABExample() },
    "Circular Progress Indicator Example" to { CircularProgressIndicatorExample() },
    "Linear Progress Indicator Example" to { LinearProgressIndicatorExample() },
    "Continuous Slider Example" to { ContinuousSliderExample() },
    "Centered Slider Example" to { CenteredSliderExample() },
    "Discrete Slider Example" to { DiscreteSliderExample() },
    "Ranged Slider Example" to { RangedSliderExample() },
    "Switch Example" to { SwitchExample() }
)

@Composable
fun BadgeExample() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        BadgedBox(
            badge = {
                Badge(
                    containerColor = Color.Red,
                    contentColor = Color.White
                ) {
                    Text("99")
                }
            }
        ) {
            Icon(
                imageVector = Icons.Filled.Call,
                contentDescription = "Call"
            )
        }
    }
}

@Composable
fun ElevatedButtonExample() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        ElevatedButton(
            onClick = {},
        ) {
            Text(
                text = "Elevated Button"
            )
        }
    }
}

@Composable
fun FilledButtonExample() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Button(
            onClick = {},
        ) {
            Text(
                text = "Filled Button"
            )
        }
    }
}

@Composable
fun FilledTonalButtonExample() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        FilledTonalButton(
            onClick = {},
        ) {
            Text(
                text = "Filled Tonal Button"
            )
        }
    }
}

@Composable
fun OutlinedButtonExample() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        OutlinedButton(
            onClick = {},
        ) {
            Text(
                text = "Outlined Button"
            )
        }
    }
}

@Composable
fun TextButtonExample() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        TextButton(
            onClick = {},
        ) {
            Text(
                text = "Text Button"
            )
        }
    }
}

@Composable
fun ElevatedCardExample() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        ElevatedCard {
            Text(
                text = "Elevated Card",
                modifier = Modifier.padding(32.dp)
            )
        }
    }
}

@Composable
fun FilledCardExample() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Card {
            Text(
                text = "Filled Card",
                modifier = Modifier.padding(32.dp)
            )
        }
    }
}

@Composable
fun OutlinedCardExample() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        OutlinedCard {
            Text(
                text = "Outlined Card",
                modifier = Modifier.padding(32.dp)
            )
        }
    }
}

@Composable
fun CheckboxExample() {
    var checked by remember { mutableStateOf(true) }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = { checked = it }
        )
    }
}

@Composable
fun AssistChipExample() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        AssistChip(
            onClick = { },
            label = { Text("Assist Chip") },
            leadingIcon = {
                Icon(
                    Icons.Filled.Settings,
                    contentDescription = "Assist Chip",
                    Modifier.size(AssistChipDefaults.IconSize)
                )
            }
        )
    }
}

@Composable
fun FilterChipExample() {
    var selected by remember { mutableStateOf(false) }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        FilterChip(
            onClick = { selected = !selected },
            label = { Text("Filter Chip") },
            selected = selected,
            leadingIcon = if (selected) {
                {
                    Icon(
                        imageVector = Icons.Filled.Done,
                        contentDescription = "Done",
                        modifier = Modifier.size(FilterChipDefaults.IconSize)
                    )
                }
            } else {
                null
            },
        )
    }
}

@Composable
fun SuggestionChipExample() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        SuggestionChip(
            onClick = { },
            label = { Text("Suggestion Chip") }
        )
    }
}

@Composable
fun ExtendedFABExample() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        ExtendedFloatingActionButton(
            onClick = { },
            icon = { Icon(Icons.Filled.Add, "Extended FAB") },
            text = { Text(text = "Extended FAB") },
        )
    }
}

@Composable
fun FABExample() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        FloatingActionButton(
            onClick = { },
        ) {
            Icon(Icons.Filled.Add, "FAB")
        }
    }
}

@Composable
fun SmallFABExample() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        SmallFloatingActionButton(
            onClick = { },
        ) {
            Icon(Icons.Filled.Add, "Small FAB")
        }
    }
}

@Composable
fun LargeFABExample() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        LargeFloatingActionButton(
            onClick = { },
        ) {
            Icon(Icons.Filled.Add, "FAB")
        }
    }
}

@Composable
fun CircularProgressIndicatorExample() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        CircularProgressIndicator(
            modifier = Modifier.width(100.dp),
            color = MaterialTheme.colorScheme.primary,
            trackColor = MaterialTheme.colorScheme.surfaceVariant,
            progress = { 0.75f },
        )
    }
}

@Composable
fun LinearProgressIndicatorExample() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        LinearProgressIndicator(
            modifier = Modifier.width(100.dp),
            color = MaterialTheme.colorScheme.primary,
            trackColor = MaterialTheme.colorScheme.surfaceVariant,
        )
    }
}

@Composable
fun ContinuousSliderExample() {
    var sliderPosition by remember { mutableFloatStateOf(0f) }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            modifier = Modifier.fillMaxWidth(0.3f)
        )
    }
}

@Composable
fun DiscreteSliderExample() {
    var sliderPosition by remember { mutableFloatStateOf(0f) }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            steps = 5,
            modifier = Modifier.fillMaxWidth(0.3f)
        )
    }
}

@Composable
fun CenteredSliderExample() {
    var sliderPosition by remember { mutableFloatStateOf(0f) }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            steps = 1,
            modifier = Modifier.fillMaxWidth(0.3f)
        )
    }
}

@Composable
fun RangedSliderExample() {
    var sliderPosition by remember { mutableStateOf(0f..1f) }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        RangeSlider(
            value = sliderPosition,
            onValueChange = { range: ClosedFloatingPointRange<Float> ->
                sliderPosition = range
            },
            modifier = Modifier.fillMaxWidth(0.3f)
        )
    }
}

@Composable
fun SwitchExample() {
    var checked by remember { mutableStateOf(true) }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Switch(
            checked = checked,
            onCheckedChange = { checked = it }
        )
    }
}

@Composable
fun ComposableExample(examples: List<String>, navController: NavHostController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        examples.forEach { example ->
            Button(
                onClick = { navController.navigate(example) },
                shape = RoundedCornerShape(8.dp),
                contentPadding = PaddingValues(0.dp),
                modifier = Modifier.height(75.dp),
                colors = ButtonDefaults.buttonColors(contentColor = MaterialTheme.colorScheme.onBackground)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(MaterialTheme.colorScheme.surfaceContainerLowest)
                        .fillMaxSize()
                        .border(
                            width = 1.dp,
                            color = MaterialTheme.colorScheme.surfaceContainerHighest,
                            shape = RoundedCornerShape(8.dp)
                        )
                        .padding(start = 16.dp, end = 8.dp)
                ) {
                    Text(
                        text = example,
                        style = MaterialTheme.typography.titleMedium,
                    )
                    Icon(
                        imageVector = Icons.Rounded.PlayArrow,
                        contentDescription = example,
                        modifier = Modifier.size(35.dp)
                    )
                }
            }
        }
    }
}

val composableDetails = mapOf(
    "Badge" to ComposableDetail(
        description = "A badge show information on a navigation item.",
        example = { navController ->
            ComposableExample(listOf("Badge Example"), navController)
        }
    ),
    "Buttons" to ComposableDetail(
        description = "Buttons allow users to trigger a action.",
        example = { navController ->
            ComposableExample(
                listOf(
                    "Elevated Button Example",
                    "Filled Button Example",
                    "Filled Tonal Button Example",
                    "Outlined Button Example",
                    "Text Button Example"
                ), navController
            )
        }
    ),
    "Card" to ComposableDetail(
        description = "Cards hold content about a object.",
        example = { navController ->
            ComposableExample(
                listOf(
                    "Elevated Card Example",
                    "Filled Card Example",
                    "Outlined Card Example"
                ), navController
            )
        }
    ),
    "Checkbox" to ComposableDetail(
        description = "Checkboxes show if an item is on or off.",
        example = { navController ->
            ComposableExample(listOf("Checkbox Example"), navController)
        }
    ),
    "Chips" to ComposableDetail(
        description = "Chips help make selections.",
        example = { navController ->
            ComposableExample(
                listOf(
                    "Assist Chip Example",
                    "Filter Chip Example",
                    "Suggestion Chip Example"
                ), navController
            )
        }
    ),
    "Extended FAB" to ComposableDetail(
        description = "Extended FABs are the most important action on screen.",
        example = { navController ->
            ComposableExample(listOf("Extended FAB Example"), navController)
        }
    ),
    "FAB" to ComposableDetail(
        description = "FABs are the most important action on screen.",
        example = { navController ->
            ComposableExample(
                listOf(
                    "FAB Example",
                    "Small FAB Example",
                    "Large FAB Example"
                ), navController
            )
        }
    ),
    "Progress Indicators" to ComposableDetail(
        description = "Progress indicators show the status of a process.",
        example = { navController ->
            ComposableExample(
                listOf(
                    "Circular Progress Indicator Example",
                    "Linear Progress Indicator Example"
                ), navController
            )
        }
    ),
    "Sliders" to ComposableDetail(
        description = "Sliders have a range of values to choose from",
        example = { navController ->
            ComposableExample(
                listOf(
                    "Continuous Slider Example",
                    "Centered Slider Example",
                    "Discrete Slider Example",
                    "Ranged Slider Example"
                ), navController
            )
        }
    ),
    "Switch" to ComposableDetail(
        description = "Switches toggle an item on or off.",
        example = { navController ->
            ComposableExample(listOf("Switch Example"), navController)
        }
    ),
)

@Composable
fun ComponentDetailsScreen(detail: ComposableDetail, navController: NavHostController) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Description", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(16.dp))
        Text(detail.description, style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Text("Examples", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(16.dp))
        detail.example(navController)
    }
}

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidMaterialCatalogTheme {
                val navController = rememberNavController()
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute =
                    navBackStackEntry?.destination?.route ?: "Android Material Catalog"
                Scaffold(
                    // Bottom bar just for taking screenshots
                    bottomBar = {
                        BottomAppBar(modifier = Modifier.height(88.dp)) { }
                    },
                    topBar = {
                        CenterAlignedTopAppBar(
                            title = {
                                Text(
                                    currentRoute
                                )
                            },
                            navigationIcon = {
                                if (currentRoute != "Android Material Catalog") {
                                    IconButton(onClick = { navController.popBackStack() }) {
                                        Icon(
                                            imageVector = Icons.AutoMirrored.Rounded.ArrowBack,
                                            contentDescription = "Back"
                                        )
                                    }
                                }
                            }
                        )
                    }

                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "Android Material Catalog",
                        modifier = Modifier.padding(innerPadding),
                        enterTransition = { fadeIn(animationSpec = tween(300)) },
                        exitTransition = { fadeOut(animationSpec = tween(300)) },
                        popEnterTransition = { fadeIn(animationSpec = tween(300)) },
                        popExitTransition = { fadeOut(animationSpec = tween(300)) }
                    ) {
                        composable("Android Material Catalog") {
                            MainContent(navController)
                        }
                        Composables.items.forEach { item ->
                            composable(item.name) {
                                val detail = composableDetails[item.name]
                                if (detail != null) {
                                    ComponentDetailsScreen(detail, navController)
                                } else {
                                    Text("Details not found for ${item.name}")
                                }
                            }
                        }
                        exampleComposables.forEach { (exampleName, exampleComposable) ->
                            composable(exampleName) {
                                exampleComposable()
                            }
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun MainContent(navController: NavHostController) {
    val configuration = LocalConfiguration.current
    val screenWidthDp = configuration.screenWidthDp

    val columnCount = remember(screenWidthDp) {
        when {
            screenWidthDp < 350 -> 1
            screenWidthDp < 500 -> 2
            screenWidthDp < 750 -> 3
            screenWidthDp < 1000 -> 4
            else -> 5
        }
    }

    LazyVerticalGrid(
        columns = GridCells.Fixed(columnCount),
        contentPadding = PaddingValues(16.dp),
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(Composables.items) { composable ->
            Button(
                onClick = {
                    navController.navigate(composable.name)
                },
                shape = RoundedCornerShape(8.dp),
                contentPadding = PaddingValues(0.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.background,
                    contentColor = MaterialTheme.colorScheme.onBackground
                ),
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        //.background(MaterialTheme.colorScheme.surfaceContainerLowest)
                        .fillMaxSize()
                        .border(
                            width = 1.dp,
                            color = MaterialTheme.colorScheme.surfaceContainerHighest,
                            shape = RoundedCornerShape(8.dp)
                        )
                ) {
                    val isDarkMode = isSystemInDarkTheme()
                    val imageResourceId = if (isDarkMode) {
                        composable.darkImageResourceId ?: composable.lightImageResourceId
                    } else {
                        composable.lightImageResourceId ?: composable.darkImageResourceId
                    }

                    if (imageResourceId != null) {
                        Image(
                            painter = painterResource(id = imageResourceId),
                            contentDescription = composable.name,
                            modifier = Modifier
                                .size(125.dp)
                                .padding(top = 8.dp, bottom = 8.dp)
                        )
                    }
                    Text(
                        text = composable.name,
                        style = MaterialTheme.typography.titleMedium,
                    )
                }
            }
        }
    }
}