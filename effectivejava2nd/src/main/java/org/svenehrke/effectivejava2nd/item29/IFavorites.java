package org.svenehrke.effectivejava2nd.item29;

public interface IFavorites {
	public <T> void putFavorite(Class<T> type, T instance);
	public <T> T getFavorite(Class<T> type);
}
