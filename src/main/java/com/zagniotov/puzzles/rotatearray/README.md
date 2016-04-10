Given an array 6x6:

|    |    |    |    |    |    |
|----|----|----|----|----|----|
| __1__  | __2__  | __3__  | 4   | 5   | 6  |
| __7__  | __8__  | __9__     | 10  | 11  | 12 |   
| __13__ | __14__ | __15__    | 16  | 17  | 18 |   
| 19  | 20  | 21  | 22  | 23  | 24  |   
| 25  | 26  | 27  | 28  | 29  | 30  |  
| 31  | 32  | 33  | 34  | 35  | 36  |

The nested loop iterates over an `array.length / 2` in `y/rows` and `x/columns` directions. 

In others words, a `quarter` of the above 2D array (see the numbers in bold):

The values cached in the constant space in each iteration in the following order (if rotating click-wise):

1 -> 2 -> 3 ->

7 -> 8 -> 9 -> 

13 -> 14 -> 15 
