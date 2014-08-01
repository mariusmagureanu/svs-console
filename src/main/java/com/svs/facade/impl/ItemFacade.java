package com.svs.facade.impl;

import org.json.JSONException;
import org.json.JSONObject;

import com.svs.dao.factory.DaoFactory;
import com.svs.dao.interfaces.IBaseDao;
import com.svs.dao.interfaces.IItemDao;
import com.svs.entities.Item;
import com.svs.facade.interfaces.IItemFacade;

public final class ItemFacade extends BaseFacade<Item> implements IItemFacade {

	private final IItemDao dao = DaoFactory.getInstance().getDaoFactory()
			.getItemDao();

	@Override
	public Item fromJSON(String jsonData) throws JSONException {
		final JSONObject jsonItem = new JSONObject(jsonData);
		final Item item = new Item();
		item.fromJSON(jsonItem);
		return item;
	}

	@Override
	protected IBaseDao<Item> getBaseDao() {
		return this.dao;
	}
}
