/**
 * Copyright 2016-2017 Emmanuel Keller / QWAZR
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.qwazr.jdbc.cache;

import java.io.IOException;
import java.sql.SQLException;

class CacheSQLException extends RuntimeException {

    private final SQLException sqlException;

    private CacheSQLException(SQLException sqlException) {
        super(sqlException);
        this.sqlException = sqlException;
    }

    SQLException getSQLException() {
        return sqlException;
    }

    static CacheSQLException of(String msg, IOException e) {
        return new CacheSQLException(new SQLException(msg, e));
    }

    static CacheSQLException of(String msg) {
        return new CacheSQLException(new SQLException(msg));
    }
}
