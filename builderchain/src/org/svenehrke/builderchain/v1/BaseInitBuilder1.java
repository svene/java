/*
 * Copyright (c) 2010 by Sven Ehrke
 */

package org.svenehrke.builderchain.v1;

public class BaseInitBuilder1<D, NB extends BaseInitBuilder1<D, ?>> {
	protected final D data;
	protected final NB nextBuilder;

	public BaseInitBuilder1(NB aNextBuilder) {
		data = aNextBuilder.data;
		nextBuilder = aNextBuilder;
	}
	public BaseInitBuilder1(D aData) {
		data = aData;
		nextBuilder = null;
	}

	public D getData() {
		return data;
	}
}
