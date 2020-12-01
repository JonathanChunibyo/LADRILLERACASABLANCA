/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;

public class Test {

    public void startConnection(){
        /**
         * This beauty here, does help me to get a remote connection to the
         * mysql server installed on my phone via Termux. I need to document carefully
         * what i did to make it work, can be very useful on the future:
         * 1. Change the mysqld config files to allow TCP/IP requests from another
         * hosts than the default localhost. The file itself is located (in Termux):
         *  data/data/com.termux/files/usr/etc/my.cnf
         * You should look for the route this file is saved on depending on the host O.S.
         * 1.a Usually there're multiple tweaks needed, for this specific case i had luck
         * and just needed to add this:
         *  [client]
         *  port = 3306
         *  [mysqld]
         *  port = 3306
         *  but more work could be need, check these for more insight:
         *  https://support.rackspace.com/how-to/configure-mariadb-server-on-centos/
         *  https://www.cyberciti.biz/tips/how-do-i-enable-remote-access-to-mysql-database-server.html
         * 2. Now MySQL is ready to listen petitions, we should create users with permissions to do that.
         * I needed to make it works fast, so i just gave to the default root account privileges to operate
         * remotely, but this is not recomended:
         * #Execute these queries on the host.
         *   GRANT ALL PRIVILEGES ON *.* TO 'root'@'%' IDENTIFIED BY 'password' WITH GRANT OPTION;
             FLUSH PRIVILEGES;
         *  Taken from https://stackoverflow.com/questions/23733734/how-to-enable-remote-access-of-mysql-in-centos
         * Restart the server after doing this.
         * 3. Coming back into this class, to create the Connection object, we're going to need three things:
         * - an privileged enough user (root for this example)
         * - the password of that user (the one used in the SQL query below this)
         * - the server's URL
         * 3.a the server's URL is assembled with the device's public IP, a port and the specific DB we're interesed
         * to access. I got the IP adress following this
         *  https://linuxhint.com/expose_mysql_server_internet/
         * Keep in mind this is a public IP's address, do not share it mindlessly
         * 3.b Renember the 'port = 3306', we´re going to use that port for assemble the URL.
         **/
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
            String query = "SELECT * FROM Usuario;";
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                System.out.println(rs.getString("nombre"));
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
