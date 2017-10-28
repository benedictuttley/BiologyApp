
CURRENT APPLICATION STATE:
--------------------------

- This application is not finished, currently the core framework of the app hierarchy is implemented and the various activities are
  partially linked, meaning that they can be accessed through onClick clisteners however no back button functionality has been added.
- The text and images for the topics and there components are currently being added to a SQLite database which will be shiped preloaded with
  the download. As a result currently there is a test database. Test images are hardcoded into the .XML layout files.
  
  
  
  
  TODO:
  ------
  - Have a test associated wih each activity with fill the gap questions only on first iteration
  - Complete 5 topic + components database entries
  - Create a logo
  - Design a more decriptive main activity, describing what the app does
  - Test adaptability to different screen resolutions and sizes
  
 
 
 
 
 
  DESCRIPTION:
  -----------
 
   - This is an android application currently without a title, that is a learning assist for biology students at GCSE or international        equivelant.
   - There is a hierarchial structure consisting of three classes:

 1) Topic - eg: Cell
 2) Structure - eg: Nucleus
 3) StructureComponent - eg: Nuclear Envelope

At each level the data contained within each object is displayed in a cardview container which is then wrapped in a RecyclerView. Currently
the user can move through the different topics and gain a basic understanding of the organisation of biological structures or proceeses,
the aim is not to be a substitute for school education, but mererly as a tool to gain a understanding the 'general picture' which will 
hopefully give users confidence about learning the more intricate workings of each topic as they will have a general understanding instead  of, as I found, learning content that was in signifiacant detail, without knowing its more general purpose which is just confusing!
