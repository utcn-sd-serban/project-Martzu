package com.example.demo.Persistence.Jdbc;

import com.example.demo.Model.Transaction;
import com.example.demo.Persistence.API.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
public class JdbcTransactionRepository implements TransactionRepository {


    private final JdbcTemplate template;

    @Override
    public Transaction save(Transaction transaction) {
        if(transaction.getId() != 0)
        {
            update(transaction);
        }
        else
        {
            int id = insert(transaction);
            transaction.setId(id);
        }
        return transaction;
    }

    @Override
    public Optional<Transaction> findById(int id) {
        List<Transaction> transactions = template.query("SELECT * FROM transactions WHERE id = ?",
                (resultSet, i) ->
                        new Transaction(resultSet.getInt("id"),
                                resultSet.getInt("investorId"),
                                resultSet.getInt("companyId"),
                                resultSet.getString("kind"),
                                resultSet.getInt("stockNumber"),
                                resultSet.getDouble("stockPrice"),
                                resultSet.getDate("creationDate")
                        ), id);
        return transactions.isEmpty() ? Optional.empty() : Optional.ofNullable(transactions.get(0));
    }

    @Override
    public List<Transaction> findAll() {
        return template.query("SELECT * FROM transactions", ((resultSet, i) ->
                new Transaction(resultSet.getInt("id"),
                        resultSet.getInt("investorId"),
                        resultSet.getInt("companyId"),
                        resultSet.getString("kind"),
                        resultSet.getInt("stockNumber"),
                        resultSet.getDouble("stockPrice"),
                        resultSet.getDate("creationDate")

                )));
    }


    private int insert(Transaction transaction)
    {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(template);
        insert.setTableName("transactions");
        insert.setGeneratedKeyName("id");
        Map<String, Object> data = new HashMap<>();
        data.put("investorId", transaction.getInvestorId());
        data.put("companyId", transaction.getCompanyId());
        data.put("kind", transaction.getType());
        data.put("stockNumber", transaction.getStockNumber());
        data.put("stockPrice", transaction.getStockPrice());
        data.put("creationDate", transaction.getCreationDate());
        return insert.executeAndReturnKey(data).intValue();
    }

    private void update(Transaction transaction)
    {
        template.update("UPDATE transactions SET investorId = ?, companyId = ?, kind = ?, stockNumber = ?, stockPrice = ?, creationDate = ? WHERE id = ?", transaction.getInvestorId(), transaction.getCompanyId(), transaction.getType(), transaction.getStockNumber(), transaction.getStockPrice(), transaction.getCreationDate(), transaction.getId());
    }
}
