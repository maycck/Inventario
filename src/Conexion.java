import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
	 private String username="root";
	  private String pass="1234";
	  private String host="localhost";
	  private String port="3306";
	  private String database="proyecto";
	  private String classname="com.mysql.jdbc.Driver";
	  private String url="jdbc:mysql://"+host+":"+port+"/"+database;
	  private Connection con;
	  
	  public Conexion()
	  {
	      try{
	        
				Class.forName(classname);
	          con = DriverManager.getConnection(url, username, pass);
	      } catch (ClassNotFoundException ex) {
	          Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
	      } catch(SQLException e){
	          
	      }
	  }
	  public Connection getConexion()
	  {
	      return con;
	  }
	  public void closeConexion()
	  {
		  try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	  }
	  
	    public static void main(String arg[])
	    {
	        Conexion con=new Conexion();
	        System.out.println(con.correo());
	        ArrayList<String> rs=con.mostrarventas();
	        for (String string : rs) {
				System.out.println(string);
			}
	        con.closeConexion();
	    }
	    
	    public String correo()
	    {
	        PreparedStatement pst= null;
	        ResultSet rs=null;
	        try{
	            String consulta="select * from clientes";
	            pst = getConexion().prepareStatement(consulta);
	            rs=pst.executeQuery();
	            
	            if(rs.absolute(1))
	            {
	                return rs.getString(7);
	            }
	            
	        }catch(Exception e){}
	        finally{
	            try{
	            if(pst!=null) pst.close();
	            if(rs!=null) rs.close();
	            }catch(Exception e){}
	        }
	        return "no";
	}
	    public ArrayList mostrarventas()
	    {
	        PreparedStatement pst= null;
	        ResultSet rs=null;
	        ArrayList<String> result=new ArrayList<>();
	        try{
	            String consulta="select * from menus";
	            pst = getConexion().prepareStatement(consulta);
	            rs=pst.executeQuery();
	            while(rs.next())
	            {
	            	result.add(rs.getString(2));
	            }
	        }catch(Exception e){}
	        finally{
	            try{
	            if(pst!=null) pst.close();
	            
	            }catch(Exception e){}
	        }
	        return result;
	    }
	    
}
