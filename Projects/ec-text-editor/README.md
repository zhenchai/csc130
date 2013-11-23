#P-6.3

Write a simple text editor, which stores and displays a string of characters using the list ADT, together with a cursor object that highlights a position in this string. Your editor should support the following operations:

- left: Move cursor left one character (do nothing if at text end).
- right: Move cursor right one character (do nothing if at text end).
- cut: Delete the character right of the cursor (do nothing at text end).
- paste c: Insert the character c just after the cursor.