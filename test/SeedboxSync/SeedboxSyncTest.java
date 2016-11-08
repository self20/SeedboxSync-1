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

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.PatternLayout;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.mockito.Mockito.mock;

/**
 * Tests the SeedboxSync class.
 */
public class SeedboxSyncTest {
    /**
     * The logger for this class.
     */
    private static Logger logger = LoggerFactory.getLogger(new Throwable().getStackTrace()[0].getClassName());

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    /**
     * Configure the logger.
     */
    @Before
    public void setup() {
        org.apache.log4j.Logger logger = org.apache.log4j.Logger.getRootLogger();

        if (logger.getAppender("console") != null) {
            ConsoleAppender console = new ConsoleAppender();
            console.setName("console");
            console.setLayout(new PatternLayout("%d{yyyy-MM-dd' 'HH:mm:ss.SSS} [%-5p] [%c] - %m%n"));
            console.setThreshold(Level.INFO);
            console.activateOptions();
            org.apache.log4j.Logger.getRootLogger().addAppender(console);
            org.apache.log4j.Logger.getRootLogger().setAdditivity(false);
        }
    }

    /**
     * Tests the constructor.
     */
    @Test
    public void testConstructor() {
        SeedboxSync test = new SeedboxSync();
    }

    /**
     * Tests main() with the default config file.
     */
    @Test
    public void vestMainDefault() { SeedboxSync.main(new String[] { }); }

    /**
     * Tests main() with an explicitly defined config file.
     */
    @Test
    public void testMain() {
        SeedboxSync.main(new String[] { "test/SeedboxSync/resources/goodConfig.json" });
    }

    /**
     * Tests main() with a missing config file.
     */
    @Test
    public void testMainMissingConfig() {
        SeedboxSync.main(new String[] { "missing" });
    }

    /**
     * Tests main() with a known bad config file.
     */
    @Test
    public void testMainBadConfig() {
        SeedboxSync.main(new String[] { "test/SeedboxSync/resources/badConfig.json" });
    }

    /**
     * Tests main() with a partially complete config file.
     */
    @Test
    public void testMainPartialConfig() { SeedboxSync.main(new String[] { "test/SeedboxSync/resources/partialConfig.json" }); }

    /**
     * Perform teardown.
     */
    @After
    public void teardown() {
    }
}