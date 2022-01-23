package examenbacalaureat;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Catalina Bejan
 */

public class OracleConnection {

    private final static String URL = "jdbc:oracle:thin:@localhost:1521/orcl";
    private final static String USERNAME = "SYSTEM";
    private final static String PASSWORD = "oracle";
    private final static String DRIVER = "oracle.jdbc.driver.OracleDriver";

    
    /**
     * Return the opened Connection to the database
     * 
     * @param connection - the Connection object that needs to be opened
     * @return - the Connection after being opened or null if the connection failed
     */
    public static Connection openConnection(Connection connection) {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if (connection != null) {
                System.out.println("Connection successful!");
                System.out.println("##################################################");
            } else {
                System.out.println("\nConnection failed!");
                System.out.println("##################################################\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * Return the ResultSet containing data asked in the query
     * 
     * @param connection - the Connection object to the database
     * @param query - the query applied to the database
     * @return - the ResultSet containing data from the database asked in the query or null if there is no data found
     */
    public static ResultSet executeQuery(Connection connection, String query) {
        ResultSet results = null;
        Statement statement = null;
        try {
            statement = connection.createStatement();
            System.out.println("Executed QUERY:\n" + query);
            System.out.println("##################################################");
            results = statement.executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }
    
    /**
     * Close the connection to the database
     * 
     * @param connection - the Connection object to the database
     */
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("\nConnection closed!\n");
            } catch (SQLException e) {
            }
        }
    }

    /**
     * Insert new row into table Liceu
     * 
     * @param codl - the id of a new highschool
     * @param denl - the name of a new highschool
     * @param adresal - the address of a new highschool
     */
    public static void insertIntoLiceu(String codl, String denl, String adresal) {

        String query = "INSERT INTO liceu VALUES(" + codl + ", '" + denl + "', '" + adresal + "')";
        Connection connection = null;
        connection = openConnection(connection);
        ResultSet result = executeQuery(connection, query);

        closeConnection(connection);
    }
    
    /**
     * Insert new row into table Users
     * 
     * @param nume - the last name of a new user
     * @param prenume - the first name of a new user
     * @param cnp - the personal numerical code of a new user
     * @param username - the username of a new user would be formed by the initials of his name and 3 random numbers
     * @param parola - the password of the user
     */
    public static void insertIntoUsers(String nume, String prenume, String cnp, String username, String parola) {
        String query = "INSERT INTO users VALUES('" + nume + "', '" + prenume + "', '" + cnp + "', '" + username + "', '" + parola + "', 'elev'" + ")";
        Connection connection = null;
        connection = openConnection(connection);
        ResultSet result = executeQuery(connection, query);
        closeConnection(connection);
    }

    /**
     * Return a string that contains the function for the specified user
     * 
     * @param username - the username of an user
     * @param parola - the password of an user
     * @return - the function of the given user can be administrator if the user is an admin or elev if the user is a student
     */
    public static String selectFunctieFromUsers(String username, String parola) {
        String query = "SELECT functie "
                + "FROM users "
                + "WHERE lower(username)=lower('" + username + "') "
                + "AND lower(parola)=lower('" + parola + "')";
        Connection connection = null;
        connection = openConnection(connection);
        ResultSet result = executeQuery(connection, query);
        List<String> results = new ArrayList<>();
        String rezultat = "faraFunctie";
        try {
            while (result.next()) {
                results.add(result.getString("functie"));
            }
        } catch (SQLException e) {
        }

        closeConnection(connection);

        if (results.size() > 1) {
            System.out.println("Prea multe rezultate");
        } else {
            rezultat = results.get(0);
        }
        return rezultat;
    }

    public static void insertIntoElev(String nume, String initiala, String prenume, String cnp, String profil, String liceu) {
        String query = "SELECT codp FROM profil WHERE lower(denp)=lower('" + profil + "')";
        Connection connection = null;
        connection = openConnection(connection);
        ResultSet resultProfil = executeQuery(connection, query);
        List<String> resultsProfil = new ArrayList<>();
        try {
            while (resultProfil.next()) {
                resultsProfil.add(resultProfil.getString("codp"));
            }
        } catch (SQLException e) {
        }

        String query2 = "SELECT codl FROM liceu WHERE lower(denl) = lower('" + liceu + "')";
        ResultSet resultLiceu = executeQuery(connection, query2);
        List<String> resultsLiceu = new ArrayList<>();
        try {
            while (resultLiceu.next()) {
                resultsLiceu.add(resultLiceu.getString("codl"));
            }
        } catch (SQLException e) {
        }

        String query3 = "SELECT codlp "
                + "FROM liceu_profil "
                + "WHERE codp = '" + resultsProfil.get(0) + "' "
                + "and codl = '" + resultsLiceu.get(0) + "'";

        ResultSet resultLiceu_Profil = executeQuery(connection, query3);
        List<String> resultsLiceu_Profil = new ArrayList<>();
        try {
            while (resultLiceu_Profil.next()) {
                resultsLiceu_Profil.add(resultLiceu_Profil.getString("codlp"));
            }
        } catch (SQLException e) {
        }

        String query4 = "INSERT INTO elev VALUES(seq_elev.nextval,'"
                + nume + "', '"
                + initiala + "', '"
                + prenume + "', '"
                + cnp + "', '"
                + resultsLiceu_Profil.get(0) + "')";
        executeQuery(connection, query4);

        String query5 = "SELECT code FROM elev WHERE cnp='" + cnp + "'";
        ResultSet resultElev = executeQuery(connection, query5);
        List<String> resultsElev = new ArrayList<>();
        try {
            while (resultElev.next()) {
                resultsElev.add(resultElev.getString("code"));
            }
        } catch (SQLException e) {
        }

        String query6 = "SELECT codpr FROM proba,elev,liceu_profil where proba.codp=liceu_profil.codp and elev.codlp=liceu_profil.codlp and cnp='" + cnp + "' and tip_proba=1";
        ResultSet resultProba1 = executeQuery(connection, query6);
        List<String> resultsProba1 = new ArrayList<>();
        try {
            while (resultProba1.next()) {
                resultsProba1.add(resultProba1.getString("codpr"));
            }
        } catch (SQLException e) {
        }

        String query7 = "SELECT codpr FROM proba,elev,liceu_profil where proba.codp=liceu_profil.codp and elev.codlp=liceu_profil.codlp and cnp='" + cnp + "' and tip_proba=2";
        ResultSet resultProba2 = executeQuery(connection, query7);
        List<String> resultsProba2 = new ArrayList<>();
        try {
            while (resultProba2.next()) {
                resultsProba2.add(resultProba2.getString("codpr"));
            }
        } catch (SQLException e) {
        }

        String query8 = "INSERT INTO examen VALUES(seq_examen.nextval, " + resultsElev.get(0) + ", " + resultsProba1.get(0) + " )";
        executeQuery(connection, query8);

        String query9 = "INSERT INTO examen VALUES(seq_examen.nextval, " + resultsElev.get(0) + ", " + resultsProba2.get(0) + " )";
        executeQuery(connection, query9);

        String query10 = "select codex from examen,elev,proba where examen.code=elev.code and examen.codpr=proba.codpr and tip_proba=1 and cnp='" + cnp + "'";
        ResultSet resultExamen1 = executeQuery(connection, query10);
        List<String> resultsExamen1 = new ArrayList<>();
        try {
            while (resultExamen1.next()) {
                resultsExamen1.add(resultExamen1.getString("codex"));
            }
        } catch (SQLException e) {
        }

        String query11 = "select codex from examen,elev,proba where examen.code=elev.code and examen.codpr=proba.codpr and tip_proba=2 and cnp='" + cnp + "'";
        ResultSet resultExamen2 = executeQuery(connection, query11);
        List<String> resultsExamen2 = new ArrayList<>();
        try {
            while (resultExamen2.next()) {
                resultsExamen2.add(resultExamen2.getString("codex"));
            }
        } catch (SQLException e) {
        }

        String query12 = "INSERT INTO rezultat VALUES(" + resultsExamen1.get(0) + ",0.0,0.0)";
        executeQuery(connection, query12);

        String query13 = "INSERT INTO rezultat VALUES(" + resultsExamen2.get(0) + ",0.0,0.0)";
        executeQuery(connection, query13);

        connection = openConnection(connection);
        closeConnection(connection);
    }

    public static List<String> selectDenlFromLiceu() {
        String query = "SELECT denl FROM liceu";
        Connection connection = null;
        connection = openConnection(connection);
        ResultSet result = executeQuery(connection, query);
        List<String> results = new ArrayList<>();
        try {
            while (result.next()) {
                results.add(result.getString("denl"));
            }
        } catch (SQLException e) {
        }

        closeConnection(connection);
        return results;
    }

    public static List<String> selectDenpFromProfil() {
        String query = "SELECT denp FROM profil";
        Connection connection = null;
        connection = openConnection(connection);
        ResultSet result = executeQuery(connection, query);
        List<String> results = new ArrayList<>();
        try {
            while (result.next()) {
                results.add(result.getString("denp"));
            }
        } catch (SQLException e) {
        }

        closeConnection(connection);
        return results;
    }

    public static List<String> selectDenpFromProfilWhereLiceuIsSelected(String liceu) {
        String query = "SELECT denp "
                + "FROM profil, liceu, liceu_profil "
                + "WHERE profil.codp=liceu_profil.codp "
                + "and liceu.codl=liceu_profil.codl "
                + "and denl='" + liceu + "'";
        Connection connection = null;
        connection = openConnection(connection);
        ResultSet result = executeQuery(connection, query);
        List<String> results = new ArrayList<>();
        try {
            while (result.next()) {
                results.add(result.getString("denp"));
            }
        } catch (SQLException e) {
        }

        closeConnection(connection);
        return results;
    }

    public static List<String> selectCodlpFromElev(String nume, String prenume, String cnp) {
        String query = "SELECT codlp "
                + "FROM elev "
                + "where lower(nume)=lower('" + nume + "') "
                + "and lower(prenume)=lower('" + prenume + "') "
                + "and cnp='" + cnp + "'";
        Connection connection = null;
        connection = openConnection(connection);
        ResultSet result = executeQuery(connection, query);
        List<String> results = new ArrayList<>();
        try {
            while (result.next()) {
                results.add(result.getString("codlp"));
            }
        } catch (SQLException e) {
        }

        closeConnection(connection);
        return results;
    }

    public static List<String> selectNumeFromElev(String nume, String prenume, String cnp) {
        String query = "SELECT nume, init_tata, prenume "
                + "FROM elev,liceu,profil,liceu_profil "
                + "WHERE lower(nume) like lower('%" + nume + "%') "
                + "and lower(prenume) like lower('%" + prenume + "%') "
                + "and cnp like '%" + cnp + "%' "
                + "and elev.codlp = liceu_profil.codlp "
                + "and liceu_profil.codp = profil.codp "
                + "and liceu_profil.codl = liceu.codl "
                + "order by code ";
        Connection connection = null;
        connection = openConnection(connection);
        ResultSet result = executeQuery(connection, query);
        List<String> results = new ArrayList<>();
        try {
            while (result.next()) {
                results.add(result.getString("nume") + " " + result.getString("init_tata") + ". " + result.getString("prenume"));
            }
        } catch (SQLException e) {
        }

        closeConnection(connection);
        return results;
    }

    public static List<String> selectNumeCompletElev(String cnp) {
        String query = "SELECT nume, init_tata, prenume "
                + "FROM elev "
                + "WHERE cnp = '" + cnp + "' ";
        Connection connection = null;
        connection = openConnection(connection);
        ResultSet result = executeQuery(connection, query);
        List<String> results = new ArrayList<>();
        try {
            while (result.next()) {
                results.add(result.getString("nume") + " " + result.getString("init_tata") + ". " + result.getString("prenume"));
            }
        } catch (SQLException e) {
        }

        closeConnection(connection);
        return results;
    }

    public static List<String> selectCNPFromElev(String nume, String prenume, String cnp) {
        String query = "SELECT cnp "
                + "FROM elev,liceu,profil,liceu_profil "
                + "WHERE lower(nume) like lower('%" + nume + "%') "
                + "and lower(prenume) like lower('%" + prenume + "%') "
                + "and cnp like '%" + cnp + "%' "
                + "and elev.codlp = liceu_profil.codlp "
                + "and liceu_profil.codp = profil.codp "
                + "and liceu_profil.codl = liceu.codl "
                + "order by code ";
        Connection connection = null;
        connection = openConnection(connection);
        ResultSet result = executeQuery(connection, query);
        List<String> results = new ArrayList<>();
        try {
            while (result.next()) {
                results.add(result.getString("cnp"));
            }
        } catch (SQLException e) {
        }

        closeConnection(connection);
        return results;
    }

    public static List<String> selectDenlFromLiceuForElev(String nume, String prenume, String cnp) {
        String query = "SELECT denl "
                + "FROM elev,liceu,profil,liceu_profil "
                + "WHERE lower(nume) like lower('%" + nume + "%') "
                + "and lower(prenume) like lower('%" + prenume + "%') "
                + "and cnp like '%" + cnp + "%' "
                + "and elev.codlp = liceu_profil.codlp "
                + "and liceu_profil.codp = profil.codp "
                + "and liceu_profil.codl = liceu.codl "
                + "order by code ";
        Connection connection = null;
        connection = openConnection(connection);
        ResultSet result = executeQuery(connection, query);
        List<String> results = new ArrayList<>();
        try {
            while (result.next()) {
                results.add(result.getString("denl"));
            }
        } catch (SQLException e) {
        }

        closeConnection(connection);
        return results;
    }

    public static List<String> selectDenpFromProfilForElev(String nume, String prenume, String cnp) {
        String query = "SELECT denp "
                + "FROM elev,liceu,profil,liceu_profil "
                + "WHERE lower(nume) like lower('%" + nume + "%') "
                + "and lower(prenume) like lower('%" + prenume + "%') "
                + "and cnp like '%" + cnp + "%' "
                + "and elev.codlp = liceu_profil.codlp "
                + "and liceu_profil.codp = profil.codp "
                + "and liceu_profil.codl = liceu.codl "
                + "order by code ";
        Connection connection = null;
        connection = openConnection(connection);
        ResultSet result = executeQuery(connection, query);
        List<String> results = new ArrayList<>();
        try {
            while (result.next()) {
                results.add(result.getString("denp"));
            }
        } catch (SQLException ex) {
        }

        closeConnection(connection);
        return results;
    }

    public static void deleteElev(String cnp) {
        String query1 = "DELETE "
                + "FROM rezultat "
                + "WHERE codex in "
                + "(SELECT codex "
                + "FROM examen "
                + "WHERE code = (SELECT code "
                + "FROM elev "
                + "where cnp = '" + cnp + "' ))";
        Connection connection = null;
        connection = openConnection(connection);
        executeQuery(connection, query1);

        String query2 = "DELETE "
                + "FROM examen "
                + "WHERE code = "
                + "(SELECT code "
                + "FROM elev "
                + "where cnp = '" + cnp + "' )";
        executeQuery(connection, query2);

        String query3 = "DELETE "
                + "FROM elev "
                + "where cnp = '" + cnp + "' ";
        executeQuery(connection, query3);

        String query4 = "DELETE "
                + "FROM users "
                + "where cnp = '" + cnp + "' ";
        executeQuery(connection, query4);

        closeConnection(connection);
    }

    public static List<String> selectDenpr3FromProba(String profil) {
        String query = "SELECT denpr "
                + "FROM proba, profil "
                + "WHERE proba.codp = profil.codp "
                + "AND tip_proba = 3 "
                + "AND denp = '" + profil + "'";
        Connection connection = null;
        connection = openConnection(connection);
        ResultSet result = executeQuery(connection, query);
        List<String> results = new ArrayList<>();
        try {
            while (result.next()) {
                results.add(result.getString("denpr"));
            }
        } catch (SQLException e) {
        }

        closeConnection(connection);
        return results;
    }

    public static List<String> selectDenprForElev(String cnp, int tip_proba) {
        String query = "SELECT denpr "
                + "FROM proba,examen,elev "
                + "WHERE proba.codpr=examen.codpr "
                + "AND examen.code=elev.code "
                + "AND proba.tip_proba= " + tip_proba + " "
                + "AND elev.cnp='" + cnp + "'";
        Connection connection = null;
        connection = openConnection(connection);
        ResultSet result = executeQuery(connection, query);
        List<String> results = new ArrayList<>();
        try {
            while (result.next()) {
                results.add(result.getString("denpr"));
            }
        } catch (SQLException e) {
        }

        closeConnection(connection);
        return results;
    }

    public static List<Double> selectNota_initForElev(String cnp, int tip_proba) {
        String query = "SELECT nota_init "
                + "FROM rezultat,examen,elev,proba "
                + "WHERE proba.codpr=examen.codpr "
                + "AND examen.code=elev.code "
                + "AND rezultat.codex=examen.codex "
                + "AND proba.tip_proba= " + tip_proba + " "
                + "AND elev.cnp='" + cnp + "'";
        Connection connection = null;
        connection = openConnection(connection);
        ResultSet result = executeQuery(connection, query);
        List<Double> results = new ArrayList<>();
        try {
            while (result.next()) {
                results.add(result.getDouble("nota_init"));
            }
        } catch (SQLException e) {
        }

        closeConnection(connection);
        return results;
    }

    public static List<Double> selectNota_contForElev(String cnp, int tip_proba) {
        String query = "SELECT nota_cont "
                + "FROM rezultat,examen,elev,proba "
                + "WHERE proba.codpr=examen.codpr "
                + "AND examen.code=elev.code "
                + "AND rezultat.codex=examen.codex "
                + "AND proba.tip_proba= '" + tip_proba + "' "
                + "AND elev.cnp='" + cnp + "'";
        Connection connection = null;
        connection = openConnection(connection);
        ResultSet result = executeQuery(connection, query);
        List<Double> results = new ArrayList<>();
        try {
            while (result.next()) {
                results.add(result.getDouble("nota_cont"));
            }
        } catch (SQLException e) {
        }

        closeConnection(connection);
        return results;
    }

    public static List<String> selectCNPFromUsers(String username, String parola) {
        String query = "SELECT cnp "
                + "FROM users "
                + "WHERE username = '" + username + "' "
                + "AND parola = '" + parola + "' ";
        Connection connection = null;
        connection = openConnection(connection);
        ResultSet result = executeQuery(connection, query);
        List<String> results = new ArrayList<>();
        try {
            while (result.next()) {
                results.add(result.getString("cnp"));
            }
        } catch (SQLException e) {
        }

        closeConnection(connection);
        return results;
    }

    public static List<String> selectUsernameFromUsers(String cnp) {
        String query = "SELECT username "
                + "FROM users "
                + "WHERE cnp = '" + cnp + "' ";
        Connection connection = null;
        connection = openConnection(connection);
        ResultSet result = executeQuery(connection, query);
        List<String> results = new ArrayList<>();
        try {
            while (result.next()) {
                results.add(result.getString("username"));
            }
        } catch (SQLException e) {
        }

        closeConnection(connection);
        return results;
    }

    public static void insertProba3(String cnp, String denumire_proba) {
        String query = "SELECT code FROM elev WHERE cnp='" + cnp + "' ";
        Connection connection = null;
        connection = openConnection(connection);
        ResultSet resultElev = executeQuery(connection, query);
        List<String> resultsElev = new ArrayList<>();
        try {
            while (resultElev.next()) {
                resultsElev.add(resultElev.getString("code"));
            }
        } catch (SQLException e) {
        }

        String query2 = "select codpr from proba,elev,liceu_profil where proba.codp=liceu_profil.codp and elev.codlp= liceu_profil.codlp and proba.denpr='" + denumire_proba + "' and proba.tip_proba=3 and elev.cnp='" + cnp + "' ";
        ResultSet resultProba = executeQuery(connection, query2);
        List<String> resultsProba = new ArrayList<>();
        try {
            while (resultProba.next()) {
                resultsProba.add(resultProba.getString("codpr"));
            }
        } catch (SQLException e) {
        }

        String query3 = "INSERT INTO examen VALUES(seq_examen.nextval, " + resultsElev.get(0) + ", " + resultsProba.get(0) + " )";
        executeQuery(connection, query3);

        String query4 = "select codex from examen,elev,proba where examen.code=elev.code and examen.codpr=proba.codpr and tip_proba=3 and cnp='" + cnp + "'";
        ResultSet resultExamen = executeQuery(connection, query4);
        List<String> resultsExamen = new ArrayList<>();
        try {
            while (resultExamen.next()) {
                resultsExamen.add(resultExamen.getString("codex"));
            }
        } catch (SQLException e) {
        }

        String query5 = "INSERT INTO rezultat VALUES(" + resultsExamen.get(0) + ",0.0, 0.0)";
        executeQuery(connection, query5);

        closeConnection(connection);
    }

    public static void updateElevAndProba(String nume, String init_tata, String prenume, String cnp, String proba3, Double nota_initiala1, Double nota_initiala2, Double nota_initiala3) {
        String query = "update elev set nume='" + nume + "',init_tata='" + init_tata + "',prenume='" + prenume + "' where cnp='" + cnp + "' ";
        Connection connection = null;
        connection = openConnection(connection);
        executeQuery(connection, query);

        String query2 = "update users set nume='" + nume + "',prenume='" + prenume + "' where cnp='" + cnp + "' ";
        executeQuery(connection, query2);

        String query3 = "select codpr from proba,elev,liceu_profil,profil where proba.codp=profil.codp and elev.codlp=liceu_profil.codlp and liceu_profil.codp=profil.codp and elev.cnp = '" + cnp + "' and proba.denpr='" + proba3 + "' and proba.tip_proba = 3";
        ResultSet resultProba3 = executeQuery(connection, query3);
        List<String> resultsProba3 = new ArrayList<>();
        try {
            while (resultProba3.next()) {
                resultsProba3.add(resultProba3.getString("codpr"));
            }
        } catch (SQLException e) {
        }

        String query4 = "select codex from examen,elev,proba where examen.code=elev.code and proba.codpr=examen.codpr and tip_proba = 3 and cnp = '" + cnp + "'";
        ResultSet resultExamen3 = executeQuery(connection, query4);
        List<String> resultsExamen3 = new ArrayList<>();
        try {
            while (resultExamen3.next()) {
                resultsExamen3.add(resultExamen3.getString("codex"));
            }
        } catch (SQLException e) {
        }

        String query5 = "update examen set codpr=" + resultsProba3.get(0) + " where codex=" + resultsExamen3.get(0) + " ";
        executeQuery(connection, query5);

        String query6 = "select codex from examen,elev,proba where examen.code=elev.code and examen.codpr=proba.codpr and cnp='" + cnp + "' and tip_proba=1";
        ResultSet resultExamen1 = executeQuery(connection, query6);
        List<String> resultsExamen1 = new ArrayList<>();
        try {
            while (resultExamen1.next()) {
                resultsExamen1.add(resultExamen1.getString("codex"));
            }
        } catch (SQLException e) {
        }

        String query7 = "select codex from examen,elev,proba where examen.code=elev.code and examen.codpr=proba.codpr and cnp='" + cnp + "' and tip_proba=2";
        ResultSet resultExamen2 = executeQuery(connection, query7);
        List<String> resultsExamen2 = new ArrayList<>();
        try {
            while (resultExamen2.next()) {
                resultsExamen2.add(resultExamen2.getString("codex"));
            }
        } catch (SQLException e) {
        }

        String query8 = "update rezultat set nota_init = " + nota_initiala1 + "  where codex=" + resultsExamen1.get(0) + " ";
        executeQuery(connection, query8);

        String query9 = "update rezultat set nota_init = " + nota_initiala2 + "  where codex=" + resultsExamen2.get(0) + " ";
        executeQuery(connection, query9);

        String query10 = "update rezultat set nota_init = " + nota_initiala3 + "  where codex=" + resultsExamen3.get(0) + " ";
        executeQuery(connection, query10);

        closeConnection(connection);
    }

    public static void updateElev(String nume, String init_tata, String prenume, String cnp, Double nota_initiala1, Double nota_initiala2) {
        String query = "update elev set nume='" + nume + "',init_tata='" + init_tata + "',prenume='" + prenume + "' where cnp='" + cnp + "' ";
        Connection connection = null;
        connection = openConnection(connection);
        executeQuery(connection, query);

        String query2 = "update users set nume='" + nume + "',prenume='" + prenume + "' where cnp='" + cnp + "' ";
        executeQuery(connection, query2);

        String query6 = "select codex from examen,elev,proba where examen.code=elev.code and examen.codpr=proba.codpr and cnp='" + cnp + "' and tip_proba=1";
        ResultSet resultExamen1 = executeQuery(connection, query6);
        List<String> resultsExamen1 = new ArrayList<>();
        try {
            while (resultExamen1.next()) {
                resultsExamen1.add(resultExamen1.getString("codex"));
            }
        } catch (SQLException e) {
        }

        String query7 = "select codex from examen,elev,proba where examen.code=elev.code and examen.codpr=proba.codpr and cnp='" + cnp + "' and tip_proba=2";
        ResultSet resultExamen2 = executeQuery(connection, query7);
        List<String> resultsExamen2 = new ArrayList<>();
        try {
            while (resultExamen2.next()) {
                resultsExamen2.add(resultExamen2.getString("codex"));
            }
        } catch (SQLException e) {
        }

        String query8 = "update rezultat set nota_init = " + nota_initiala1 + " where codex=" + resultsExamen1.get(0) + " ";
        executeQuery(connection, query8);

        String query9 = "update rezultat set nota_init = " + nota_initiala2 + " where codex=" + resultsExamen2.get(0) + " ";
        executeQuery(connection, query9);

        closeConnection(connection);
    }

    public static void updateNota_cont(String cnp, Double nota_contestatie, int tip_proba) {
        String query = "update rezultat "
                + "set nota_cont=" + nota_contestatie + " "
                + "where codex = (select codex "
                + "from examen,elev,proba "
                + "where examen.code=elev.code "
                + "and examen.codpr=proba.codpr "
                + "and tip_proba=" + tip_proba + " "
                + "and cnp ='" + cnp + "') ";
        Connection connection = null;
        connection = openConnection(connection);
        executeQuery(connection, query);
        closeConnection(connection);
    }

    public static void updateNota_cont(String cnp, Double nota_contestatie, String proba) {
        String query = "update rezultat "
                + "set nota_cont=" + nota_contestatie + " "
                + "where codex = (select codex "
                + "from examen,elev,proba "
                + "where examen.code=elev.code "
                + "and examen.codpr=proba.codpr "
                + "and denpr ='" + proba + "' "
                + "and cnp ='" + cnp + "') ";
        Connection connection = null;
        connection = openConnection(connection);
        executeQuery(connection, query);
        closeConnection(connection);
    }

    public static List<String> selectNumeForContestatie() {
        String query = "select nume,init_tata,prenume "
                + "from elev,proba,examen,rezultat "
                + "where elev.code = examen.code "
                + "and proba.codpr=examen.codpr "
                + "and rezultat.codex=examen.codex "
                + "and nota_cont <> 0.0 "
                + "order by elev.code,proba.tip_proba ";
        Connection connection = null;
        connection = openConnection(connection);
        ResultSet result = executeQuery(connection, query);
        List<String> results = new ArrayList<>();
        try {
            while (result.next()) {
                results.add(result.getString("nume") + " " + result.getString("init_tata") + ". " + result.getString("prenume"));
            }
        } catch (SQLException e) {
        }

        closeConnection(connection);
        return results;
    }

    public static List<String> selectCNPForContestatie() {
        String query = "select cnp "
                + "from elev,proba,examen,rezultat "
                + "where elev.code = examen.code "
                + "and proba.codpr=examen.codpr "
                + "and rezultat.codex=examen.codex "
                + "and nota_cont <> 0.0 "
                + "order by elev.code,proba.tip_proba ";
        Connection connection = null;
        connection = openConnection(connection);
        ResultSet result = executeQuery(connection, query);
        List<String> results = new ArrayList<>();
        try {
            while (result.next()) {
                results.add(result.getString("cnp"));
            }
        } catch (SQLException e) {
        }

        closeConnection(connection);
        return results;
    }

    public static List<String> selectDenprForContestatie() {
        String query = "select denpr "
                + "from elev,proba,examen,rezultat "
                + "where elev.code = examen.code "
                + "and proba.codpr=examen.codpr "
                + "and rezultat.codex=examen.codex "
                + "and nota_cont <> 0.0 "
                + "order by elev.code,proba.tip_proba ";
        Connection connection = null;
        connection = openConnection(connection);
        ResultSet result = executeQuery(connection, query);
        List<String> results = new ArrayList<>();
        try {
            while (result.next()) {
                results.add(result.getString("denpr"));
            }
        } catch (SQLException e) {
        }

        closeConnection(connection);
        return results;
    }

    public static List<Double> selectNota_contForContestatie() {
        String query = "select nota_cont "
                + "from elev,proba,examen,rezultat "
                + "where elev.code = examen.code "
                + "and proba.codpr=examen.codpr "
                + "and rezultat.codex=examen.codex "
                + "and nota_cont <> 0.0 "
                + "order by elev.code,proba.tip_proba ";
        Connection connection = null;
        connection = openConnection(connection);
        ResultSet result = executeQuery(connection, query);
        List<Double> results = new ArrayList<>();
        try {
            while (result.next()) {
                results.add(result.getDouble("nota_cont"));
            }
        } catch (SQLException e) {
        }

        closeConnection(connection);
        return results;
    }

    public static List<String> selectNumeForRezultat() {
        String query = "select nume, init_tata, prenume \n "
                + "from rezultat r1, rezultat r2, rezultat r3, examen e1, examen e2, examen e3, elev, proba p1, proba p2, proba p3, liceu, profil, liceu_profil \n "
                + "where profil.codp= liceu_profil.codp \n "
                + "and liceu.codl=liceu_profil.codl \n "
                + "and elev.codlp=liceu_profil.codlp \n "
                + "and p1.tip_proba = 1 \n "
                + "and p2.tip_proba = 2 \n "
                + "and p3.tip_proba = 3 \n "
                + "and r1.codex = e1.codex \n "
                + "and e1.code = elev.code \n "
                + "and e1.codpr = p1.codpr \n "
                + "and r2.codex = e2.codex \n "
                + "and e2.code = elev.code \n "
                + "and e2.codpr = p2.codpr \n "
                + "and r3.codex = e3.codex \n "
                + "and e3.code = elev.code \n "
                + "and e3.codpr = p3.codpr \n "
                + "and elev.code in (select elev.code from examen,elev where elev.code=examen.code group by elev.code having count(examen.code)=3) \n "
                + "order by elev.nume,elev.init_tata,elev.prenume ";
        Connection connection = null;
        connection = openConnection(connection);
        ResultSet result = executeQuery(connection, query);
        List<String> results = new ArrayList<>();
        try {
            while (result.next()) {
                results.add(result.getString("nume") + " " + result.getString("init_tata") + ". " + result.getString("prenume"));
            }
        } catch (SQLException e) {
        }

        closeConnection(connection);
        return results;
    }

    public static List<String> selectDenlForRezultat() {
        String query = "select denl \n"
                + "from rezultat r1, rezultat r2, rezultat r3, examen e1, examen e2, examen e3, elev, proba p1, proba p2, proba p3, liceu, profil, liceu_profil \n"
                + "where profil.codp= liceu_profil.codp \n"
                + "and liceu.codl=liceu_profil.codl \n"
                + "and elev.codlp=liceu_profil.codlp \n"
                + "and p1.tip_proba = 1 \n"
                + "and p2.tip_proba = 2 \n"
                + "and p3.tip_proba = 3 \n"
                + "and r1.codex = e1.codex \n"
                + "and e1.code = elev.code \n"
                + "and e1.codpr = p1.codpr \n"
                + "and r2.codex = e2.codex \n"
                + "and e2.code = elev.code \n"
                + "and e2.codpr = p2.codpr \n"
                + "and r3.codex = e3.codex \n"
                + "and e3.code = elev.code \n"
                + "and e3.codpr = p3.codpr \n"
                + "and elev.code in (select elev.code from examen,elev where elev.code=examen.code group by elev.code having count(examen.code)=3) \n"
                + "order by elev.nume,elev.init_tata,elev.prenume ";
        Connection connection = null;
        connection = openConnection(connection);
        ResultSet result = executeQuery(connection, query);
        List<String> results = new ArrayList<>();
        try {
            while (result.next()) {
                results.add(result.getString("denl"));
            }
        } catch (SQLException e) {
        }

        closeConnection(connection);
        return results;
    }

    public static List<String> selectDenpForRezultat() {
        String query = "select denp \n"
                + "from rezultat r1, rezultat r2, rezultat r3, examen e1, examen e2, examen e3, elev, proba p1, proba p2, proba p3, liceu, profil, liceu_profil \n"
                + "where profil.codp= liceu_profil.codp \n"
                + "and liceu.codl=liceu_profil.codl \n"
                + "and elev.codlp=liceu_profil.codlp \n"
                + "and p1.tip_proba = 1 \n"
                + "and p2.tip_proba = 2 \n"
                + "and p3.tip_proba = 3 \n"
                + "and r1.codex = e1.codex \n"
                + "and e1.code = elev.code \n"
                + "and e1.codpr = p1.codpr \n"
                + "and r2.codex = e2.codex \n"
                + "and e2.code = elev.code \n"
                + "and e2.codpr = p2.codpr \n"
                + "and r3.codex = e3.codex \n"
                + "and e3.code = elev.code \n"
                + "and e3.codpr = p3.codpr \n"
                + "and elev.code in (select elev.code from examen,elev where elev.code=examen.code group by elev.code having count(examen.code)=3) \n"
                + "order by elev.nume,elev.init_tata,elev.prenume ";
        Connection connection = null;
        connection = openConnection(connection);
        ResultSet result = executeQuery(connection, query);
        List<String> results = new ArrayList<>();
        try {
            while (result.next()) {
                results.add(result.getString("denp"));
            }
        } catch (SQLException e) {
        }

        closeConnection(connection);
        return results;
    }

    public static List<String> selectProba1ForRezultat() {
        String query = "select p1.denpr \n"
                + "from rezultat r1, rezultat r2, rezultat r3, examen e1, examen e2, examen e3, elev, proba p1, proba p2, proba p3, liceu, profil, liceu_profil \n"
                + "where profil.codp= liceu_profil.codp \n"
                + "and liceu.codl=liceu_profil.codl \n"
                + "and elev.codlp=liceu_profil.codlp \n"
                + "and p1.tip_proba = 1 \n"
                + "and p2.tip_proba = 2 \n"
                + "and p3.tip_proba = 3 \n"
                + "and r1.codex = e1.codex \n"
                + "and e1.code = elev.code \n"
                + "and e1.codpr = p1.codpr \n"
                + "and r2.codex = e2.codex \n"
                + "and e2.code = elev.code \n"
                + "and e2.codpr = p2.codpr \n"
                + "and r3.codex = e3.codex \n"
                + "and e3.code = elev.code \n"
                + "and e3.codpr = p3.codpr \n"
                + "and elev.code in (select elev.code from examen,elev where elev.code=examen.code group by elev.code having count(examen.code)=3) \n"
                + "order by elev.nume,elev.init_tata,elev.prenume ";
        Connection connection = null;
        connection = openConnection(connection);
        ResultSet result = executeQuery(connection, query);
        List<String> results = new ArrayList<>();
        try {
            while (result.next()) {
                results.add(result.getString("denpr"));
            }
        } catch (SQLException e) {
        }

        closeConnection(connection);
        return results;
    }

    public static List<Double> selectNota_init1ForRezultat() {
        String query = "select r1.nota_init \n"
                + "from rezultat r1, rezultat r2, rezultat r3, examen e1, examen e2, examen e3, elev, proba p1, proba p2, proba p3, liceu, profil, liceu_profil \n"
                + "where profil.codp= liceu_profil.codp \n"
                + "and liceu.codl=liceu_profil.codl \n"
                + "and elev.codlp=liceu_profil.codlp \n"
                + "and p1.tip_proba = 1 \n"
                + "and p2.tip_proba = 2 \n"
                + "and p3.tip_proba = 3 \n"
                + "and r1.codex = e1.codex \n"
                + "and e1.code = elev.code \n"
                + "and e1.codpr = p1.codpr \n"
                + "and r2.codex = e2.codex \n"
                + "and e2.code = elev.code \n"
                + "and e2.codpr = p2.codpr \n"
                + "and r3.codex = e3.codex \n"
                + "and e3.code = elev.code \n"
                + "and e3.codpr = p3.codpr \n"
                + "and elev.code in (select elev.code from examen,elev where elev.code=examen.code group by elev.code having count(examen.code)=3) \n"
                + "order by elev.nume,elev.init_tata,elev.prenume ";
        Connection connection = null;
        connection = openConnection(connection);
        ResultSet result = executeQuery(connection, query);
        List<Double> results = new ArrayList<>();
        try {
            while (result.next()) {
                results.add(result.getDouble("nota_init"));
            }
        } catch (SQLException e) {
        }

        closeConnection(connection);
        return results;
    }

    public static List<Double> selectNota_cont1ForRezultat() {
        String query = "select r1.nota_cont \n"
                + "from rezultat r1, rezultat r2, rezultat r3, examen e1, examen e2, examen e3, elev, proba p1, proba p2, proba p3, liceu, profil, liceu_profil \n"
                + "where profil.codp= liceu_profil.codp \n"
                + "and liceu.codl=liceu_profil.codl \n"
                + "and elev.codlp=liceu_profil.codlp \n"
                + "and p1.tip_proba = 1 \n"
                + "and p2.tip_proba = 2 \n"
                + "and p3.tip_proba = 3 \n"
                + "and r1.codex = e1.codex \n"
                + "and e1.code = elev.code \n"
                + "and e1.codpr = p1.codpr \n"
                + "and r2.codex = e2.codex \n"
                + "and e2.code = elev.code \n"
                + "and e2.codpr = p2.codpr \n"
                + "and r3.codex = e3.codex \n"
                + "and e3.code = elev.code \n"
                + "and e3.codpr = p3.codpr \n"
                + "and elev.code in (select elev.code from examen,elev where elev.code=examen.code group by elev.code having count(examen.code)=3) \n"
                + "order by elev.nume,elev.init_tata,elev.prenume ";
        Connection connection = null;
        connection = openConnection(connection);
        ResultSet result = executeQuery(connection, query);
        List<Double> results = new ArrayList<>();
        try {
            while (result.next()) {
                results.add(result.getDouble("nota_cont"));
            }
        } catch (SQLException e) {
        }

        closeConnection(connection);
        return results;
    }

    public static List<String> selectProba2ForRezultat() {
        String query = "select p2.denpr \n"
                + "from rezultat r1, rezultat r2, rezultat r3, examen e1, examen e2, examen e3, elev, proba p1, proba p2, proba p3, liceu, profil, liceu_profil \n"
                + "where profil.codp= liceu_profil.codp \n"
                + "and liceu.codl=liceu_profil.codl \n"
                + "and elev.codlp=liceu_profil.codlp \n"
                + "and p1.tip_proba = 1 \n"
                + "and p2.tip_proba = 2 \n"
                + "and p3.tip_proba = 3 \n"
                + "and r1.codex = e1.codex \n"
                + "and e1.code = elev.code \n"
                + "and e1.codpr = p1.codpr \n"
                + "and r2.codex = e2.codex \n"
                + "and e2.code = elev.code \n"
                + "and e2.codpr = p2.codpr \n"
                + "and r3.codex = e3.codex \n"
                + "and e3.code = elev.code \n"
                + "and e3.codpr = p3.codpr \n"
                + "and elev.code in (select elev.code from examen,elev where elev.code=examen.code group by elev.code having count(examen.code)=3) \n"
                + "order by elev.nume,elev.init_tata,elev.prenume ";
        Connection connection = null;
        connection = openConnection(connection);
        ResultSet result = executeQuery(connection, query);
        List<String> results = new ArrayList<>();
        try {
            while (result.next()) {
                results.add(result.getString("denpr"));
            }
        } catch (SQLException e) {
        }

        closeConnection(connection);
        return results;
    }

    public static List<Double> selectNota_init2ForRezultat() {
        String query = "select r2.nota_init \n"
                + "from rezultat r1, rezultat r2, rezultat r3, examen e1, examen e2, examen e3, elev, proba p1, proba p2, proba p3, liceu, profil, liceu_profil \n"
                + "where profil.codp= liceu_profil.codp \n"
                + "and liceu.codl=liceu_profil.codl \n"
                + "and elev.codlp=liceu_profil.codlp \n"
                + "and p1.tip_proba = 1 \n"
                + "and p2.tip_proba = 2 \n"
                + "and p3.tip_proba = 3 \n"
                + "and r1.codex = e1.codex\n"
                + "and e1.code = elev.code \n"
                + "and e1.codpr = p1.codpr \n"
                + "and r2.codex = e2.codex \n"
                + "and e2.code = elev.code \n"
                + "and e2.codpr = p2.codpr \n"
                + "and r3.codex = e3.codex \n"
                + "and e3.code = elev.code \n"
                + "and e3.codpr = p3.codpr \n"
                + "and elev.code in (select elev.code from examen,elev where elev.code=examen.code group by elev.code having count(examen.code)=3) \n"
                + "order by elev.nume,elev.init_tata,elev.prenume ";
        Connection connection = null;
        connection = openConnection(connection);
        ResultSet result = executeQuery(connection, query);
        List<Double> results = new ArrayList<>();
        try {
            while (result.next()) {
                results.add(result.getDouble("nota_init"));
            }
        } catch (SQLException e) {
        }

        closeConnection(connection);
        return results;
    }

    public static List<Double> selectNota_cont2ForRezultat() {
        String query = "select r2.nota_cont \n"
                + "from rezultat r1, rezultat r2, rezultat r3, examen e1, examen e2, examen e3, elev, proba p1, proba p2, proba p3, liceu, profil, liceu_profil \n"
                + "where profil.codp= liceu_profil.codp \n"
                + "and liceu.codl=liceu_profil.codl \n"
                + "and elev.codlp=liceu_profil.codlp \n"
                + "and p1.tip_proba = 1 \n"
                + "and p2.tip_proba = 2 \n"
                + "and p3.tip_proba = 3 \n"
                + "and r1.codex = e1.codex \n"
                + "and e1.code = elev.code \n"
                + "and e1.codpr = p1.codpr \n"
                + "and r2.codex = e2.codex \n"
                + "and e2.code = elev.code \n"
                + "and e2.codpr = p2.codpr \n"
                + "and r3.codex = e3.codex \n"
                + "and e3.code = elev.code \n"
                + "and e3.codpr = p3.codpr \n"
                + "and elev.code in (select elev.code from examen,elev where elev.code=examen.code group by elev.code having count(examen.code)=3) \n"
                + "order by elev.nume,elev.init_tata,elev.prenume ";
        Connection connection = null;
        connection = openConnection(connection);
        ResultSet result = executeQuery(connection, query);
        List<Double> results = new ArrayList<>();
        try {
            while (result.next()) {
                results.add(result.getDouble("nota_cont"));
            }
        } catch (SQLException e) {
        }

        closeConnection(connection);
        return results;
    }

    public static List<String> selectProba3ForRezultat() {
        String query = "select p3.denpr \n"
                + "from rezultat r1, rezultat r2, rezultat r3, examen e1, examen e2, examen e3, elev, proba p1, proba p2, proba p3, liceu, profil, liceu_profil \n"
                + "where profil.codp= liceu_profil.codp \n"
                + "and liceu.codl=liceu_profil.codl \n"
                + "and elev.codlp=liceu_profil.codlp \n"
                + "and p1.tip_proba = 1 \n"
                + "and p2.tip_proba = 2 \n"
                + "and p3.tip_proba = 3 \n"
                + "and r1.codex = e1.codex \n"
                + "and e1.code = elev.code \n"
                + "and e1.codpr = p1.codpr \n"
                + "and r2.codex = e2.codex \n"
                + "and e2.code = elev.code \n"
                + "and e2.codpr = p2.codpr \n"
                + "and r3.codex = e3.codex \n"
                + "and e3.code = elev.code \n"
                + "and e3.codpr = p3.codpr \n"
                + "and elev.code in (select elev.code from examen,elev where elev.code=examen.code group by elev.code having count(examen.code)=3) \n"
                + "order by elev.nume,elev.init_tata,elev.prenume ";
        Connection connection = null;
        connection = openConnection(connection);
        ResultSet result = executeQuery(connection, query);
        List<String> results = new ArrayList<>();
        try {
            while (result.next()) {
                results.add(result.getString("denpr"));
            }
        } catch (SQLException e) {
        }

        closeConnection(connection);
        return results;
    }

    public static List<Double> selectNota_init3ForRezultat() {
        String query = "select r3.nota_init \n"
                + "from rezultat r1, rezultat r2, rezultat r3, examen e1, examen e2, examen e3, elev, proba p1, proba p2, proba p3, liceu, profil, liceu_profil \n"
                + "where profil.codp= liceu_profil.codp \n"
                + "and liceu.codl=liceu_profil.codl \n"
                + "and elev.codlp=liceu_profil.codlp \n"
                + "and p1.tip_proba = 1 \n"
                + "and p2.tip_proba = 2 \n"
                + "and p3.tip_proba = 3 \n"
                + "and r1.codex = e1.codex \n"
                + "and e1.code = elev.code \n"
                + "and e1.codpr = p1.codpr \n"
                + "and r2.codex = e2.codex \n"
                + "and e2.code = elev.code \n"
                + "and e2.codpr = p2.codpr \n"
                + "and r3.codex = e3.codex \n"
                + "and e3.code = elev.code \n"
                + "and e3.codpr = p3.codpr \n"
                + "and elev.code in (select elev.code from examen,elev where elev.code=examen.code group by elev.code having count(examen.code)=3) \n"
                + "order by elev.nume,elev.init_tata,elev.prenume ";
        Connection connection = null;
        connection = openConnection(connection);
        ResultSet result = executeQuery(connection, query);
        List<Double> results = new ArrayList<>();
        try {
            while (result.next()) {
                results.add(result.getDouble("nota_init"));
            }
        } catch (SQLException e) {
        }

        closeConnection(connection);
        return results;
    }

    public static List<Double> selectNota_cont3ForRezultat() {
        String query = "select r3.nota_cont \n"
                + "from rezultat r1, rezultat r2, rezultat r3, examen e1, examen e2, examen e3, elev, proba p1, proba p2, proba p3, liceu, profil, liceu_profil \n"
                + "where profil.codp= liceu_profil.codp \n"
                + "and liceu.codl=liceu_profil.codl \n"
                + "and elev.codlp=liceu_profil.codlp \n"
                + "and p1.tip_proba = 1 \n"
                + "and p2.tip_proba = 2 \n"
                + "and p3.tip_proba = 3 \n"
                + "and r1.codex = e1.codex \n"
                + "and e1.code = elev.code \n"
                + "and e1.codpr = p1.codpr \n"
                + "and r2.codex = e2.codex \n"
                + "and e2.code = elev.code \n"
                + "and e2.codpr = p2.codpr \n"
                + "and r3.codex = e3.codex \n"
                + "and e3.code = elev.code \n"
                + "and e3.codpr = p3.codpr \n"
                + "and elev.code in (select elev.code from examen,elev where elev.code=examen.code group by elev.code having count(examen.code)=3) \n"
                + "order by elev.nume,elev.init_tata,elev.prenume ";
        Connection connection = null;
        connection = openConnection(connection);
        ResultSet result = executeQuery(connection, query);
        List<Double> results = new ArrayList<>();
        try {
            while (result.next()) {
                results.add(result.getDouble("nota_cont"));
            }
        } catch (SQLException e) {
        }

        closeConnection(connection);
        return results;
    }

}
