# README.md
** Version 1.0.0 **
--
## Contributors
Sanchita Kanade <sanchitamystudies@gmail.com>

## File manifest
  - README.md
  - ArrayPriQueue.java 
  - HeapPriQueue.java
  - IPriorityQueue.java
  - IQueue.java 
  - UnorderedPriQueue.java
  - App.java (main class)
   
## Project Description

A.  This program contains three different implementations of Priority Queue:
1) Array based Priority Queue - In this implementation elements are inserted into the queue in sorted order using 
Binary Search algorithm and elements are always removed from the head of the queue.
2) Unordered priority queue - In this implementation elements are appended at the end of the queue and during poll operation
element with lowest priority is removed.
3) Heap based priority queue - This implementation uses Priority Queue implemented in Java libraries.
elements are inserted at the end of the priority queue and elements are always removed from head of the queue.

B. This program compares efficiency of three priority queue implementations, based on time required for each of them 
for enqueue and poll operations when input size is doubled.

C. This program also uses testReverseOrderedInput() and testSortedInput() methods to test the affect of Reverse sorted input 
and sorted input on Priority Queue operations.
	 
## Getting Started

### Prerequisites

 To run this program user required to have any Java IDE and git (Distributed Version Control System).

### Installation
I am using eclipse, java IDE and a web based git platform 'github.com'
1. Go to the following website
   https://ninite.com/
2. Select proper JDK and eclipse, then click on 'Get your Ninite'. 
3. Download and install eclipse and JDK.
4. Go to https://github.com/ and create an account.
5. Open a git perspective in the eclipse on your computer
6. Clone this repository into eclipse IDE using option 'Clone a Git Repository and add a clone to this view'.
7. Switch over to java perspective -> right click -> select import -> select 'Projects from Git' -> next
8. select 'Existing local repository' -> next -> JavaProjects -> next
9. select 'Import using the New Project wizard' -> click on 'Finish'
10. Java Project -> next -> Give project name -> Bowse the location of JavaProjects repository on your local machine 
instead of using default location -> Finish.
11. Run the project

