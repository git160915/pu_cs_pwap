public class Birthday {
    public static void main(String[] args) {
        int iN = Integer.parseInt(args[0]);
        int iTrials = Integer.parseInt(args[1]);
        int iNumTrialsCounter = 0;
        
        // Each index represents the number of people who entered before
        // a shared birthday is found, this list stores up to iN+1, 
        // in the event that somehow it took the iN'th + 1 person to enter
        // before a shared birthday occurs.  This can happen when the 
        // number of birthdays is a low number
        int[] iListOfFirstDuplicateBirthday = new int[iN+1];

        // Stores a boolean at each index/day
        // false = means no one with a birthday at that index/day
        // true = there is already someone in the room with that birthday at this index/day
        boolean[] bListPeopleEnteredRoom;

        // false = if no one in room has a shared birthday
        // true = upon finding first person entering the room with a shared birthday
        boolean bSharedBirthdayExist = false;

        // random birthday
        int iRandomBirthday = 0;

        // number of people who have entered thus far
        int iNumPeopleEntered = 0;
        
        while (iNumTrialsCounter < iTrials) {
            // Init variable which will control the loop that generates 
            // people with random birthday's entering the room
            bSharedBirthdayExist = false;

            bListPeopleEnteredRoom = new boolean[iN + 1];

            // reset number of people who have entered counter
            iNumPeopleEntered = 0;

            while (!bSharedBirthdayExist) {
                // Generate a person with random birthday to enter into the room
                iRandomBirthday = (int) (Math.random() * iN);

                // System.out.print(iRandomBirthday + "  ");

                // increment number of people who have entered
                iNumPeopleEntered++;

                if (!bListPeopleEnteredRoom[iRandomBirthday]) {
                    // if no one at this index/birthday yet, then set to true
                    bListPeopleEnteredRoom[iRandomBirthday] = true;
                } else {
                    // increment the list that tracks the number of people 
                    // entering into a room before a shared birthday appears
                    iListOfFirstDuplicateBirthday[iNumPeopleEntered-1]++;

                    // else there is already someone with this birthday so 
                    // set this variable so that the while loop will exit
                    bSharedBirthdayExist = true;
                }
            }

            iNumTrialsCounter++;
        }
        // System.out.println();

        int iRunningTotalOfDuplicate = 0;
        double dFraction = 0.0;
        
        // Keep looping until the dFraction exceeds 50%/0.5
        for (int i = 0; i < iListOfFirstDuplicateBirthday.length && dFraction < 0.5; i++) {
            iRunningTotalOfDuplicate += iListOfFirstDuplicateBirthday[i];

            // System.out.println(iRunningTotalOfDuplicate + "  " + iListOfFirstDuplicateBirthday[i]);

            dFraction = (double) iRunningTotalOfDuplicate/iTrials;

            System.out.print(i+1 + "\t");
            System.out.print(iListOfFirstDuplicateBirthday[i] + "\t");
            System.out.print(dFraction);
            System.out.println();
        }
    }
}