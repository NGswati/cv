import java.io.*; //you have to change address of file according to your file location
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
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
            File file=new File("/Users/swati/Documents/java/2101211/"+str1);        //HERE
            if (file.exists()) {
                FileReader fileReader1 = new FileReader(file.getAbsolutePath());
                BufferedReader br1 = new BufferedReader(fileReader1);
                int c = 0;
                int character=0,line=1;
                while((c = br1.read()) != -1){
                    character++;
                    if(c==10)
                        line++;
                }
                outputStream.writeUTF("\nAbsolute Path: "+file.getAbsolutePath()+"\nNumber of Character: "+character+ "\nNumber of Line: " + line + "");
                outputStream.flush();
            }
            else{
                outputStream.writeUTF("Does not Exists\n You can write (py.txt, 123.txt, abc.txt) instead");
                outputStream.flush();
            }
        }
        System.out.println("\nServer Exits ");
    }
}

// Server output
// Waiting for client...
// Just connected
// Start comminicating with Client
// Write stop to finish
// Client Says: abc.txt
// Client Says: py.txt
// Client Says:123.txt 
// Client Says: dart.txt
// Client Says: stop

// ServerExits




// Client output

// Connecting to server...
// Connected to server 
// Start comminicating with Server 
// Write stop to finish 
// Type here: abc.txt
// You Say: abc.txt
// Server Says:
// Absolute Path:/Users/swati/Documents/2101211/abc.txt
// Number of Character:3
// Number of Line:2
// Type here: py.txt
// You Say: py.txt
// Server Says:
// Absolute Path:/Users/swati/Documents/2101211/py.txt
// Number of Character:453
// Number of Line:12
// Type here:123.txt 
// You Say:123.txt 
// Server Says:
// Absolute Path:/Users/swati/Documents/2101211/123.txt
// Number of Character:215
// Number of Line:3
// Type here: dart.txt
// You Say: dart.txt
// Server Says: Does not Exists 
// You can write (py.txt, 123.txt, abc.txt) instead
// Type here: stop

// Client Exits