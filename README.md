# Personality-Analyzer
### Overview

The Personality Analyzer is a Java program designed for CSCI 211 Spring 2024 that analyzes and categorizes individuals into different personality types. These personality types are represented by animals: Lion, Otter, Golden Retriever, and Beaver. The program reads input data from CSV files, where each row corresponds to a student's answers to an animal personality test.

### Components

#### 1. Personality Class

The `Personality` class is the core of the program, containing methods to analyze data, determine personality types, and provide insights about the class.

##### Constructors

- `Personality(String filename) throws FileNotFoundException`: This constructor initializes the class with the filename of the CSV file containing personality test data. It throws a `FileNotFoundException` if the file is not found.
- `Personality(String filename, String name) throws FileNotFoundException`: This constructor, similar to the first one, also allows the specification of a last name for similarity checks.

##### Methods

- `analyze() throws FileNotFoundException`: The `analyze` method reads data from the CSV file provided in the constructor. It processes each student's answers and determines their personality types using the `setPersonalityType` method.
- `setPersonalityType()`: This method determines the dominant personality type(s) for a student based on their test scores. If there is a tie, multiple personality types are listed in order: Lion, Otter, Golden Retriever, and Beaver.
- `getClassPersonalityTypes()`: The `getClassPersonalityTypes` method generates a formatted string listing each student's last name and their corresponding personality type(s).
- `countClassTypes()`: The `countClassTypes` method counts the total number of each personality type in the class and returns a formatted string.
- `mostCommonType()`: The `mostCommonType` method identifies the most common personality type(s) in the class and returns a formatted string.
- `similarity()`: The `similarity` method lists the last names of students with the same personality type(s) as the user. It identifies the user's personality types and then finds other students with matching types.

#### 2. PersonalityDriver Class

The `PersonalityDriver` class serves as the entry point to the program. It demonstrates the usage of the `Personality` class by analyzing individual and class data.

##### Main Method

- `main(String[] args) throws FileNotFoundException`: The `main` method creates an instance of the `Personality` class, analyzes individual and class data, and prints out the results. It showcases how to use various methods of the `Personality` class, such as `getClassPersonalityTypes`, `countClassTypes`, and `similarity`.

### Getting Started

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/your-username/PersonalityAnalyzer.git
   ```

2. **Open the Project:**
   Open the project in your preferred Java development environment.

3. **Run the Program:**
   Run the `PersonalityDriver` class to see the analysis results.

### Contributing

If you'd like to contribute to this project:

- Fork the repository.
- Make improvements or add features.
- Submit a pull request.

### License

This project is licensed under the MIT License. See the [LICENSE.md](LICENSE.md) file for details.

Enjoy exploring personalities with the Personality Analyzer!
