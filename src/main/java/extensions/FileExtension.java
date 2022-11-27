package extensions;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;


public class FileExtension {
    public String getCurrentWorkingDir()
    {
        return System.getProperty("user.dir");
    }


    public void downloadFileByURL(String scrURL, String name ,String imgID) throws IOException {
       /** URL imageURL = new URL(scrURL);
        URLConnection urlCon = imageURL.openConnection();
        System.setProperty("http.agent", "Chrome");
        BufferedImage saveImage = ImageIO.read(imageURL);
        ImageIO.write(saveImage,"jpg",new File(imageURL + "jpg")); **/
        URL url = new URL(scrURL);
        File destination_file = new File(String.format("files/"+name+"/" + imgID + ".png"));
        FileUtils.copyURLToFile(url, destination_file);
    }

    public void createFolderByTeamName(String teamName)
    {
        new File("files/" + teamName).mkdir();
    }
}
