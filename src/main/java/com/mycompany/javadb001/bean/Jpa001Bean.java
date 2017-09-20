/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.javadb001.bean;

import com.mycompany.javadb001.db.CustomerDb;
import com.mycompany.javadb001.entity.Customer;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author t-tio
 */
@Named(value = "jpa001Bean")
@RequestScoped
public class Jpa001Bean {
    
    @EJB
    private CustomerDb customerDb;
    
    @Getter @Setter
    private List<Customer> customerList;
    @Getter @Setter
    private List<Customer> filteredCustomerList;

    /**
     * Creates a new instance of Page001Bean
     */
    public Jpa001Bean() {
    }
    
    @PostConstruct
    public void init() {
	this.customerList = this.customerDb.findAll();
    }
    
    public void onStandardOutputButton() {
	this.filteredCustomerList.forEach(c -> 
	);
    }

}
