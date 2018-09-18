package service;

import Manager.TransactionManager;

import java.sql.SQLException;

public abstract class TransactionTemplate {
    public void doJobInTransaction() throws SQLException {
        TransactionManager.beginTransaction();

        try {
            this.doJob();
        } catch (Exception e) {
            TransactionManager.rollback();
        }finally {
            TransactionManager.close();
        }
    }

    protected abstract void doJob() throws Exception;
}
