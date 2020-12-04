/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;

public class Test {

    public void startConnection(){
        //This is the all mighty server's URL.
        String url = "jdbc:mysql://3.92.88.197:3306/Ladrillera";
        //Isn't the best idea hardcoding the user and passwords credentials but this is a test anywas
        String user = "admin";
        String password = "B@53S_202O_OF1W=4YI";
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection cn = DriverManager.getConnection(url,user, password);
            System.out.println("System managed a sucessful connection");
            Statement st = cn.createStatement();
            String query = "SELECT * FROM usuario;";
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()){
                if(rs.getString("email").equals("jonathanadonayrj@ufps.edu.co")){
                    System.out.println(rs.getString("email"));
                }
            }
            
            cn.close();
        } catch(Exception e){

            System.out.println("System retrieved an error, connection aborted\n"+e.getLocalizedMessage());
        }
    }

    public static void main(String[] args) {
        Test c = new Test();
        c.startConnection();
    }

}
