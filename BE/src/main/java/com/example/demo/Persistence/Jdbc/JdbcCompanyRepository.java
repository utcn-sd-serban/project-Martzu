package com.example.demo.Persistence.Jdbc;

import com.example.demo.Model.Company;
import com.example.demo.Persistence.API.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@RequiredArgsConstructor
public class JdbcCompanyRepository implements CompanyRepository {

    private final JdbcTemplate template;
    @Override
    public Company save(Company company) {
        if(company.getId() != 0)
        {
            update(company);
        }
        else
        {
            int id = insert(company);
            company.setId(id);
        }
        return company;
    }

    @Override
    public Optional<Company> findById(int id) {
        List<Company> companies = template.query("SELECT * FROM company WHERE id = ?",
                (resultSet, i) ->
                        new Company(resultSet.getInt("id"),
                                resultSet.getInt("ownerId"),
                                resultSet.getString("companyName"),
                                resultSet.getString("companyTag"),
                                resultSet.getInt("shares"),
                                resultSet.getDouble("sharePrice"),
                                resultSet.getString("splitFactor")
                        ), id);
        return companies.isEmpty() ? Optional.empty() : Optional.ofNullable(companies.get(0));
    }

    @Override
    public Optional<Company> findByName(String name) {
        List<Company> companies = template.query("SELECT * FROM company WHERE companyName = ?",
                (resultSet, i) ->
                        new Company(resultSet.getInt("id"),
                                resultSet.getInt("ownerId"),
                                resultSet.getString("companyName"),
                                resultSet.getString("companyTag"),
                                resultSet.getInt("shares"),
                                resultSet.getDouble("sharePrice"),
                                resultSet.getString("splitFactor")
                        ), name);
        return companies.isEmpty() ? Optional.empty() : Optional.ofNullable(companies.get(0));
    }

    @Override
    public Optional<Company> findByTag(String tag) {
        List<Company> companies = template.query("SELECT * FROM company WHERE companyTag = ?",
                (resultSet, i) ->
                        new Company(resultSet.getInt("id"),
                                resultSet.getInt("ownerId"),
                                resultSet.getString("companyName"),
                                resultSet.getString("companyTag"),
                                resultSet.getInt("shares"),
                                resultSet.getDouble("sharePrice"),
                                resultSet.getString("splitFactor")
                        ), tag);
        return companies.isEmpty() ? Optional.empty() : Optional.ofNullable(companies.get(0));
    }

    @Override
    public List<Company> findAll() {
        return template.query("SELECT * FROM company", ((resultSet, i) ->
                new Company(resultSet.getInt("id"),
                        resultSet.getInt("ownerId"),
                        resultSet.getString("companyName"),
                        resultSet.getString("companyTag"),
                        resultSet.getInt("shares"),
                        resultSet.getDouble("sharePrice"),
                        resultSet.getString("splitFactor")
                )));
    }

    private int insert(Company company)
    {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(template);
        insert.setTableName("company");
        insert.setGeneratedKeyName("id");
        Map<String, Object> data = new HashMap<>();
        data.put("ownerId", company.getOwnerId());
        data.put("companyName", company.getName());
        data.put("companyTag", company.getTag());
        data.put("shares", company.getShares());
        data.put("sharePrice", company.getSharePrice());
        data.put("splitFactor", company.getSplitFactor());
        return insert.executeAndReturnKey(data).intValue();
    }

    private void update(Company company)
    {
        template.update("UPDATE company SET ownerId = ?, companyName = ?, companyTag = ?, shares = ?, sharePrice = ? WHERE id = ?", company.getOwnerId(), company.getName(), company.getTag(), company.getShares(), company.getSharePrice(), company.getId());
    }
}
