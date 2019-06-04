package com.example.demo.Persistence.Jdbc;

import com.example.demo.Persistence.API.BusinessOwnerRepository;
import com.example.demo.Model.BusinessOwner;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@RequiredArgsConstructor
public class JdbcBusinessOwnerRepository implements BusinessOwnerRepository {

    private final JdbcTemplate template;

    @Override
    public BusinessOwner save(BusinessOwner businessOwner) {
        if(businessOwner.getId() != 0)
        {
            update(businessOwner);
        }
        else
        {
            int id = insert(businessOwner);
            businessOwner.setId(id);
        }
        return businessOwner;
    }

    @Override
    public Optional<BusinessOwner> findById(int id)
    {
        List<BusinessOwner> owners = template.query("SELECT * FROM business_owner WHERE id = ?",
                (resultSet, i) ->
                    new BusinessOwner(resultSet.getInt("id"),
                    resultSet.getString("username"),
                    resultSet.getString("password")
                            ), id);
        return owners.isEmpty() ? Optional.empty() : Optional.ofNullable(owners.get(0));
    }

    @Override
    public Optional<BusinessOwner> findByUsername(String username)
    {
        List<BusinessOwner> owners = template.query("SELECT * FROM business_owner WHERE username = ?",
                (resultSet, i) ->
                        new BusinessOwner(resultSet.getInt("id"),
                                resultSet.getString("username"),
                                resultSet.getString("password")
                        ), username);
        return owners.isEmpty() ? Optional.empty() : Optional.ofNullable(owners.get(0));
    }

    @Override
    public List<BusinessOwner> findAll() {
        return template.query("SELECT * FROM business_owner", ((resultSet, i) ->
                new BusinessOwner(resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("password")
                        )));
    }

    private int insert(BusinessOwner businessOwner)
    {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(template);
        insert.setTableName("business_owner");
        insert.setGeneratedKeyName("id");
        Map<String, Object> data = new HashMap<>();
        data.put("username", businessOwner.getUsername());
        data.put("password", businessOwner.getPassword());

        return insert.executeAndReturnKey(data).intValue();
    }

    private void update(BusinessOwner businessOwner)
    {
        template.update("UPDATE business_owner SET username = ?, password = ? WHERE id = ?", businessOwner.getUsername(), businessOwner.getPassword(), businessOwner.getId());
    }
}
