-- Overview --
This is a simple text-based adventure game program that reads through a "Rooms.txt" file
and allows you to navigate through any given map of rooms.


-- mini2.controller.Room Format --
Rooms are defined in blocks of text which are separated by the ~ character
Each line of a block refers to an attribute of the room:
Line 1 - RoomId, a unique integer used for identification
Line 2 - mini2.controller.Room Name, a string value representing the room's name
Line 3 - mini2.controller.Room Description, a string value representing the room's description
Line 4 - Exit Directions, a list of four integers in the (N,S,E,W) format, representing the RoomId's of adjacent rooms


-- mini2.controller.Item Format --
Line 1 - Name, a string value for the name of the item
Line 2 - Description, a string value for the text displayed when examining the item



-- Commands --
* move north
* move south
* move east
* move west

* explore
* inventory
* pickup <item_name>
* drop <item_name>
* inspect <item_name>



-- Default GameMap Layout --
  _____   _____
 |  5  | |  6  |
 |_____| |_____|
  _____   _____   _____
 |  4  | |  1  | |  2  |
 |_____| |_____| |_____|
          _____
         |  3  |
         |_____|

mini2.controller.Room 1 = Desert Crossroads (mini2.controller.Item=Stick)
mini2.controller.Room 2 = Oasis Stream (mini2.controller.Item = Rusty Sword)
mini2.controller.Room 3 = Old Outpost
mini2.controller.Room 4 = Animal Tracks
mini2.controller.Room 5 = Large Rock
mini2.controller.Room 6 = Vibrant Oasis (mini2.controller.Item = Banana)
