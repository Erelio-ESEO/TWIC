package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.config.JDBCConfiguration;
import com.dto.Ville;

@Repository
public class VilleDAOImpl implements VilleDAO {
	public ArrayList<Ville> getInfoVille() {
		Ville ville = null;
		ArrayList<Ville> villes = new ArrayList<Ville>();
		Connection con = JDBCConfiguration.getonnexionBDD();

		String requete = "SELECT * FROM ville_france";
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(requete);
			while (rs.next()) {
				ville = new Ville();
				ville.setCodeCommune(rs.getString(1));
				ville.setCodePostal(rs.getString(3));
				ville.setNomCommune(rs.getString(2));
				ville.setLibelleAcheminement(rs.getString(4));
				ville.setLigne(rs.getString(5));
				ville.setLatitude(rs.getString(6));
				ville.setLongitude(rs.getString(7));
				villes.add(ville);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return villes;
	}

	public ArrayList<Ville> getInfoVilles(String param) {
		ArrayList<Ville> villes = new ArrayList<Ville>();
		Ville ville = null;

		String requete = "SELECT * FROM ville_france WHERE code_postal = " + param;
		Connection con = JDBCConfiguration.getonnexionBDD();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(requete);
			while (rs.next()) {
				ville = new Ville();
				ville.setCodeCommune(rs.getString(1));
				ville.setCodePostal(rs.getString(3));
				ville.setNomCommune(rs.getString(2));
				ville.setLibelleAcheminement(rs.getString(4));
				ville.setLigne(rs.getString(5));
				ville.setLatitude(rs.getString(6));
				ville.setLongitude(rs.getString(7));
				villes.add(ville);
			}
			return villes;
		} catch (SQLException e) {
			System.out.println("Une erreur s'est produite.");
			return null;
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void setVille(Ville ville) {
		Connection con = null;
		Statement stmt = null;
		try {
			con = JDBCConfiguration.getonnexionBDD();
			stmt = con.createStatement();
			stmt.executeUpdate(
					"Insert into ville_france(Code_commune_INSEE,Nom_commune,Libelle_acheminement,Ligne_5,Latitude,Code_postal,Longitude)"
							+ " values(" + ville.getCodeCommune() + ",'" + ville.getNomCommune() + "','"
							+ ville.getLibelleAcheminement() + "','" + ville.getLigne() + "'," + ville.getLatitude() + ","
							+ ville.getCodePostal() + "," + ville.getLongitude() + ")");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {

				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void mettreAJour(Ville ville) {
		Connection con = null;
		Statement stmt = null;
		try {
			con = JDBCConfiguration.getonnexionBDD();
			stmt = con.createStatement();
			stmt.executeUpdate("UPDATE ville_france SET Nom_commune='" + ville.getNomCommune() + "', Code_postal='"
					+ ville.getCodePostal() + "', Libelle_acheminement='" + ville.getLibelleAcheminement() + "', Ligne_5 = '"
					+ ville.getLigne() + "', Latitude='" + ville.getLatitude() + "', Longitude='" + ville.getLongitude()
					+ "'  WHERE Code_commune_INSEE='" + ville.getCodeCommune() + "'");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void supprimerLigne(String code_commune_INSEE) {
		Connection con = null;
		Statement stmt = null;
		try {
			con = JDBCConfiguration.getonnexionBDD();
			stmt = con.createStatement();
			stmt.executeUpdate("DELETE FROM ville_france WHERE Code_commune_INSEE = '" + code_commune_INSEE + "'");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
