package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entities.Contact;
import entities.Person;
import rest.ContactService;

/**
 * An implementation of ContactService.
 */
public class PersonDAO implements ContactService {

	
    public Connection        conn      = null;
    public PreparedStatement preStm    = null;
    public ResultSet         resSet    = null;
	
	
	// Get all the clients.
	@Override
	public List<Person> listNames() {
		
		List<Person> people = new ArrayList<Person>();
		Person objPerson = null;
		String sql = "SELECT * FROM clients";
		
		try {
			this.conn = DatabaseConnection.getInstance().getConnection(); 
            this.preStm = conn.prepareStatement(sql);
            this.resSet = preStm.executeQuery();

            while(resSet.next()){

            	Contact newContact = new Contact();
            	newContact.setEmail(resSet.getString("email"));
            	newContact.setPhone(resSet.getString("phone"));
            	newContact.setWhatsapp(resSet.getString("whatapp"));
            	
            	objPerson = new Person();            	            	
            	objPerson.setId(resSet.getInt("id"));
            	objPerson.setName(resSet.getString("name"));
            	objPerson.setContact(newContact);            	
            	
            	people.add(objPerson);
            }
        } catch (SQLException e) {
           
        	System.out.println("An error to load the list of Person has been detected!");
        	
        }finally{
        	closeConnections();
         }		
		return people;
	}

	
	// Get client by id.
	@Override
	public Person getClient(int id) {
		Person objPerson = null;
		String sql = "SELECT * FROM clients WHERE id = "+id;
		
		try {
			this.conn = DatabaseConnection.getInstance().getConnection(); 
            this.preStm = conn.prepareStatement(sql);
            this.resSet = preStm.executeQuery();

            while(resSet.next()){

            	Contact newContact = new Contact();
            	newContact.setEmail(resSet.getString("email"));
            	newContact.setPhone(resSet.getString("phone"));
            	newContact.setWhatsapp(resSet.getString("whatapp"));
            	
            	objPerson = new Person();            	            	
            	objPerson.setId(resSet.getInt("id"));
            	objPerson.setName(resSet.getString("name"));
            	objPerson.setContact(newContact);            	            	
            }
        } catch (SQLException e) {
           
        	System.out.println("An error to load a Person by ID has been detected!");
        	
        }finally{
        	closeConnections();
         }		
		return objPerson;
	}

	
	// Add new client.
	@Override
	public void saveNewClient(Person person) {
		
		int id = person.getId();
		String name = person.getName();
		String email = person.getContact().getEmail();
		String phone = person.getContact().getPhone();
		String whatsapp = person.getContact().getWhatsapp();
		
		
		String sql = "INSERT INTO clients (id, name, phone, email, whatsapp) "
				+ "VALUES ("+id+", '"+name+"', '"+phone+"', '"+email+"', '"+whatsapp+"')";
				
		try {
			this.conn = DatabaseConnection.getInstance().getConnection(); 
            this.preStm = conn.prepareStatement(sql);					
            preStm.execute(); 
            
        } catch (SQLException e) {
        	System.out.println("An error to save new client has been detected!");
        }finally{
        	closeConnections();
         }
	}

	
	// Delete 
	@Override
	public void deleteClient(int id) {
		String sql = "DELETE FFROM clients WHERE id = "+id;
				
		try {
			this.conn = DatabaseConnection.getInstance().getConnection(); 
            this.preStm = conn.prepareStatement(sql);					
            preStm.execute(); 
            
        } catch (SQLException e) {
        	System.out.println("An error to delete a client has been detected!");
        }finally{
            closeConnections();
         }
	}


	// Update
	@Override
	public void updateClient(Person person) {
		
		int id = person.getId();
		String name = person.getName();
		String email = person.getContact().getEmail();
		String phone = person.getContact().getPhone();
		String whatsapp = person.getContact().getWhatsapp();
		
		String sql = "UPDATE clients "
				+ "SET name='"+name+"', email='"+email+"', "
				+ "phone='"+phone+"', whatsapp='"+whatsapp+"'"
				+ "WHERE id = "+id;
				
		try {
			this.conn = DatabaseConnection.getInstance().getConnection(); 
            this.preStm = conn.prepareStatement(sql);					
            preStm.execute(); 
            
        } catch (SQLException e) {
        	System.out.println("An error to update a client has been detected!");
        }finally{
        	closeConnections();
         }
	}

	
	
	/**
	 * Close all the database connections.
	 */
	private void closeConnections() {
		try {
        	if(conn   != null) conn  .close();                
            if(preStm != null) preStm.close();
            if(resSet != null) resSet.close();
        } catch (SQLException e) {
            System.out.println("An error to close the database connections has been detected!");
        }
	}
}
