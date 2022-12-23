//BUILT AND INDEXED USING JAVA DEVELOPMENT KIT v18

import org.jetbrains.annotations.NotNull;

import java.util.Scanner;
public class Main
{
    static final int COLUMNS = 8;
    static int Rows = 5, numOfElements = 0, Choice;
    static String Name, Section, English, Math, Science, PE, Filipino;
    static float Average;
    static String[][] Array = new String[Rows][COLUMNS];
    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args)
    {
        Array[0][0] = "Name"; Array[0][1] = "Section"; Array[0][2] = "English"; Array[0][3] = "Math"; Array[0][4] = "Science"; Array[0][5] = "Physical Education"; Array[0][6] = "Filipino"; Array[0][7] = "Average";

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
        if(numOfElements == Array.length-1) // Check if array is almost full, then extends it.
        {
            String[][] tmp = Array.clone();
            Array = new String[Rows+=5][COLUMNS];
            for (int i = 0; i < tmp.length; i++)
            {
                for (int j = 0; j < tmp[i].length; j++)
                {
                    Array[i][j] = tmp[i][j];
                }
            }
        }
    }

    /**
     * Creates an entry within the two-dimensional array {@code Array}
     */
    static void createEntry(){
        scanner.nextLine();
        System.out.println("Enter a name: ");
        Name = scanner.nextLine();
        inputValidator(Name);

        System.out.println("Enter student's section: ");
        Section = scanner.nextLine();

        System.out.println("Enter student's English grade: ");
        English = scanner.next();
        inputValidator(English);

        System.out.println("Enter student's Math grade: ");
        Math = scanner.next();
        inputValidator(Math);

        System.out.println("Enter student's Science grade: ");
        Science = scanner.next();
        inputValidator(Science);

        System.out.println("Enter student's Physical Education grade: ");
        PE = scanner.next();
        inputValidator(PE);

        System.out.println("Enter student's Filipino grade: ");
        Filipino = scanner.next();
        inputValidator(Filipino);

        getAverage( Integer.parseInt(English),
                    Integer.parseInt(Math),
                    Integer.parseInt(Science),
                    Integer.parseInt(PE),
                    Integer.parseInt(Filipino));

        for (int i = 1; i < Array.length; i++)
        {
           for (int j = 0; j < Array[i].length-1;i++)
           {
              if(Array[i][j] == null){
                  Array[i][j] = Name;
                  Array[i][j+1] = Section;
                  Array[i][j+2] = English;
                  Array[i][j+3] = Math;
                  Array[i][j+4] = Science;
                  Array[i][j+5] = PE;
                  Array[i][j+6] = Filipino;
                  Array[i][j+7] = Float.valueOf(Average).toString();
                  ++numOfElements;
                  break;
              }
           }

           if(Array[i][0] != null)
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

                for (int i = 0; i < Array[0].length; i++) {
                    System.out.print(Array[0][i] + " \t\t\t");
                }

                for (int i = 0; i < Array.length; i++)
                {
                    if(i == _row)
                    {
                        for (int j = 0; j < Array[i].length; j++)
                        {
                            System.out.print(Array[i][j] + " \t\t\t");
                        }
                    }
                    System.out.println();
                }
                break;
            case 2:
                for (int i = 0; i < Array.length; i++)
                {
                    if(Array[i][0] != null)
                    {
                        for (int j = 0; j < Array[i].length; j++)
                        {
                            System.out.print(Array[i][j] + " \t\t\t");
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
        inputValidator(_row);

        System.out.println("""
                Select which data you want to change:
                1 - Name
                2 - Section
                3 - English grade
                4 - Math grade
                5 - Science grade
                6 - Physical Education grade
                7 - Filipino grade
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

                for (int i = 1; i < Array.length; i++)
                {
                    if(i == _row)
                    {
                        Array[i][0] = Name;
                    }
                }
                break;
            case 2:
                scanner.nextLine();
                System.out.println("Enter section: ");
                Section = scanner.nextLine();

                for (int i = 1; i < Array.length; i++)
                {
                    if(i == _row)
                    {
                        Array[i][1] = Section;
                    }
                }
                break;
            case 3:
                System.out.println("Enter English grade: ");
                English = scanner.next();
                inputValidator(English);

                for (int i = 1; i < Array.length; i++)
                {
                    if(i == _row)
                    {
                        Array[i][2] = English;
                        getAverage( Integer.parseInt(English),
                                    Integer.parseInt(Math),
                                    Integer.parseInt(Science),
                                    Integer.parseInt(PE),
                                    Integer.parseInt(Filipino));
                        Array[i][7] = Float.valueOf(Average).toString();
                    }
                }
                break;
            case 4:
                System.out.println("Enter Math grade: ");
                Math = scanner.next();
                inputValidator(Math);

                for (int i = 1; i < Array.length; i++)
                {
                    if(i == _row)
                    {
                        Array[i][3] = Math;
                        getAverage( Integer.parseInt(English),
                                    Integer.parseInt(Math),
                                    Integer.parseInt(Science),
                                    Integer.parseInt(PE),
                                    Integer.parseInt(Filipino));
                        Array[i][7] = Float.valueOf(Average).toString();
                    }
                }
                break;
            case 5:
                System.out.println("Enter Science grade: ");
                Science = scanner.next();
                inputValidator(Science);

                for (int i = 1; i < Array.length; i++)
                {
                    if (i == _row) {
                        Array[i][4] = Science;
                        getAverage( Integer.parseInt(English),
                                    Integer.parseInt(Math),
                                    Integer.parseInt(Science),
                                    Integer.parseInt(PE),
                                    Integer.parseInt(Filipino));
                        Array[i][7] = Float.valueOf(Average).toString();
                    }
                }
                break;
            case 6:
                System.out.println("Enter Physical Education grade: ");
                PE = scanner.next();
                inputValidator(PE);

                for (int i = 1; i < Array.length; i++)
                {
                    if (i == _row) {
                        Array[i][5] = PE;
                        getAverage( Integer.parseInt(English),
                                    Integer.parseInt(Math),
                                    Integer.parseInt(Science),
                                    Integer.parseInt(PE),
                                    Integer.parseInt(Filipino));
                        Array[i][7] = Float.valueOf(Average).toString();
                    }
                }
                break;
            case 7:
                System.out.println("Enter Filipino grade: ");
                Filipino = scanner.next();
                inputValidator(Filipino);

                for (int i = 1; i < Array.length; i++)
                {
                    if (i == _row) {
                        Array[i][6] = Filipino;
                        getAverage( Integer.parseInt(English),
                                    Integer.parseInt(Math),
                                    Integer.parseInt(Science),
                                    Integer.parseInt(PE),
                                    Integer.parseInt(Filipino));
                        Array[i][7] = Float.valueOf(Average).toString();
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

                System.out.println("Enter student's English grade: ");
                English = scanner.next();

                inputValidator(English);

                System.out.println("Enter student's Math grade: ");
                Math = scanner.next();

                inputValidator(Math);

                System.out.println("Enter student's Science grade: ");
                Science = scanner.next();

                inputValidator(Science);

                System.out.println("Enter student's Physical Education grade: ");
                PE = scanner.next();

                inputValidator(PE);

                System.out.println("Enter student's Filipino grade: ");
                Filipino = scanner.next();

                inputValidator(Filipino);

                getAverage( Integer.parseInt(English),
                            Integer.parseInt(Math),
                            Integer.parseInt(Science),
                            Integer.parseInt(PE),
                            Integer.parseInt(Filipino));

                for (int i = 1; i < Array.length; i++)
                {
                    if(i == _row)
                    {
                        for (int j = 0; j < Array[i].length-1;)
                        {
                            Array[i][j] = Name;
                            Array[i][j+1] = Section;
                            Array[i][j+2] = English;
                            Array[i][j+3] = Math;
                            Array[i][j+4] = Science;
                            Array[i][j+5] = PE;
                            Array[i][j+6] = Filipino;
                            Array[i][j+7] = Float.valueOf(Average).toString();
                        }
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
     * Deletes an entry within the two-dimensional array {@code Array}
     */
    static void deleteEntry()
    {
        System.out.println("Select which row entry to delete: ");
        int _row = scanner.nextInt();
        inputValidator(_row);

        for (int i = 1; i < Array.length; i++)
        {
            if(i == _row)
            {
                for (int j = 0; j < Array[i].length; j++)
                {
                    Array[i][j] = null;
                }
            }
        }
        System.out.println("Entry Deleted!");
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
    static void inputValidator(@NotNull String input)
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
        if(input >= Array.length-1)
        {
            System.out.println("""
                    Error: row is out of bounds
                    """);
        }
    }
}