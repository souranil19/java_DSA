# LinkedList Implementation

A Java implementation of a singly linked list with basic operations like insert and display.

## Project Structure

```
DSA_JAVA_PRACTICE/
└── linked_list/
    └── LinkedList.java
```

## How to Run

### Step 1: Navigate to the Project Directory
Open PowerShell and navigate to the root directory:
```powershell
cd E:\DSA_JAVA_PRACTICE
```

### Step 2: Compile the Java File
Compile the LinkedList.java file with the `-d .` flag to organize it into the package structure:
```powershell
javac -d . linked_list/LinkedList.java
```

This creates a `linked_list/LinkedList.class` file that matches the package declaration.

### Step 3: Run the Program
Execute the program using the full package name:
```powershell
java -cp . linked_list.LinkedList
```

### Expected Output
```
10 -> 20 -> 30 -> null
```

## Important Notes

- **Package Declaration**: The file contains `package linked_list;` which must match the directory structure. Do not remove this declaration.
- **Working Directory**: Always run the commands from the `E:\DSA_JAVA_PRACTICE` directory (the root folder containing the `linked_list` folder).
- **Classpath**: The `-cp .` (classpath) tells Java to look for classes in the current directory.

## Code Description

### LinkedList Class
- **insert(int data)**: Adds a new node with the given data at the end of the list.
- **display()**: Prints all elements in the linked list in order.
- **main()**: Entry point that creates a list, inserts three elements (10, 20, 30), and displays them.

### Node Class
A static inner class representing each node in the linked list:
- `data`: Stores the integer value
- `next`: Reference to the next node (null if it's the last node)
