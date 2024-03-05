package org.example;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PersonalityTest_Student {
    @Test
    public void testsetPersonalityType1() throws FileNotFoundException {
        Personality evaluator = new Personality("Kilichov.csv", "Kilichov");
        evaluator.setLion(1);
        ArrayList<String> temp = evaluator.setPersonalityType();
        String output = "";
        for(String oneAnimal: temp)
            output += " :" + oneAnimal;
        assertEquals(" :Lion", output);
    }

    @Test
    public void testsetPersonalityType5() throws FileNotFoundException {
        Personality evaluator = new Personality("Kilichov.csv", "Kilichov");
        evaluator.setBeaver(1);
        evaluator.setLion(1);
        ArrayList<String> temp = evaluator.setPersonalityType();
        String output = "";
        for(String oneAnimal: temp)
            output += " :" + oneAnimal;
        assertEquals(" :Lion :Beaver", output);
    }
    @Test
    public void testsetPersonalityType6() throws FileNotFoundException {
        Personality evaluator = new Personality("Davidson.csv", "Davidson");
        evaluator.setRetriever(1);
        evaluator.setOtter(1);
        ArrayList<String> temp = evaluator.setPersonalityType();
        String output = "";
        for(String oneAnimal: temp)
            output += " :" + oneAnimal;
        assertEquals(" :Otter :Golden_Retriever", output);
    }
    @Test
    public void testsetPersonalityType7() throws FileNotFoundException {
        Personality evaluator = new Personality("Davidson.csv", "Davidson");
        evaluator.setRetriever(1);
        evaluator.setOtter(1);
        evaluator.setLion(1);
        ArrayList<String> temp = evaluator.setPersonalityType();
        String output = "";
        for(String oneAnimal: temp)
            output += " :" + oneAnimal;
        assertEquals(" :Lion :Otter :Golden_Retriever", output);
    }

    @Test
    public void testsetPersonalityType8() throws FileNotFoundException {
        Personality evaluator = new Personality("Kilichov.csv", "Kilichov");
        evaluator.setRetriever(1);
        evaluator.setBeaver(1);
        evaluator.setLion(1);
        evaluator.setOtter(1);
        ArrayList<String> temp = evaluator.setPersonalityType();
        String output = "";
        for(String oneAnimal: temp)
            output += " :" + oneAnimal;
        assertEquals(" :Lion :Otter :Golden_Retriever :Beaver", output);
    }
    @Test
    public void testGetClassPersonalityTypes1() throws FileNotFoundException {
        Personality evaluator = new Personality("Kilichov.csv");
        evaluator.analyze();
        assertEquals("Kilichov :Beaver\n", evaluator.getClassPersonalityTypes());
    }

    @Test
    public void testGetClassPersonalityTypes4() throws FileNotFoundException {
        Personality evaluator = new Personality("fiveStudents.csv");
        evaluator.analyze();
        assertEquals("Davidson :Beaver\n" +
                "LO :Lion :Otter\n" +
                "OGB :Otter :Golden_Retriever :Beaver\n" +
                "GB :Golden_Retriever :Beaver\n" +
                "Golden_Retriever :Golden_Retriever\n", evaluator.getClassPersonalityTypes());
    }

    @Test
    public void testGetClassPersonalityTypes5() throws FileNotFoundException {
        Personality evaluator = new Personality("csci211_S24.csv");
        evaluator.analyze();
        assertEquals("Davidson :Beaver\n" +
                "Anderson :Beaver\n" +
                "Scott :Otter\n" +
                "Fabra :Lion\n" +
                "Kilichov :Beaver\n" +
                "Kamler :Beaver\n" +
                "Britt :Lion\n" +
                "Njiti :Beaver\n" +
                "Abdullokh :Beaver\n" +
                "Laughton :Lion\n" +
                "Swetman :Lion\n" +
                "Callaway :Beaver\n" +
                "Furr :Otter\n" +
                "DuCharme :Golden_Retriever\n" +
                "Turner :Lion\n" +
                "Jimenez :Golden_Retriever\n" +
                "McNeer :Lion\n" +
                "Bufkin :Lion :Golden_Retriever\n" +
                "Gangwer :Golden_Retriever\n" +
                "Pandit :Beaver\n" +
                "Devivo :Beaver\n" +
                "Chamulak :Lion\n" +
                "Jones-Reed :Beaver\n" +
                "Kelchner :Golden_Retriever\n" +
                "Meijer :Lion\n" +
                "Williams :Lion\n" +
                "Bourgeois :Lion\n" +
                "May :Golden_Retriever\n" +
                "Geron :Golden_Retriever\n" +
                "Zosel :Beaver\n" +
                "Palmer :Lion\n" +
                "Oakes :Beaver\n" +
                "DeBruyn :Golden_Retriever\n" +
                "Lindsay :Beaver\n" +
                "Roach :Otter :Golden_Retriever\n" +
                "Perera :Otter\n" +
                "Zachary :Beaver\n" +
                "Lee :Lion\n" +
                "Nogueira :Beaver\n", evaluator.getClassPersonalityTypes());
    }

    @Test
    public void testCountClassTypes1() throws FileNotFoundException {
        Personality evaluator = new Personality("Kilichov.csv");
        evaluator.analyze();
        assertEquals("Lions: 0\n" +
                "Otters: 0\n" +
                "Golden_Retrievers: 0\n" +
                "Beavers: 1\n", evaluator.countClassTypes());
    }

    @Test
    public void testCountClassTypes4() throws FileNotFoundException {
        Personality evaluator = new Personality("fiveStudents.csv");
        evaluator.analyze();
        assertEquals("Lions: 1\n" +
                "Otters: 2\n" +
                "Golden_Retrievers: 3\n" +
                "Beavers: 3\n", evaluator.countClassTypes());
    }
    // Whole Class
    @Test
    public void testCountClassTypes5() throws FileNotFoundException {
        Personality evaluator = new Personality("csci211_S24.csv");
        evaluator.analyze();
        assertEquals("Lions: 13\n" +
                "Otters: 4\n" +
                "Golden_Retrievers: 9\n" +
                "Beavers: 15\n", evaluator.countClassTypes());
    }
    @Test
    public void testMostCommonTypes1() throws FileNotFoundException {
        Personality evaluator = new Personality("Kilichov.csv");
        evaluator.analyze();
        assertEquals("Beaver ", evaluator.mostCommonType());
    }

    @Test
    public void testMostCommonTypes4() throws FileNotFoundException {
        Personality evaluator = new Personality("fiveStudents.csv");
        evaluator.analyze();
        assertEquals("Golden_Retriever Beaver ", evaluator.mostCommonType());
    }

    // NOTE: The animal name has a : (colon). The last names of those with this
    //       personality type are listed.  If there is more than one personality type
    //       then if follows immediately on the next line - again, a : (colon) is after the animal
    @Test
    public void testSimilarity1() throws FileNotFoundException {
        Personality evaluator = new Personality("Kilichov.csv", "Kilichov");
        evaluator.analyze();
        assertEquals("Beaver:\n" +
                "Kilichov\n", evaluator.similarity());
    }

    @Test
    public void testSimilarity7() throws FileNotFoundException {
        Personality evaluator = new Personality("fiveStudents.csv", "Davidson");
        evaluator.analyze();
        assertEquals("Beaver:\n" +
                "Davidson\n" +
                "OGB\n" +
                "GB\n", evaluator.similarity());
    }
    @Test
    public void testSimilarity8() throws FileNotFoundException {
        Personality evaluator = new Personality("fiveStudents.csv", "LO");
        evaluator.analyze();
        assertEquals("Lion:\n" +
                "LO\n" +
                "Otter:\n" +
                "LO\n" +
                "OGB\n", evaluator.similarity());
    }
    @Test
    public void testSimilarity10() throws FileNotFoundException {
        Personality evaluator = new Personality("fiveStudents.csv", "GB");
        evaluator.analyze();
        assertEquals("Golden_Retriever:\n" +
                "OGB\n" +
                "GB\n" +
                "Golden_Retriever\n" +
                "Beaver:\n" +
                "Davidson\n" +
                "OGB\n" +
                "GB\n", evaluator.similarity());
    }

    //Whole Class
     @Test
    public void testSimilarity13() throws FileNotFoundException {
        Personality evaluator = new Personality("csci211_S24.csv", "Perera");
        evaluator.analyze();
        assertEquals("Otter:\n" +
                "Scott\n" +
                "Furr\n" +
                "Roach\n" +
                "Perera\n", evaluator.similarity());
    }
    @Test
    public void testSimilarity14() throws FileNotFoundException {
        Personality evaluator = new Personality("csci211_S24.csv", "Geron");
        evaluator.analyze();
        assertEquals("Golden_Retriever:\n" +
                "DuCharme\n" +
                "Jimenez\n" +
                "Bufkin\n" +
                "Gangwer\n" +
                "Kelchner\n" +
                "May\n" +
                "Geron\n" +
                "DeBruyn\n" +
                "Roach\n", evaluator.similarity());
    }
    @Test
    public void testSimilarity15() throws FileNotFoundException {
        Personality evaluator = new Personality("csci211_S24.csv", "Oakes");
        evaluator.analyze();
        assertEquals("Beaver:\n" +
                "Davidson\n" +
                "Anderson\n" +
                "Kilichov\n" +
                "Kamler\n" +
                "Njiti\n" +
                "Abdullokh\n" +
                "Callaway\n" +
                "Pandit\n" +
                "Devivo\n" +
                "Jones-Reed\n" +
                "Zosel\n" +
                "Oakes\n" +
                "Lindsay\n" +
                "Zachary\n" +
                "Nogueira\n", evaluator.similarity());
    }



    /// ---------------------------------------------------------------------------

    // Test with all scores set to 0
    @Test
    public void testAllScoresZero() throws FileNotFoundException {
        Personality evaluator = new Personality("fiveStudents.csv", "Empty");
        evaluator.setLion(0);
        evaluator.setOtter(0);
        evaluator.setRetriever(0);
        evaluator.setBeaver(0);
        ArrayList<String> temp = evaluator.setPersonalityType();
        assertTrue(temp.isEmpty(), "Expected no personality types when all scores are 0");
    }

    // Test with extremely high scores
    @Test
    public void testHighScores() throws FileNotFoundException {
        Personality evaluator = new Personality("fiveStudents.csv", "HighScore");
        evaluator.setLion(10000);
        evaluator.setOtter(20000);
        evaluator.setRetriever(15000);
        evaluator.setBeaver(5000);
        ArrayList<String> temp = evaluator.setPersonalityType();
        String output = "";
        for(String oneAnimal: temp)
            output += " :" + oneAnimal;
        assertEquals(" :Otter", output);
    }

    // Test with negative scores
    @Test
    public void testNegativeScores() throws FileNotFoundException {
        Personality evaluator = new Personality("negativeScores.csv", "Negative");
        evaluator.setLion(-1);
        evaluator.setOtter(-2);
        evaluator.setRetriever(-3);
        evaluator.setBeaver(-4);
        ArrayList<String> temp = evaluator.setPersonalityType();
        assertTrue(temp.isEmpty(), "Expected no personality types when all scores are negative");
    }

    // Test with only one personality type having a non-zero score
    @Test
    public void testSingleNonZeroScore() throws FileNotFoundException {
        Personality evaluator = new Personality("singleNonZero.csv", "SingleNonZero");
        evaluator.setLion(10);
        ArrayList<String> temp = evaluator.setPersonalityType();
        assertEquals(" :Lion", " :" + String.join(" :", temp), "Expected Lion to be the only personality type");
    }

    // Test with two personality types tied for the highest score, excluding the ones already tested
    @Test
    public void testTwoWayTieDifferent() throws FileNotFoundException {
        Personality evaluator = new Personality("twoWayTie.csv", "TwoWay");
        evaluator.setRetriever(5);
        evaluator.setBeaver(5);
        ArrayList<String> temp = evaluator.setPersonalityType();
        assertEquals(" :Golden_Retriever :Beaver", " :" + String.join(" :", temp), "Expected Golden Retriever and Beaver to be tied");
    }

    // Test with three personality types tied for the highest score, with different combinations from those already tested
    @Test
    public void testThreeWayTieDifferent() throws FileNotFoundException {
        Personality evaluator = new Personality("threeWayTie.csv", "ThreeWay");
        evaluator.setLion(3);
        evaluator.setRetriever(3);
        evaluator.setBeaver(3);
        ArrayList<String> temp = evaluator.setPersonalityType();
        assertEquals(" :Lion :Golden_Retriever :Beaver", " :" + String.join(" :", temp), "Expected Lion, Golden Retriever, and Beaver to be tied");
    }

    // Test `analyze` method with an empty file
    @Test
    public void testAnalyzeEmptyFile() throws FileNotFoundException {
        Personality evaluator = new Personality("azka.csv");
        evaluator.analyze();
        assertEquals("", evaluator.getClassPersonalityTypes().trim(), "Expected no output from an empty file");
    }

    // Test `analyze` method with a file containing only one student's data
    @Test
    public void testAnalyzeOneStudent() throws FileNotFoundException {
        Personality evaluator = new Personality("Kilichov.csv");
        evaluator.analyze();
        assertTrue(evaluator.getClassPersonalityTypes().contains("Kilichov"), "Expected output to contain the single student's data");
    }

    // Te3,4,3,3st `analyze` method with a file where some lines are missing for a student
    @Test
    public void testAnalyzeIncompleteData() throws FileNotFoundException {
        Personality evaluator = new Personality("Kilichov.csv");
        evaluator.analyze();
        assertTrue(evaluator.getClassPersonalityTypes().trim().endsWith("Incomplete"), "Expected the last entry to be for the student with incomplete data");
    }

    // Test `getClassPersonalityTypes` with no students analyzed
    @Test
    public void testGetClassPersonalityTypesNoAnalyze() throws FileNotFoundException {
        Personality evaluator = new Personality("noAnalyze.csv");
        assertEquals("", evaluator.getClassPersonalityTypes().trim(), "Expected no output when no students have been analyzed");
    }

    // Test `countClassTypes` immediately after initialization, without calling `analyze`
    @Test
    public void testCountClassTypesNoAnalyze() throws FileNotFoundException {
        Personality evaluator = new Personality("noAnalyzeCount.csv");
        assertEquals("Lions: 0\nOtters: 0\nGolden_Retrievers: 0\nBeavers: 0\n", evaluator.countClassTypes(), "Expected all counts to be zero before analysis");
    }

    // Test `mostCommonType` with multiple types tied for the most common, with different combinations from those already tested
    @Test
    public void testMostCommonTypeTieDifferent() throws FileNotFoundException {
        Personality evaluator = new Personality("fiveStudents.csv");
        evaluator.analyze();
        assertTrue(evaluator.mostCommonType().contains("Beaver") && evaluator.mostCommonType().contains("Golden_Retriever"), "Expected Lion and Otter to be the most common types");
    }

    // Test `similarity` method for a student whose name is not in the list
    @Test
    public void testSimilarityNameNotFound() throws FileNotFoundException {
        Personality evaluator = new Personality("nameNotFound.csv", "NotFound");
        evaluator.analyze();
        assertThrows(InvalidPersonalityException.class, evaluator::similarity, "Expected an exception when the student's name is not found");
    }



    // Test with input where the scores for each type are in descending order
    @Test
    public void testScoresDescendingOrder() throws FileNotFoundException {
        Personality evaluator = new Personality("descendingScores.csv", "Descending");
        evaluator.setLion(4);
        evaluator.setOtter(3);
        evaluator.setRetriever(2);
        evaluator.setBeaver(1);
        ArrayList<String> temp = evaluator.setPersonalityType();
        assertEquals(" :Lion", " :" + String.join(" :", temp), "Expected Lion to be the dominant personality type");
    }

    // Test with input where the scores for each type are in ascending order
    @Test
    public void testScoresAscendingOrder() throws FileNotFoundException {
        Personality evaluator = new Personality("ascendingScores.csv", "Ascending");
        evaluator.setLion(1);
        evaluator.setOtter(2);
        evaluator.setRetriever(3);
        evaluator.setBeaver(4);
        ArrayList<String> temp = evaluator.setPersonalityType();
        assertEquals(" :Beaver", " :" + String.join(" :", temp), "Expected Beaver to be the dominant personality type");
    }

    // Test `mostCommonType` for a class where every type has exactly one representative
    @Test
    public void testMostCommonTypeAllEqual() throws FileNotFoundException {
        Personality evaluator = new Personality("azka.csv");
        evaluator.analyze();
        String result = evaluator.mostCommonType();
        assertTrue(result.contains("Lion") && result.contains("Otter") && result.contains("Golden_Retriever") && result.contains("Beaver"), "Expected all types to be equally most common");
    }

    // Test `getClassPersonalityTypes` with students having the same scores across all personality types
    @Test
    public void testClassPersonalityTypesAllEqualScores() throws FileNotFoundException {
        Personality evaluator = new Personality("azka.csv");
        evaluator.analyze();
        assertTrue(evaluator.getClassPersonalityTypes().contains("Lion :Otter :Golden_Retriever :Beaver"), "Expected all personality types listed for students with equal scores");
    }

    // Test the entire workflow with a custom CSV file designed to test edge cases
    @Test
    public void testEc() throws FileNotFoundException  {
        Personality evaluator = new Personality("azaka.csv");
        FileNotFoundException thrown = assertThrows(FileNotFoundException.class, () -> evaluator.analyze());
    }



}
