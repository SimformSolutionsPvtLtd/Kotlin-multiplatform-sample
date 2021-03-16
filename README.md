# KMM First Look

### What is Kotlin Multiplatform (KMP)

* Kotlin Multiplatform allows you share your business logic on multiple platforms like JavaScript, iOS, and native desktop applications and as a result reducing the amount of time required for development.

### Now what is Kotlin Multiplatform Mobile (KMM) ?

* Kotlin Multiplatform (KMP) and Kotlin Multiplatform Mobile (KMM) are not seperate technologies. You can think of Kotlin Multiplatform Mobile (KMM) as a subset of Kotlin Multiplatform (KMP) which primarily focuses on mobile features. Kotlin Multiplatform Mobile (KMM) uses the multiplatform capabilities of kotlin to share bussiness logic of iOS and Android apps.

## Why Kotlin Multiplatform Mobile (KMM) ?

*  Using KMM we can write our business logic once and reuse that for both the platforms android and iOS. We only need to write our platform specific code wherever it's necessary for example to implement our native UI. Does that mean we can have a single application which can run on both Android and iOS app using KMM ? No KMM is specifically design to share only business logic and use native UI to have exact look and feel as simple Android or iOS app. So we still need to create seperate applications for both the platforms.

### About this project. 
This is a sample KMM project which tries to shares as much as code possible between Android and iOS. 

Android App                          |  iOS App
:-------------------------:|:-------------------------:
<img src="https://github.com/SimformSolutionsPvtLtd/Kotlin-multiplatform-sample/blob/feature/update_readme/screenshots/android.gif" width="400" height="800">  | <img src="https://github.com/SimformSolutionsPvtLtd/Kotlin-multiplatform-sample/blob/feature/update_readme/screenshots/iOS.gif" width="400" height="800">

## Pre-requisites
* Android Studio – version 4.2 or higher.
* Xcode – version 11.3 or higher.
* This app displays a list of movies using API from TMDB so you must have a valid api key from TMDB. (If you don't have one you can get it here :- https://www.themoviedb.org/documentation/api)

### How to Run Android App :- 
* Open Android Studio 
* Add KMM Plugin from `Android Studio` -> `Preferences` -> `Plugins` -> `MarketPlace` -> `Search for Kotlin Multiplatform Mobile` -> `Install and Restart Android Studio`
 <img src = https://github.com/SimformSolutionsPvtLtd/Kotlin-multiplatform-sample/blob/feature/update_readme/screenshots/KMM%20Plugin.png>
* Run app. 

### How to Run iOS App :-

* Pretty Simple KMM allows you to run and debug your iOS App from Android Studio itself. Just switch from `androidApp` to `iosApp` in your run configurations menu. (Remember :- This app contains `Pods` so we need to install that from Terminal first before running iOS app from Android Studio or xCode) 
* <img src = https://github.com/SimformSolutionsPvtLtd/Kotlin-multiplatform-sample/blob/feature/update_readme/screenshots/Run%20Configurations.png>
* Does that mean you can simply run iOS App without xCode or macOS machine ? No You still need a macOS ,  xCode (and Simulators) and command line tools installed on your machine to run your iOS App. 
* Also you can run this project with xCode.
* Open `iosApp` folder from the project install `pods` with terminal open `.xcworkspace` and run your application. 

## Find this example useful? :heart:
Support it by joining __[stargazers](https://github.com/SimformSolutionsPvtLtd/Kotlin-multiplatform-sample/stargazers)__ for this repository. :star:

## 🤝 How to Contribute

Whether you're helping us fix bugs, improve the docs, or a feature request, we'd love to have you! :muscle:

Check out our [**Contributing Guide**](https://github.com/SimformSolutionsPvtLtd/Kotlin-multiplatform-sample/blob/master/CONTRIBUTING.md) for ideas on contributing.

## Bugs and Feedback

For bugs, feature requests, and discussion please use [GitHub Issues](https://github.com/SimformSolutionsPvtLtd/Kotlin-multiplatform-sample/issues).

### LICENSE
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details
