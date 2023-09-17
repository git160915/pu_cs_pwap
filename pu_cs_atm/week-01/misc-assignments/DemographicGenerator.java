public class DemographicGenerator {

    /*
     * args[0]: number of random people to generate
     * args[1]: file containing lastnames
     * args[2]: file containing firstnames
     *
     */
    public static void main(String[] args) {
        int iRandomPeopleCount = Integer.parseInt(args[0]);
        In inLastnames = new In(args[1]);
        In inFirstnames = new In(args[2]);
        String[] sLastnames = inLastnames.readAllStrings();
        String[] sFirstnames = inFirstnames.readAllStrings();
        int iSizeOfLastnamesList = sLastnames.length;
        int iSizeOfFirstnamesList = sFirstnames.length;

        int iGenerateMiddleName = 0;

        for (int i = 0; i < iRandomPeopleCount; i++) {
            iGenerateMiddleName = StdRandom.uniformInt(2);

            String sLastname = sLastnames[StdRandom.uniformInt(iSizeOfLastnamesList)].toUpperCase();
            String sFirstname = sFirstnames[StdRandom.uniformInt(iSizeOfFirstnamesList)].toUpperCase();
            String sMiddlename = "";

            if (iGenerateMiddleName > 0) {
                sMiddlename = sFirstnames[StdRandom.uniformInt(iSizeOfFirstnamesList)].toUpperCase();
            }

            StdOut.println(sLastname + ", " + sFirstname + " " + sMiddlename);
        }
    }
}