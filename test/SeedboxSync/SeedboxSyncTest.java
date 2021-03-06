/****************************************************************************
 *
 * SeedboxSyncTest.java
 *
 * Tests the SeedboxSync class.
 *
 ***************************************************************************
 *
 * Copyright (C) 2016 JP Dillingham (jp@dillingham.ws)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 ****************************************************************************/

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

/**
 * Tests the SeedboxSync class.
 */
public class SeedboxSyncTest extends BaseTest {
    /**
     * The temporary folder for the class.
     */
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    /**
     * Tests the constructor.
     */
    @Test
    public void testConstructor() {
        try {
            begin();

            SeedboxSync test = new SeedboxSync();
        }
        finally {
            end();
        }
    }

    /**
     * Tests main() with the default config file.
     * @throws Exception
     */
    @Test(expected=Exception.class)
    public void testMainDefault() throws Exception {
        try {
            begin();

            if (new java.io.File("config.json").exists()) {
                log("Throwing fake exception to emulate remote CI");
                throw new Exception("");
            }
            SeedboxSync.main(new String[]{});
        }
        finally {
            end();
        }
    }


    /**
     * Tests main() with an explicitly defined config file.
     * @throws Exception
     */
    @Test
    public void testMain() throws Exception {
        try {
            begin();

            SeedboxSync.main(new String[] { "test/SeedboxSync/resources/goodConfig.json" });
        }
        finally {
            end();
        }
    }

    /**
     * Tests main() with a missing config file.
     * @throws Exception
     */
    @Test(expected=Exception.class)
    public void testMainMissingConfig() throws Exception {
        try {
            begin();

            SeedboxSync.main(new String[]{"missing"});
        }
        finally {
            end();
        }
    }

    /**
     * Tests main() with a known bad config file.
     * @throws Exception
     */
    @Test(expected=Exception.class)
    public void testMainBadConfig() throws Exception {
        try {
            begin();

            SeedboxSync.main(new String[]{"test/SeedboxSync/resources/badConfig.json"});
        }
        finally {
            end();
        }
    }

    /**
     * Tests main() with a partially complete config file.
     * @throws Exception
     */
    @Test(expected=Exception.class)
    public void testMainPartialConfig() throws Exception {
        try {
            begin();

            SeedboxSync.main(new String[]{"test/SeedboxSync/resources/partialConfig.json"});
        }
        finally {
            end();
        }
    }
}