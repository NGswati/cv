import java.io.*; //you have to change address of file according to your file location
import java.net.ServerSocket;
import java.net.Socket;
public class serveres2101211 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(3000);
        System.out.println("Waiting for client ...");
        Socket connection = serverSocket.accept();
        System.out.println("Just connected ");
        DataInputStream inputStream=new DataInputStream(connection.getInputStream());
        DataOutputStream outputStream=new DataOutputStream(connection.getOutputStream());
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str1="",str2="";
        System.out.println("Start comminicating with Client\nWrite stop to finish ");
        while (!str1.equals("stop")){
            if (str1.equals("stop"))
                break;
            str1=inputStream.readUTF(); 
            System.out.println("Client Says: "+str1);     
            File file=new File("/Users/swati/Documents/java/es2101211/copy");        //HERE
            
            
        }
        System.out.println("\nServer Exits ");
    }

}
\
