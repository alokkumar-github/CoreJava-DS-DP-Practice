package dp.behaviourdesignpattern.chainofresposiblity;

public class Request {	
	private int m_value;
	private String m_description;

	public Request(String description, int value)
	{
		m_description = description;
		m_value = value;
	}

	public int getValue()
	{
		return m_value;
	}

	public String getDescription()
	{
		return m_description;
	}          
}
