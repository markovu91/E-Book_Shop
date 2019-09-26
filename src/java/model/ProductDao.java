package model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import model.Orders;
import model.Customers;
import model.Product;
import java.util.*;  
import java.sql.*;
/**
 *
 * @author marko
 */
public class ProductDao {
  
  

  
    public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost/ebookshop", "root", "");  
        }catch(ClassNotFoundException | SQLException e){System.out.println(e);}  
        return con;  
    }  
    public static int save(Product p){  
        int status=0;  
        try{  
            Connection con=ProductDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("insert into books(title,author,price,qty) values (?,?,?,?)");  
            ps.setString(1,p.getTitle());  
            ps.setString(2,p.getAuthor());  
            ps.setFloat(3,p.getPrice());  
            ps.setInt(4,p.getQty());  
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
      
    }  
    public static int update(Product p){  
        int status=0;  
        try{  
            Connection con=ProductDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "update books set title=?,author=?,price=?,qty=? where id=?");  
            ps.setString(1,p.getTitle());  
            ps.setString(2,p.getAuthor());  
            ps.setFloat(3,p.getPrice());  
            ps.setInt(4,p.getQty());  
            ps.setInt(5,p.getId());  
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    } 
    
    
        public static int updateOrder(Orders c){  
        int status=0;  
        try{  
            Connection con=ProductDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "update order_records set qty_ordered=?,cust_name=?,cust_email=?,cust_phone=? where id=?");  
            ps.setInt(1,c.getQuantityOrdered());  
            ps.setString(2,c.getCustomerName());  
            ps.setString(3,c.getCustomerEmail());  
            ps.setInt(4,c.getCustomerPhone());  
            ps.setInt(5,c.getId());  
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }
    
            public static int updateCust(Customers cu){  
        int status=0;  
        try{  
            Connection con=ProductDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "update customers set cust_name=?,cust_phone=?,cust_email=? where id=?");  
            ps.setString(1,cu.getCustomerName());  
            ps.setInt(2,cu.getCustomerPhone());  
            ps.setString(3,cu.getCustomerEmail());  
            ps.setInt(4,cu.getId());  
    
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }
    
    
    
    
    
    
    public static int delete(int id){  
        int status=0;  
        try{  
            Connection con=ProductDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from books where id=?");  
            ps.setInt(1,id);  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    }  
    
        public static int deleteOrder(int id, int qty){  
        int status=0;  
        try{  
            Connection con=ProductDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from order_records where id=? and qty_ordered=?");  
            ps.setInt(1,id);
            ps.setInt(2,qty);  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    }  
    
        
        public static int deleteCust(int id, String name){  
        int status=0;  
        try{  
            Connection con=ProductDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from customers where id=? and cust_name=?");  
            ps.setInt(1,id);
            ps.setString(2,name);  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    }  
        
        
        
        
    
    public static Product getEmployeeById(int id){  
        Product p=new Product();  
          
        try{  
            Connection con=ProductDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from books where id=?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                p.setId(rs.getInt(1));  
                p.setTitle(rs.getString(2));  
                p.setAuthor(rs.getString(3));  
                p.setPrice(rs.getFloat(4));  
                p.setQty(rs.getInt(5));  
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return p;  
    }  
    
    
        public static Orders getOrderByIdQty(int id, int qty){  
        Orders c=new Orders();  
          
        try{  
            Connection con=ProductDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from order_records where id=? and qty_ordered=?");  
            ps.setInt(1,id); 
            ps.setInt(2,qty);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                c.setId(rs.getInt(1));  
                c.setQuantityOrdered(rs.getInt(2));  
                c.setCustomerName(rs.getString(3));  
                c.setCustomerEmail(rs.getString(4));  
                c.setCustomerPhone(rs.getInt(5));  
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return c;  
    }
    
        public static Customers getCustomerByIdQty(int id, String name){  
        Customers cu=new Customers();  
          
        try{  
            Connection con=ProductDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from customers where id=? and cust_name=?");  
            ps.setInt(1,id); 
            ps.setString(2,name);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                cu.setId(rs.getInt(1));  
                cu.setCustomerName(rs.getString(2));  
                cu.setCustomerPhone(rs.getInt(3));  
                cu.setCustomerEmail(rs.getString(4));    
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return cu;  
    }
    
    
    
    public static List<Product> getAllEmployees(){  
        List<Product> list=new ArrayList<Product>();  
          
        try{  
            Connection con=ProductDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from books");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Product p=new Product();  
                p.setId(rs.getInt(1));  
                p.setTitle(rs.getString(2));  
                p.setAuthor(rs.getString(3));  
                p.setPrice(rs.getFloat(4));  
                p.setQty(rs.getInt(5));  
                list.add(p);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    } 
    
        public static List<Orders> getAllOrders(){  
        List<Orders> list=new ArrayList<Orders>();  
          
        try{  
            Connection con=ProductDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from order_records");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Orders c=new Orders();  
                c.setId(rs.getInt(1));  
                c.setQuantityOrdered(rs.getInt(2));  
                c.setCustomerName(rs.getString(3));  
                c.setCustomerEmail(rs.getString(4));  
                c.setCustomerPhone(rs.getInt(5));  
                list.add(c);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    } 
    
       public static List<Customers> getAllCustomers(){  
        List<Customers> list=new ArrayList<Customers>();  
          
        try{  
            Connection con=ProductDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from customers");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Customers cu=new Customers();  
                cu.setId(rs.getInt(1));  
                cu.setCustomerName(rs.getString(2));  
                cu.setCustomerPhone(rs.getInt(3));  
                cu.setCustomerEmail(rs.getString(4));  
                list.add(cu);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    } 
    
}

