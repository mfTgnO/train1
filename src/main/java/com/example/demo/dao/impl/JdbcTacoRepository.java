package com.example.demo.dao.impl;

import com.example.demo.dao.TacoRepository;
import com.example.demo.domain.Ingredient;
import com.example.demo.domain.Taco_ch03;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.sql.Types;
import java.util.Arrays;
import java.util.Date;

@Repository
public class JdbcTacoRepository implements TacoRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcTacoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Taco_ch03 save(Taco_ch03 taco) {
        Long tacoId = saveTacoInfo(taco);
        taco.setId(tacoId);
        for (Ingredient ingredient : taco.getIngredients()) {
            saveIngredientToTaco(ingredient, tacoId);
        }

        return taco;
    }

    private Long saveTacoInfo(Taco_ch03 taco_ch03) {
        taco_ch03.setCreatedAt(new Date());
        PreparedStatementCreator psc = new PreparedStatementCreatorFactory(
                "insert into Taco (name, createdAt) values (?, ?)",
                Types.VARCHAR,
                Types.TIMESTAMP)
                .newPreparedStatementCreator(
                        Arrays.asList(
                                taco_ch03.getName(),
                                new Timestamp(taco_ch03.getCreatedAt().getTime()))
                );

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(psc, keyHolder);
        return keyHolder.getKey().longValue();
    }

    private void saveIngredientToTaco(Ingredient ingredient, long tacoId) {
        jdbcTemplate.update("insert into Taco_Ingredients (taco, ingredient) " +
                "values (?, ?)", tacoId, ingredient.getId());
    }
}