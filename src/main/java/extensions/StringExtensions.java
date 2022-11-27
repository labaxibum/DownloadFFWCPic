package extensions;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class StringExtensions {

    public String filterWWWUrl(String URL)
    {
        if (URL.contains("https://i"))
        {
            URL = URL;
        }
        else {URL = "";}
        return URL;
    }
    // background-image: url("https://digitalhub.fifa.com/transform/08c7e932-41a2-460e-b14b-04903ac5ca8c/1442774135?io=transform:fill,width:792,height:900");
    public String splitURLString(String inputURL){
        String[] split1 = inputURL.split("h",2);
        String[] split2 = split1[1].split("\\?io",2);
        return String.format("h" +split2[0]);
    }

    //https://digitalhub.fifa.com/transform/55e9fe36-b328-44f5-86d8-1cba96a4d05e/1442740056
    public String splitImageURL(String inputURL)
    {
        String[] splitString = inputURL.split("/",6);
        return splitString[5];
    }
}
