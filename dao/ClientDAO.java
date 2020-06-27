 package dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.Client;

public class ClientDAO extends DAO{
	
	/**
	 * search all clients in the tblClient whose name contains the @key
	 * @param key
	 * @return list of client whose name contains the @key
	 */
	public ArrayList<Client> searchClient(String key){
		ArrayList<Client> result = new ArrayList<Client>();
		String sql = "SELECT * FROM tblclient WHERE name LIKE ?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "%" + key + "%");
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				Client client = new Client();
				client.setId(rs.getInt("id"));
				client.setName(rs.getString("name"));
				client.setIdCard(rs.getString("idcard"));
				client.setAddress(rs.getString("address"));
				client.setTel(rs.getString("tel"));
				client.setEmail(rs.getString("email"));
				client.setNote(rs.getString("note"));
				result.add(client);
			}
		}catch(Exception e){
			e.printStackTrace();
		}	
		return result;
	}
	
	/**
	 * get a client whose id is @key
	 * @param key
	 * @return
	 */
	public Client getClientById(int key){
		Client client = null;
		String sql = "SELECT * FROM tblclient WHERE id=?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, key);
			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				client = new Client();
				client.setId(rs.getInt("id"));
				client.setName(rs.getString("name"));
				client.setIdCard(rs.getString("idcard"));
				client.setAddress(rs.getString("address"));
				client.setTel(rs.getString("tel"));
				client.setEmail(rs.getString("email"));
				client.setNote(rs.getString("note"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}	
		return client;
	}
	
	/**
	 * get all client from tblClient
	 * @return
	 */
	public ArrayList<Client> getAllClient(){
		ArrayList<Client> result = new ArrayList<Client>();
		String sql = "SELECT * FROM tblclient";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				Client client = new Client();
				client.setId(rs.getInt("id"));
				client.setName(rs.getString("name"));
				client.setIdCard(rs.getString("idcard"));
				client.setAddress(rs.getString("address"));
				client.setTel(rs.getString("tel"));
				client.setEmail(rs.getString("email"));
				client.setNote(rs.getString("note"));
				result.add(client);
			}
		}catch(Exception e){
			e.printStackTrace();
		}	
		return result;
	}
	
	/**
	 * add a new @client into the DB
	 * @param client
	 */
	public void addClient(Client client){
		String sql = "INSERT INTO tblclient(name, idcard, address, tel, email, note) VALUES(?,?,?,?,?,?)";
		try{
			PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, client.getName());
			ps.setString(2, client.getIdCard());
			ps.setString(3, client.getAddress());
			ps.setString(4, client.getTel());
			ps.setString(5, client.getEmail());
			ps.setString(6, client.getNote());

			ps.executeUpdate();
			
			//get id of the new inserted client
			ResultSet generatedKeys = ps.getGeneratedKeys();
			if (generatedKeys.next()) {
				client.setId(generatedKeys.getInt(1));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * update the @client
	 * @param client
	 */
	public void editClient(Client client){
		String sql = "UPDATE tblclient SET name=?, idcard =?, address=?, tel=?, email=?, note=? WHERE id=?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, client.getName());
			ps.setString(2, client.getIdCard());
			ps.setString(3, client.getAddress());
			ps.setString(4, client.getTel());
			ps.setString(5, client.getEmail());
			ps.setString(6, client.getNote());
			ps.setInt(7, client.getId());

			ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * delete the client whose id is @id
	 * @param id
	 */
	public void deleteClient(int id){
		String sql = "DELETE FROM tblclient WHERE id=?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);

			ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
