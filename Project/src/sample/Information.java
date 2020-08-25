package sample;

public class Information
{
    // CLASS THAT CONTAINS SAMPLE INSERTED FROM THE USER AND SEQUENCE PLACES IN THE TEXT FILE FROM THE WANTED SAMPLE
    private String sample;
    private String sequence;

    public Information ()
    {
        this ("", "");
    }

    public Information (String sample, String sequence)
    {
        setSample(sample);
        setSequence(sequence);
    }

    public Information (Information information)
    {
        this(information.getSample(), information.getSequence());
    }

    public void setSample (String sample)
    {
        if (sample != null)
        {
            this.sample = sample;
        }
        else
        {
            this.sample = "";
        }
    }

    public void setSequence (String sequence)
    {
        if (sequence != null)
        {
            this.sequence = sequence;
        }
        else
        {
            this.sequence = "";
        }
    }

    public String getSample()
    {
        return sample;
    }

    public String getSequence()
    {
        return sequence;
    }

    @Override
    public String toString()
    {
       return String.format("INFORMATION\nsample = %s\nsequence = %s\n", sample, sequence);
    }
}
