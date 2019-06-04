package com.example.demo.Persistence.Jdbc;

import com.example.demo.Model.Investor;
import com.example.demo.Persistence.API.InvestorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@RequiredArgsConstructor
public class JdbcInvestorRepository implements InvestorRepository
{
    private final JdbcTemplate template;

    @Override
    public Investor save(Investor investor) {
        if(investor.getId() != 0)
        {
            update(investor);
        }
        else
        {
            int id = insert(investor);
            investor.setId(id);
        }
        return investor;
    }

    @Override
    public Optional<Investor> findById(int id) {
        List<Investor> owners = template.query("SELECT * FROM investor WHERE username = ?",
                (resultSet, i) ->
                        new Investor(resultSet.getInt("id"),
                                resultSet.getString("username"),
                                resultSet.getString("password"),
                                resultSet.getDouble("capital")
                        ), id);
        return owners.isEmpty() ? Optional.empty() : Optional.ofNullable(owners.get(0));
    }

    @Override
    public Optional<Investor> findByUsername(String username) {
        List<Investor> investors = template.query("SELECT * FROM investor WHERE username = ?",
                (resultSet, i) ->
                        new Investor(resultSet.getInt("id"),
                                resultSet.getString("username"),
                                resultSet.getString("password"),
                                resultSet.getDouble("capital")
                        ), username);
        return investors.isEmpty() ? Optional.empty() : Optional.ofNullable(investors.get(0));
    }

    @Override
    public List<Investor> findAll() {
        return template.query("SELECT * FROM investor", ((resultSet, i) ->
                new Investor(resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getDouble("capital")
                )));
    }


    private int insert(Investor investor)
    {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(template);
        insert.setTableName("investor");
        insert.setGeneratedKeyName("id");
        Map<String, Object> data = new HashMap<>();
        data.put("username", investor.getUsername());
        data.put("password", investor.getPassword());
        data.put("capital", investor.getCapital());

        return insert.executeAndReturnKey(data).intValue();
    }

    private void update(Investor investor)
    {
        template.update("UPDATE investor SET username = ?, password = ?, capital = ? WHERE id = ?", investor.getUsername(), investor.getPassword(), investor.getCapital(), investor.getId());
    }
}
