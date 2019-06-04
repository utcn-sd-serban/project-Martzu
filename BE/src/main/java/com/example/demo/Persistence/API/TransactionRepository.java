package com.example.demo.Persistence.API;

import com.example.demo.Model.Transaction;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository {

    public Optional<Transaction> findById(int id);

    public Transaction save(Transaction transaction);

    public List<Transaction> findAll();


}
