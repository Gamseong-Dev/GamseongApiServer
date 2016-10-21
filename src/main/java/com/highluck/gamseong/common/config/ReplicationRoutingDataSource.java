package com.highluck.gamseong.common.config;

import java.util.Random;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.support.TransactionSynchronizationManager;

public class ReplicationRoutingDataSource extends AbstractRoutingDataSource { 
	
	@Override
	protected Object determineCurrentLookupKey() {		
		return TransactionSynchronizationManager.isCurrentTransactionReadOnly() ? "read" : "write";
	}
}
