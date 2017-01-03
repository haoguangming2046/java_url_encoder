public class MyUrl //(String url)
{
    //instance variables for the string
    private String mURL = "";
    private String mName = "";
    private String mValue = "";
    private int counter = 0;

    public MyUrl (String url)       //initialize base URL and make sure http or https is at the beginning
    {
        if (url.startsWith("http://"))
            mURL = url;
        else
            mURL = "http://"+url;
    }

    public void addArgument (String name, String value) //add argument if user selects 's'
    {
        mName = urlEncode(name);
        mValue = urlEncode(value);
        mURL = buildString(mName,mValue);   //call custom build string function
        return;
    }
    public void addArgument (String name, int ivalue)   //add argument if user selects 'i'
    {
        mName = urlEncode(name);
        mValue = Integer.toString(ivalue);  //change integer value into string
        mValue = urlEncode(mValue);
        mURL = buildString(mName,mValue);   //call custom build string function
        return;
    }
    public void addArgument (String name, double dvalue)    //add argument if user selects 'd'
    {
        mName = urlEncode(name);
        mValue = Double.toString(dvalue);   //change double value into string
        mValue = urlEncode(mValue);
        mURL = buildString(mName,mValue);   //call custom build string function
        return;
    }
    public String toString()    //return final built string to main function
    {
        return mURL;
    }
    public String buildString(String mName, String mValue)  //returns the object's URL value (the base URL plus all arguments).
    {
        String result;
        String mTSName = mName;
        String mTSValue = mValue;
        if ((mTSName == "") && (mTSValue == "") && counter == 0)
            return mURL;
        else if (counter == 0)
        {
            result = mURL+'?'+mTSName+'='+mTSValue;     //first argument
        }
        else
        {
            result = mURL+'&'+mTSName+'='+mTSValue;     //subsequent arguments
        }
        counter = counter+1;
        return result;
    }
    public static String urlEncode (String text)    //encodes name or value and returns result
    {
        String nonEncodeText = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_-*.";
        String hex = "";
        int count = 0;
        String encodeText = "";
        //loop to analyze and or encode the entire string
        for(count = 0; count < text.length() ; count++)
        {
           hex="";
           char test = text.charAt(count);
            if (test == ' ')
               encodeText = encodeText+'+';
            else if ((nonEncodeText.indexOf(test)) >= 0)
               encodeText = encodeText+test;
            else
            {
                hex = Integer.toHexString(test);
                encodeText = encodeText+'%'+hex;
            }
         }
         return encodeText;
    }
}