# Experiment 11 – Develop an Application to Display Google Maps

**Name:** Shubham Shivaji Kondikire
**USN:** 25MCAR0102
**Course:** MCA – Jain (Deemed-to-be University)
**Platform:** Android (Kotlin + Jetpack Compose)

---

## 1. Aim
To develop an Android application that displays Google Maps, adds markers, moves the camera to different locations and switches between map types.

## 2. Concept / Technology Behind It

| Concept | Explanation |
|---|---|
| **Maps SDK for Android** | Google's library that renders interactive maps inside an app. It loads map tiles from Google servers using an API key. |
| **API Key** | A secret key from Google Cloud Console that identifies the app. It is stored in `local.properties` and injected into `AndroidManifest.xml` as `com.google.android.geo.API_KEY`. |
| **Maps Compose** | A Jetpack Compose wrapper (`GoogleMap`, `Marker`, `CameraPositionState`) so the map can be used as a normal composable. |
| **Camera** | Controls what part of the world is visible (target LatLng, zoom, tilt, bearing). `cameraPositionState.animate()` smoothly moves it. |
| **Marker** | A pin placed at a `LatLng` with a title and snippet shown in the info window. |
| **Map Types** | NORMAL, SATELLITE, TERRAIN, HYBRID – changed through `MapProperties(mapType = ...)`. |

**Analogy:** The map is a TV screen, the camera is the remote (pan/zoom), markers are sticky notes, and the API key is the cable subscription that lets the TV show channels.

## 3. Scenario Used for Demonstration
A "city explorer" app. The map opens on **Vidhana Soudha, Bengaluru**. The user can:
1. Tap a place chip (Vidhana Soudha, Lalbagh, Cubbon Park, Gateway of India, India Gate) to fly the camera there.
2. Tap any marker to see its info window with the place name and the student's **Name + USN**.
3. Switch between **Normal / Satellite / Terrain / Hybrid** map types.

## 4. Folder / File Structure

```
GoogleMapsApp/
├── README.md                          -> This documentation
├── .gitignore                         -> Ignores build files and local.properties (API key)
├── build.gradle.kts                   -> Root Gradle file (plugin versions)
├── settings.gradle.kts                -> Project name + repositories + modules
├── gradle.properties                  -> Gradle / AndroidX settings
├── gradle/wrapper/
│   └── gradle-wrapper.properties      -> Gradle version used (8.7)
├── docs/screenshots/                  -> Output + test case screenshots
│   ├── output.png
│   ├── testcase1_default_map.png
│   ├── testcase2_navigate_place.png
│   └── testcase3_marker_name_usn.png
└── app/
    ├── build.gradle.kts               -> App dependencies, reads MAPS_API_KEY
    ├── proguard-rules.pro
    └── src/main/
        ├── AndroidManifest.xml        -> Permissions + API key meta-data + launcher activity
        ├── java/com/shubham/mapsdemo/
        │   └── MainActivity.kt        -> UI: GoogleMap, markers, chips, map-type selector
        └── res/values/
            └── strings.xml            -> App name
```

## 5. How to Run
1. Open the project in **Android Studio** (File > Open > `GoogleMapsApp`), wait for Gradle sync.
2. Get a key: Google Cloud Console > create project > enable **Maps SDK for Android** > Credentials > Create API key.
3. Open `local.properties` (in project root) and add:
   ```
   MAPS_API_KEY=your_real_api_key_here
   ```
4. Run on an emulator with **Google Play** image (or a real phone with internet).

## 6. Output Screenshot
![Output](docs/screenshots/output.png)

## 7. Test Cases

| # | Test Case | Steps | Expected Result | Screenshot |
|---|---|---|---|---|
| 1 | Map loads with default location | Launch the app | Map opens centred on Vidhana Soudha, Bengaluru with markers visible | ![TC1](docs/screenshots/testcase1_default_map.png) |
| 2 | Navigate to another place + change map type | Tap the "India Gate" chip, then choose "Satellite" | Camera animates to Delhi and the map switches to satellite view | ![TC2](docs/screenshots/testcase2_navigate_place.png) |
| 3 | Marker shows student Name and USN | Tap any marker | Info window shows place name, **Shubham Shivaji Kondikire \| USN: 25MCAR0102** (app bar also shows Name + USN) | ![TC3](docs/screenshots/testcase3_marker_name_usn.png) |

## 8. Result
The application successfully displays Google Maps with markers, animated camera movement and multiple map types using the Maps SDK for Android and Jetpack Compose.
