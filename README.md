# Navigation Compose APP

### This is a study project about the Navigation Compose UI

In this APP have only one Activity, where navigation between screens is controlled.

The first screen to be opened is the `MainScreen`, where the `startDestination` attribute was passed to it.

<img src="https://user-images.githubusercontent.com/23016117/155796529-5812ae29-36d3-456b-856f-4b66e5a6cd61.png" width="200" height="400"/>


On the `MainScreen` screen we also observe the element passed by parameter by another screen.
In the image below, we have the representation of a value passed by parameter in the `onBackPressed` of the `ListScreen` screen:

<img src="https://user-images.githubusercontent.com/23016117/155797266-d69797ef-1e4b-46fb-9102-02e5b31e945e.png" width="200" height="400"/>

On the `ListScreen` screen we have a list of names, which, when clicking on any name, is redirected to the `DetailScreen` screen

When opening the `DetailScreen`, the `idUser` information is passed by `arguments` and in the `navigation route` is passed the name selected from the list.

<img src="https://user-images.githubusercontent.com/23016117/155798489-48e97536-fd09-45a6-ab04-8930d5075b4d.png" width="200" height="400"/>

Finally, the `DetailScreen` screen shows the name that was selected on the previous screen and also the value that was passed by `Bundle arguments`.

This screen also shows a button that redirects to a specific screen, which in this case is `MainScreen`, that is, when clicking on this button, it closes the `DetailScreen` and `ListScreen` screens and only `MainScreen` remains in the screen stack.

<img src="https://user-images.githubusercontent.com/23016117/155798563-e29f9aab-657b-4fd7-bf26-0fbc048c4292.png" width="200" height="400"/>
