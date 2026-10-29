# Experiment 11 – Develop an Application to Display Google Maps

## Student Details

- **Name:** Shubham Shivaji Kondikire
- **USN:** 25MCAR0102
- **Course:** MCA – Jain (Deemed-to-be University)
- **Experiment No.:** 11
- **Platform:** Android Studio
- **Programming Language:** Kotlin
- **UI Framework:** Jetpack Compose

---

## 1. Aim

To develop an Android application that displays Google Maps and demonstrates map markers, camera movement, location selection, and different map types.

## 2. Objectives

- To integrate Google Maps into an Android application.
- To display an interactive map with a default location.
- To add markers for different places.
- To move the map camera to selected locations.
- To switch between Normal, Satellite, Terrain, and Hybrid map types.
- To understand the use of Jetpack Compose in Android development.

## 3. Technologies Used

- Android Studio
- Kotlin
- Jetpack Compose
- Google Maps SDK for Android
- Maps Compose Library
- Gradle Kotlin DSL
- Google Cloud Console

## 4. Project Description

GoogleMapsApp is an Android application that displays an interactive Google Map with multiple location markers. The application opens with Vidhana Soudha in Bengaluru as the default location.

Users can select different places using the location chips displayed on the screen. The map camera moves to the selected location.

The application also provides four map types: Normal, Satellite, Terrain, and Hybrid. When a marker is selected, its information window displays the location name and student details.

## 5. Features

1. Google Maps Integration: Displays an interactive Google Map inside the application.
2. Location Markers: Displays markers for five selected locations.
3. Camera Movement: Moves the map camera to the selected location.
4. Multiple Map Types: Supports Normal, Satellite, Terrain, and Hybrid views.
5. Location Selection: Allows users to select locations using FilterChip components.
6. Student Details: Displays the student's name and USN in the application interface and marker information windows.
7. Zoom Controls: Allows users to zoom in and out of the map.

## 6. Locations Used

The application includes the following locations:

- Vidhana Soudha, Bengaluru
- Lalbagh Garden, Bengaluru
- Cubbon Park, Bengaluru
- Gateway of India, Mumbai
- India Gate, Delhi

## 7. Project Structure

```text
GoogleMapsApp/
├── app/
│   ├── build.gradle.kts
│   ├── proguard-rules.pro
│   └── src/
│       └── main/
│           ├── AndroidManifest.xml
│           ├── java/
│           │   └── com/
│           │       └── shubham/
│           │           └── mapsdemo/
│           │               └── MainActivity.kt
│           └── res/
│               └── values/
│                   └── strings.xml
├── docs/
│   └── screenshots/
├── gradle/
│   └── wrapper/
│       └── gradle-wrapper.properties
├── build.gradle.kts
├── settings.gradle.kts
├── gradle.properties
├── .gitignore
└── README.md
```

## 8. Important Files

- MainActivity.kt: Contains the main user interface, Google Map, location markers, camera movement, and map-type selection.
- AndroidManifest.xml: Contains application configuration, permissions, launcher activity, and Google Maps API key metadata.
- app/build.gradle.kts: Configures Android settings, Kotlin, Jetpack Compose, and Google Maps dependencies.
- strings.xml: Contains application string resources.
- local.properties: Stores the local Google Maps API key configuration. This file should not be uploaded to GitHub.

## 9. Google Maps API Key Configuration

Google Maps requires a valid API key to display map data.

Steps to configure the API key:

1. Open Google Cloud Console: https://console.cloud.google.com/
2. Create or select a Google Cloud project.
3. Enable Maps SDK for Android.
4. Open the Credentials section.
5. Create an API key.
6. Open the local.properties file in the project root directory.
7. Add the following configuration:

```properties
MAPS_API_KEY=YOUR_GOOGLE_MAPS_API_KEY
```

Replace YOUR_GOOGLE_MAPS_API_KEY with your actual API key.

Important: Never upload your real API key to GitHub. Restrict the key to your Android application and configure appropriate API restrictions in Google Cloud Console.

## 10. How to Run the Project

1. Download or clone the project repository.
2. Open Android Studio.
3. Select File → Open.
4. Choose the GoogleMapsApp project folder.
5. Wait for Gradle synchronization to complete.
6. Configure the Google Maps API key in local.properties.
7. Ensure Maps SDK for Android is enabled in Google Cloud Console.
8. Connect an Android device or start an emulator with Google Play services.
9. Click the Run button in Android Studio.
10. Test the location markers and map types.

An active internet connection is required to load Google Maps.

## 11. Test Cases

| Test Case | Test Procedure | Expected Result |
|---|---|---|
| Test Case 1 | Launch the application. | The map opens at Vidhana Soudha, Bengaluru. |
| Test Case 2 | Select Lalbagh Garden. | The camera moves to Lalbagh Garden. |
| Test Case 3 | Select India Gate. | The camera moves to India Gate, Delhi. |
| Test Case 4 | Select a marker. | The location name and student details appear. |
| Test Case 5 | Select Normal map type. | The normal map is displayed. |
| Test Case 6 | Select Satellite map type. | Satellite imagery is displayed. |
| Test Case 7 | Select Terrain map type. | The terrain map is displayed. |
| Test Case 8 | Select Hybrid map type. | Satellite imagery and map labels are displayed. |
| Test Case 9 | Use the zoom controls. | The map zoom level changes. |

## 12. Output Screenshots

Capture screenshots of the running application and save them in the docs/screenshots/ directory.

Suggested screenshot filenames:

- output.png
- <img width="1600" height="899" alt="exp11 (1)" src="https://github.com/user-attachments/assets/5ba3f596-2297-4472-9ae6-a64e0c102e1c" />
<img width="1600" height="847" alt="exp11 (2)" src="https://github.com/user-attachments/assets/4ee9aaf3-2084-438c-be8c-8eb0356fab75" />



To display a screenshot in this README, use the following Markdown after adding the image to the repository:

```markdown
![Google Maps Application Output](docs/screenshots/output.png)
```

## 13. Result

The GoogleMapsApp Android application demonstrates Google Maps integration using Kotlin and Jetpack Compose. It displays an interactive map, provides location markers, supports camera movement, and allows users to switch between different map types.

## 14. Conclusion

This experiment demonstrates how to integrate Google Maps into an Android application using Jetpack Compose. It provides practical knowledge of map rendering, markers, camera positioning, map properties, and user interaction in Android development.

---

**Developed By:** Shubham Shivaji Kondikire

**USN:** 25MCAR0102

**Course:** MCA – Jain (Deemed-to-be University)
