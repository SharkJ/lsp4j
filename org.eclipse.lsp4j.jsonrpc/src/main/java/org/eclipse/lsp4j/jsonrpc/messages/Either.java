/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.lsp4j.jsonrpc.messages;

import org.eclipse.lsp4j.jsonrpc.validation.NonNull;


/**
 * 
 * An either type maps union types in protocol specifications.
 *
 * @param <L>
 * @param <R>
 */
public class Either<L, R> {
	
	public static <L,R> Either<L,R> forLeft(@NonNull L left) {
		return new Either<L,R>(left, null);
	}
	
	public static <L,R> Either<L,R> forRight(@NonNull R right) {
		return new Either<L,R>(null, right);
	}

	private final L left;
	private final R right;
	
	protected Either(L left, R right) {
		super();
		this.left = left;
		this.right = right;
	}

	public L getLeft() {
		return left;
	}
	
	public R getRight() {
		return right;
	}
	
	public boolean isLeft() {
		return left != null;
	}
	
	public boolean isRight() {
		return right != null;
	}
	
}