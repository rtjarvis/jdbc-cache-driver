/**
 * Copyright 2016 Emmanuel Keller / QWAZR
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

import org.apache.derby.impl.jdbc.EmbedResultSet42;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class OnDiskCacheDisabledJdbcWithDerbyBackendTest extends OnDiskCacheJdbcWithDerbyBackendTest {
    @Override
    Class<? extends ResultSet> expectedResultSetClass() {
        return EmbedResultSet42.class;
    }

    @Override
    boolean isCacheEnabled() {
        return false;
    }

    @Override
    String getDerbyDbName() {
        return "onDiskCacheDisabled";
    }

    @Override
    Connection getConnection() throws SQLException {
        final Properties info = new Properties();
        info.setProperty("cache.driver.url", "jdbc:derby:memory:" + getDerbyDbName() + ";create=true");
        info.setProperty("cache.driver.class", "org.apache.derby.jdbc.EmbeddedDriver");
        info.setProperty("cache.driver.active", "false");
        return DriverManager.getConnection(getOrSetJdbcCacheUrl(), info);
    }
}
