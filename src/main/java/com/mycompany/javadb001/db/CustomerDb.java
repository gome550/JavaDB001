package com.mycompany.javadb001.db;

import com.mycompany.javadb001.entity.Customer;
import javax.ejb.Stateless;


/**
 * Jobデータベース操作クラス
 */
@Stateless
public class CustomerDb extends BaseDb<Customer> {

	/**
	 * コンストラクタ
	 */
	public CustomerDb() {
		super(Customer.class);
	}

}
