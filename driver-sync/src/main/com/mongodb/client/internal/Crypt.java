/*
 * Copyright 2008-present MongoDB, Inc.
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

package com.mongodb.client.internal;

import com.mongodb.MongoNamespace;
import org.bson.RawBsonDocument;

import java.io.Closeable;

/**
 * This class is NOT part of the public API.
 */
public interface Crypt extends Closeable {

    /**
     * Whether the namespace should be auto-encrypted or auto-decrypted
     * @param namespace the namespace
     * @return true if the namespace should be auto-encrypted or auto-decrypted
     */
    boolean isEnabled(MongoNamespace namespace);

    /**
     * Encrypt the given command
     *
     * @param namespace the namespace
     * @param command      the unencrypted command
     * @return the encyrpted command
     */
    RawBsonDocument encrypt(MongoNamespace namespace, RawBsonDocument command);

    /**
     * Decrypt the given command response
     *
     * @param namespace the namespace
     * @param commandResponse the encrypted command response
     * @return the decrypted command response
     */
    RawBsonDocument decrypt(MongoNamespace namespace, RawBsonDocument commandResponse);

    @Override
    public void close();
}