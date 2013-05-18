// ========================================================================
// Copyright (C) zeroth Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package zeroth.framework.command.iface;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.UnrecognizedOptionException;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.BeforeClass;
import org.junit.Test;
/**
 * {@link CommandLineUtility} のユニットテスト
 * @author nilcy
 */
@SuppressWarnings("all")
public class CommandLineUtilityTest {
    private static final Options OPTS = new Options();
    @BeforeClass
    public static void beforeClass() {
        OPTS.addOption("R", false, "output date and time in RFC 2822 format");
        OPTS.addOption("u", "utc", false, "print or set Coordinated Universal Time");
    }
    @Test
    public void testParseEmpty() throws ParseException {
        final CommandLine cmdLine = CommandLineUtility.parse(OPTS, ArrayUtils.EMPTY_STRING_ARRAY);
        assertThat(cmdLine, is(not(nullValue())));
        assertThat(cmdLine.hasOption("R"), is(false));
        assertThat(cmdLine.hasOption("u"), is(false));
    }
    @Test
    public void testParseR() throws ParseException {
        final CommandLine cmdLine = CommandLineUtility.parse(OPTS, new String[] { "-R" });
        assertThat(cmdLine, is(not(nullValue())));
        assertThat(cmdLine.hasOption("R"), is(true));
        assertThat(cmdLine.hasOption("u"), is(false));
    }
    @Test
    public void testParseRu() throws ParseException {
        final CommandLine cmdLine = CommandLineUtility.parse(OPTS, new String[] { "-u" });
        assertThat(cmdLine, is(not(nullValue())));
        assertThat(cmdLine.hasOption("R"), is(false));
        assertThat(cmdLine.hasOption("u"), is(true));
    }
    @Test
    public void testParseLongOption() throws ParseException {
        final CommandLine cmdLine = CommandLineUtility.parse(OPTS, new String[] { "-R", "--utc" });
        assertThat(cmdLine, is(not(nullValue())));
        assertThat(cmdLine.hasOption("R"), is(true));
        assertThat(cmdLine.hasOption("u"), is(true));
    }
    @Test
    public void testParseZ() throws ParseException {
        CommandLine cmdLine;
        try {
            cmdLine = CommandLineUtility.parse(OPTS, new String[] { "-Z" });
            fail("UnrecognizedOptionException");
        } catch (final UnrecognizedOptionException e) {
        }
    }
}
