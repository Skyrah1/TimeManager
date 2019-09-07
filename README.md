# TimeManager
A scheduling app/reminder thingy with a cute jellyfish gif

# How it works
The application reads from a CSV file that stores different activities and when they are to be done. It then stores the data in a TreeMap, with the time as the key. When the current time matches with one of the keys, the interface is updated to remind the user. A pop-up window can be opened by clicking a button to update the schedule at any time.

# Limitations
- The schedule can't have multiple entries with the same time, as the time is used as the key.
- The schedule does not record what date the activity is to be carried out, only what time during the day. The app is intended only for daily activities, but this could change in the future.

# To-do list
- Update the interface to make it more user friendly
- Add more dynamic animation
- Add sounds
