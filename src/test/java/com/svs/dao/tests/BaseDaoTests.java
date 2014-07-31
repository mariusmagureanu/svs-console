package com.svs.dao.tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.svs.dao.interfaces.IBaseDao;
import com.svs.entities.BaseEntity;

public abstract class BaseDaoTests<T extends BaseEntity> {

	protected IBaseDao<T> dao;
	protected T testEntity;

	@Before
	public abstract void setUp();

	@After
	public void clean() {
		this.dao.clearAll();
	}

	@Test
	public void testSaveEntity() {
		this.dao.saveEntity(this.testEntity);
		final T savedEntity = this.dao.getByKey(this.testEntity.getEntityKey());
		Assert.assertEquals(this.testEntity.getEntityKey(),
				savedEntity.getEntityKey());
	}

	@Test
	public void testUpdateEntity() {
		this.dao.saveEntity(this.testEntity);

		final T savedEntity = this.dao.getByKey(this.testEntity.getEntityKey());
		Assert.assertEquals(this.testEntity.getEntityKey(),
				savedEntity.getEntityKey());

		this.testEntity.setEntityKey("##key##");
		this.dao.update(this.testEntity);

		final T updatedEntity = this.dao.getByKey(this.testEntity
				.getEntityKey());
		Assert.assertEquals(this.testEntity.getEntityKey(),
				updatedEntity.getEntityKey());
	}

	@Test
	public void testDeleteEntity() {
		this.dao.saveEntity(this.testEntity);
		final int countBeforeDelete = this.dao.getAll().size();

		Assert.assertEquals(1, countBeforeDelete);

		this.dao.deleteEntity(this.testEntity);
		final int countAfterDelete = this.dao.getAll().size();

		Assert.assertEquals(0, countAfterDelete);
	}

	@Test
	public void testGetAll() {
		final int insertCount = 500;

		for (int i = 0; i < insertCount; i++) {
			this.dao.saveEntity(this.testEntity);
		}

		final int countAfterInsert = this.dao.getAll().size();

		Assert.assertEquals(insertCount, countAfterInsert);
	}
}
