package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId() {
        Job test1 = new Job();
        Job test2 = new Job();
        assertNotEquals(test1.getId(), test2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job test = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(test.getName() instanceof String);
        assertTrue(test.getCoreCompetency() instanceof CoreCompetency);
        assertTrue(test.getEmployer() instanceof Employer);
        assertTrue(test.getLocation() instanceof Location);
        assertTrue(test.getPositionType() instanceof PositionType);

        assertEquals("Product tester", test.getName());
        assertEquals("ACME", test.getEmployer().toString());
        assertEquals("Desert", test.getLocation().toString());
        assertEquals("Quality control", test.getPositionType().toString());
        assertEquals("Persistence", test.getCoreCompetency().toString());

    }

    @Test
    public void testJobsForEquality() {
        Job test1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job test2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(test1.equals(test2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job test = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String testString = test.toString();
        assertEquals(testString.charAt(0), '\n');
        assertEquals(testString.charAt(testString.length() - 1), '\n');
    }

        @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job test = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String testString = test.toString();
        assertEquals(testString, "\nID: " + test.getId() +
                "\nName: Product tester" +
                "\nEmployer: ACME" +
                "\nLocation: Desert" +
                "\nPosition Type: Quality control" +
                "\nCore Competency: Persistence" +
                "\n");
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job test = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        String testString = test.toString();
        assertEquals(testString, "\nID: " + test.getId() +
                "\nName: Data not available" +
                "\nEmployer: Data not available" +
                "\nLocation: Data not available" +
                "\nPosition Type: Data not available" +
                "\nCore Competency: Data not available\n");
    }

    }


