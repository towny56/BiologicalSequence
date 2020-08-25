package sample;

public enum Element
{
    // ENUM THAT CONTAINS TNE NUMBER OF CHARACTERS A, T, G, C, N, U IN THE SEQUENCE
    COUNTER_A (Main.INFORMATION.getSequence().replaceAll("[^A]*", "").length()),
    COUNTER_T (Main.INFORMATION.getSequence().replaceAll("[^T]*", "").length()),
    COUNTER_G (Main.INFORMATION.getSequence().replaceAll("[^G]*", "").length()),
    COUNTER_C (Main.INFORMATION.getSequence().replaceAll("[^C]*", "").length()),
    COUNTER_N (Main.INFORMATION.getSequence().replaceAll("[^N]*", "").length()),
    COUNTER_U (Main.INFORMATION.getSequence().replaceAll("[^U]*", "").length());

    private final Integer counter;

    Element (Integer counter)
    {
        if (counter > 0)
        {
            this.counter = counter;
        }
        else
        {
            this.counter = 0;
        }
    }

    public Integer getCounter()
    {
        return this.counter;
    }
}
