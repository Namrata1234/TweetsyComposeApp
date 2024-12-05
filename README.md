TweetsyComposeApp

A Jetpack Compose-based Android application to display a list of categories and their associated tweets. Users can explore tweets by selecting categories, navigating through a seamless and modern UI. This project implements modern Android development best practices.

Features 

- Display a list of categories in a clean, user-friendly UI.
- Fetch and display tweets based on selected categories.
- A detailed view of tweets, showing all tweet attributes.
- MVVM architecture for separation of concerns and easy scalability.
- Dependency Injection with Hilt for modular and testable code.
- Networking powered by Retrofit with structured API calls.
- Coroutines for managing asynchronous tasks efficiently.
- Fully built using Jetpack Compose, ensuring dynamic, responsive UI.


Tech Stack Component	Description
- Jetpack Compose	UI toolkit for declarative UI and state management.
- Hilt	Dependency Injection for streamlined object creation and injection.
- Coroutines	Handling background operations and threading.
- Flow	Reactive streams for data handling and UI updates.
- MVVM Architecture	Ensures separation of UI, business logic, and data layers.
- Retrofit & OkHttp	Efficient networking for API integration.
- ViewModel & LiveData	Manages UI-related data in a lifecycle-aware manner.


App Structure
1. Presentation Layer
UI (Jetpack Compose):
Category List Screen: Displays a scrollable list of categories.
Tweets List Screen: Fetches and displays tweets based on the selected category.
Tweet Detail Screen: Showcases detailed tweet information.
2. Domain Layer
ViewModel:
Responsible for handling business logic and exposing UI state via StateFlow or LiveData.
Use Cases:
Fetch categories.
Retrieve tweets by category.
3. Data Layer
Repository:
Abstracts data sources and exposes them to ViewModels.
Integrates Retrofit API calls and Flow-based data streams.


