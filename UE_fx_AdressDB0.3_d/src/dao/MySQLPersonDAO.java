package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DBConnect;
import javafx.collections.FXCollections;
import model.Person;

public class MySQLPersonDAO implements PersonDAO {
	private Connection con;

	public MySQLPersonDAO() {
		con = DBConnect.getInstance().getConnection();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.PersonDAO#findAllPersons()
	 */
	@Override
	public List<Person> findAllPersons() {
		List<Person> list = null;
		// Statement

		// in Schleife Person-Objekte erzeugen und der Liste hinzufügen

		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM adressen");
			ResultSet rs = ps.executeQuery();
			list = createPersonLIst(rs);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	private List<Person> createPersonLIst(ResultSet rs) throws SQLException {
		List<Person> list = FXCollections.observableArrayList();
		while (rs.next()) {
			Person p = new Person();
			p.setId(rs.getInt("id"));
			p.setVorname(rs.getString("vorname"));
			p.setNachname(rs.getString("nachname"));
			p.setOrt(rs.getString("ort"));
			p.setPlz(rs.getString("plz"));
			p.setStrasse(rs.getString("strasse"));
			p.setTelefon(rs.getString("telefon"));
			p.setMobil(rs.getString("mobil"));
			p.setEmail(rs.getString("email"));
			list.add(p);
		}
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.PersonDAO#savePerson(model.Person)
	 */
	@Override
	public boolean savePerson(Person person) {

		String q = "INSERT INTO adressen (vorname, nachname, plz,ort,strasse, telefon,mobil,email)"
				+ "VALUES (?,?,?,?,?,?,?,?)";
		try (PreparedStatement ps = con.prepareStatement(q)) {
			ps.setString(1, person.getVorname());
			ps.setString(2, person.getNachname());
			ps.setString(3, person.getPlz());
			ps.setString(4, person.getOrt());
			ps.setString(5, person.getStrasse());
			ps.setString(6, person.getTelefon());
			ps.setString(7, person.getMobil());
			ps.setString(8, person.getEmail());

			ps.executeUpdate();

			return ps.getUpdateCount() == 1;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.PersonDAO#deletePerson(int)
	 */
	@Override
	public boolean deletePerson(int id) {
		final String q = "DELETE FROM adressen WHERE id =?";
		try (PreparedStatement deleteStatement = con.prepareStatement(q)){
			deleteStatement.setInt(1, id); // deleteStatement.executeUpdate();
			return 1 == deleteStatement.executeUpdate();
		} catch (Exception e) { 
			e.printStackTrace();
		}

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.PersonDAO#updatePerson(int, java.lang.String, java.lang.String)
	 */
	@Override
	public boolean updatePerson(int id, String fieldName, String newValue) {
		// TODO Auto-generated method stub
		return false;
	}

	public static void main(String[] args) {

		PersonDAO dao = new MySQLPersonDAO();
		System.out.println(dao.findAllPersons().size());
	}

}
