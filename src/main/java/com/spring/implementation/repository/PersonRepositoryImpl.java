package com.spring.implementation.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.implementation.model.Person;

@Repository
public class PersonRepositoryImpl implements PersonRepository{
	
	private final JdbcTemplate jdbcTemplate;

    public PersonRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

	@Override
	public List<Person> findAll() {
		// TODO Auto-generated method stub
		String sql = "SELECT * from person";
		return jdbcTemplate.query(sql, new PersonRowMapper());
		}

	@Override
	public void save(Person person) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO person (firstName, lastName) VALUES (?, ?)";
        jdbcTemplate.update(sql, person.getFirstName(), person.getLastName());
		
	}
	
	private static class PersonRowMapper implements RowMapper<Person> {
        @Override
        public Person mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            Person person = new Person();
            person.setId(resultSet.getLong("id"));
            person.setFirstName(resultSet.getString("firstName"));
            person.setLastName(resultSet.getString("lastName"));
            return person;
        }
    }

}
