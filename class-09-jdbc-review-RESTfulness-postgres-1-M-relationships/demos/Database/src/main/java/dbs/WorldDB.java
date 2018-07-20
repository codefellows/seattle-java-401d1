package dbs;

import models.City;
import models.Country;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class WorldDB {
    private static final String GET_ALL_COUNTRIES = "SELECT * FROM country";
    private static final String GET_COUNTRIES_UNDER_LIMIT =
            "SELECT * FROM country WHERE population < ?";
    private static final String GET_COUNTRIES_BETWEEN =
            "SELECT * FROM country WHERE population > ? AND population < ?";
    private static final String GET_CITIES_COUNTRY =
            "SELECT * FROM city " +
            "JOIN country ON city.countrycode = country.code " +
            "WHERE country.code = ?";

    private Connection conn;

    public WorldDB() {
        String url = "jdbc:postgresql://localhost:5432/world";
        Properties props = new Properties();
        // use these properties if you need to provide a username or password.
        //props.setProperty("user","fred");
        //props.setProperty("password","secret");
        //props.setProperty("ssl","true");

        try {
            this.conn = DriverManager.getConnection(url, props);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Country> getAllCountries() {
        List<Country> countries = new ArrayList<>();

        try {
            Statement sql = this.conn.createStatement();
            ResultSet results = sql.executeQuery(GET_ALL_COUNTRIES);

            while (results.next()) {
                Country country = new Country();
                country.name = results.getString("name");
                country.countryCode = results.getString("code");
                country.population = results.getInt("population");
                countries.add(country);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return countries;
    }

    public List<Country> getCountriesBelowPopulation(int population) {
        List<Country> countries = new ArrayList<>();

        try {
            PreparedStatement sql = this.conn.prepareStatement(GET_COUNTRIES_UNDER_LIMIT);
            sql.setInt(1, population);

            ResultSet results = sql.executeQuery();

            while (results.next()) {
                Country country = new Country();
                country.name = results.getString("name");
                country.countryCode = results.getString("code");
                country.population = results.getInt("population");
                countries.add(country);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return countries;
    }

    public List<City> getAllCities() {
        List<City> cities = new ArrayList<>();
        return cities;
    }

    public List<City> getCitiesInCountry(String countryCode) {
        List<City> cities = new ArrayList<>();

        try {
            PreparedStatement sql = this.conn.prepareStatement(GET_CITIES_COUNTRY);
            sql.setString(1, countryCode);

            ResultSet results = sql.executeQuery();
            while (results.next()) {
                City city = new City();
                city.name = results.getString("name");
                city.countryCode = results.getString("countrycode");
                city.population = results.getInt("population");
                cities.add(city);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cities;
    }

    public List<Country> getCountriesBetweenPopulation(int lowBound, int highBound) {
        List<Country> countries = new ArrayList<>();

        try {
            PreparedStatement sql = this.conn.prepareStatement(GET_COUNTRIES_BETWEEN);
            sql.setInt(1, lowBound);
            sql.setInt(2, highBound);

            ResultSet results = sql.executeQuery();

            while (results.next()) {
                Country country = new Country();
                country.name = results.getString("name");
                country.countryCode = results.getString("code");
                country.population = results.getInt("population");
                countries.add(country);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return countries;
    }
}
