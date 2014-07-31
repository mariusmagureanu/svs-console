package com.svs.dao.morphia;

import com.google.code.morphia.Morphia;
import com.google.code.morphia.query.Query;
import com.mongodb.Mongo;
import com.svs.dao.interfaces.ICustomerDao;
import com.svs.entities.Customer;


/**
 * Created by mariusmagureanu on 7/15/14.
 */
public final class CustomerDao extends BaseDao<Customer, String> implements ICustomerDao {

    protected CustomerDao(Mongo mongo, Morphia morphia, String dbName) {
        super(mongo, morphia, dbName);
    }

    /**
     *
     * @param name
     * @return
     */
    public Customer getByName(final String name) {
        final Query<Customer> query = this.getDatastore().createQuery(Customer.class).field("name").equal(name);
        return query.get();
    }
}