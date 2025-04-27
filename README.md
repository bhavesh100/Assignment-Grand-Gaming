# 🐱 Assignmenet Grand Gaming

A simple Android app that fetches and displays a list of cat images.  
Users can click on any cat image to view it in full screen.

---

## ✨ Features

- Fetches cat images from API
- Shows loading progress while fetching
- Handles loading, success, and error states
- Opens full-screen detail view on image click
- MVVM Architecture + ViewModel + StateFlow
- Glide used for image loading
- Modern Android best practices

---

## 📸 Screenshots

| Home Screen (List) | Detail Screen (Full Image) |
|:-------------------:|:---------------------------:|
| ![Home Screen](screenshots/home_screen.png) | ![Detail Screen](screenshots/detail_screen.png) |

---

## 🎥 Screen Recording

| Screen Recording |
|:----------------:|
| ![Screen Recording](screenshots/screen_recording.gif) |

---

## 🏛️ Architecture

- **ViewModel**: Manages UI state using `StateFlow`
- **Repository Pattern**: To fetch data
- **UI**: Activity + RecyclerView
- **Navigation**: Intent passing
- **Image Loading**: Glide library

---

## 🔥 Tech Stack

- Kotlin
- Android Jetpack
- StateFlow
- ViewModel
- LifecycleScope
- Glide
- MVVM Architecture

---

## 🚀 How to Run

1. Clone this repository
2. Open in Android Studio
3. Build and run on Emulator or Android Device (API 24+)

---

## 💃 License

This project is free to use.
