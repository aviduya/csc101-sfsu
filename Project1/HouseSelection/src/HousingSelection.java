import java.util.Scanner;

public class HousingSelection {

    public static int validateIntChoice(Scanner input, int minChoice, int maxChoice) {
        if (!input.hasNextInt()) {
            System.err.println("Please enter a valid choice");
            System.exit(1);
        }
        int rawInput = input.nextInt();
        if (rawInput < minChoice || rawInput > maxChoice) {
            System.err.println("Please enter the number corresponding from one of the choices");
            System.exit(1);
        }
        return rawInput;
    }

    public static void main(String[] args) {
        String name;
        String housingPriority;

        int isADA;
        int currentYear;
        int residencyStatus;
        int enrollmentStatus;
        int academicStanding;
        int disciplinaryStanding;
        int housingStability;
        int localCommuter = 0;
        int housingScore = 0;


        // Greeting
        Scanner input = new Scanner(System.in);
        System.out.print("""
                \n\nHello and welcome to the house selection app.
                We will be asking a few questions to help determine your eligibility for campus housing.
                Hit enter to begin\n""");
        input.nextLine();

        // Name
        System.out.print("What is your name? ");
        name = input.nextLine();

        System.out.printf("""
                %nIts nice to meet you %s.
                To answer the questions please type in the number corresponding from one of the choices%n
                """, name);

        // ADA
        System.out.print("""
                Do you require disability-related housing accommodations?
                1: Yes
                2: No
                Selection:""" + " ");
        isADA = validateIntChoice(input, 1, 2);

        // Class Year
        System.out.print("""
                \nWhat is your current class year?
                1: Freshman
                2: Sophomore
                3: Junior
                4: Senior+
                Selection:""" + " ");
        currentYear = validateIntChoice(input, 1, 4);

        // Residency
        System.out.print("""
                \nWhat is your current residency status?
                1: Local
                2: In-State
                3: Out of State
                4: International
                Selection:""" + " ");
        residencyStatus = validateIntChoice(input, 1, 4);

        // If local, commute time
        if (residencyStatus == 1) {
            System.out.print("""
                \nSince you are a local student, to the best of your ability, how much time does it take you to commute to campus?
                1: Less than 60 minutes.
                2: Between 60 - 89 Minutes.
                3: 90 Minutes or longer
                Selection:""" + " ");
            localCommuter = validateIntChoice(input, 1, 3);
        }

        // Enrollment
        System.out.print("""
                \nWhat is your current enrollment status?
                1: Part Time
                2: Full time
                Selection:""" + " ");
        enrollmentStatus = validateIntChoice(input, 1, 2);

        // Academic Standing
        System.out.print("""
                \nWhat is your current academic standing?
                1: Good
                2: First Academic Probation
                3: Repeated Academic Probation
                Selection:""" + " ");
        academicStanding = validateIntChoice(input, 1, 3);

        // Disciplinary Standing
        System.out.print("""
                \nWhat is your current disciplinary standing?
                1: Good Disciplinary Standing
                2: Minor Disciplinary Probation
                3: Serious Disciplinary Probation
                Selection:""" + " ");
        disciplinaryStanding = validateIntChoice(input, 1, 3);

        // Housing Stability
        System.out.print("""
                \nWhich statement best describes your current housing situation?
                1: Stable and reliable housing:
                2: Currently have housing but am at risk of losing it
                3: Currently live in temporary or unstable housing
                4: Currently experiencing homelessness
                Selection:""" + " ");
        housingStability = validateIntChoice(input, 1, 4);

        input.close();

        // Aggregate housing score.
        if (isADA == 1) {
            housingScore += 5;
        }

        switch (currentYear) {
            case 1:
                housingScore += 4;
                break;
            case 2:
                housingScore += 3;
                break;
            case 3:
                housingScore += 2;
                break;
            case 4:
                housingScore += 1;
                break;
        }

        switch (residencyStatus) {
            case 1:
                switch (localCommuter) {
                    case 2:
                        housingScore += 1;
                        break;
                    case 3:
                        housingScore += 2;
                        break;
                }
                break;
            case 2:
                housingScore += 3;
                break;
            case 3:
                housingScore += 4;
                break;
            case 4:
                housingScore += 5;
                break;
        }

        switch (enrollmentStatus) {
            case 1:
                housingScore += 1;
                break;
            case 2:
                housingScore += 2;
                break;
        }

        switch (academicStanding) {
            case 2:
                housingScore -= 1;
                break;
            case 3:
                housingScore -= 2;
                break;
        }

        switch (disciplinaryStanding) {
            case 2:
                housingScore -= 3;
                break;
            case 3:
                housingScore -= 4;
                break;
        }

        switch (housingStability) {
            case 2:
                housingScore += 1;
                break;
            case 3:
                housingScore += 2;
                break;
            case 4:
                housingScore += 3;
                break;
        }

        // Students could face Academic Probation based on housing stability;
        // adding a point to offset academic probation
        if (academicStanding >= 2 && housingStability >= 3) {
            housingScore += 1;
        }

        // Thejn Point range total would be -4 < housingScore < 19
        // housingScore < 5 = LOW
        // 5 < housingScore < 11 = MEDIUM
        // housingScore > 11 = HIGH
        if (housingScore <= 5) {
            housingPriority = "LOW";
        } else if (housingScore <= 11) {
            housingPriority = "MEDIUM";
        } else {
            housingPriority = "HIGH";
        }

        System.out.printf("""
                \nThank you for your time %s
                Your total housing score: %d
                Your housing priority is: %s
                """, name, housingScore, housingPriority);

    }
}
