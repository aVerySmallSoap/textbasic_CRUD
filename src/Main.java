//BUILT AND INDEXED USING JAVA DEVELOPMENT KIT v18
import java.util.Scanner;
public class Main
{
    static final int COLUMNS = 8;
    static int Rows = 5, numOfElements = 0, Choice;
    static String Name, Section, Quizzes, writtenWorks, Performance, Midterms, Finals;
    static float Average;
    static String[][] Students = new String[Rows][COLUMNS];
    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args)
    {
        Students[0][0] = "Name"; Students[0][1] = "Section"; Students[0][2] = "Quizzes"; Students[0][3] = "Written Works"; Students[0][4] = "Performance"; Students[0][5] = "Midterms"; Students[0][6] = "Finals"; Students[0][7] = "Average";

        while(true)
        {
            System.out.println("""
                Welcome to a simple Class Record System!
                1 - Create
                2 - Retrieve
                3 - Update
                4 - Delete
                5 - Exit
                """);
            Choice = scanner.nextInt();
            switch (Choice)
            {
                case 1  -> createEntry();   //create
                case 2  -> retrieveEntry(); //retrieve
                case 3  -> updateEntry();   //update
                case 4  -> deleteEntry();   //delete
                case 5  -> System.exit(0);
                default ->
                {
                    System.out.println("ERROR!");
                    System.exit(0);
                }
            }
        }
    }

    /**
     * Dynamically extends the static array by copying the original, instantiating a new array with a bigger size, and fills it with the copy
     */
    static void checkAndExtend()
    {
        if(numOfElements == Students.length-1) // Check if array is almost full, then extends it.
        {
            String[][] tmp = Students.clone();
            Students = new String[Rows+=5][COLUMNS];
            for (int i = 0; i < tmp.length; i++)
            {
                for (int j = 0; j < tmp[i].length; j++)
                {
                    Students[i][j] = tmp[i][j];
                }
            }
        }
    }

    /**
     * Creates an entry within the two-dimensional array {@code Array}
     */
    static void createEntry(){
        scanner.nextLine();
        //This input method could be looped for less code; TODO: Looped input
        System.out.println("Enter a name: ");
        Name = scanner.nextLine();
        inputValidator(Name); // In every possible loop, this method only needs to be executed once.

        System.out.println("Enter student's section: ");
        Section = scanner.nextLine();

        System.out.println("Enter student's Quizzes: ");
        Quizzes = scanner.next();
        inputValidator(Quizzes);

        System.out.println("Enter student's Written Works: ");
        writtenWorks = scanner.next();
        inputValidator(writtenWorks);

        System.out.println("Enter student's Performance: ");
        Performance = scanner.next();
        inputValidator(Performance);

        System.out.println("Enter student's Midterms: ");
        Midterms = scanner.next();
        inputValidator(Midterms);

        System.out.println("Enter student's Finals: ");
        Finals = scanner.next();
        inputValidator(Finals);

        /*
        As each input gets looped, every STRING containing a number will be parsed into a number; and
        TODO: Check and store the WRITTEN data to get the AVERAGE;
        TODO: A variable that will store data in a += manner. Parse STRING input to INT.
        */
        getAverage( Integer.parseInt(Quizzes),
                    Integer.parseInt(writtenWorks),
                    Integer.parseInt(Performance),
                    Integer.parseInt(Midterms),
                    Integer.parseInt(Finals));

        /*As each input is looped, this nested loop will already function as implemented
        TODO: LOOP the assigning of data.
         */
        for (int i = 1; i < Students.length; i++)
        {
           for (int j = 0; j < Students[i].length-1; i++)
           {
              if(Students[i][j] == null)
              {
                  Students[i][j] = Name;
                  Students[i][j+1] = Section;
                  Students[i][j+2] = Quizzes;
                  Students[i][j+3] = writtenWorks;
                  Students[i][j+4] = Performance;
                  Students[i][j+5] = Midterms;
                  Students[i][j+6] = Finals;
                  Students[i][j+7] = Float.valueOf(Average).toString();
                  ++numOfElements;
                  break;
              }
           }
           if(Students[i][0] != null)
           {
               break;
           }
        }
        checkAndExtend();
    }

    /**
     * Retrieves an entry within the two-dimensional array {@code Array}
     */
    static void retrieveEntry()
    {
        System.out.println("""
                Retrieve list of entries:
                1 - One entry
                2 - Entire set
                """);
        int Choice = scanner.nextInt();

        switch (Choice)
        {
            case 1:
                System.out.println("Enter row: ");
                int _row = scanner.nextInt();
                inputValidator(_row);
                if(!(_row == 0 || _row > Students.length)){
                for (int i = 0; i < Students[0].length; i++)
                {
                    System.out.printf("%-20s|", Students[0][i]);
                }

                System.out.println();
                for (int i = 0; i <= 167; i++) {
                    System.out.print("-");
                }

                    for (int i = 0; i < Students.length; i++)
                    {
                        if(i == _row)
                        {
                            for (int j = 0; j < Students[i].length; j++)
                            {
                                System.out.printf("%-20s|", Students[i][j]);
                            }
                            System.out.println();
                        }
                    }
                }
                break;
            case 2:
                for (int i = 0; i < Students[0].length; i++) {
                    System.out.printf("%-20s|", Students[0][i]);
                }

                System.out.println();
                for (int i = 0; i <= 167; i++) {
                    System.out.print("-");
                }
                System.out.println();

                for (int i = 1; i < Students.length; i++)
                {
                    if(Students[i][0] != null)
                    {
                        for (int j = 0; j < Students[i].length; j++)
                        {
                            System.out.printf("%-20s|", Students[i][j]);
                        }
                        System.out.println();
                    }
                }
                break;
            default:
                System.out.println("""
                        Error: Invalid option
                        """);
                System.exit(0);
                break;
        }
    }

    /**
     * Updates an entry within the two-dimensional array {@code Array}
     */
    static void updateEntry()
    {
        System.out.println("Select which row entry to update: ");
        int _row = scanner.nextInt();
        if(_row == 0 || Students[_row][0] == null)
        {
            System.out.println("""
                    Error: entry non-existent
                    """);
        }else{
        System.out.println("""
                Select which data you want to change:
                1 - Name
                2 - Section
                3 - Quizzes
                4 - Written Works
                5 - Performance
                6 - Midterms
                7 - Finals
                8 - All
                """);
        Choice = scanner.nextInt();

        switch(Choice)
        {
            case 1:
                scanner.nextLine();
                System.out.println("Enter name: ");
                Name = scanner.nextLine();
                inputValidator(Name);

                for (int i = 1; i < Students.length; i++)
                {
                    if(i == _row)
                    {
                        Students[i][0] = Name;
                    }
                }
                break;
            case 2:
                scanner.nextLine();
                System.out.println("Enter section: ");
                Section = scanner.nextLine();

                for (int i = 1; i < Students.length; i++)
                {
                    if(i == _row)
                    {
                        Students[i][1] = Section;
                    }
                }
                break;
            case 3:
                System.out.println("Enter Quizzes: ");
                Quizzes = scanner.next();
                inputValidator(Quizzes);

                for (int i = 1; i < Students.length; i++)
                {
                    if(i == _row)
                    {
                        Students[i][2] = Quizzes;
                        getAverage( Integer.parseInt(Quizzes),
                                    Integer.parseInt(writtenWorks),
                                    Integer.parseInt(Performance),
                                    Integer.parseInt(Midterms),
                                    Integer.parseInt(Finals));
                        Students[i][7] = Float.valueOf(Average).toString();
                    }
                }
                break;
            case 4:
                System.out.println("Enter Written Works: ");
                writtenWorks = scanner.next();
                inputValidator(writtenWorks);

                for (int i = 1; i < Students.length; i++)
                {
                    if(i == _row)
                    {
                        Students[i][3] = writtenWorks;
                        getAverage( Integer.parseInt(Quizzes),
                                    Integer.parseInt(writtenWorks),
                                    Integer.parseInt(Performance),
                                    Integer.parseInt(Midterms),
                                    Integer.parseInt(Finals));
                        Students[i][7] = Float.valueOf(Average).toString();
                    }
                }
                break;
            case 5:
                System.out.println("Enter Performance: ");
                Performance = scanner.next();
                inputValidator(Performance);

                for (int i = 1; i < Students.length; i++)
                {
                    if (i == _row) {
                        Students[i][4] = Performance;
                        getAverage( Integer.parseInt(Quizzes),
                                    Integer.parseInt(writtenWorks),
                                    Integer.parseInt(Performance),
                                    Integer.parseInt(Midterms),
                                    Integer.parseInt(Finals));
                        Students[i][7] = Float.valueOf(Average).toString();
                    }
                }
                break;
            case 6:
                System.out.println("Enter Midterms: ");
                Midterms = scanner.next();
                inputValidator(Midterms);

                for (int i = 1; i < Students.length; i++)
                {
                    if (i == _row) {
                        Students[i][5] = Midterms;
                        getAverage( Integer.parseInt(Quizzes),
                                    Integer.parseInt(writtenWorks),
                                    Integer.parseInt(Performance),
                                    Integer.parseInt(Midterms),
                                    Integer.parseInt(Finals));
                        Students[i][7] = Float.valueOf(Average).toString();
                    }
                }
                break;
            case 7:
                System.out.println("Enter Finals: ");
                Finals = scanner.next();
                inputValidator(Finals);

                for (int i = 1; i < Students.length; i++)
                {
                    if (i == _row) {
                        Students[i][6] = Finals;
                        getAverage( Integer.parseInt(Quizzes),
                                    Integer.parseInt(writtenWorks),
                                    Integer.parseInt(Performance),
                                    Integer.parseInt(Midterms),
                                    Integer.parseInt(Finals));
                        Students[i][7] = Float.valueOf(Average).toString();
                    }
                }
                break;
            case 8:
                scanner.nextLine();
                System.out.println("Enter a name: ");
                Name = scanner.nextLine();
                inputValidator(Name);

                System.out.println("Enter student's section: ");
                Section = scanner.nextLine();
                System.out.println("Enter student's Quizzes: ");
                Quizzes = scanner.next();
                inputValidator(Quizzes);

                System.out.println("Enter student's Written Works: ");
                writtenWorks = scanner.next();
                inputValidator(writtenWorks);

                System.out.println("Enter student's Performance: ");
                Performance = scanner.next();
                inputValidator(Performance);

                System.out.println("Enter student's Midterms: ");
                Midterms = scanner.next();
                inputValidator(Midterms);

                System.out.println("Enter student's Finals: ");
                Finals = scanner.next();
                inputValidator(Finals);

                getAverage( Integer.parseInt(Quizzes),
                            Integer.parseInt(writtenWorks),
                            Integer.parseInt(Performance),
                            Integer.parseInt(Midterms),
                            Integer.parseInt(Finals));

                for (int i = 1; i < Students.length; i++)
                {
                    if(i == _row)
                    {
                        int j = 0;
                        Students[i][j] = Name;
                        Students[i][j+1] = Section;
                        Students[i][j+2] = Quizzes;
                        Students[i][j+3] = writtenWorks;
                        Students[i][j+4] = Performance;
                        Students[i][j+5] = Midterms;
                        Students[i][j+6] = Finals;
                        Students[i][j+7] = Float.valueOf(Average).toString();
                    }
                }
                break;
            default:
                System.out.println("""
                        Error: Invalid option
                        """);
                System.exit(0);
                break;
            }
        }
    }

    /**
     * Deletes an entry within the two-dimensional array {@code Array}
     */
    static void deleteEntry()
    {
        System.out.println("Select which row entry to delete: ");
        int _row = scanner.nextInt();
        inputValidator(_row);
        if(Students[_row][0] != null){
            for (int i = 1; i < Students.length; i++)
            {
                if(i == _row)
                {
                    for (int j = 0; j < Students[i].length; j++)
                    {
                        Students[i][j] = null;
                    }
                }
            }
            --numOfElements;
            System.out.println("Entry Deleted!");
        }
    }

    /**
     * Summate its entire parameters and averages it<br>
     * @param grade1 int
     * @param grade2 int
     * @param grade3 int
     * @param grade4 int
     * @param grade5 int
     */
    static void getAverage(int grade1, int grade2, int grade3, int grade4, int grade5)
    {
        int SUM = grade1 + grade2 + grade3 + grade4 + grade5;
        SUM /= 5;
        Average = SUM;
    }

    /**
     * Checks the users {@code input} for validation
     * @param input String
     */
    static void inputValidator(String input)
    {
        if(input.equals(Name))
        {
            if( input.matches("[0-9]"))
            {
                System.out.println("""
                    Error: Invalid name
                    Only characters are allowed.
                    """);
                System.exit(0);
            }
        }
        else
        {
            if(input.matches("[a-zA-Z]") || Integer.parseInt(input) < 0)
            {
                System.out.println("""
                    Error: Invalid grade
                    Only positive digits are allowed.
                    """);
                System.exit(0);
            }
        }
    }

    /**
     * Checks the users {@code input} for validation
     * @param input int
     */
    static void inputValidator(int input)
    {
        if(input > numOfElements || input == 0)
        {
            System.out.println("""
                    Error: entry non-existent
                    """);
        }
    }
}