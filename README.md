# Pathfinding Application SHORTEST PATH  - USING A STAR AND DFS ALGORITHMS

# Overview
This application uses search algorithms to find the most efficient route between different cities in Palestine. 
The user inputs a source city and a destination city, and the program returns the best path, time complexity, running time, and total cost.
# Data
The application reads data from three CSV files:

Cities.csv: Contains a list of the selected cities/towns.
Roads.csv: Contains the road distances between each pair of cities.
AirDistance.csv: Contains the aerial distances between cities, which are used as a heuristic function for the A* algorithm.

# Algorithms
The application uses two different search algorithms to find the best route:

A*: A heuristic-based search algorithm that finds the least-cost path from a given initial node to one goal node.
DFS (Depth-First Search): An algorithm for traversing or searching tree or graph data structures. It starts at the root and explores as far as possible along each branch before backtracking.

# User Interface
The user interface allows the user to:

Select a source city and a destination city from a drop-down menu.
Run the pathfinding algorithm.
View the resulting path, the distance between each city on the path, and the total cost.
View the time complexity of the search operation and the actual runtime in milliseconds.

