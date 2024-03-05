// CSCI 211, Section 1
// Azizbek Kilichov
// Student ID 10923170
// Program 1
// Due 2/21/2024
// In keeping with the UM Honor Code, I have neither given nor
// received assistance from anyone other than the instructor/TA/tutor.
// The program analyzes and categorizes individuals into personality types such as lion, otter, retriever, and beaver
// based on input data that has been already uploaded.

package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Personality {
    private int lion;
    private int otter;
    private int retriever;
    private int beaver;
    private String filename;
    private String lastName;
    private ArrayList<ArrayList<String>> csci211;

    public Personality(String filename) throws FileNotFoundException {
        this.lion = 0;
        this.beaver = 0;
        this.otter = 0;
        this.retriever = 0;
        this.filename = filename;
        this.lastName = "";
        this.csci211 = new ArrayList<>();
    }
    public Personality(String filename, String name) throws FileNotFoundException {
        this.lion = 0;
        this.beaver = 0;
        this.otter = 0;
        this.retriever = 0;
        this.filename = filename;
        this.lastName = name;
        this.csci211 = new ArrayList<>();
    }

    /**
     * SETTERS - GIVEN
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setLion(int lion) {
        this.lion = lion;
    }

    public void setOtter(int otter) {
        this.otter = otter;
    }

    public void setRetriever(int retriever) {
        this.retriever = retriever;
    }

    public void setBeaver(int beaver) {
        this.beaver = beaver;
    }

    /**
     * method setPersonalityType: determines animal type
     *  If there is a tie, both should be listed.
     *  NOTE: When there is more than one ordering should always be Lion, Otter, Golden_Retriever, Beaver
     *        e.g., if you determine that otter and beaver are the two types, "Otter" should be at index 0
     *                                                                        "Beaver" should be at index 1
     */
    public ArrayList<String> setPersonalityType() {

        // TODO:  Return an ArrayList of the animal personality type(s) - largest number(s) wins.
        //        You should use the lion, otter, retriever and beaver instance variables te determine animal
        //        Possible animals: "Lion", "Otter", "Golden_Retriever", "Beaver"
        //        NOTE: If there is a tie then fill in as "Lion", "Otter", "Golden_Retriever",
        //        "Beaver", in that order (again, depends on which animals are ties)

        // Initialize an ArrayList to store personality types
        ArrayList<String> types = new ArrayList<>();
            // Finding the highest score
        int highestScore = Math.max(Math.max(lion, otter), Math.max(retriever, beaver));
             // We will check each personality types and if it matches the highest score, add to types list
        if (highestScore > 0) {
            if (lion == highestScore) {
                types.add("Lion");
            }
            if (otter == highestScore) {
                types.add("Otter");
            }
            if (retriever == highestScore) {
                types.add("Golden_Retriever");
            }
            if (beaver == highestScore) {
                types.add("Beaver");
            }
        }
        return types;
    }

/**
 * method analyze: steps through input file and determines each person's animal personality type
 * Determine lion, otter, retriever, and beaver scores
 */




    public void analyze() throws FileNotFoundException {

        // TODO:  Populate the csci211 ArrayList of ArrayLists by reading in data from filename
        //        For each student,
        //             a. reset lion, otter, golden_retriever and beaver instance variables to 0
        //             b. for this student, index 0 is the student's last name (each student uses 11 rows - this is their first line)/        //             c. assign lion, otter, golden_retriever and beaver instance variables for this student by
        //                processing next 10 rows (student's answers to animal personality test)
        //                NOTE: You need the values of these instance variable because you will be calling setPersonalityTypes
        //             d. invoke/call setPersonalityType method to determine this student's animal personality type(s).  Populate this students index 1.
        //                NOTE: If there is a tie, then add the additional types to index 2, 3, and/or 4 depending on the number of ties
        //        NOTE: Fill in as "Lion", "Otter", "Golden_Retriever" and/or "Beaver" (again, depends on which animals are ties)


        Scanner scanner;
        // If can't find the file, throw Exception
        try {
            scanner = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            throw e;
        }

        // Read each line of the CSV file
        while (scanner.hasNextLine()) {
            String lastName = scanner.nextLine().trim();
            lion = 0;
            otter = 0;
            retriever = 0;
            beaver = 0;

            // Read the next 10 lines for the student's answers
            for (int i = 0; i < 10; i++) {
                if (!scanner.hasNextLine()) break; // If there are no more lines, break the loop

                String[] answers = scanner.nextLine().split(",");
                lion += Integer.parseInt(answers[0].trim());
                otter += Integer.parseInt(answers[1].trim());
                retriever += Integer.parseInt(answers[2].trim());
                beaver += Integer.parseInt(answers[3].trim());
            }

            ArrayList<String> personalityTypes = setPersonalityType();

            // Create a new ArrayList to store the last name and personality types
            ArrayList<String> studentInfo = new ArrayList<>();
            studentInfo.add(lastName);
            studentInfo.addAll(personalityTypes);

            // Add the student's info to the class-level ArrayList
            csci211.add(studentInfo);
        }

        scanner.close();
    }




    /**
     * method getClassPersonalityTypes: lists each person's last name and their animal personality type(s)
     * @return
     */

    public String getClassPersonalityTypes() {

        // TODO: Step through the csci211 ArrayList
        //       Output student last name
        //       Output space:animalType   do for each of this student's animal personality type(s)
        //       After each student output a newline
        //       e.g.,  For me I would output "Davidson :Beaver"
        //       e.g.,  If it is me and LO (look at twoStudents.csv), the output would be
        //       Davidson :Beaver
        //       LO :Lion :Otter
        //  ASSUME the analyze method has been called - DO NOT call within this method

        StringBuilder output = new StringBuilder();

        for (ArrayList<String> studentInfo : csci211) {
            // Append the student's last name followed by a colon and a space
            output.append(studentInfo.get(0)).append(" :");
            for (int i = 1; i < studentInfo.size(); i++) {
                output.append(studentInfo.get(i));
                if (i < studentInfo.size() - 1) {
                    output.append(" :");
                }
            }
            output.append("\n");
        }
        return output.toString();
    }


    /**
     * method countClassTypes: determines the number of Lions, Otters, Golden_Retrievers and Beavers in the class
     * @return
     * @throws FileNotFoundException
     */

    public String countClassTypes() {

        // TODO:  Add up the total number of Lions, Otters, Golden_Retrievers and Beavers
        //  NOTE: Use the instance variables lion, otter, retriever and beaver to do this (be sure to initialize them as 0)
        //  ASSUME the analyze method has been called - DO NOT call within this method

        lion = 0;
        otter = 0;
        retriever = 0;
        beaver = 0;

        for (ArrayList<String> studentInfo : csci211) {
            // The personality types start from index 1 as index 0 contains the last name
            for (int i = 1; i < studentInfo.size(); i++) {
                switch (studentInfo.get(i)) {
                    case "Lion":
                        lion++;
                        break;
                    case "Otter":
                        otter++;
                        break;
                    case "Golden_Retriever":
                        retriever++;
                        break;
                    case "Beaver":
                        beaver++;
                        break;
                }
            }
        }

        // Construct the result string
        return "Lions: " + lion + "\n" +
                "Otters: " + otter + "\n" +
                "Golden_Retrievers: " + retriever + "\n" +
                "Beavers: " + beaver + "\n";
    }


    /**
     * method mostCommonType: method that determines the most common type in the class
     * @return
     */


    public String mostCommonType() {

        StringBuilder output = new StringBuilder();
        int l = 0;
        int o = 0;
        int b = 0;
        int g = 0;

        for(int i = 0; i < csci211.size(); i++) {
            if(csci211.get(i).contains("Lion")) {
                l++;
            }
            if(csci211.get(i).contains("Otter")) {
                o++;
            }
            if(csci211.get(i).contains("Beaver")) {
                b++;
            }
            if(csci211.get(i).contains("Golden_Retriever")) {
                g++;
            }
        }

        int maxCount = Math.max(Math.max(l, o), Math.max(g, b));

        // Check if each personality type count equals the max count and append it to the output
        if (maxCount > 0) {
            if (maxCount == l) {
                output.append("Lion ");
            }
            if (maxCount == o) {
                output.append("Otter ");
            }
            if (maxCount == g) {
                output.append("Golden_Retriever ");
            }
            if (maxCount == b) {
                output.append("Beaver ");
            }
        }
        return output.toString();
    }


    /**
     * method similarity: list name(s) of your personality type and all students with that same type
     * @return
     */

    public String similarity() {

        // TODO:  Step through csci211 and list everyone's last name, including yours, that has the same animal personality type
        //        If there is a tie, you need to list all your personality types.
        //        I recommend using ArrayList's "contains" method
        //        You should list the personality type: and a newline. And each student last name and new line
        //   ERROR CHECKING: If the name of the person not found (you can't find who is similar to them!)
        //        e.g., If I am OGB (look at the file fivestudents.csv), I have 3 animal personality types so I would expect the following output
        //        Otter:
        //        LO
        //        OGB
        //        Golden_Retriever:
        //        OGB
        //        GB
        //        Golden_Retriever (note that this is the "student" name)
        //        Beaver:
        //        Davidson
        //        OGB
        //        GB

        // Find the student's personality types
        ArrayList<String> myTypes = new ArrayList<>();
        for (ArrayList<String> studentInfo : csci211) {
            if (studentInfo.get(0).equals(lastName)) {
                myTypes.addAll(studentInfo.subList(1, studentInfo.size()));
                break;
            }
        }

        // Check if the student was found
        if (myTypes.isEmpty()) {
            throw new InvalidPersonalityException();
        }
        StringBuilder output = new StringBuilder();

        for (String type : myTypes) {
            output.append(type).append(":\n");
            for (ArrayList<String> studentInfo : csci211) {
                // If this student has a matching type, add their name to the output
                if (studentInfo.subList(1, studentInfo.size()).contains(type)) {
                    output.append(studentInfo.get(0)).append("\n");
                }
            }
        }

        return output.toString();
    }


}
