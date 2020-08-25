package sample;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Function
{
    public static final Integer SUM_ELEMENT_A_T_G_C = Element.COUNTER_A.getCounter() + Element.COUNTER_T.getCounter() + Element.COUNTER_G.getCounter() + Element.COUNTER_C.getCounter();

    // CONVERTS LIST OF CHARACTERS TO ONE STRING
    public static String makeString (List<Character> list)
    {
        String result = "";

        for (Character element : list)
        {
            result = result + element;
        }

        return result;
    }

    // FORMAT STRING TO LOWER CASES AND REMOVE THE SPACE AND THE NEW LINE
    public static String formatString ()
    {
        Predicate<Character> predicateSpace = (x) -> x.equals(' ');
        Predicate<Character> predicateNewLine = (x) -> x.equals('\n');
        Predicate<Character> predicate = (predicateSpace.negate()).and(predicateNewLine.negate());

        Stream<Character> stream = (Main.INFORMATION.getSequence()).chars().mapToObj((x) -> (char)(x));
        List<Character> list = stream.filter(predicate).map(Character::toLowerCase).collect(Collectors.toList());

        return Function.makeString(list);
    }

    // MAKE THE STRING WITH SEQUENCE PROPERTIES
    public static String computeString ()
    {
        String result = String.format("Sequence ID: %s\nType: %s\nLength: %s\nAverage nucleotides: %s\nAverage: %s\nLongest sequences:\n%s\n",
                                       sequenceId(),type(), length(), averageNucleotides(), average(), longestSequence());

        return result;
    }

    // THE SEQUENCE SAMPLE
    public static String sequenceId()
    {
        return Main.INFORMATION.getSample();
    }

    // THE TYPE OF THE SEQUENCE
    public static String type()
    {
        String type = "";

        if ((double)(SUM_ELEMENT_A_T_G_C + Element.COUNTER_U.getCounter()) / (double)Main.INFORMATION.getSequence().length() >= 0.85)
        {
            if (Element.COUNTER_U.getCounter() == 0)
            {
                type = "DNA";
            }
            else
            {
                type = "RNA";
            }
        }
        else
        {
            type = "PROTEIN";
        }

        return type;
    }

    // THE LENGTH OF THE SEQUENCE BY THE GENE OF DNA WITCH ARE A, T, G, C, N
    public static String length()
    {
        return Integer.toString(SUM_ELEMENT_A_T_G_C + Element.COUNTER_N.getCounter());
    }

    // AVERAGE OF THE NUCLEOTIDES A, T, G, C IN THE SEQUENCE
    public static String averageNucleotides()
    {
        return Double.toString((double)(SUM_ELEMENT_A_T_G_C)/4);
    }

    // AVERAGE OF THE A, T, G, C, U IN THE SEQUENCE
    public static String average()
    {
        return Double.toString((double)(SUM_ELEMENT_A_T_G_C + Element.COUNTER_U.getCounter())/5);
    }

    // LONGEST SUB SEQUENCE OF A's, T's, G's, C'S AND HOW MUCH TIME THEY APPEARS IN THE SEQUENCE OF GENE
    public static String longestSequence ()
    {
        Integer counterA = sequenceSize('A');
        Integer counterT = sequenceSize('T');
        Integer counterG = sequenceSize('G');
        Integer counterC = sequenceSize('C');

        String result = String.format("A(%d) = %d\nT(%d) = %d\nG(%d) = %d\nC(%d) = %d\n",
                                              counterA, sequenceRepeat("A".repeat(counterA)),
                                              counterT, sequenceRepeat("T".repeat(counterT)),
                                              counterG, sequenceRepeat("G".repeat(counterG)),
                                              counterC, sequenceRepeat("C".repeat(counterC)));

        return result;
    }

    // FINDS THE LONGEST SUB SEQUENCE SIZE OF EXACT ELEMENT
    public static Integer sequenceSize (Character character)
    {
        Integer counter = 0;
        Integer current = 0;

        List<Character> list = Main.INFORMATION.getSequence().chars().mapToObj((x) -> (char)(x)).collect(Collectors.toList());

        for (Character element : list)
        {
            if (element.equals(character))
            {
                current = current + 1;
            }
            else
            {
                if (current > counter)
                {
                    counter = current;
                }

                current = 0;
            }
        }

        return counter;
    }

    // FINDS THE NUMBER OF REPEATS FOR THE LONGEST SUB SEQUENCE BY CURRENT CHARACTER
    public static Integer sequenceRepeat (String string)
    {
        Integer counter = 0;
        String sequence = Main.INFORMATION.getSequence();
        String current = "";
        //List<Character> list = Main.INFORMATION.getSequence().chars().mapToObj((x) -> (char)(x)).collect(Collectors.toList());

        for (int index = 0; index < sequence.length() - string.length(); index++)
        {
            current = sequence.substring(index, index + string.length());

            if (current.equals(string) && !string.equals(""))
            {
                counter = counter + 1;
            }
        }

        return counter;
    }
}
