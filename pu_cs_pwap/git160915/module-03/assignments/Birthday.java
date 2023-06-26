public class Birthday {
    public static void main (String[] args) {
        int iN = Integer.parseInt(args[0]);
        int iTrials = Integer.parseInt(args[1]);
        int iNumTrialsCounter = 0;
        int[] iListOfFirstDuplicateBirthday = new int[iN];

        // Stores the list of people who have entered the room.
        // Assume it does not exceed the number iN
        int[] iListPeopleEnteredRoom = new int[iN];

        boolean bIsDuplicateBirthday = false;
        
        while (iNumTrialsCounter < iTrials) {
            // Init variable which will control the loop that generates 
            // people with random birthday's entering the room
            bIsDuplicateBirthday = false;

            for (int i = 0; i < iListOfFirstDuplicateBirthday.length & !bIsDuplicateBirthday; i++) {
                iListPeopleEnteredRoom[i] = (int) (Math.random() * iN);

                for (int j = 0; j < i; j++) {
                    if (iListPeopleEnteredRoom[j] == iListPeopleEnteredRoom[i]) {
                        iListOfFirstDuplicateBirthday[i]++;
                        
                        // Set this to true so that the outter for loop for "i" will exit
                        bIsDuplicateBirthday = true;
                    }
                }

            }

            iNumTrialsCounter++;
        }

        int iRunningTotalOfDuplicate = 0;
        double dFraction = 0.0;
        
        // Keep looping until the dFraction exceeds 50%/0.5
        for (int i = 0; i < iListOfFirstDuplicateBirthday.length && dFraction < 0.5; i++) {
            iRunningTotalOfDuplicate += iListOfFirstDuplicateBirthday[i];

            dFraction = (double) iRunningTotalOfDuplicate/iTrials;

            System.out.print(i+1 + "\t");
            System.out.print(iRunningTotalOfDuplicate + "\t");
            System.out.print(dFraction);
            System.out.println();
        }
    }
}