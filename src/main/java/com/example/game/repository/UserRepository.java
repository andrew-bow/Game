package com.example.game.repository;

import com.example.game.model.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addUser(Integer id) {
        jdbcTemplate.update("INSERT INTO scoretable (id,  score) VALUES (? , ?)", id, 0);
    }

    public Integer checkUserId(Integer id) {

        return jdbcTemplate.query("SELECT id FROM scoretable WHERE id=?", new Object[]{id}, (rs, rowNum) -> rs.getInt("id"))
                .stream().findAny().orElse(null);


    }

    public void updateScore(Integer id, Integer score) {
        jdbcTemplate.update("UPDATE scoretable SET score = ? WHERE id = ?", score, id);
    }

    public User getUser(Integer id) {
        try {
            return jdbcTemplate.query("SELECT * FROM scoretable WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(User.class))
                    .stream().findAny().orElse(null);
        } catch (Exception e) {
            throw new RuntimeException("User not found");
        }

    }

}
