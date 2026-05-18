# Java DSA Practice

Data-structure and algorithm practice in Java, organized by topic folders.

## Project Structure

```
/
├─ linked_list/
│  ├─ linked_list.java
│  └─ DoublyLL.java
├─ searching_algorithm/
│  └─ search.java
└─ sorting_algo/
   ├─ all_short_test.java
   ├─ bubble_sort.java
   └─ selection_short.java
```

## Features

- Singly linked list (menu-driven add/remove/print)
- Doubly linked list (menu-driven add/remove/print)
- Searching algorithms (linear + recursive binary search)
- Sorting algorithms (bubble, selection, plus a test runner)

## How to Run (PowerShell)

### Step 1: Go to the repo root
```powershell
cd "<repo-root>"
```

If your folder name has spaces, keep the quotes.

### Step 2: Compile and run what you need

#### Searching
```powershell
javac -d . searching_algorithm/search.java
java searching_algorithm.search
```

#### Sorting test runner
```powershell
javac -d . sorting_algo/all_short_test.java
java sorting_algo.all_short_test
```

#### Singly linked list (menu-driven)
```powershell
javac -d . linked_list/linked_list.java
java linked_list.linked_list
```

#### Doubly linked list (menu-driven)
```powershell
javac -d . linked_list/DoublyLL.java
java linked_list.DoublyLL
```

### Optional: Compile everything at once
```powershell
javac -d . linked_list/*.java searching_algorithm/*.java sorting_algo/*.java
```

## Notes

- **Package names match folders**. Keep `package linked_list;`, `package sorting_algo;`, and `package searching_algorithm;` aligned with their directories.
- **Run from repo root** so the classpath lines up with the package structure.
