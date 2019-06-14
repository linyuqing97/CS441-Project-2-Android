# CS441-Project-2-Android

This is the CS441 Second project created base on libGDX.

Objective:This project is base on android studio with a game API called libGDX. libGDX provides functionalities for responding users' gestrues with different animations such as tap, pan , rotation or changeing seting on an object.

In this project, I have implemented an equation called the bearcat magic function. What happens if a bear and a cat get together?  By implement this equation, I have created five sprites which is libGdx API allows me to display and play around the images/object on the screen. Then I have implemented an input processor with a gesture detector along to handle users' finger gestures on the screen. This interprocessor and gesture detector provides the functionalities to handle events such as moving the object around the screen, taping the screen with different responses from the program or rotation, zome the object. 
With the capabilities of moving object around the screen in mind, an idea pops up on my mind, what happens if two images combined? So, I implemented my Bearcat magic function by putting a "bear + cat = ? "form on the screen when users first launch the program. By setting up a gesture detector on the cat image, image cat now is an object that user can play around with.  The cat image will follow users finger movement on the screen. The cat will also pop up at users taping position on the screen or returns to it's inital position if double taping. Besides, users can rotate the cat image or long press the screen to change the brightness of the cat image. Most importantly, if users move the cat on top of the bear, the equation  result will pop up on the screen which is BEARCAT!!!(Sounds stupid , but I like bing and bearcat!)
This bearcat image is trigerd by collision handeling  using gdx rectangle API. This api tranfer two sprites into two rectangles. With rectangle overlaping check, if these two images are overlaped,  new sprite with bearcat image get loaded in and displays on top of all other sprites. Users can bring back the orignial function by double tapping the screen.  




Time line:
6/8 Created Github repository.
6/9 Created the project with libGdx.
6/11 Play around the libGdx touch handeler, create a blue doc which follow user's gestrue(No multitouch).
6/12 Added images on libgdx sprite, applied different animation on sprite including tap, pan, rotation.
6/13 Finalize the bearcat equation, set all images to it's corrent position. Implement collision handeler.Seted the bear and cat image into rectangles handelers. If the bear and cat image overlap to each others, a new bearcat image would pop up. 
