/*
 * Copyright (c) 2008-2014 MongoDB, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mongodb.operation;

import org.bson.BsonDocument;

import static com.mongodb.assertions.Assertions.notNull;

/**
 * A representation of an update where the update is a document that completely replaces the existing document.
 *
 * @since 3.0
 */
public final class ReplaceRequest<T> extends BaseUpdateRequest {
    private final T replacement;

    /**
     * Construct an instance.
     *
     * @param criteria the non-null query criteria
     * @param replacement the non-null replacement document
     */
    public ReplaceRequest(final BsonDocument criteria, final T replacement) {
        super(criteria);
        this.replacement = notNull("replacement", replacement);
    }

    /**
     * Get the document to replace the existing one with.
     *
     * @return the replacement
     */
    public T getReplacement() {
        return replacement;
    }

    public ReplaceRequest<T> upsert(final boolean isUpsert) {
        super.upsert(isUpsert);
        return this;
    }

    @Override
    public boolean isMulti() {
        return false;
    }

    @Override
    public Type getType() {
        return Type.REPLACE;
    }
}