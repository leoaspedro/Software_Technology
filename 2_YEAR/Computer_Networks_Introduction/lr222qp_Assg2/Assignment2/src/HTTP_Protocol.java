
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * This class, implements the logic for the method GET in the HTTP Protocol.
 */

public class HTTP_Protocol {

    public String Root;
    public String HTTP_Code;
    public String header = "";
    public String RequestLine = "";
    private String FileType = "";
    public String getHost;
    public String []requestLineSplitted;
    public String requestGET;
    public String requestPATH;
    public String requestHTTP;
    private String DataType="";
    private String Location;
    public int size;


    /**
     * Method that reads everything and return a byte array
     * @param PATH Takes the path to the html file
     * @return byte array that has the html file
     * @throws IOException
     */

   public byte [] startReading(String PATH) throws IOException {
       Root = PATH;
       readFiles(getIndex(SendFiles()));

       if (HTTP_Code.contains("200")){
           return readFiles(getIndex(SendFiles()));
       } else if (HTTP_Code.contains("302")){
           return readFiles(getIndex(SendFiles()));
       } else if (HTTP_Code.contains("403")){
           return readFiles(getIndex(SendFiles()));
       } else if(HTTP_Code.contains("404")){
           return readFiles(getIndex(SendFiles()));
       } else if (HTTP_Code.contains("500")){
           return readFiles(getIndex(SendFiles()));
       }

       return readFiles(getIndex(SendFiles()));
   }


    /**
     * Method that generates the header
     * @param httpCode HTTP response code like 200 OK
     * @param htmlSize Length of the HTML
     * @param Path HTML file path
     */

    public void responseHeader(String httpCode, int htmlSize, String Path) {

        String fType = DataType;

        if (RequestLine.contains(".png")) {
            fType = "image/png";
        } else if (RequestLine.contains(".html")) {
            fType = "text/html";
        }

        if (httpCode.contains("302")) {
             header = "HTTP/1.1 " + httpCode + "\r\n"
                     + "Location: " + Path + "\r\n"
                     + "\r\n";
         }
         else {
            header = "HTTP/1.1 " + httpCode + "\r\n"
                    + "Content-Type: " + fType + "\r\n"
                    + "Content-Length: " + htmlSize + "\r\n"
                    + "\r\n";
        }

        System.out.println("Header :"+header);

    }

    public String getResponseHeader(){
       return header;
}


    /**
     * Method that splits the request message into a string array.
     * getHost contains the host name like localhost
     * @param Header takes the request message from the browser in a String
     */

    public void requestLineGET(String Header) {

        String[] HeaderLines = Header.split("\n"); //HTTP Header splitted into lines/paragraphs to get the different data in the correct from the correct format

        if(Header.contains(" ")){
        for (int i = 0; i < HeaderLines.length; i++) {
            //System.out.println(HeaderLines[i]);

            if (HeaderLines[i].contains("GET")) {
                RequestLine = HeaderLines[i];
            } else if (HeaderLines[i].contains("Host")) {
                getHost = HeaderLines[i];
                getHostName(getHost);
            }
        }

    }
        requestLineSplitted = RequestLine.split(" ");
        requestGET = requestLineSplitted[0]; //First header line - first element - gets the GET
        requestPATH = requestLineSplitted[1];//First header line - second element - gets the PATH
        requestHTTP = requestLineSplitted[2];//First header line - third element - gets the HTTP Version
    }



    /**
     * Methods that verify if the given path is a directory, then if it is true, it will check if it has index.html or index.htm
     * then will return one of these 2 files if they exist. If there are no index.html file, it will return the asked file.
     * @param File takes the path and checks if it is a directory or not
     * @return the correct file to read
     */
    public File getIndex(File File){
        if (File.isDirectory()){
            String[] AllFiles = File.list();

            for (int i = 0;i<AllFiles.length;i++){
                if (AllFiles[i].contains("index.html") || AllFiles[i].contains("index.htm")){
                    File = Paths.get(SendFiles().toString()+"/"+AllFiles[i]).toFile(); //
                    DataType = "text/html";
                }
            }
        } return File;
    }


    /**
     * Method that combines the root which is the directory where the HTML files are located and the path of the file location
     * @return file location
     */
    private File SendFiles() {
       String webRoot = Root + requestPATH;
       System.out.println("webRoot :"+ webRoot);


        return new File(webRoot);
    }


    /**
     * Method that reads the html file and return a byte array. Also, verify the location of the file which will help to know
     * where the file is located with TrackingFile() method. Also the code 500 is generated here, when it throws the Exception.
     * @param File html file
     * @return byte array that has the html file data
     * @throws IOException
     */

    public byte[] readFiles(File File) throws IOException {

        File Checker = TrackingFiles(File, File.getName());

        byte[] FileData = new byte[ (int) Checker.length()];

            //System.out.print(new String());
        try {
            FileInputStream fin = new FileInputStream(Checker);
            fin.read(FileData);
            fin.close();
            size = FileData.length;


            //TO TRIGGER 500
            //size=0;
           // if (size==0) throw new IOException();
            //

        }catch (IOException i){

            if (HTTP_Code == "404"){

            } else {
                HTTP_Code = "500";

                File file = new File(Root + "/ErrorHandler/Error500.html");
                responseHeader("500 Internal Server Error",500,"");

                FileData = new byte[ (int) file.length()];

                FileInputStream fin = new FileInputStream(file);
                fin.read(FileData);
                fin.close();
                size = FileData.length;
            }


        }


        return FileData;
    }


    /**
     * Method that checks the location of the file and decides the correct file to send.
     * @param file path of the file
     * @param FileName file name to find
     * @return the file to read
     */

    private File TrackingFiles(File file, String FileName) {

        if (!file.isDirectory()){
            if (!file.exists()){
                String directory = file.getParent();
                //System.out.println("This is a directory : "+ directory);
                File[] directories = new File(directory).listFiles(File::isDirectory);


                String pathing = redirect(directories,FileName);
                file = new File(pathing);

                if (file.exists()){
                    HTTP_Code = "302";
                    responseHeader("302 Found",(int)file.length(),Location);
                    DataType = "text/html";
                } else {
                    HTTP_Code = "404";
                    responseHeader("404 Not Found",size,"");
                    file = new File(Root + "/ErrorHandler/Error404.html");
                }

            } else if(adminAccess(requestPATH)){
                HTTP_Code = "200";
                responseHeader("200 OK", size,"");
            } else {
                HTTP_Code = "403";
                responseHeader("403 Forbidden",size,"");
                file = new File(Root + "/ErrorHandler/Error403.html");
            }
        }
        return file;
    }


    /**
     * Method of type boolean that checks if the URI is admin or not.
     * @param requestPATH takes the URI as String
     * @return boolean
     */
    private boolean adminAccess(String requestPATH) {
        if (requestPATH.contains("admin")){
            return false;
        }
        return true;
    }




    /**
     * Method that verifies all the available directories and redirect to the correct path if found.
     * @param directories File Array that contains all directories
     * @param FileName Name to find
     * @return redirected path
     */
    private String redirect(File[] directories, String FileName) {
        String redirect = "";

        for (File directory : directories){
            String[] All = directory.list();
            for (int i = 0; i<All.length;i++){
                if (All[i].contains(FileName)){

                    Location = "http://"+ getHostName(getHost) +"/"+ directory.getName()+ "/"+ FileName ;

                    redirect += directory.getAbsolutePath() + "/" + FileName;
                }
            }
        }
        return redirect;
    }



    private String getHostName(String name) {
       String [] HostName = name.split(" ");
       String getName = HostName[1].trim();

       return getName;
    }

}
