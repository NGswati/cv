import java.io.*;
import java.net.Socket;

public class MyClient {
    public static void main(String[] args) throws IOException {
        System.out.println("Connecting to server... ");
        Socket socket = new Socket("localhost",3000);
        System.out.println("Connected to server");
        DataInputStream dataInputStream=new DataInputStream(socket.getInputStream());
        DataOutputStream dataOutputStream=new DataOutputStream(socket.getOutputStream());
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str1="",str2="";
        System.out.println("Start comminicating with Server \nWrite stop to finish ");
        while(!str1.equals("stop")){
            System.out.print("Type here: ");
            str1=br.readLine();
            dataOutputStream.writeUTF(str1); 
            if (str1.equals("stop"))
                break;
            System.out.println("You Say: " + str1); 
            dataOutputStream.flush();
            str2=dataInputStream.readUTF(); 
            System.out.println("Server Says: "+str2);
        }
        socket.close();
        System.out.println("\nClient Exits");
    }
}

