package com.example.demo.Persistence.Jdbc;


import com.example.demo.Model.OwnedStocks;
import com.example.demo.Persistence.API.OwnedStocksRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
public class JdbcOwnedStocksRepository implements OwnedStocksRepository {
    private final JdbcTemplate template;

    @Override
    public OwnedStocks save(OwnedStocks ownedStocks) {
        if(ownedStocks.getId() != 0)
        {
            update(ownedStocks);
        }
        else
        {
            int id = insert(ownedStocks);
            ownedStocks.setId(id);
        }
        return ownedStocks;
    }

    @Override
    public Optional<OwnedStocks> findById(int id) {
        List<OwnedStocks> ownedStocks = template.query("SELECT * FROM owned_stocks WHERE id = ?",
                (resultSet, i) ->
                        new OwnedStocks(resultSet.getInt("id"),
                                resultSet.getInt("investorId"),
                                resultSet.getInt("companyId"),
                                resultSet.getInt("stockNumber"),
                                resultSet.getDouble("stockPrice")
                        ), id);
        return ownedStocks.isEmpty() ? Optional.empty() : Optional.ofNullable(ownedStocks.get(0));
    }

    @Override
    public List<OwnedStocks> findAll() {
        return template.query("SELECT * FROM owned_stocks", ((resultSet, i) ->
                new OwnedStocks(resultSet.getInt("id"),
                        resultSet.getInt("investorId"),
                        resultSet.getInt("companyId"),
                        resultSet.getInt("stockNumber"),
                        resultSet.getDouble("stockPrice")

                )));
    }

    public Optional<OwnedStocks> findOwnedStockByUsernameAndCompany(int investorId, int companyId)
    {
        List<OwnedStocks> ownedStocks = template.query("SELECT * FROM owned_stocks WHERE investorId = ? AND companyId = ?",
                (resultSet, i) ->
                        new OwnedStocks(resultSet.getInt("id"),
                                resultSet.getInt("investorId"),
                                resultSet.getInt("companyId"),
                                resultSet.getInt("stockNumber"),
                                resultSet.getDouble("stockPrice")
                        ), investorId, companyId);
        return ownedStocks.isEmpty() ? Optional.empty() : Optional.ofNullable(ownedStocks.get(0));
    }

    @Override
    public List<OwnedStocks> findAllStocksOwnedAtACompany(int companyId) {
        return template.query("SELECT * FROM owned_stocks WHERE companyId = ?", ((resultSet, i) ->
                new OwnedStocks(resultSet.getInt("id"),
                        resultSet.getInt("investorId"),
                        resultSet.getInt("companyId"),
                        resultSet.getInt("stockNumber"),
                        resultSet.getDouble("stockPrice")

                )), companyId);
    }

    @Override
    public List<OwnedStocks> findAllStocksOwnedByInvestor(int investorId) {
        return template.query("SELECT * FROM owned_stocks WHERE investorId = ?", ((resultSet, i) ->
                new OwnedStocks(resultSet.getInt("id"),
                        resultSet.getInt("investorId"),
                        resultSet.getInt("companyId"),
                        resultSet.getInt("stockNumber"),
                        resultSet.getDouble("stockPrice")

                )), investorId);
    }

    private int insert(OwnedStocks ownedStocks)
    {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(template);
        insert.setTableName("owned_stocks");
        insert.setGeneratedKeyName("id");
        Map<String, Object> data = new HashMap<>();
        data.put("investorId", ownedStocks.getInvestorId());
        data.put("companyId", ownedStocks.getCompanyId());
        data.put("stockNumber", ownedStocks.getStockNumber());
        data.put("stockPrice", ownedStocks.getStockPrice());
        return insert.executeAndReturnKey(data).intValue();
    }

    private void update(OwnedStocks ownedStocks)
    {
        template.update("UPDATE owned_stocks SET investorId = ?, companyId = ?, stockNumber = ?, stockPrice = ? WHERE id = ?", ownedStocks.getInvestorId(), ownedStocks.getCompanyId(), ownedStocks.getStockNumber(), ownedStocks.getStockPrice(), ownedStocks.getId());
    }


}
