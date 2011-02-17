package org.svenehrke.effectivejava2nd.item29;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class FavoritesTest {

	@Test
	public void testFavorites() {
		IFavorites f = new Favorites();
		f.putFavorite(String.class, "Java");
		f.putFavorite(Integer.class, 0xcafebabe);
		f.putFavorite(Class.class, Favorites.class);
		String favoriteString = f.getFavorite(String.class);
		int favoriteInteger = f.getFavorite(Integer.class);
		final Class<?> favoriteClass = f.getFavorite(Class.class);

		final String expected = "Java cafebabe org.svenehrke.effectivejava2nd.item29.Favorites";
		final String s = String.format("%s %x %s", favoriteString, favoriteInteger, favoriteClass.getName());

		assertEquals(expected, s);
		assertThat(s, equalTo(expected));

	}

}
