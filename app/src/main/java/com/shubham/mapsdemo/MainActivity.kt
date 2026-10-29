package com.shubham.mapsdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.maps.android.compose.rememberMarkerState
import kotlinx.coroutines.launch

// ---- Student details (shown in the app bar and marker info window) ----
private const val STUDENT_NAME = "Shubham Shivaji Kondikire"
private const val STUDENT_USN = "25MCAR0102"

data class Place(val name: String, val latLng: LatLng)

// Places in Bengaluru + a few other cities to test camera movement
private val places = listOf(
    Place("Vidhana Soudha, Bengaluru", LatLng(12.9791, 77.5913)),
    Place("Lalbagh Garden, Bengaluru", LatLng(12.9507, 77.5848)),
    Place("Cubbon Park, Bengaluru", LatLng(12.9763, 77.5929)),
    Place("Gateway of India, Mumbai", LatLng(18.9220, 72.8347)),
    Place("India Gate, Delhi", LatLng(28.6129, 77.2295))
)

private val mapTypes = listOf(
    "Normal" to MapType.NORMAL,
    "Satellite" to MapType.SATELLITE,
    "Terrain" to MapType.TERRAIN,
    "Hybrid" to MapType.HYBRID
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                MapsScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MapsScreen() {
    val scope = rememberCoroutineScope()
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(places[0].latLng, 13f)
    }
    var selectedPlace by remember { mutableStateOf(0) }
    var selectedType by remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text("Experiment 11 - Google Maps")
                        Text(
                            "$STUDENT_NAME | $STUDENT_USN",
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
            )
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {
            // ---- The Google Map ----
            GoogleMap(
                modifier = Modifier.fillMaxSize(),
                cameraPositionState = cameraPositionState,
                properties = MapProperties(mapType = mapTypes[selectedType].second),
                uiSettings = MapUiSettings(zoomControlsEnabled = true)
            ) {
                places.forEach { place ->
                    Marker(
                        state = rememberMarkerState(position = place.latLng),
                        title = place.name,
                        snippet = "$STUDENT_NAME | USN: $STUDENT_USN"
                    )
                }
            }

            // ---- Place chips (top) ----
            LazyRow(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(places.size) { index ->
                    FilterChip(
                        selected = selectedPlace == index,
                        onClick = {
                            selectedPlace = index
                            scope.launch {
                                cameraPositionState.animate(
                                    CameraUpdateFactory.newLatLngZoom(places[index].latLng, 14f)
                                )
                            }
                        },
                        label = { Text(places[index].name.substringBefore(",")) }
                    )
                }
            }

            // ---- Map type chips (bottom) ----
            Card(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .padding(12.dp),
                elevation = CardDefaults.cardElevation(6.dp)
            ) {
                Column(Modifier.padding(8.dp)) {
                    Text("Map type", style = MaterialTheme.typography.labelMedium)
                    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        items(mapTypes) { (label, _) ->
                            val idx = mapTypes.indexOfFirst { it.first == label }
                            FilterChip(
                                selected = selectedType == idx,
                                onClick = { selectedType = idx },
                                label = { Text(label) }
                            )
                        }
                    }
                }
            }
        }
    }
}
